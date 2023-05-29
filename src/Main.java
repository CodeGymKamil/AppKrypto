import models.BruteForceAttack;
import models.CaesarCipher;
import util.Config;

import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;

import static util.FileUtils.*;
import static util.Helper.*;

/* TEST CISES : "Joanna will invite Mark for Friday dinner."*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] customAlphabetPL = readAlphabetFromFile("AlphabetPL");

        String plaintext = "";
        int shift = 0;
        CaesarCipher caesarCipher = null;
        String encryptedText = null;


        while (true) {
            printMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter some text: ");
                        plaintext = scanner.nextLine();
                        System.out.print("Enter a shift value: ");

                        String shiftInput = scanner.nextLine();
                        while (!shiftInput.matches("\\d+")) {
                            System.out.println("Invalid input. Please enter a numeric value for shift: ");
                            shiftInput = scanner.nextLine();
                        }
                        shift = Integer.parseInt(shiftInput);
                        printLine();
                        System.out.println("Input string: " + plaintext);
                        System.out.println("Input shift value: " + shift);
                        printLine();
                        break;
                    case 2:
                        if (plaintext.isEmpty()) {
                            System.out.println("Please enter some text first.");
                        } else {
                            caesarCipher = createCaesarCipher(customAlphabetPL, shift);
                            encryptedText = caesarCipher.encrypt(plaintext);
                            printLine();
                            System.out.println("Encrypt: " + encryptedText);
                            printLine();
                            System.out.println("Do you want to save the ciphertext to a file? YES => 'y' or NO => 'n'?");
                            String selectionFlag = scanner.nextLine();
                            if (selectionFlag.toLowerCase().equals("y")) {
                                System.out.println("Enter a filename to save the encrypted text:");
                                String filename = scanner.nextLine();
                                addTextFile(filename, encryptedText);
                                System.out.println("The encrypted text has been saved to the file.");
                            } else {
                                System.out.println("Unsaved");
                            }
                        }
                        break;
                    case 3:
                        if (plaintext.isEmpty()) {
                            System.out.println("Please enter some text first.");
                        } else {
                            if (caesarCipher != null) {
                                String decryptedText = caesarCipher.decrypt(encryptedText);
                                printLine();
                                System.out.println("Decrypt: " + decryptedText);
                                printLine();
                            } else {
                                System.out.println("There is no word of Encrypt.");
                                System.out.println("Please enter some text first.");
                            }
                        }
                        break;
                    case 4:
                        if (encryptedText.isEmpty()) {
                            System.out.println("Please enter some text first.");
                        } else {
                            System.out.println("Choose option : decryption from a file or decryption from a sentence.");
                            System.out.println("Enter word: file => 'f' or sentence => 's'.");
                            String selectionWordFlag = scanner.nextLine();
                            if (selectionWordFlag.toLowerCase().equals("f")) {
                                System.out.println("Please enter the file name:");
                                String fileName = scanner.nextLine();
                                String filePath = Paths.get(Config.PATH, fileName + ".txt").toString();
                                File file = new File(filePath);

                                if (!file.exists()) {
                                    System.out.println("The file does not exist.");
                                } else if (file.length() == 0) {
                                    System.out.println("The file is empty.");
                                } else {
                                    encryptedText = readTextFromFile(filePath);
                                    BruteForceAttack bruteForceAttack = new BruteForceAttack(customAlphabetPL);
                                    bruteForceAttack.bruteForceAttack(encryptedText);
                                }
                            } else {
                                if (caesarCipher != null) {
                                    BruteForceAttack bruteForce = new BruteForceAttack(customAlphabetPL);
                                    bruteForce.bruteForceAttack(encryptedText);

                                } else {
                                    System.out.println("There is no word of Encrypt.");
                                    System.out.println("Please enter some text first.");
                                }
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Exiting program...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                System.out.println("Press enter.");
                scanner.nextLine();
            }
        }
    }

    private static CaesarCipher createCaesarCipher(char[] alphabet, int shift) {
        return new CaesarCipher(alphabet, shift);
    }
}











