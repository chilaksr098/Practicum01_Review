import java.util.Calendar;

import java.util.*;

public class Product {

    String ID, Name, Description;
    int Cost;
    public Product() {
        this.ID = "";
        this.Name = "";
        this.Description = "";
        this.Cost = 0;
    }
    public Product(String ID, String name, String desc, int cost) {
        this.ID = ID;
        this.Name = name;
        this.Description = desc;
        // year validation
        if(cost>=1000 && cost <=9999)
            this.Cost = cost;
    }
    public String Name() {
        return Name + " ";
    }
    public String formalName() {
        return Description + " ";
    }
    public static int getCost(int cost) {
        // year validation
        if(cost<=1000 && cost >=9999)
            return Calendar.getInstance().get(Calendar.YEAR) - cost;
        return 0;
    }
    public String toTXTDataRecord() {
        return this.ID + "," + this.Name + "," + this.Description + "," + this.Cost + "\n";
    }
}