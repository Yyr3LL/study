package laba3;

import java.util.Scanner;

public class Menu {
	
	public static void showMenu() {

		System.out.println();
		System.out.println("a. Show points");
        System.out.println("b. Add point");
        System.out.println("c. Remove point");
        System.out.println("d: Decode point");
        System.out.println("e: Encode point");
        System.out.println("q. Exit");
        System.out.println();

	}
	
	public static void main(String[] args) {
        Catalogue cata = new Catalogue();
        while (true)
        {
        	showMenu();
            System.out.println("Choose command: ");
            Scanner scan = new Scanner(System.in);

            String choice = scan.nextLine();

            switch (choice){
                case "a":			//SHOWING POINTS

                    if(cata.sizeOfPoints() > 0)
                        cata.showPoints();
                    else
                        System.out.println("Catalogue is empty");
                    break;

                case "b":			//ADDING POINTS

                    cata.addSalePoint();
                    break;

                case "c":			//REMOVING POINTS

                    cata.removeSalePoint();
                    break;

                case "e":			//ENCODING POINTS
                	
                	System.out.println("enter name of obj you want to add: ");
                	cata.encode();
//               		cata.encode(cata.findPoint(scan.nextLine()));              		
               		break;

                case "d":			//DECODING POINTS

                	cata.decode();
                	break;
                	
                case "q":			//EXIT

                    System.exit(0);
            }
        }
    }

}
