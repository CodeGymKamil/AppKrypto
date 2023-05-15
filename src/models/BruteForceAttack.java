package models;

import util.Dictionary;

import java.util.Arrays;
import java.util.Set;

public class BruteForceAttack {
    private Set<String> words;

    public BruteForceAttack(Set<String> words) {
        this.words = words;
    }
    public boolean contains(String word) {
        return words.contains(word);
    }

    public String containsPassword(String password) {
        String[] words = password.split(" ");
        // String[] words = password.split("(?<=[\\w\\d])\\s(?=[\\w\\d])");

        System.out.println(Arrays.toString(words));
        for (String word : words) {
            if (!this.contains(word)) {
                return "Password Decrypt: Not able to decrypt the password.";
            }
        }
        String passwordDecrypt = String.join(" ", words);
        return "Password Brute Force Attack: " + passwordDecrypt;

    }
}
