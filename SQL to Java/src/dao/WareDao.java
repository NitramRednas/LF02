package dao;

import bussinesObjects.Ware;

import java.sql.*;
import java.util.ArrayList;

public class WareDao {

    private final String CLASSNAME = "org.sqlite.JDBC";
    private final String CONNECTIONSTRING = "jdbc:sqlite:SQL to Java/src/data/Kaufvertrag.db";

    public WareDao() throws ClassNotFoundException {
        Class.forName(CLASSNAME);

    }

    /**
     * Liest eine Ware auf basis seiner Warennummer
     *
     * @return Der Gewünschte Vertragspartner
     */


    public ArrayList<Ware> read() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Ware> warenArraylist = new ArrayList<>();
        // Verbindung zu Datenbank Herstellen

        try {

            connection = DriverManager.getConnection(CONNECTIONSTRING);
            //SQL-Abfrage erstellen
            String sql = "SELECT * From Ware";
            preparedStatement = connection.prepareStatement(sql);
            //SQL-Abfrage ausführen
            ResultSet resultSet = preparedStatement.executeQuery();
            //Zeiger auf den ersten Datensatz setzen

            while (resultSet.next()) {
                //ResulSet auswerten
                Integer Nr = resultSet.getInt("warenNr");
                String bezeichnung = resultSet.getString("bezeichnung");
                String beschreibung = resultSet.getString("beschreibung");
                double preis = resultSet.getDouble("preis");
                String[] besonderheiten = resultSet.getString("besonderheiten").split(";");
                String[] maengel = resultSet.getString("maengel").split(";");
                //Ware ertsellen
                Ware ware = new Ware(bezeichnung, preis);
                ware.setWarenNr(Nr);
                ware.setBezeichnung(bezeichnung);
                ware.setPreis(preis);
                ware.setBeschreibung(beschreibung);
                ArrayList<String> besonderheitenListe = new ArrayList<>();

                for (String s : besonderheiten) {
                    besonderheitenListe.add(s.trim());
                }
                ware.setBesonderheitenListe(besonderheitenListe);

                ArrayList<String> maengelListe = new ArrayList<>();

                for (String s : maengel) {
                    maengelListe.add(s.trim());
                }

                ware.setMaengelListe(maengelListe);
                warenArraylist.add(ware);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            try {
                connection.close();

            } catch (SQLException e) {

                e.printStackTrace();
            }

        }
        return warenArraylist;
    }

    Connection connection;

    public Ware read(int warenNr) {
        Ware ware = null;
        connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);

            //SQL-Abfrage erstellen
            String sql = "SELECT * From ware WHERE warenNr = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, warenNr);

            //SQL-Abfrage ausführen
            ResultSet resultSet = preparedStatement.executeQuery();

            //Zeiger auf den ersten Datensatz setzen
            resultSet.next();


            ware = createObjects(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ware;
    }

    public Ware createObjects(ResultSet resultSet) throws SQLException{

        int nr = resultSet.getInt("warenNr");
        String bezeichnung = resultSet.getString("bezeichnung");
        String beschreibung = resultSet.getString("beschreibung");
        double preis = resultSet.getDouble("preis");
        String maengel = resultSet.getString("maengel");
        String besonderheiten = resultSet.getString("besonderheiten");

        Ware ware = new Ware(bezeichnung, preis);
        ware.setWarenNr(nr);
        ware.setBeschreibung(beschreibung);
        ware.setBezeichnung(bezeichnung);
        ware.setPreis(preis);
        ware.setBesonderheitenListe(ware.getBesonderheitenListe());
        ware.setMaengelListe(ware.getMaengelListe());

        if (besonderheiten != null) {
            String[] besonderheitenarray = besonderheiten.split(";");
            for (String b : besonderheitenarray) {
                ware.getBesonderheitenListe().add(b.trim());
            }
        }

        if (maengel != null) {
            String[] maengelarray = maengel.split(";");
            for (String m : maengelarray) {
                ware.getMaengelListe().add(m.trim());
            }
        }

        return ware;
    }
}


