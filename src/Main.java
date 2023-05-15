import models.BruteForceAttack;
import models.CaesarCipher;
import util.Dictionary;
import util.FileUtils;

import static util.Config.*;
import static util.Helper.printSeparator;


public class Main {
    public static void main(String[] args) {

        printSeparator("file");

        FileUtils.addTextFile("AlphabetPL", CASTOMER_ALPHABET_PL);
        FileUtils.addTextFile("AlphabetDU", CASTOMER_ALPHABET_DE);

        char[] customAlphabetPL = FileUtils.readAlphabetFromFile("AlphabetPL");
        // char[] customAlphabetDE = FileUtils.readAlphabetFromFile("AlphabetDU");

        int shift = 3;
        //String plaintext = "example test";
        String plaintext = "example test2";
        String plaintext3 = "example test2%";

        printSeparator("password");
        System.out.println(plaintext);
        //String plaintext2 = "example test2";

        CaesarCipher caesarCipher = new CaesarCipher(customAlphabetPL, 3);
        // CaesarCipher caesarCipher2 = new CaesarCipher(customAlphabetDE, CASTOMER_SHIFT);

        printSeparator("encryptDecrypt");
        String text = caesarCipher.encrypt(plaintext);
        System.out.println("Encrypt: " + text);
        String passwordDecrypt = caesarCipher.decrypt(text);
        System.out.println("Decrypt: " + passwordDecrypt);

        printSeparator("attack");
        Dictionary dictionary = new Dictionary();

        BruteForceAttack bruteForceAttack = new BruteForceAttack(dictionary.words);
        System.out.println(bruteForceAttack.containsPassword(passwordDecrypt));


    }


}