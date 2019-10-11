public class Auto_mode {

    private static Catalogue cata = new Catalogue();

    public static void auto(){

        Point p = new Point();

        p.setName("Avon");
        p.setAdress("town");

        GenericLinkedList<String> telephones = new GenericLinkedList<String>();

        telephones.insert("5");
        telephones.insert("6");

        int num = 3;

        for(int i = 0; i < num + 1; i++){
            telephones.insert(Integer.toString(i));
        }

        p.setSpec("shmot, cukerki");
        p.setTelephones(telephones);

        cata.add(p);

        System.out.println("sale point succesfully added!!!\n");

        cata.showPoints();

        System.out.println("serializing...");
        cata.serialize();
        System.out.println("points were succesfully serialized\n");

        System.out.println("deserealizing...");
        cata.deSerialize();
        System.out.println("points were succesfully deserialized\n");

        cata.showPoints();

        System.out.println("encoding...");
        cata.encode();
        System.out.println("encoded succsesfully\n");

        System.out.println("decocing...");
        cata.decode();
        System.out.println("decoded succsesfully\n");

        cata.showPoints();

        System.out.println("removing...");
        System.out.println("removing point of index 1");
        cata.remove_point(1);
        System.out.println("point removed!\n");

        cata.showPoints();


    }
}

