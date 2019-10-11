import java.util.Scanner;

public class Menu {

    private static void showChoices() {

        System.out.println();
        System.out.println("a. Show points");
        System.out.println("b. Add point");
        System.out.println("c. Remove point");
        System.out.println("d: Decode point");
        System.out.println("e: Encode point");
        System.out.println("f: Serialize");
        System.out.println("g: deSerialize");
        System.out.println("q. Exit");
        System.out.println();

    }

    public static void menu() {
        Catalogue cata = new Catalogue();
        while (true)
        {
            showChoices();
            System.out.println("Choose command: ");
            Scanner scan = new Scanner(System.in);

            String choice = scan.nextLine();

            switch (choice){
                case "a":			//SHOWING POINTS
                    cata.showPoints(); break;
                case "b":			//ADDING POINTS
                    cata.add(); break;
                case "c":			//REMOVING POINTS
                    cata.remove_point(); break;
                case "e":			//ENCODING POINTS
                    cata.encode(); break;
                case "d":			//DECODING POINTS
                    cata.decode(); break;
                case "f":			//DECODING POINTS
                    cata.serialize(); break;
                case "g":			//DECODING POINTS
                    cata.deSerialize(); break;
                case "h":			//DECODING POINTS
                    cata.search(); break;
                case "j":			//DECODING POINTS
                    cata.sort(); break;
                case "q":			//EXIT
                    System.exit(0);
            }
        }
    }

}

