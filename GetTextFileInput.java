package assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GetTextFileInput {

    private static BufferedReader br = null;
    static int count = 0;

    public static void openFile() {
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\USER\\Desktop\\Test.txt"));

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void readFile() {

        String line = "";
        int countComment = 0;

        try {

            while ((line = br.readLine()) != null) {
                int a = line.indexOf("/*");
                //System.out.println(a);
                if (a < 0) {
                   System.out.println(line);
                   
                } else {
                    String c = line.substring(a, a + 2);
                    if (c.contains("/*")||c.contains("*/")||c.contains("//")) {
                        count++;
                        System.out.println("Comment");
                    }
                }

            }

            br.close();

            System.out.println("Total Comment Line is : " + count);

        } catch (IOException e) {

            System.out.println(e);

        }

    }

    public static void main(String[] args) {

        openFile();
        readFile();

    }
}
