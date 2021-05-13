package org.fiek;

import java.util.ArrayList;
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

            ArrayList<Integer> tempciphertext = new ArrayList<>();
            StringBuilder ciphertext = new StringBuilder();
            for (int i = 0; i < plaintextArray.length; i++) {
                for (int j = 0; j < getLetters.length(); j++) {
                    if (plaintextArray[i] == getLetters.charAt(j)) {
                        tempciphertext.add(j + 1);
                    }
                }
                int index = (int) (Math.random() * tempciphertext.size());
                ciphertext.append(tempciphertext.get(index));
                ciphertext.append(" ");
                tempciphertext.clear();
            }
            return "Encrypted text: " + ciphertext;
        } else {
            return "You can't encrypt special characters!";
        }
    }
}
