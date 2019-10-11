package main.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;


public class Point implements Serializable {

    private StringProperty name;
    private StringProperty adress;
    private StringProperty spec;
    private StringProperty telephone;
    private StringProperty worktime;

    public Point() {
        this(null, null);
    }

    public Point(String name, String spec) {
        this.name = new SimpleStringProperty(name);
        this.spec = new SimpleStringProperty(spec);

        this.adress = new SimpleStringProperty("not stated");
        this.telephone = new SimpleStringProperty("not stated");
        this.worktime = new SimpleStringProperty("not stated");

    }

    //**********GETTERS**********

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty(){
        return name;
    }

    public String getAdress() {
        return adress.get();
    }

    public StringProperty adressProperty(){
        return adress;
    }

    public String getTelephones() {
        return telephone.get();
    }

    public StringProperty telephoneProperty(){
        return telephone;
    }

    public String getSpec() {
        return spec.get();
    }

    public StringProperty specProperty(){
        return spec;
    }

    public String getWorktime() {
        return worktime.get();
    }

    public StringProperty worktimeProperty(){
        return worktime;
    }

    //**********SETTERS**********

    public void setName(String  name) {
        this.name.set(name);
    }

    public void setAdress(String adress) {
        this.adress.set(adress);
    }

    public void setSpec(String spec) {
        this.spec.set(spec);
    }

    public void setTelephones(String telephone) {
        this.telephone.set(telephone);
    }

    public void setWorktime(String worktime) {
        this.worktime.set(worktime);
    }

}



