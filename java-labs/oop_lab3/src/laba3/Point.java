package laba3;

import java.util.ArrayList;


public class Point {
	
	private String name;
	private String adress;
	private ArrayList<String> telephones;
	private String spec;
	
	public Point() {}
	
	public Point(String name, String adress, ArrayList<String> telephones, String spec) { 
		this.name = name;
		this.adress = adress;
		this.telephones = telephones;
		this.spec = spec;
	}
	
	//**********GETTERS**********
	
	public String getName() {
		return this.name;
	}

	public String getAdress() {
		return this.adress;
	}

	public ArrayList<String> getTelephones() {
		return this.telephones;
	}

	public String getSpec() {
		return this.spec;
	}

	//**********SETTERS**********
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public void setTelephones(ArrayList<String> telephones) {
		this.telephones = telephones;
	}

						
}
