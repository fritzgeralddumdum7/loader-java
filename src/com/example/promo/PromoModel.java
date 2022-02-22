package com.example.promo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PromoModel {
    private Connection connection = null;

    public PromoModel(Connection connection) {
        this.connection = connection;
    }

    public void getAllPromo() {
        try {
            Statement statement = this.connection.createStatement();
            String query = "SELECT * FROM promo";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String promoCode = resultSet.getString("promo_code");
                String details = resultSet.getString("details");
                int shortCode = resultSet.getInt("short_code");
                String startDate = resultSet.getDate("start_date").toString();
                String endDate = resultSet.getDate("end_date").toString();

                System.out.println(promoCode + "\t\t" + details + "\t\t\t" + shortCode + "\t\t\t" + startDate + " - " + endDate);
            }
        } catch (SQLException err) {
            System.out.println(err);
        }
    }
}
