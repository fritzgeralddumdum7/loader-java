package com.example.sms;
import com.example.database.Database;
import com.example.promo.Promo;
import com.example.promo.PromoModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.Arrays;

interface Recipient {
    String name = "Francis the Recipient";
}

interface Sender {
    String name = "Francis the Sender";
}

interface DBConnection {
    Database db = new Database();
    Connection connection = db.connect();
}

interface SMSManager {
    void insertSMS();
}

public class SMS implements DBConnection, SMSManager, Recipient, Sender {
    public static void main(String[] args) {
        SMS sms = new SMS();

        sms.showMenu();
        sms.selectToDo();
    }

    // displays the mobile number, message and short code from the user inputs
    public void showUserInputs(String mobileNumber, String message, Integer shortCode) {
        System.out.println("\n=============================");
        System.out.println("Mobile #: " + mobileNumber);
        System.out.println("Message: " + message);
        System.out.println("Short Code: " + shortCode.toString());
        System.out.print("=============================");
    }

    // ask user for its mobile number, message and short code
    public void getUserInputs() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter mobile #: ");
        String mobileNumber = scanner.next();
        System.out.print("Enter message: ");
        String message = scanner.next();
        System.out.print("Enter short code: ");
        Integer shortCode = scanner.nextInt();

        sendSMS(mobileNumber, shortCode);
    }

    // insert new data in sms
    public void sendSMS(String mobileNumber, Integer shortCode) {
        SMSModel smsModel = new SMSModel(connection);

        smsModel.saveSMS(mobileNumber, Recipient.name, Sender.name, shortCode);
    }

    // show all the features of the app
    public void showMenu() {
        System.out.println("=============================");
        System.out.println("Welcome to LOADY: #1 Loader");
        System.out.println("=============================");
        System.out.println("[0] - EXIT");
        System.out.println("[1] - Show all promo");
        System.out.println("[2] - Insert SMS");
        System.out.println("[3] - Retrieve SMS using start & end dates");
        System.out.println("[4] - Retrieve SMS using promo code");
        System.out.println("[5] - Retrieve SMS using MSISDN");
        System.out.println("[6] - Retrieve SMS sent by the system [NOT AVAILABLE]");
        System.out.println("[7] - Retrieve SMS received by the system [NOT AVAILABLE]");
        System.out.println("[8] - Retrieve SMS given several MSISDN");
        System.out.println("=============================\n");
    }

    // ask user on what action to be performed
    public void selectToDo() {
        Integer[] options = {0, 1, 2};
        Scanner scanner = new Scanner(System.in);
        int n;

        do {
            System.out.print("Select an action on what to do using [n]: ");
            n = scanner.nextInt();

            if (!Arrays.asList(options).contains(n)) {
                System.out.println("Invalid selection, please try again!");
            }
        } while (!Arrays.asList(options).contains(n));

        toDos(n);
    }

    // execute the selected action
    public void toDos(int n) {
        Promo promo = new Promo();

        switch (n) {
            case 0 -> System.out.println("Terminating application, thank you for using!");
            case 1 -> {
                promo.showAllPromo();
                selectToDo();
            }
            case 2 -> {
                insertSMS();
            }
            default -> System.out.println("Invalid selection, please try again!");
        }
    }

    @Override
    public void insertSMS() {
        getUserInputs();
    }
}
