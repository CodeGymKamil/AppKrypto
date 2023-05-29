package util;

import java.io.*;
import java.util.Scanner;

import static util.Config.PATH;

public class FileUtils {

    public static void addTextFile(String fileName, String text) {

        File file = new File(fileName + ".txt");
        if (file.exists()) {
            System.out.println("File alredy exists.");
        } else {
            try {

                file.createNewFile();
                FileWriter writer = new FileWriter(file);
                writer.write(text);
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
            File file = new File(fileName + ".txt");
            Scanner scanner = new Scanner(file);
            String alphabetString = scanner.nextLine();
            alphabet = alphabetString.toCharArray();
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return alphabet;
    }

    public static String readTextFromFile(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

}
