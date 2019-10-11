package laba1;


public class Counter {
    public int[] how_much(StringBuffer s,int debug){
        int countV = 0, countC = 0;
        char[] vowels={'a','e','y','u','i','o'};
        char[] consonants={'q','w','r','t','p','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m',};
        for (int i =0;i<s.length();i++){
            for (int j=0;j<vowels.length;j++){
                if (vowels[j]==s.charAt(i)){
                    countV++;
                }


            }
            for (int f=0; f<consonants.length;f++){
                if (consonants[f]==s.charAt(i)){
                    countC++;
                }
            }
        }

        int[] letters = {countV, countC};
        if (debug == 1) {
        	
            for (int k = 0; k < vowels.length; k++) {
                System.out.print(vowels[k] + " ");
            }
            for (int k = 0; k < consonants.length; k++) {
                System.out.print(consonants[k] + " ");
            }
        }
        return letters;

    }
}