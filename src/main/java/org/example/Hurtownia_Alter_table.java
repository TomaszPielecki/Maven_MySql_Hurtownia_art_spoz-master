package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Hurtownia_Alter_table {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
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

            String sqlAlterKontakt = "ALTER TABLE sklep ADD CONSTRAINT kontakt_idk FOREIGN KEY (kontakt_idk) " +
                    "REFERENCES kontakt(idk) ON UPDATE CASCADE ON DELETE CASCADE;";
            String sqlAlterAdress = "ALTER TABLE sklep ADD CONSTRAINT adress_ida FOREIGN KEY (adress_ida) " +
                    "REFERENCES adress(ida) ON UPDATE CASCADE ON DELETE CASCADE;";
            String sqlAlterZam = "ALTER TABLE zam ADD CONSTRAINT sklep_nip FOREIGN KEY (sklep_nip) " +
                    "REFERENCES sklep(nip) ON UPDATE CASCADE ON DELETE CASCADE;";
            String sqlAlterZamHurtownia = "ALTER TABLE zam ADD CONSTRAINT hurtownia_nazwa FOREIGN KEY (hurtownia_nazwa) " +
                    "REFERENCES hurtownia(nazwa) ON UPDATE CASCADE ON DELETE CASCADE;";


            statement.executeUpdate(sqlAlterKontakt);
            statement.executeUpdate(sqlAlterAdress);
            statement.executeUpdate(sqlAlterZam);
            statement.executeUpdate(sqlAlterZamHurtownia);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            // zamykanie bazy danych
        } finally {
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
