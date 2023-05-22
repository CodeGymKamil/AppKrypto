package util;

import java.util.LinkedHashMap;
import java.util.Map;

public class Helper {
    private Map<Character, Character> rivertShiftChar;



    public static void verificationMap(Map<Character, Character> customAlphabet) {
        System.out.println("==========================================");
        System.out.println("========== Verification Map ==============");
        System.out.println("Key and Value: ");
        System.out.println("==========================================");

        for (Map.Entry<Character, Character> entry : customAlphabet.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        System.out.println("==========================================");
    }

    public static Map<Character, Character> createAlphabetMap(char[] alphabet, int shift) {
        Map<Character, Character> customAlphabet = new LinkedHashMap<>();
        for (int i = 0; i < alphabet.length; i++) {
            char c = alphabet[i];
            int newIndex = (i + shift) % alphabet.length;
            char toBeReplacedWith = alphabet[newIndex];
            customAlphabet.put(c, toBeReplacedWith);


        }
        return customAlphabet;
    }

    //type
    public static void printMenu() {
        System.out.println("================= MENU =================");
        System.out.println("1. Enter text to encrypt and shift value.");
        System.out.println("2. Encrypt value.");
        System.out.println("3. Encrypt decrypt.");
        System.out.println("4 Perform encrypt-decrypt with brute force attack.");
        System.out.println("5. Exit program.");
        System.out.println("=======================================");
        System.out.print("Enter your choice: ");
    }

}



