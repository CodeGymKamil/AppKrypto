package models;

import java.util.Arrays;
import java.util.Set;

public class BruteForceAttack {

    private char[] alphabet;

    public BruteForceAttack(char[] alphabet) {
        this.alphabet = alphabet;
    }

    public String bruteForceAttack(String wordDecrypt) {
        int bestShift = 0;
        int maxPoints = 0;

        String[] targetWords = {
                "i", "up", "end", "the", "and", "to", "of", "a", "in", "that",
                "it", "is", "was", "for", "you", "he", "be", "on", "are", "with",
                "as", "his", "they", "at", "one", "have", "this", "from", "or",
                "had", "by", "hot", "word", "but", "what", "some", "we", "can",
                "out", "other", "were", "all", "there", "when", "your", "how",
                "said", "an", "each", "she", "which", "123", "12", "new", "more",
                "if", "no", "man", "do", "my", "time", "than", "first", "water",
                "been", "called", "who", "oil", "its", "now", "find", "long",
                "down", "day", "did", "get", "come", "made", "may", "part","like"
        };

        int noWordPenalty = -10;

        for (int shift = 0; shift < alphabet.length; shift++) {
            CaesarCipher caesarCipher = new CaesarCipher(alphabet, shift);
            String decryptedText = caesarCipher.decrypt(wordDecrypt);
            int points = 0;

            for (String word : targetWords) {
                if (decryptedText.contains(word)) {
                    points += 5;
                }
            }

            if (points == 0) {
                points += noWordPenalty;
            }
            System.out.println("Decryption with shift " + shift + ": " + decryptedText +" Points:" +points );
            if (points > maxPoints) {
                maxPoints = points;
                bestShift = shift;
            }

        }


        CaesarCipher caesarCipher = new CaesarCipher(alphabet, bestShift);
        String bestDecryption = caesarCipher.decrypt(wordDecrypt);

        System.out.println("Best decryption: " + bestDecryption);
        return bestDecryption;
    }

}
