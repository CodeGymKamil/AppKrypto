package util;

import java.util.LinkedHashMap;
import java.util.Map;

public class Helper {

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
        // verificationMap(customAlphabet);
        return customAlphabet;
    }

    //type
    public static void printSeparator(String type) {

        if (type == "encrypt") {
            System.out.println("=================Encrypt==================");
        } else if (type == "encrypt") {
            System.out.println("==================encrypt=================");
        } else if (type == "fileEncrypt") {
            System.out.println("===================FileEncrypt===================");
        } else if (type == "file") {
            System.out.println("===================File===================");
        } else {
            System.out.println("==========================================");
        }
    }

}



