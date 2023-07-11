package org.example;

import java.sql.*;

public class Hurtownia_Select {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection =
                    DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Hurtownia_art_spoz",
                            "root", "");
            if (connection == null) {
                System.out.println("Brak połączenia z bazą danych.");
            } else {
                System.out.println("Jest połączenie.");
            }
            statement = connection.createStatement();
            String sql = "SELECT * FROM kontakt";

            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int idk = resultSet.getInt("idk");
                String nr_telefonu = resultSet.getString("nr_telefonu");
                String fax = resultSet.getString("fax");
                String mail = resultSet.getString("mail");
                String www = resultSet.getString("www");
                System.out.println(" idk " + idk + " nr_telefonu " + nr_telefonu + " fax "
                        + fax + " mail " + mail + " www " + www);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            // zamykanie bazy danych
        } finally {
            try {
                resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


