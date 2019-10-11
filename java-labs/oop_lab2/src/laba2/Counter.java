package laba2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Counter {

	MyCo mc = new MyCo();

    public void how_much(StringBuffer s,int debug){
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
        for(int a = 0; a < letters.length; ++a) {
        	mc.add(letters[a]);
        }
    }


    public static void serialize() {
		try {
			FileOutputStream fOutput = new FileOutputStream("file.txt");
			ObjectOutputStream sOutput = new ObjectOutputStream(fOutput);
			sOutput.writeObject(si);
			sOutput.flush();
			sOutput.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println("Object written successfully.");
	}


	public static void deSerialize() {
		try {
			FileInputStream fInput = new FileInputStream("file.txt");
			ObjectInputStream sInput = new ObjectInputStream(fInput);
			si = (StringIterator) sInput.readObject();
			sInput.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println("Object read successfully.");
    }


    public void make_chart(int[] letters){
        
        System.out.print("Vowels      |  ");
        System.out.print(letters[0]);
        System.out.println();
        System.out.print("______________________");
        System.out.println();
        System.out.println();
        System.out.print("Consonants  |  ");
        System.out.println(letters[1]);
        
        
    }
    
}