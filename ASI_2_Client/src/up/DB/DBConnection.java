package up.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        String url = "jdbc:mysql://localhost:port";
        System.setProperty("jdbcDrivers", "com.mysql.jdbc.Driver");
        Properties prop = new Properties();
        prop.setProperty("user", "student");
        prop.setProperty("pass", "password");
        try {
            conn = DriverManager.getConnection(url, prop);
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
}
