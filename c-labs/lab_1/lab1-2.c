#include <stdio.h>
#include <cs50.h>
int main(){
    int n, m;
    scanf("%d%d", &n, &m);
    // 1) n---m
    int viraz1 = (n--) - m;
    // 2) m--<n
    string viraz2;
    if (m-- < n)
        viraz2 = "true";
    else
        viraz2 = "false";
    // 3) n++>m
    string viraz3;
    if(n++ > m)
        viraz3 = "true";
    else
        viraz3 = "false";

    printf("n-- -m = %d\n", viraz1);
    printf("m-- < n = %s\n", viraz2);
    printf("n++ > m = %s\n", viraz3);

}
