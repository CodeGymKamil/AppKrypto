import models.BruteForceAttack;
import models.CaesarCipher;
import util.FileUtils;

import java.util.Scanner;

import static util.Config.*;
import static util.Helper.printMenu;
import static util.Config.*;
import static util.Helper.printMenu;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] customAlphabetPL = FileUtils.readAlphabetFromFile("AlphabetPL");

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

                        System.out.println("Input string: " + plaintext);
                        System.out.println("Input shift value: " + shift);
                        break;
                    case 2:
                        if (plaintext.isEmpty()) {
                            System.out.println("Please enter some text first.");
                        } else {
                            caesarCipher = createCaesarCipher(customAlphabetPL, shift);
                            encryptedText = caesarCipher.encrypt(plaintext);

                            System.out.println("Encrypt: " + encryptedText);
                        }
                        break;
                    case 3:
                        if (plaintext.isEmpty()) {
                            System.out.println("Please enter some text first.");
                        } else {
                            if (caesarCipher != null) {
                                String decryptedText = caesarCipher.decrypt(encryptedText);
                                System.out.println("Decrypt: " + decryptedText);
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
                            if (caesarCipher != null) {
                                encryptedText = caesarCipher.encrypt(encryptedText);
                                BruteForceAttack bruteForceAttack = new BruteForceAttack(customAlphabetPL);
                                String decryptedText = bruteForceAttack.bruteForceAttack(encryptedText);
                                System.out.println("Decrypted text: " + decryptedText);
                            } else {
                                System.out.println("There is no word of Encrypt.");
                                System.out.println("Please enter some text first.");
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
                scanner.nextLine();
            }
        }
    }

    private static CaesarCipher createCaesarCipher(char[] alphabet, int shift) {
        return new CaesarCipher(alphabet, shift);
    }
}











