package dao;

import bussinesObjects.Ware;

import java.sql.*;

public class WareDao {

    private final String CLASSNAME = "org.sqlite.JDBC";
    private final String CONNECTIONSTRING = "jdbc:sqlite:SQL to Java/src/data/Kaufvertrag.db";

    public WareDao() throws ClassNotFoundException {
        Class.forName(CLASSNAME);

    }

    /**

     * Liest eine Ware auf basis seiner Warennummer

     * @param warenNr Die Ausweisnummer

     * @return Der Gewünschte Vertragspartner

     */



    public Ware read(String warenNr){

        Ware ware = null;

        Connection connection = null;

        PreparedStatement preparedStatement = null;



        // Verbindung zu Datenbank Herstellen



        try {

            connection = DriverManager.getConnection(CONNECTIONSTRING);



            //SQL-Abfrage erstellen

            String sql = "SELECT * From Ware WHERE warenNr = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,warenNr);



            //SQL-Abfrage ausführen

            ResultSet resultSet = preparedStatement.executeQuery();



            //Zeiger auf den ersten Datensatz setzen

            resultSet.next();



            //ResulSet auswerten

            String Nr = resultSet.getString("warenNr");
            String bezeichnung = resultSet.getString("bezeichnung");
            String beschreibung = resultSet.getString("beschreibung");
            double preis = resultSet.getDouble("preis");
            String besonderheiten = resultSet.getString("besonderheiten");
            String maengel = resultSet.getString("maengel");


            //Vertragsprtner ertselle

            ware = new Ware(bezeichnung,preis);

            ware.setBezeichnung(bezeichnung);

            ware.setPreis(preis);

            ware.setBeschreibung(beschreibung);


        } catch (SQLException e) {

            e.printStackTrace();

        }finally {

            try {

                connection.close();

            } catch (SQLException e) {

                e.printStackTrace();

            }

        }

        return ware;

    }

}


