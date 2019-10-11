#include <stdio.h>
#include <math.h>

int main(){
    double a = 1000, b = 0.0001;
    float c = 1000, d = 0.0001;
    double func = (pow((a+b),3) - (pow(a,3) + 3*pow(a,2)*b))/(3*a*pow(b,2)+pow(b,3));
    float funcf = (pow((c+d),3) - (pow(c,3) + 3*pow(c,2)*d))/(3*c*pow(d,2)+pow(d,3));
    printf("Double: %f\nFloat: %f", func, funcf);
}