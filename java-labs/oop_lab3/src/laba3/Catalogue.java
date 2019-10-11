package laba3;

import java.util.Scanner;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Catalogue {

	ArrayList<Point> points;
//	ArrayList<Point> points;
	
	public Catalogue() {
		points = new ArrayList<>();
	}
	
	public boolean add(Point point) {
		return points.add(point);
	}
	
//	public boolean remove(Point point) {
//		return points.remove(point);
//	}
	
//	public Point findPoint(String name) {
//
//		for(int i = 0; i < points.size(); i++) {
//			if(points.get(i).getName().equals(name)) {
//				System.out.println("object was found succsesfully!");
//				return points.get(i);
//			}
//		}
//		
//		return null;
//		
//	}
	
	public void showPoints() {
		
		for(int i = 0; i < points.size(); ++i) {
			System.out.println("Name: " + 				points.get(i).getName() 
					   + "\nAdress: " + 			points.get(i).getAdress()
					   + "\nSpecialization: " + 	points.get(i).getSpec());
		
			System.out.print("Worktime: ");

			for(int j = 0; j < 2; ++j) { 
				System.out.print(points.get(i).getTelephones().get(j)); 
				if(j == 0) { System.out.print(" : "); }
			}
			
			System.out.println();
			System.out.print("telephones: ");

			for(int j = 2; j < points.get(i).getTelephones().size(); ++j) {
				System.out.print(points.get(i).getTelephones().get(j));
				if(j != 2 && j != points.get(i).getTelephones().size() - 1) {System.out.print(", ");}
			}
			
			System.out.println();
			System.out.println();
		}
		
	}
	
//	public void showPoints(String name) {
//	
//		for(int i = 0; i < points.size(); i++) {
//			
//			if(points.get(i).getName().equals(name)) {
//				
//				System.out.println("Name: " + 				points.get(i).getName() 
//							   + "\nAdress: " + 			points.get(i).getAdress()
//							   + "\nSpecialization: " + 	points.get(i).getSpec());
//				
//				System.out.print("Worktime: ");
//
//				for(int j = 0; j < 2; ++j) { 
//					System.out.print(points.get(i).getTelephones().get(j) + ", "); 
//				}
//				
//
//				System.out.print("telephones: ");
//
//				for(int j = 2; j < points.get(i).getTelephones().size(); ++j)
//					System.out.print(points.get(i).getTelephones().get(j)); System.out.print(" ");
//				
//				System.out.println();
//			}
//	
//		}
//	}
	
	public int sizeOfPoints() {
		return points.size();
	}
	
	public void addSalePoint() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("enter name of the point: ");
		String name = scan.nextLine();
		
		System.out.println("enter adress of the point: ");
		String adress = scan.nextLine();
		
		ArrayList<String> telephones = new ArrayList<>();

		System.out.println("enter days: ");
		telephones.add(scan.nextLine());
		System.out.println("enter hours: ");
		telephones.add(scan.nextLine());
		
		System.out.println("enter number of telephones \nyou're going to add: ");
		int num = scan.nextInt();


		for(int i = 0; i < num + 1; i++){

			telephones.add(scan.nextLine());

		}
		
		System.out.println("enter spec: ");
		String spec = scan.nextLine();
		
		points.add(new Point(name, adress, telephones, spec));

		System.out.println("sale point succesfully added!!!");	

	}

	public void removeSalePoint(){

		Scanner scan = new Scanner(System.in);

        System.out.println("enter point's name you want to delete");

        String deletingName = scan.nextLine();

        for(int i = 0; i < points.size(); i++)
        {
        	if(points.get(i).getName().equals(deletingName)) {
                points.remove(i);
                System.out.println("item succesfully removed");
            }
            else
                System.out.println("there's no item like that, sorry");

        }
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

	public void encode() {
		
		XMLEncoder encoder;

		try {

			encoder = new XMLEncoder(new FileOutputStream("test.xml"));
			encoder.writeObject(points);

			for (Point i : points){

				String listToString = objectToString(i.getTelephones());
	        	encoder.writeObject(listToString);

			}

			encoder.close();

		} catch (FileNotFoundException e) {

			System.out.println("File not found!");

		}
		
	}
	
	

	public void decode() {
		 
		XMLDecoder decoder;

		try {

			decoder = new XMLDecoder(new FileInputStream("test.xml"));
			points = (ArrayList<Point>) decoder.readObject();

			for (Point p : points) {
				
				ArrayList parsedList = (ArrayList) stringToObject((String) decoder.readObject());
				p.setTelephones((ArrayList<String>) parsedList);
				
			}

			showPoints();

			decoder.close();

		} catch (FileNotFoundException e) {

			System.out.println("File not found!");

		}
	}


	public static String objectToString(Object list) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        XMLEncoder xmlEncoder = new XMLEncoder(bos);
        xmlEncoder.writeObject(list);
        xmlEncoder.close();
        return bos.toString();
    }

    public static Object stringToObject(String string) {
        XMLDecoder xmlDecoder = new XMLDecoder(new ByteArrayInputStream(string.getBytes()));
        return xmlDecoder.readObject();
    }
}
