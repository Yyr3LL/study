#include "math.h"
#include <stdio.h>
#include <iostream>
#include <string>
#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <sys/time.h>
#include <sys/resource.h>

using namespace std;


void taylor(double start, double end);


int main()
{
    long N;

    double border_start = 0;
    double border_end = 1;

    cout << "num of processes: " << endl;
    cin >> N;

    double step = (abs(border_start) + abs(border_end))/N;

    double iteration_start = border_start;
    double iteration_end = step;
    
    int pid = 1;

    for (int i = 0, z = 1; i < N; i++, z++)
    {
	if(pid > 0)
	{
	    pid = fork();
	    if(pid > 0)
	    {
		iteration_start += step;
		iteration_end += step;
	    }
	    cout << z << " process has been finished" << endl;
	}
	else if(pid < 0)
	{
	    cout << "some error occured" << endl;
	    return -1;
	}
    }

    setpriority(0, getpid(), 1);

    if(pid == 0)
	taylor(iteration_start, iteration_end);

    for (int i = 0; i < N; ++i)
	wait(0);

    return 0;
}


void taylor(double start, double end)
{
    int iterations = 100000;

    for (double i = start; i < end; i += 0.001)
    {
	double sum = 1;

	for (double j = 0; j < iterations; j++)
	    sum += pow(-1, j) * pow(i, j); 
	
	cout << "approx value of (1 + {" << i << "} = " << sum << endl;
    }
}
