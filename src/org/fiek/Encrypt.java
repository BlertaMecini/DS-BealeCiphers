package org.fiek;

import java.util.regex.Pattern;

public class Encrypt {
    public static String encrypt(String plaintext, String key) {

        if (Pattern.matches("[a-zA-Z0-9 ]+", plaintext)) {
            char[] plaintextArray = plaintext.replaceAll(" ", "").toCharArray();
            String[] splitedKey = key.split(" ");

            StringBuilder getLetters = new StringBuilder();
            for (int i = 0; i < splitedKey.length; i++) {
                getLetters.append(splitedKey[i].charAt(0));
            }

            StringBuilder ciphertext = new StringBuilder();
            for (int i = 0; i < plaintextArray.length; i++) {
                for (int j = 0; j < getLetters.length(); j++) {
                    if (plaintextArray[i] == getLetters.charAt(j)) {
                        ciphertext.append(j + 1);
                        ciphertext.append(" ");
                        break;
                    }
                }
            }
            return "Encrypted text: " + (ciphertext);
        } else {
            return "You can't encrypt special characters!";
        }
    }
}
