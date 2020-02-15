package assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SecondAssignment {

    private static BufferedReader br = null;
    static int count = 0;
    static int newCount = 0;

    static int s_Count = 0;
    static int s_newCount = 0;

    public static void openFile() {
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\USER\\Desktop\\Test.txt"));

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void readFile() {

        String line = "";

        try {

            while ((line = br.readLine()) != null) {

                if (line.equals("") || line.equals("}") || line.equals("{")) {

                    System.out.println(line);

                } else {

                    char f_FirstChar = line.charAt(0);
                    char f_SecondChar = line.charAt(1);
                    String c = f_FirstChar + "" + f_SecondChar;

                    //First  Comment  Check...............
                    if (c.equals("/*")) {
                        count++;

                        if (isChcekString(line)) {

                        }

                    } else if (!isChcekString(line)) {
                        System.out.println(line);

                    }

                    //Second Comment Check Start...............
                    for (int i = 0; i < line.length() - 1; i++) {

                        char s_FirstChar = line.charAt(i);
                        char s_SecondChar = line.charAt(i + 1);
                        String sC = s_FirstChar + "" + s_SecondChar;
                        if (sC.contains("//")) {
                            s_Count++;

                            System.out.println(isSecondChcekString(line));
                        }

                    }

                }

            }

            br.close();

        } catch (IOException e) {

            System.out.println(e);

        }

    }

    public static void main(String[] args) {

        openFile();
        readFile();

    }

    private static boolean isChcekString(String line) {

        boolean check = false;

        for (int i = 0; i < line.length() - 1; i++) {

            char sceondLastChar = line.charAt(i);
            char lastChar = line.charAt(i + 1);

            String c = sceondLastChar + "" + lastChar;

            if (c.contains("*/")) {
                newCount++;

                check = true;

            } else if (c.contains("//")) {
                check = true;
                break;
            } else if (newCount == count) {
                check = false;
            } else {
                check = true;
            }

        }

        return check;
    }

    private static String isSecondChcekString(String line) {
        String getData = "";

        for (int i = 0; i < line.length() - 1; i++) {

            char sceondLastChar = line.charAt(i);
            char lastChar = line.charAt(i + 1);

            String c = sceondLastChar + "" + lastChar;

            if (c.contains("//")) {
                s_newCount++;

            } else if (s_Count == s_newCount) {
                getData += "";

            } else {
                getData += sceondLastChar;

            }

        }
        return getData;
    }

}
