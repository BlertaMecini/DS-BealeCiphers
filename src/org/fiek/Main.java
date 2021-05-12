package org.fiek;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("\n---This is the Beale Ciphers encryption/decryption algorithm that uses a text document as a book!---\n");

        while (true) {
            System.out.print("\nYou can type encrypt for encryption, decrypt for decryption or stop to stop the running program: ");
            String answer = input.nextLine().toLowerCase();
            answer = answer.replaceAll(" ", "");
            //String answer=args[0].replaceAll(" ","");
            if (answer.equals("encrypt")) {
                System.out.println("You chose encryption");
                System.out.print("Enter the text you want to encrypt: ");
                String plaintext = input.nextLine().toLowerCase();
                System.out.println(Encrypt.encrypt(plaintext, readFile()));
            } else if (answer.equals("decrypt")) {
                System.out.println("You chose decryption");
                System.out.print("Enter the text you want to decrypt: ");
                String ciphertext = input.nextLine().toLowerCase();
                System.out.println(Decrypt.decrypt(ciphertext, readFile()));
            } else if (answer.equals("stop")) {
                System.out.println("\nThe program is stopping...");
                break;
            } else {
                System.out.print("You must only type encrypt, decrypt or stop!\n");
            }
        }
        input.close();
    }


    public static String readFile() {

        String addNumber = "";

        try {
            File file = new File("book.txt");
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                String text = fileReader.nextLine().toLowerCase();
                String[] arrayOfText = text.split(" ");
                int count = 1;
                for (int i = 0; i < arrayOfText.length; i++, count++) {
                    addNumber += (arrayOfText[i] + count + " ");
                }
            }
            fileReader.close();

        } catch (FileNotFoundException e) {
            System.err.println("\nAn error occurred.The system cannot find the file specified.\n");
            e.printStackTrace();
            System.exit(1);
        }
        return addNumber;
    }
}

