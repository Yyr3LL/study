#include <stdio.h>
#include <math.h>


int fact(int arg){
    if(arg < 0){
        return 0;
    }
    else if(arg == 0){
        return 1;
    }
    else{
        return arg*fact(arg-1);
    }
}


int main() {
    double a = 0.1, b = 1, x, step = (b-a)/10, sn, se, y, diff;
    int n = 10;
    unsigned long i;
    for (x = a; x <= b; x += step) {
        sn = x;
        se = x;
        y = sin(x);
        diff = 1;
        for (i = 1; i < n; i ++) {
            sn += pow((-1),i)*(pow(x,(2*i)+1))/fact(((2*i)+1));
        }
        i = 1;
        while (1) {
            diff = pow((-1),i)*(pow(x,(2*i)+1))/fact(((2*i)+1));
            se += diff;
            if (diff < 0.0001) {
                break;
            }
            i ++;
        }
        printf("X = %f    SN = %f    SE = %f    Y = %f\n", x, sn, se, y);
    }
    return 0;
}