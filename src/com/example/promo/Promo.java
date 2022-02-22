package com.example.promo;


import com.example.database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

interface DBConnection {
    Database db = new Database();
    Connection connection = db.connect();
}
public class Promo implements DBConnection {
    public void showAllPromo() {
        PromoModel promoModel = new PromoModel(connection);

        System.out.println("========================================================================");
        System.out.println("\t\t\t\t\t\t\t\tLIST OF PROMO");
        System.out.println("========================================================================");
        System.out.println("PROMO CODE \t\t DETAILS \t\t\t SHORT CODE \t\t\t VALIDITY");
        System.out.println("------------------------------------------------------------------------");
        promoModel.getAllPromo();
        System.out.println("========================================================================");
    }
}
