package org.example;

import java.sql.*;

public class Hurtownia_Insert_table {
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

            String sqlkontaktInsert = "INSERT INTO kontakt(nr_telefonu, fax, mail, www) VALUES"
                    + "(2794456, 2567890, 'tom@wp.pl', 'www.laga.pl'),"
                    + "(2785578, 6773390, 'domi@o2.pl', 'www.dominierz.pl'),"
                    + "(2793323, 5552267, 'okroj@go2.pl', 'www.okroj.pl'),"
                    + "(2733423, 5555267, 'damc@go2.pl', 'www.damc.pl'),"
                    + "(2743223, 5555267, 'wejer@go2.pl', 'www.wejerka.pl')";
            String sqlAdressInsert = "INSERT INTO adress(miejscowosc, region, kod_pocztowy, ulica, nr_budynku) VALUES"
                    + "('Łebno', 'Pomorze', '83303', 'Chorobrego', '23'),"
                    + "('Dominierz', 'Pomorze', '83304', 'Zawadzkiego', '24'),"
                    + "('Bendargowo', 'Pomorze', '83309', 'Duga', '44'),"
                    + "('Sianowo', 'Pomorze', '83308', 'Wiejska', '33'),"
                    + "('Stara Huta', 'Pomorze', '83305', 'Ostatnia', '63')";
            String sqlHurtowniaInsert = "INSERT INTO hurtownia(nazwa, nip, miasto, ulica, nr_budynku) VALUES "
                    + "('Agawa', '5894455789', 'Kartuzy', 'Weglowa', '1')";
            String sqlPozZamInsert = "INSERT INTO pozzam(idpz, towary, pozycja, ilosc, zam_idzam, zam_hurtownia_nazwa, zam_sklep_nip) VALUES "
                    + "('1', '1', '1', '100', '1', 'Agawa', '555332244'),"
                    + "('2', '2', '2', '144', '2', 'Agawa', '566232345'),"
                    + "('3', '3', '3', '555', '3', 'Agawa', '577232345'),"
                    + "('4', '4', '4', '55', '4', 'Agawa', '588232345'),"
                    + "('5', '5', '5', '443', '5', 'Agawa', '596232345')";
            String sqlSklepInsert = "INSERT INTO sklep(nip, nazwa_sklepu, region, nazwisko, imie, adress_ida, kontakt_idk) VALUES "
                    + "('555332244', 'ŁagaLeon', 'wejherowski', 'Przetakiewicz', 'Tomasz', '1', '1'),"
                    + "('566232345', 'Dominierz', 'wejherowski', 'Adruskiwicz', 'Joanna', '2', '2'),"
                    + "('577232345', 'Okroj', 'wejherowski', 'Okroj', 'Adam', '3', '3'),"
                    + "('588232345', 'Dampc', 'wejherowski', 'Polanowska', 'Anna','4', '4'),"
                    + "('596232345', 'WejerkA', 'Kartuski', 'Wejer', 'Aleksandra', '5', '5')";
            String sqlTowaryInsert = "INSERT INTO sklep(producent, rodzaj, opis_towaru, cenna_towaru_netto, cenna_brutto_towaru, procent_vat_aktualnie, kod_towaru, ilosc, miara, pozzam_idpz, pozzam_zam_idzam, pozzam_zam_hurtownia_nazwa, pozzam_zam_sklep_nip) VALUES"
                    + "('Jamar', 'Przetwory', 'Groszek z marhcewka', '2,8', '3,6', '23', '12345678', '100', 'szt.', '1', '1', 'Agawa', '555332244'),"
                    + "('Jamar', 'Przetwory', 'Dżem truskawkowy', '2,1', '2,6', '23', '12333878', '10', 'szt.', '1', '1', 'Agawa', '555332244'),"
                    + "('Kwidzyn', 'Przetwory', 'Kukurydza', '2,7', '3,5', '23', '32345378', '10', 'szt.', '1', '1', 'Agawa', '555332244'),"
                    + "('Lubella', 'Suche', 'Swiderek', '3,5', '4,3', '23', '21345678', '18', 'szt.', '1', '1', 'Agawa', '555332244'),"
                    + "('Mosso', 'Olej', 'Rzepakowy', '4,86', '5,94', '23', '33345678', '16', 'szt.', '1', '1', 'Agawa', '555332244'),"
                    + "('MK', 'Przetwory', 'Pomidory krojone', '3,1', '3,8', '23', '44333878', '12', 'szt.', '2', '2', 'Agawa', '566232345'),"
                    + "('Lorenz', 'suche', 'Chipsy paprykowe 140g', '5,7', '6,5', '23', '44345378', '8', 'szt.', '2', '2', 'Agawa', '566232345'),"
                    + "('Prymat', 'Przyprawy', 'Czarny pieprz', '1,5', '1,91', '23', '21665678', '25', 'szt.', '2', '2', 'Agawa', '566232345'),"
                    + "('Cykoria', 'Przyprawy', 'Cukier waniliowy', '0,86', '1,3', '23', '73345678', '25', 'szt.', '2', '2', 'Agawa', '566232345'),"
                    + "('B&K', 'Puszki', 'Sledz w oleju 170g', '3,89', '4,95', '23', '23245678', '16', 'szt.', '2', '2', 'Agawa', '566232345'),"
                    + "('Mlekovita', 'Nabial', 'mleko 3,2%', '2,4', '2,99', '23', '14333878', '72', 'szt.', '3', '3', 'Agawa', '577232345'),"
                    + "('Jagr', 'Nabial', 'Maslo 200g', '4,45', '5,13', '23', '44342378', '40', 'szt.', '3', '3', 'Agawa', '577232345'),"
                    + "('13', 'Zott', 'Nabial', 'Jogobella 150g', '1,1', '1,42', '23', '21665699', '80', 'szt.', '3', '3', 'Agawa', '577232345'),";


            statement.executeUpdate(sqlkontaktInsert);
            statement.executeUpdate(sqlAdressInsert);
            statement.executeUpdate(sqlHurtowniaInsert);
            statement.executeUpdate(sqlPozZamInsert);
            statement.executeUpdate(sqlSklepInsert);
            statement.executeUpdate(sqlTowaryInsert);


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
