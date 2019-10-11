#include <stdio.h>
#include <stdlib.h>

int main(){
    int a[100];
    int n;
    scanf("%d", &n);
    for(int i = 0; i < n; i++){
        a[i]=rand()%5 - 2;
        printf("%dst element of array: %d\n", i+1, a[i]);
    }

    int tmp;
    for(int i = 0; i < n; i++){
        if(a[i]==0){
            for(int j = i; j < n; j++){
                a[j]=a[j+1];
            }
            n--;
        }
    }
    printf("\n");

    for(int i = 0; i < n; i++){
        if(a[i]%2==0){
            for(int j = n; j > i; j--){
                a[j+1]=a[j];
            }
            a[i+1]=a[i]+2;
            n++;
            break;
        }
    }

    for(int i = 0;i<n;i++){
        printf("%dst element of a new array: %d\n", i+1, a[i]);
    }
}

