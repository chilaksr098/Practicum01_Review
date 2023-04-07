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

public class ProductWriter {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Person p1 = new Person();
        String ID, name, desc;
        int cost;
        // taking user input
        System.out.println("Enter ID:");
        ID = br.readLine();
        System.out.println("Enter name of the product:");
        name = br.readLine();
        System.out.println("Enter short descrription:");
        desc = br.readLine();
        System.out.println("Enter the product cost:");
        cost = Integer.parseInt(br.readLine());
        // initializing the object with userdefiend values
        Product p1 = new Product(ID, name, desc, cost);
        // arraylist of type Person to store all the objects
        ArrayList<Product> l = new ArrayList<Product>();
        l.add(p1);
        // writing data to csv file and also be a text file with no issue
        FileWriter writer = new FileWriter("ProductTestData.txt", true);
        for (Product p : l) {
            writer.write(p.toTXTDataRecord());
        }
        writer.close();
    }
}



