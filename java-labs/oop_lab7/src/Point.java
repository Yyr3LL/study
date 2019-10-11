import java.io.Serializable;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Map;
import java.util.ArrayList;


public class Point implements Serializable, Comparable {

    private String name;
    private String adress;
    private LinkedList<String> telephones;
    private String spec;

    public Point() {
    }

    public Point(String name, String adress, LinkedList<String> telephones, String spec) {
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

    public LinkedList<String> getTelephones() {
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

    public void setTelephones(LinkedList<String> telephones) {
        this.telephones = telephones;
    }


    @Override
    public int compareTo(Object p) {
        int result = this.name.compareTo(((Point)p).name);

        if (result == 0) {
            result = this.spec.compareTo(((Point)p).spec);
        }
        if (result == 0) {
            result = this.adress.compareTo(((Point)p).adress);
        }

        return result;
    }
}



