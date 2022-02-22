package com.example.sms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class SMSModel {
    private Connection connection = null;

    public SMSModel(Connection connection) {
        this.connection = connection;
    }

    public void saveSMS(String msisdn, String recipient, String sender, Integer shortCode) {
        try {
            Statement statement = this.connection.createStatement();
            String query = "INSERT INTO sms" + "(msisdn, recipient, sender, short_code, transaction_id)" + "values(" + msisdn + ", '" + recipient + "', '" + sender + "', " + shortCode + ", '" + generateUUID() + "')";
            statement.executeQuery(query);

            System.out.println("SMS successfully sent.");
        } catch (SQLException err) {
            System.out.println(err);
        }
    }

    private String generateUUID() {
        return UUID.randomUUID().toString();
    }
}
