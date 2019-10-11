#include <cs50.h>
#include <stdio.h>

#include <string.h>
#include <locale.h>
#include <ctype.h>


int main(){
    printf("Write down the text you want to work with:\n");
    char arr[255];
    fgets(arr, 255, stdin);
    int k = 0, gol;
    for(int i = 0; i < strlen(arr);i++){
        gol = 0;
        if(arr[i]==(char)32 || arr[i]==(char)46){
            for(int j = k; j <= i; j++){
                if(arr[j]==(char)97 ||
                    arr[j]==(char)101 ||
                    arr[j]==(char)111 ||
                    arr[j]==(char)105 ||
                    arr[j]==(char)117){
                        gol++;
                }
            }
            if(!gol){
                for(int j = k; j <= i; j++){
                    printf("%c", arr[j]);
                }
            }
            k = i+1;

        }

    }
}


