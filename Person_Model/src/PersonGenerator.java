/*
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.SQLOutput;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {

    public static void main(String[] args) {
        ArrayList<String> folks = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\personData.txt");

        boolean done = false;

        String personRec = " ";
        String ID = " ";
        String firstName = " ";
        String lastName = " ";
        String title = " ";
        int YOB = 0;

        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter the ID [6digits]: ");
            firstName = SafeInput.getNonZeroLenString(in, "Enter the first name: ");
            lastName = SafeInput.getNonZeroLenString(in, "Enter the last name: ");
            title = SafeInput.getNonZeroLenString(in, "Enter the title: ");
            YOB = SafeInput.getRangedInt(in, "Enter the year of birthd: ", 1000, 9999 );

            personRec = ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
            folks.add(personRec);

            done = SafeInput.getYNConfirm(in, "Are you done? ");

        }while(!done);

        for( String p: folks)
            System.out.println(p);

        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(String rec : folks)
            {
                writer.write(rec, 0, rec.length());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }

}
 */

import java.io.*;

import java.util.*;

public class PersonGenerator {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Person p1 = new Person();
        String id, fname, lname, title;
        int yob;
        // taking user input
        System.out.println("Enter ID:");
        id = br.readLine();
        System.out.println("Enter first name:");
        fname = br.readLine();
        System.out.println("Enter last name:");
        lname = br.readLine();
        System.out.println("Enter title like Mr. Mrs. Prof. Ms. etc:");
        title = br.readLine();
        System.out.println("Enter year of birth:");
        yob = Integer.parseInt(br.readLine());
        // initializing the object with userdefiend values
        Person p1 = new Person(id, fname, lname, title, yob);
        // arraylist of type Person to store all the objects
        ArrayList<Person> l = new ArrayList<Person>();
        l.add(p1);
        // writing data to csv file and also be a text file with no issue
        FileWriter writer = new FileWriter("PersonTestData.txt", true);
        for (Person p : l) {
            writer.write(p.toTXTDataRecord());
        }
        writer.close();
    }
}



