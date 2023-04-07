import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.SQLOutput;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonReader {

    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";

        try
        {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                InputStream in=
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                int line = 0;

                System.out.printf( "%-5s %5s %5s %5s %5s %n", "Line", "  No. ID", "FirstName", "LastName", "Title Yob");
                System.out.printf( "%-5s %n", "===============================================");
                while(reader.ready())
                {
                    rec = reader.readLine();
                    line++;

                    System.out.printf("\nLine %4d %-70s ", line, rec);
                }
                reader.close();
                System.out.println("\n\nData file read!");
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
