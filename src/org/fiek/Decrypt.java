package org.fiek;

import java.util.regex.Pattern;

public class Decrypt {
    public static String decrypt(String ciphertext, String key) {
        if (ciphertext.length() == 0) {
            return "\nYou must type the ciphertext you want to decrypt!";
        }
        if (Pattern.matches("[0-9 ]+", ciphertext)) {
            String[] cipherArray = ciphertext.split(" ");
            String[] splitKey = key.split(" ");

            StringBuilder plaintext = new StringBuilder();
            for (int i = 0; i < cipherArray.length; i++) {
                for (int j = 0; j < splitKey.length; j++) {
                    if (Integer.parseInt(cipherArray[i]) > splitKey.length) {
                        return "\nThe number " + cipherArray[i] + " is invalid. Maximum expected is " + splitKey.length + ".";
                    }
                    if (cipherArray[i].equals(String.valueOf(j + 1))) {
                        plaintext.append(splitKey[j].charAt(0));
                    }
                }
            }
            return "\nDecrypted text: " + (plaintext);
        } else {
            return "\nThe ciphertext you want to decrypt should only contain numbers!";
        }
    }
}

