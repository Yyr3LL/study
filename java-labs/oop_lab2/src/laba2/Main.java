package laba2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int debug = 0;
        Par help = new Par();
        if (args.length > 0) {
            if (args[0].equals("-h") || args[0].equals("--help") || args[1].equals("-h") || args[1].equals("--help")) {
                help.help();
            }
            if (args[0].equals("-d") || args[0].equals("--debug") || args[1].equals("-d") || args[1].equals("--debug")) {
                debug++;
            }
        }

        help.menu();
        int e = 0;
        int cntr = 0;
        int[] letters = new int[2];

        String s = "empty";


        while (e == 0) {
            System.out.print("Enter the commands: ");
            Scanner scan = new Scanner(System.in);
            char c = scan.nextLine().charAt(0);

            if (c == 'e') {
                System.out.println("Enter data: ");
                s = scan.nextLine();
                cntr = 1;
                if (debug == 1) {
               	
                    for (int k = 0; k < s.length(); k++)
                        System.out.print(s.charAt(k) + " ");
                }

            }

            StringBuffer br = new StringBuffer(s);
            if (c == 'v') {
                if (cntr == 0) {
                    System.out.println("Empty memory");
                } else {
                    System.out.println(s);
                }
            }
            if (c == 'p') {
                if (cntr == 0) {
                    System.out.println("No data");
                } else {
                    Counter counter = new Counter();
                    letters = counter.how_much(br, debug);
                    cntr = 2;
                }
            }
            if (c == 'r') {
                if (cntr == 0) {
                    System.out.println("No data");
                } else {
                    Table table = new Table();
                    table.make_chart(letters);
                }
            }
            if (c == 'x') {
                e = 1;
            }
        }       
	}
}
