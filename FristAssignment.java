
package assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FristAssignment {


    private static BufferedReader br = null;

    public static void openFile() {
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\USER\\Desktop\\First.txt"));

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void readFile() {

        String line = "";

        try {

            while ((line = br.readLine()) != null) {

                System.out.println(line);

            }

        } catch (IOException ex) {

            System.out.println("File not found");

        }

    }

    public static void main(String[] args) {

        openFile();
        readFile();

    }
}