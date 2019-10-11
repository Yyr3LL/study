#include <iostream>
#include <cstdlib>

using namespace std;

int main(){
    int n, amount, pos;

    cout<<"Input size of the array: "<<endl;
    cin>>n;
    cout<<"Input the amount of elements which should be erased: "<<endl;
    cin>>amount;
    cout<<"Input the first position: "<<endl;
    cin>>pos;

    int *a = new int[n+1];
    for(int i = 0; i < n; i++){
        a[i] = rand()%20+1;
    }

    cout<<"the first array: "<<endl;
    for(int i = 0; i < n; i++){
       cout<<i+1<<"th element of array is: "<<a[i]<<endl;
    }
    cout<<endl;

    int *b = new int[n-amount];
    int k = 0;
    for(int i = 0; i < n; i++){
        if(i==pos-1){
            for(int j = 0; j < amount; j++){
                i++;
            }
        }
        b[k]=a[i];
        k++;
    }
    cout<<"partly erased array is: "<<endl;
    for(int i = 0; i < n - amount; i++){
        cout<<i+1<<"th element of array is: "<<b[i]<<endl;
    }
    n = n + 1 - amount;
    int new_el, new_pos;
    cout<<"Input a new element which should be added to the array: "<<endl;
    cin>>new_el;
    cout<<"Input pos of that element (1;n) "<<endl;
    cin>>new_pos;
    int kek = new_pos - 1;

    for(int i = n; i > kek; i--){
        b[i]=b[i-1];
    }

    cout<<"rg"<<endl;
    b[new_pos-1]=new_el;
    cout<<"edited final array is: "<<endl;

    for(int i = 0; i < n; i++){
         cout<<i+1<<"th element of array is: "<<b[i]<<endl;
    }
}



