package com.example.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

interface DatabaseCredentials {
    String host = "jdbc:mysql://localhost:3306/sms";
    String user = "root";
    String password = "";
}

public class Database implements DatabaseCredentials {
    public Connection connect() {
        Connection connect = null;

        try {
            connect = DriverManager.getConnection(host, user, password);
        } catch (SQLException err) {
            System.out.println(err);
        }

        return connect;
    }
}
