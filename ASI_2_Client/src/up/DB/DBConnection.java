package up.DB;

import java.sql.*;
import java.util.Properties;

public class DBConnection {

    private Connection conn;

    public DBConnection(){
        conn = null;
    }

    public Connection connectToSQLite(){
        String url = "jdbc:sqlite:baza.db";
        try {
            conn = DriverManager.getConnection(url);
            if(conn != null){
                System.out.println("Utworzono połączenie z bazą danych");
                return conn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Connection connectToMySql(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/test";
//        System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
//        Properties prop = new Properties();
//        prop.setProperty("user", "root");
//        prop.setProperty("password", "usbw");
        try {
            conn = DriverManager.getConnection(url, "root", "usbw");
            if(conn != null){
                System.out.println("Utworzono połączenie z bazą danych");
                return conn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void createTable(){
        try {
            PreparedStatement statement = conn.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS Person " +
                            "(Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "Name TEXT," +
                            "LastName TEXT," +
                            "Age INTEGER)"
            );
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect(){
        try {
            if (!conn.isClosed()){
                conn.close();
                System.out.println("Zakończenie połączenia z bazą danych");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Savepoint getSavePoint(){
        try {
            Savepoint s = conn.setSavepoint();
            conn.setAutoCommit(false);
            System.out.println("Utworzenie punktu przwracania");
            return s;
        } catch (SQLException e) {
            return null;
        }
    }

    public void getRollback(Savepoint point){
        try {
            conn.rollback(point);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
