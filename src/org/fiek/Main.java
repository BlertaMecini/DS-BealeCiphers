package org.fiek;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("This is the Beale Ciphers encyption/decryption algorithm!");
        System.out.print("You can type encrypt for encryption or decrypt for decryption: ");

        String answer = input.nextLine().toLowerCase();

        if (answer.equals("encrypt")) {
            System.out.print("Enter the text you want to encrypt: ");
            String plaintext = input.nextLine();
            //System.out.printf("Encrypted text: %s", encrypted(plaintext, readFile()));
        } else if (answer.equals("decrypt")) {
            System.out.print("Enter the text you want to decrypt: ");
            String ciphertext = input.nextLine();
            System.out.printf("Decrypted text: %s", decrypted(ciphertext, readFile()));
        } else {
            System.out.println("You must type encrypt or decrypt!");
        }

        input.close();
    }

    public static String readFile() {

        String addNum = "";

        try {
            File myObj = new File("C:/Users/Dell/Desktop/book1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().toLowerCase();
                String[] arrOfStr = data.split(" ");
                int count = 1;
                for (int i = 0; i < arrOfStr.length; i++, count++) {
                    addNum += (arrOfStr[i] + count + " ");
                }
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return addNum;
    }


    /*public static String encrypted(String plaintext, String key) {
        char[] plaintextArray = plaintext.toCharArray();
        String regex = "\\d";
        String[] splitedKey = key.split(" ");

        String ciphertext = "";
        for (int i = 0; i < plaintextArray.length; i++) {
            for (int j = 0; j < splitedKey.length; j++) {
                if (plaintextArray[i] == splitedKey[i].charAt(0)) {
                }
            }
        }
        return ciphertext;
    }*/

    public static String decrypted(String ciphertext, String key) {

        String cipherArr[] = ciphertext.split(" ");
        String[] splitedKey = key.split(" ");

        String[] getNum = new String[splitedKey.length];
        for (int i = 0; i < splitedKey.length; i++) {
            Matcher matcher = Pattern.compile("\\d+").matcher(splitedKey[i]);
            matcher.find();
            getNum[i] = String.valueOf(matcher.group());
        }

        String plaintext = "";
        for (int i = 0; i < cipherArr.length; i++) {
            for (int j = 0; j < getNum.length; j++) {
                if (cipherArr[i].equals(getNum[j])) {
                    plaintext += splitedKey[j].substring(0, 1);
                }
            }
        }
        return plaintext;
    }
}
