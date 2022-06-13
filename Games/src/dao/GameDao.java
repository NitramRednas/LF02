package dao;
import bussinesObjects.Games;

import java.sql.*;
import java.util.ArrayList;

public class GameDao {

    private final String CLASSNAME = "org.sqlite.JDBC";
    private final String CONNECTIONSTRING = "jdbc:Sqlite:Games/src/data/Games.db";

   public GameDao() throws ClassNotFoundException {
       Class.forName(CLASSNAME);
   }

    Connection connection;

    {
        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Games read(int Nummer){

        Games games = null;
        connection = null;
        PreparedStatement preparedStatement = null;

        try{
            String sql = "SELECT * FROM Games WHERE Nummer =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,Nummer);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return games;
    }

    public ArrayList<Games> readArray() throws SQLException {

        ArrayList<Games> gamesArrayList = null;
        Games games = null;
        connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            gamesArrayList = new ArrayList<>();
            String sql = "SELECT * FROM Games";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                games = gameslesen(resultSet);
                gamesArrayList.add(games);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return gamesArrayList;
    }

    private Games gameslesen(ResultSet resultSet) throws SQLException{

        int nr = resultSet.getInt("Nummer");
        String titel = resultSet.getString("Titel");
        String genre = resultSet.getString("Genre");
        double preis = resultSet.getDouble("Preis");

        Games games = new Games(nr,titel,genre,preis);
        return games;
    }

    public void delete(String nr) {

        connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "DELETE From Games WHERE Nummer = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nr);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void insert(Games games) throws SQLException {
        connection = null;
        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "Insert into Games values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,games.getNummer());
            preparedStatement.setString(2, games.getTitel());
            preparedStatement.setString(3, games.getGenre());
            preparedStatement.setDouble(4, games.getPreis());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(Games games) throws SQLException {

        connection = null;

        try {
            connection = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "UPDATE Games SET Nummer = ? ,Titel = ?, Genre = ?, Preis = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,games.getNummer());
            preparedStatement.setString(2, games.getTitel());
            preparedStatement.setString(3, games.getGenre());
            preparedStatement.setDouble(4, games.getPreis());

            preparedStatement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            try {
                connection.close();

            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }


}

