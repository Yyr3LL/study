import java.io.*;
import java.util.Scanner;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

public class Catalogue implements Serializable {

    private GenericLinkedList<Point> points = new GenericLinkedList<Point>();


    public void showPoints() {

        for (Point p : points) {

            System.out.println("name: " + p.getName()
                    + "\nadress: " + p.getAdress()
                    + "\nspecialization: " + p.getSpec());

            System.out.print("worktime: ");

            int index = 0;
            for (String t : p.getTelephones()) {
                if (index == 0)
                    System.out.println("days and hours: ");
                if (index <= 1) {
                    System.out.print(t);
                    if (index == 0)
                        System.out.print(" : ");
                }

                if (index > 1) {
                    if (index == 2) {
                        System.out.print("\ntelephones: ");
                    }
                    System.out.print(t);
                    if (index != p.getTelephones().getSize() - 1)
                        System.out.print(", ");

                }
                index++;

            }
//            System.out.println();
//            System.out.print("telephones: ");

//            for(int j = 2; j < p.getTelephones().size(); ++j) {
//                System.out.print(p.getTelephones().get(j));
//                if(j != 2 && j != p.getTelephones().size() - 1) {System.out.print(", ");}
//            }

            System.out.println();
            System.out.println();
        }

    }


    public void add() {

        Point p = new Point();

        while (true) {

            Scanner scan = new Scanner(System.in);

            System.out.println("enter name of the point: ");
            String input = scan.nextLine();

            if (input.matches("[A-Z][a-z]+ [A-Z][a-z]+"))
                p.setName(input);
            else {
                System.out.println("wrong input, try again.");
                continue;
            }


            System.out.println("enter adress of the point: ");
            p.setAdress(scan.nextLine());
            System.out.println("enter spec: ");
            p.setSpec(scan.nextLine());


            System.out.println("enter days: ");
            input = scan.nextLine();

            if (input.matches("[0-9]\\z"))
                p.addTelephone(input);
            else {
                System.out.println("wrong input, try againe");
                break;
            }

            System.out.println("enter hours: ");
            input = scan.nextLine();

            if (input.matches("[0-9]\\z"))
                p.addTelephone(input);
            else {
                System.out.println("wrong input, try againe");
                break;
            }


            while (true) {

                System.out.println("add a telephone? (Y/n): ");

                String choice = scan.nextLine();
                if (choice.equals("y") || choice.equals("Y")) {

                    input = scan.nextLine();
                    if (input.matches(".[0-9][0-9][0-9]. [0-9][0-9][0-9] [0-9][0-9][0-9][0-9]"))
                        p.addTelephone(input);
                    else {
                        System.out.println("wrong input, try againe");
                    }
                } else {
                    break;
                }
            }

            points.insert(p);

            System.out.println("sale point succesfully added!!!");
            break;

        }
    }


        public void add(Point p){

            points.insert(p);

            System.out.println("sale point succesfully added!!!");

        }


        public void remove_point () {

            Scanner scan = new Scanner(System.in);
            System.out.println("number of point you want to delete?");
            points.remove(scan.nextInt());

        }


        public void remove_point (int i){

            points.remove(i - 1);

        }

        //	public void encode(Point p){
//
//		XMLEncoder encoder;
//        try {
//			encoder = new XMLEncoder(new FileOutputStream("test.xml"));
//        	encoder.writeObject(p);
//
//        	//String encodingTelephones = objectToString(p.getTelephones());
//        	//encoder.writeObject(encodingTelephones);
//
//        	//String encodingWorktime = objectToString(p.getWorktime());
//        	//encoder.writeObject(encodingWorktime);
//
//        } catch (IOException e){
//                e.printStackTrace();
//        }
//
//	}
//
//	public void decode() {
//
//		XMLDecoder decoder;
//        try {
//
//			decoder = new XMLDecoder(new FileInputStream("test.xml"));
//
//        	Point p = (Point) decoder.readObject();
//
////        	p.setTelephones((ArrayList<String>) decoder.readObject());
//
////        	p.setWorktime((HashMap<String, String>) decoder.readObject());
//				List parsedList = (List) stringToObject((String) decoder.readObject());
//				p.setTelephones((ArrayList<String>) decoder.readObject());
//
//				Map parsedMap = (Map) stringToObject((String) decoder.readObject());
//				p.setWorktime((ArrayList<String>) decoder.readObject());
//
//        	System.out.println("Name: " + 				p.getName()
//            			   + "\nAdress: " + 			p.getAdress()
//            			   + "\nPhone numbers: " + 		p.getTelephones()
//            			   + "\nSpecialization: " + 	p.getSpec()
//            			   + "\nWorktime: " + 			p.getWorktime());
//
//        } catch (FileNotFoundException e) {
//                e.printStackTrace();
//        }
//	}
        public void serialize () {
            try {
                FileOutputStream fOutput = new FileOutputStream("file.txt");
                ObjectOutputStream sOutput = new ObjectOutputStream(fOutput);
                sOutput.writeObject(points);
                sOutput.flush();
                sOutput.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
            System.out.println("object written successfully.");
        }

        public void deSerialize () {
            try {
                FileInputStream fInput = new FileInputStream("file.txt");
                ObjectInputStream sInput = new ObjectInputStream(fInput);
                points = (GenericLinkedList<Point>) sInput.readObject();
                sInput.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
            System.out.println("object read successfully.");
        }

        public void encode () {

            XMLEncoder encoder;
            try {
                encoder = new XMLEncoder(new FileOutputStream("text.xml"));
                encoder.writeObject(points);
                for (Point i : points) {
                    encoder.writeObject(i);
                    encoder.writeObject(i.getTelephones());
                    for (String j : i.getTelephones())
                        encoder.writeObject(j);
                }
                encoder.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("file not found.");
            }
            System.out.println("xml written successfully.");

        }


        public void decode () {

            XMLDecoder decoder;
            try {
                decoder = new XMLDecoder(new FileInputStream("text.xml"));
                points = (GenericLinkedList<Point>) decoder.readObject();
                Object o = null;
                while (true) {
                    try {
                        Point t;
                        if (o == null)
                            t = (Point) decoder.readObject();
                        else
                            t = (Point) o;
                        GenericLinkedList<String> telephones = (GenericLinkedList<String>) decoder.readObject();
                        while (true) {
                            try {
                                o = decoder.readObject();
                                if (o.getClass().equals(String.class)) {
                                    String s = (String) o;
                                    telephones.insert(s);
                                } else {
                                    break;
                                }
                            } catch (Exception e) {
                                break;
                            }
                        }
                        t.setTelephones(telephones);
                        points.insert(t);
                    } catch (Exception e) {
                        break;
                    }
                }
                decoder.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("file not found.");
            }
            System.out.println("xml loaded successfully.");
        }


        public static String objectToString (Object list){
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            XMLEncoder xmlEncoder = new XMLEncoder(bos);
            xmlEncoder.writeObject(list);
            xmlEncoder.close();
            return bos.toString();
        }

        public static Object stringToObject (String string){
            XMLDecoder xmlDecoder = new XMLDecoder(new ByteArrayInputStream(string.getBytes()));
            return xmlDecoder.readObject();
        }
    }


