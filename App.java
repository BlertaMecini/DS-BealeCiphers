package org.fiek;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App extends Application {
    private TextArea encryptTextArea;
    private TextArea encryptedTextArea;
    private TextArea decryptTextArea;
    private TextArea decryptedTextArea;

    public static void main(String[] args) {
        Application.launch(args);
    }

        public String encrypt(String plaintext, String key) {

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
                return  String.valueOf(ciphertext);
            } else {
                return "You can't encrypt special characters!";
            }
        }


        public String readFile() {

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

    @Override
    public void start(Stage primaryStage) throws Exception {

        TabPane pane = new TabPane();
        pane.setMinSize(700, 500);
        pane.setTabMinHeight(30);
        pane.setTabMinWidth(60);

        Tab encryptTab = new Tab("Encrypt", getEncryptContent());
        encryptTab.setClosable(false);
        encryptTab.setStyle("-fx-background-color:white;-fx-text-base-color:teal;-fx-font-size: 15px;" +
                "-fx-accent:teal;-fx-focus-color:teal;");

        Tab decryptTab = new Tab("Decrypt", getDecryptContent());
        decryptTab.setClosable(false);
        decryptTab.setStyle("-fx-background-color:white;-fx-text-base-color:teal;-fx-font-size: 15px;" +
                "-fx-accent:teal;-fx-focus-color:teal;");

        pane.getTabs().addAll(encryptTab, decryptTab);

        BackgroundFill background_fill = new BackgroundFill(Color.rgb(225, 235, 232),
                CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        pane.setBackground(background);

        Scene scene = new Scene(pane);
        primaryStage.getIcons().add(new Image("https://icons-for-free.com/iconfiles/png/512/green+lock+privacy+safe+secure+security+icon-1320196713520107078.png"));
        primaryStage.setTitle("Beale Ciphers");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private Node getEncryptContent() {

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(15));
        gridPane.setVgap(30);
        gridPane.setHgap(30);
        gridPane.setAlignment(Pos.CENTER);

        Label title = new Label("Beale Ciphers");
        title.setStyle("-fx-font-family: Algerian; -fx-font-size: 22; -fx-text-fill:teal; ");

        Label encryptLabel = new Label("Text to encrypt:");
        encryptLabel.setFont(Font.font(20));
        encryptLabel.setMinSize(150, 50);

        encryptTextArea = new TextArea();
        encryptTextArea.setPrefSize(300, 30);
        encryptTextArea.setMinSize(300, 30);
        encryptTextArea.setStyle("-fx-font-size: 15; -fx-text-fill: black;");

        Label encryptedTextLabel = new Label("Encrypted text:");
        encryptedTextLabel.setFont(Font.font(20));
        encryptedTextLabel.setMinSize(150, 50);
        encryptedTextArea = new TextArea();
        encryptedTextArea.setPrefSize(300, 30);
        encryptTextArea.setMinSize(300, 30);
        encryptedTextArea.setStyle("-fx-font-size: 15; -fx-text-fill:black; -fx-font-weight:bold;");
        encryptedTextArea.setEditable(false);

        Button encryptButton = new Button("Encrypt");
        encryptButton.setFont(Font.font(15));
        encryptButton.setPrefSize(150, 30);
        encryptButton.setStyle("-fx-background-color: teal; -fx-text-fill: white;");

        Button clearButton = new Button("Clear");
        clearButton.setFont(Font.font(15));
        clearButton.setPrefSize(150, 30);
        clearButton.setStyle("-fx-background-color: teal; -fx-text-fill: white;");

        gridPane.add(title, 1, 0);
        gridPane.add(encryptLabel, 0, 1);
        gridPane.add(encryptTextArea, 1, 1, 2, 1);
        gridPane.add(encryptButton, 1, 2);
        gridPane.add(clearButton, 2, 2);
        gridPane.add(encryptedTextLabel, 0, 3);
        gridPane.add(encryptedTextArea, 1, 3, 2, 1);

        encryptButton.setOnAction(e -> {
            encryptedTextArea.setText(encrypt(encryptTextArea.getText().toLowerCase(), readFile()));
        });

        clearButton.setOnAction(new ClearEncryptButtonEventHandler());

        return gridPane;
    }

    private Node getDecryptContent() {

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(15));
        gridPane.setVgap(30);
        gridPane.setHgap(30);
        gridPane.setAlignment(Pos.CENTER);

        Label title2 = new Label("Beale Ciphers");
        title2.setStyle("-fx-font-family: Algerian; -fx-font-size: 22; -fx-text-fill:teal; ");

        Label decryptLabel = new Label("Text to decrypt:");
        decryptLabel.setFont(Font.font(20));
        decryptLabel.setMinSize(150, 50);

        decryptTextArea = new TextArea();
        decryptTextArea.setPrefSize(300, 30);
        decryptTextArea.setMinSize(300, 30);
        decryptTextArea.setStyle("-fx-font-size: 15; -fx-text-fill: black;");

        Label decryptedTextLabel = new Label("Decrypted text:");
        decryptedTextLabel.setFont(Font.font(20));
        decryptedTextLabel.setMinSize(150, 50);

        decryptedTextArea = new TextArea();
        decryptedTextArea.setPrefSize(300, 30);
        decryptedTextArea.setMinSize(300, 30);
        decryptedTextArea.setStyle("-fx-font-size: 15;-fx-font-color:black; -fx-font-weight:bold;");
        decryptedTextArea.setEditable(false);

        Button decryptButton = new Button("Decrypt");
        decryptButton.setFont(Font.font(15));
        decryptButton.setPrefSize(150, 30);
        decryptButton.setStyle("-fx-background-color: teal; -fx-text-fill: white;");

        Button clearButton = new Button("Clear");
        clearButton.setFont(Font.font(15));
        clearButton.setPrefSize(150, 30);
        clearButton.setStyle("-fx-background-color: teal; -fx-text-fill: white;");

        gridPane.add(title2, 1, 0);
        gridPane.add(decryptLabel, 0, 1);
        gridPane.add(decryptTextArea, 1, 1, 2, 1);
        gridPane.add(decryptButton, 1, 2);
        gridPane.add(clearButton, 2, 2);
        gridPane.add(decryptedTextLabel, 0, 3);
        gridPane.add(decryptedTextArea, 1, 3, 2, 1);

        decryptButton.setOnAction(e -> {
            decryptedTextArea.setText(decrypt(decryptTextArea.getText().toLowerCase(), readFile()));
        });

        clearButton.setOnAction(new clearDecryptButtonEventHandler());

        return gridPane;
    }

    public String decrypt(String ciphertext, String key) {

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
            return String.valueOf(plaintext);
        } else {
            return "The ciphertext you want to decrypt should only contain numbers!";
        }
    }

    class ClearEncryptButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            encryptTextArea.setText("");
            encryptedTextArea.setText("");
        }
    }

    class clearDecryptButtonEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            decryptTextArea.setText("");
            decryptedTextArea.setText("");
        }
    }
}