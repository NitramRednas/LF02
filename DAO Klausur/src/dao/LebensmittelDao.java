package dao;

import businessObjekts.Lebensmittel;

import java.sql.*;
import java.util.ArrayList;

public class LebensmittelDao {


    public LebensmittelDao() throws ClassNotFoundException {
        Class.forName(CLASSNAME);
    }

    private final String CLASSNAME = "org.sqlite.JDBC";
    private final String CONNECTIONSTRING = "jdbc:sqlite:DAO Klausur/src/data/Waren.db";

    Connection connection;
    PreparedStatement preparedStatement = null;

    public Lebensmittel read(int id) throws ClassNotFoundException, SQLException {

        connection = null;
        connection = DriverManager.getConnection(CONNECTIONSTRING);
        String sql = "SELECT * FROM Lebensmittel WHERE id =?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);

        ResultSet resultSet = preparedStatement.executeQuery();
        Lebensmittel lebensmittel = new Lebensmittel();
        resultSet.next();

        return lebensmittel;
    }

    public ArrayList<Lebensmittel> read() throws SQLException {

        connection = null;
        Lebensmittel lebensmittel = new Lebensmittel();
        ArrayList<Lebensmittel> lebensmittelArrayList = new ArrayList<>();
        connection = DriverManager.getConnection(CONNECTIONSTRING);
        String sql = "SELECT * FROM Lebensmittel";
        preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            lebensmittelArrayList.add(lebensmittel);
        }
        return lebensmittelArrayList;
    }

    public Lebensmittel create(Lebensmittel lebensmittel) throws SQLException {

        connection = null;
        connection = DriverManager.getConnection(CONNECTIONSTRING);
        String sql = "INSERT INTO Lebensmittel VLAUES (Name = ?, Gewicht = ?, Preis = ?, Nuesse = ?, Milch =?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,lebensmittel.getName());
        preparedStatement.setDouble(2,lebensmittel.getGewicht());
        preparedStatement.setDouble(3,lebensmittel.getPreis());
        preparedStatement.setString(4,lebensmittel.getNuesse());
        preparedStatement.setString(5, lebensmittel.getMilch());

        return lebensmittel;
    }

    public ArrayList<Lebensmittel> readAllergyFree() throws SQLException {

        connection = null;
        Lebensmittel lebensmittel = new Lebensmittel();
        ArrayList<Lebensmittel> lebensmittelArrayList = new ArrayList<>();
        connection = DriverManager.getConnection(CONNECTIONSTRING);
        String sql = "SELECT * FROM Lebensmittel WHERE 'Milch' IS NULL AND 'Nuesse' IS NULL";
        preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            lebensmittelArrayList.add(lebensmittel);
        }
        return lebensmittelArrayList;
    }

    public void update(Lebensmittel lebensmittel) throws SQLException {

        connection = null;
        connection = DriverManager.getConnection(CONNECTIONSTRING);
        String sql = "UPDATE Lebensmittel Where ID is =?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,lebensmittel.getId());
        preparedStatement.executeUpdate();

    }

    public void delete(int id) throws SQLException {

        connection = null;
        connection = DriverManager.getConnection(CONNECTIONSTRING);
        String sql = "DELETE FROM Lebensmittel Where ID IS =?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();

    }


}
