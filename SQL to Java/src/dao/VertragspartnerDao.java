package dao;

import bussinesObjects.Adresse;
import bussinesObjects.Vertragspartner;

import java.sql.*;
import java.util.ArrayList;

public class VertragspartnerDao {
    private final String CLASSNAME = "org.sqlite.JDBC";
    private final String CONNECTIONSTRING = "jdbc:sqlite:SQL to Java/src/data/Kaufvertrag.db";

    public VertragspartnerDao() throws ClassNotFoundException {
        Class.forName(CLASSNAME);

    }

    /**
     * Liest einen vertragsparner auf basis seiner asweisnummer
     *
     * @param ausweisNr Die Ausweisnummer
     * @return Der Gewünschte Vertragspartner
     */

    Connection connection;

    {
        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Vertragspartner read(String ausweisNr) {

        Vertragspartner vertragspartner = null;
        connection = null;
        PreparedStatement preparedStatement = null;
        // Verbindung zu Datenbank Herstellen

        try {
            //SQL-Abfrage erstellen
            String sql = "SELECT * From vertragspartner WHERE ausweisNr = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ausweisNr);
            //SQL-Abfrage ausführen
            ResultSet resultSet = preparedStatement.executeQuery();
            vertragspartner = vertragspartnerlesen(resultSet);
            //Vertragsprtner ertselle

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vertragspartner;
    }


    public ArrayList<Vertragspartner> read() {

        ArrayList<Vertragspartner> vertragspartnerArrayList = null;
        Vertragspartner vertragspartner = null;
        connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = DriverManager.getConnection(CONNECTIONSTRING);
            vertragspartnerArrayList = new ArrayList<>();
            //SQL-Abfrage erstellen
            String sql = "SELECT * From vertragspartner ";
            preparedStatement = connection.prepareStatement(sql);
            //SQL-Abfrage ausführen
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                vertragspartner = vertragspartnerlesen(resultSet);
                vertragspartnerArrayList.add(vertragspartner);
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
        return vertragspartnerArrayList;
    }

    private Vertragspartner vertragspartnerlesen(ResultSet resultSet) throws SQLException {

        //ResulSet auswerten
        String nr = resultSet.getString("ausweisNr");
        String vorname = resultSet.getString("vorname");
        String nachname = resultSet.getString("nachname");
        String strasse = resultSet.getString("strasse");
        String hausNr = resultSet.getString("hausNr");
        String plz = resultSet.getString("plz");
        String ort = resultSet.getString("ort");

        //Vertragsprtner ertselle
        Vertragspartner vertragspartner = new Vertragspartner(vorname, nachname);
        vertragspartner.setAusweisNr(nr);
        vertragspartner.setAdresse(new Adresse(strasse, hausNr, plz, ort));

        return vertragspartner;
    }
}

