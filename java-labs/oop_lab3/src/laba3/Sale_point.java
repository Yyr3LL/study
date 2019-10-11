package laba3;

import java.util.Map;
import java.util.ArrayList;


public class Sale_point {
	
	private String name;
	private String adress;
	private ArrayList<String> telephones;
	private String spec;
	private Map<String, String> worktime;
	
	public Sale_point() {}
	
	public Sale_point(String name, String adress, ArrayList<String> telephones, String spec, Map worktime) { 
		this.name = name;
		this.adress = adress;
		this.telephones = telephones;
		this.spec = spec;
		this.worktime = worktime;
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

	public Map<String, String> getWorktime() {
		return this.worktime;
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

	public void setWorktime(Map<String, String> workitme) {
		this.worktime = worktime;
	}

						
}
