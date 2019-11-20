#include <iostream>
#include <pthread.h>
#include <cstdlib>
#include <limits>
#include <unistd.h>


using namespace std;

struct Parametres
{
    int start;
    int end;
    int *arr;
    int id;
    int to_find;
};

struct Result
{
    int start;
    int end; int *arr; int id;
    int index;
};

Result* res = new Result[228];

void run(int threads, int start, int end, int to_find, int* arr);
void* _routine(void *param); /* потоковая функция */


int main()
{
    
    int N, 
	th_count, 
	to_find;

    cout << endl << "enter number of elements: "; 	cin >> N;
    cout << endl << "enter number of threads: "; 	cin >> th_count;
    cout << endl << "enter element we have to find: "; 	cin >> to_find;
    cout << endl;
    
    int * arr = new int[N];

    for (int i = 0; i < N; ++i)
	arr[i] = rand() % 100;

    for (int i = 0; i < N; ++i)
	cout << arr[i] << endl;

    run(th_count, 0, N, to_find, arr);

    cout << "************" << endl;

    for (int i = 0; i < th_count; ++i)
	cout << "in " << i+1 << " piece of array:  "<< res[i].index << endl;

    return 0;

}


void run(int threads, int start, int end, int to_find, int* arr)
{

    pthread_t* tid = new pthread_t[threads];
    pthread_attr_t* attr = new pthread_attr_t[threads];
    Parametres* p = new Parametres[threads];
    int interval_length = (max(start, end) - min(start, end)) / threads;
    int left = ((max(start, end) - min(start, end)) % threads);

    for (int i = 0; i < threads; ++i)
    {
	p[i].start = int(interval_length * i);
	p[i].end = int(interval_length * (i+1));
	p[i].arr = arr;
	p[i].id = i;
	p[i].to_find = to_find;

	// some shitcode
	//if (left > 0)
	//{
	//    p[i].end++;
	//    left--;
	//}

	pthread_attr_init(&attr[i]);
	pthread_create(&tid[i], &attr[i], _routine, (void*)&p[i]);
    }

    for (int i = 0; i < threads; ++i)
	pthread_join(tid[i], nullptr);

}


void* _routine(void *param) 
{

    Parametres* 	args = (Parametres*)param;
    int start = 	args->start,
	end = 		args->end,
	*arr = 		args->arr,
	id = 		args->id,
	to_find = 	args->to_find,
	index;
    
    for (int i = start; i < end; ++i)
    {
	cout << id << " : " << arr[i] << endl;
	if (i == end - 1 && arr[i] != to_find)
	    index = -1;
	else if (arr[i] == to_find)
	{
	    index = i;
	    break;
	}
    }

//    for (int i = start; i < end; ++i)
//	cout << arr[i] << endl;

    res[id].start = start;
    res[id].end = end;
    res[id].index = index;

    sleep(15);
    pthread_exit(0);

}


