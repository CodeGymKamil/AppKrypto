package models;

import java.util.Map;

import static util.Helper.createAlphabetMap;

public class CaesarCipher {

    private Map<Character, Character> shiftChar;
    private int shift;

    public CaesarCipher(char[] alphabet, int shift) {
        this.shift = shift;
        shiftChar = createAlphabetMap(alphabet, shift);
    }

    public String encrypt(String plaintext) {
        StringBuilder ciphertextBuilder = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            if (shiftChar.containsKey(c)) {
                char newChar = shiftChar.get(c);
                ciphertextBuilder.append(newChar);
            } else {
                ciphertextBuilder.append(c);
            }
        }
        return ciphertextBuilder.toString();
    }

    public String decrypt(String ciphertext) {
        StringBuilder plaintextBuilder = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            if (shiftChar.containsValue(c)) {
                for (Map.Entry<Character, Character> entry : shiftChar.entrySet()) {
                    if (entry.getValue().equals(c)) {
                        plaintextBuilder.append(entry.getKey());
                        break;
                    }
                }
            } else {
                plaintextBuilder.append(c);
            }
        }
        return plaintextBuilder.toString();
    }


}
