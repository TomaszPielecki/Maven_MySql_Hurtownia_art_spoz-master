package org.example;

import java.sql.*;

public class Hurtownia_Create_table {
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

            String sqlAdress = "CREATE TABLE if not exists adress("
                    + "ida          INT auto_increment Primary Key NOT NULL,"
                    + "miejscowosc  VARCHAR(45) NOT NULL,"
                    + "region       VARCHAR(45)NOT NULL,"
                    + "kod_pocztowy CHAR(10) NOT NULL,"
                    + "ulica        VARCHAR(45) NOT NULL,"
                    + "nr_budynku   VARCHAR(45) NOT NULL)";

            String sqlHurtownia = "CREATE TABLE if not exists hurtownia ("
                    + "nazwa       VARCHAR(45) Primary Key NOT NULL,"
                    + "nip         CHAR(10) NOT NULL,"
                    + "miasto      VARCHAR(50) NOT NULL,"
                    + "ulica       VARCHAR(50) NOT NULL,"
                    + "nr_budynku  VARCHAR(45) NOT NULL)";
            String sqlKontakt = "CREATE TABLE if not exists kontakt("
                    + "idk          INT auto_increment Primary Key NOT NULL,"
                    + "nr_telefonu  VARCHAR(45) NOT NULL,"
                    + "fax          VARCHAR(45) NOT NULL,"
                    + "mail         VARCHAR(45) NOT NULL,"
                    + "www          VARCHAR(45) NOT NULL)";
            String sqlPozZam = "CREATE TABLE if not exists pozzam("
                    + "idpz                 INT auto_increment Primary Key NOT NULL,"
                    + "towary               VARCHAR(40) NULL,"
                    + "pozycja              VARCHAR(40) NULL,"
                    + "ilosc                VARCHAR(40) NULL,"
                    + "zam_idzam            INT(200) NOT NULL,"
                    + "zam_hurtownia_nazwa  VARCHAR(45) NOT NULL,"
                    + "zam_sklep_nip        CHAR(10) NOT NULL)";
            String sqlSklep = "CREATE TABLE if not exists sklep("
                    + "nip           CHAR(10) Primary Key NOT NULL,"
                    + "nazwa_sklepu  VARCHAR(50),"
                    + "region        VARCHAR(50),"
                    + "nazwisko      VARCHAR(50),"
                    + "imie          VARCHAR(50),"
                    + "adress_ida    INT NOT NULL,"
                    + "kontakt_idk   INT NOT NULL)";
            String sqlTowary = "CREATE TABLE if not exists towary("
                    + "idt                         INT auto_increment Primary Key NOT NULL,"
                    + "producent                   VARCHAR(45),"
                    + "rodzaj                      VARCHAR(45),"
                    + "opis_towaru                 TEXT,"
                    + "cenna_towaru_netto          DECIMAL(10,2) UNSIGNED NOT NULL,"
                    + "cenna_brutto_towaru         DECIMAL(10,2) UNSIGNED NOT NULL,"
                    + "procent_vat_aktualnie       DECIMAL(8,2) UNSIGNED NOT NULL,"
                    + "kod_towaru                  VARCHAR(30),"
                    + "ilosc                       VARCHAR(30),"
                    + "miara                       VARCHAR(30),"
                    + "pozzam_idpz                 INT NOT NULL,"
                    + "pozzam_zam_idzam            INT NOT NULL,"
                    + "pozzam_zam_hurtownia_nazwa  VARCHAR(45) NOT NULL,"
                    + "pozzam_zam_sklep_nip        CHAR(10) NOT NULL )";
            String sqlZam = "CREATE TABLE if not exists zam("
                    + "idzam INT auto_increment Primary Key NOT NULL,"
                    + "data_zlozenia_zamowienia DATE,"
                    + "data_przyjecia_zamowienia DATE,"
                    + "realizacja CHAR (1),"
                    + "data_wysylki DATE,"
                    + "dostawa VARCHAR (45),"
                    + "hurtownia_nazwa VARCHAR(45) NOT NULL,"
                    + "sklep_nip CHAR (10) NOT NULL)";


            statement.executeUpdate(sqlAdress);
            statement.executeUpdate(sqlHurtownia);
            statement.executeUpdate(sqlKontakt);
            statement.executeUpdate(sqlPozZam);
            statement.executeUpdate(sqlSklep);
            statement.executeUpdate(sqlTowary);
            statement.executeUpdate(sqlZam);

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
