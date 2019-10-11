#include <stdio.h>

int main(){
    int sum = 0;
    for(int i = 0;i<200;i++){
        if(i % 2 != 0){
            sum += i;
        } else {
            continue;
        }
    }
    printf("sum of odd numbers under 200 is %d\n", sum);
}
