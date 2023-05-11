import models.CaesarCipher;
import util.FileUtils;

import static util.Config.*;
import static util.Helper.printSeparator;


public class Main {
    public static void main(String[] args) {

        printSeparator("file");
        FileUtils.addTextFile("AlphabetPL", CASTOMER_ALPHABET_PL);
        FileUtils.addTextFile("AlphabetDU", CASTOMER_ALPHABET_DE);

        char[] customAlphabetPL = FileUtils.readAlphabetFromFile("AlphabetPL");
        char[] customAlphabetDE = FileUtils.readAlphabetFromFile("AlphabetDU");

        int shift = 3;
        String plaintext = "example test";
        String plaintext2 = "example test2";
        CaesarCipher caesarCipher = new CaesarCipher(customAlphabetPL, shift);
        CaesarCipher caesarCipher2 = new CaesarCipher(customAlphabetDE, CASTOMER_SHIFT);
        printSeparator("fileEncrypt");
        String text = caesarCipher.encrypt(plaintext);
        System.out.println(text);
        System.out.println(caesarCipher.decrypt(text));
        printSeparator("fileEncrypt");
        String text2 = caesarCipher2.encrypt(plaintext2);
        System.out.println(text2);
        System.out.println(caesarCipher2.decrypt(text2));

    }


}