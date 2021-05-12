package org.fiek;

import java.util.regex.Pattern;

public class Decrypt {
    public static String decrypt(String ciphertext, String key) {

        if (Pattern.matches("[0-9 ]+", ciphertext)) {
            String[] cipherArray = ciphertext.split(" ");
            String[] splitKey = key.split(" ");

            StringBuilder plaintext = new StringBuilder();
            for (int i = 0; i < cipherArray.length; i++) {
                for (int j = 0; j < splitKey.length; j++) {
                    if (Integer.parseInt(cipherArray[i]) > splitKey.length) {
                        return "The number " + cipherArray[i] + " is invalid.Maximum expected is " + splitKey.length + ".";
                    }
                    if (cipherArray[i].equals(String.valueOf(j + 1))) {
                        plaintext.append(splitKey[j].charAt(0));
                    }
                }
            }
            return "Decrypted text: " + (plaintext);
        } else {
            return "The ciphertext you want to decrypt should only contain numbers!";
        }
    }
}

