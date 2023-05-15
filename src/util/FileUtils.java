package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static util.Config.PATH;

public class FileUtils {

    public static void addTextFile(String fileName, String alphabet) {

        File file = new File(PATH + "/" + fileName + ".txt");
        if (file.exists()) {
            System.out.println("File alredy exists.");
        } else {
            try {

                file.createNewFile();
                FileWriter writer = new FileWriter(file);
                writer.write(alphabet);
                //writer.write(CASTOMER_ALPHABET);
                writer.close();
                System.out.println("File has been created.");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static char[] readAlphabetFromFile(String fileName) {
        char[] alphabet = null;
        try {
            File file = new File(PATH + fileName + ".txt");
            Scanner scanner = new Scanner(file);
            String alphabetString = scanner.nextLine();
            alphabet = alphabetString.toCharArray();
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return alphabet;
    }
}
