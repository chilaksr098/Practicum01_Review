import java.util.*;

public class Person {

    String ID, firstName, lastName, title;
    int YOB;
    public Person() {
        this.ID = "";
        this.firstName = "";
        this.lastName = "";
        this.title = "";
        this.YOB = 0;
    }
    public Person(String ID, String fname, String lname, String title, int yob) {
        this.ID = ID;
        this.firstName = fname;
        this.lastName = lname;
        this.title = title;
        // year validation
        if(yob>=1000 && yob <=9999)
            this.YOB = yob;
    }
    public String fullName() {
        return firstName + " " + lastName;
    }
    public String formalName() {
        return title + " " + fullName();
    }
    public static int getAge(int year) {
        // year validation
        if(year<=1000 && year >=9999)
            return Calendar.getInstance().get(Calendar.YEAR) - year;
        return 0;
    }
    public String toTXTDataRecord() {
        return this.ID + "," + this.firstName + "," + this.lastName + "," + this.title + "," + this.YOB + "\n";
    }
}