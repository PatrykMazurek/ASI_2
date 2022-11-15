package up.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBOperation {

    private Connection connection;

    public DBOperation(Connection c){
        connection = c;
    }

    public void insertPerson(String name, String lastName, int age){
        try {
            PreparedStatement preper = connection.prepareStatement("" +
                    "INSERT INTO Person (Name, LastName, Age) " +
                    "VALUES (?,?,?) ");
            preper.setString(1, name);
            preper.setString(2, lastName);
            preper.setInt(3, age);
            int rowCount = preper.executeUpdate();
            System.out.println(String.format("Wstawiono %d rekordów", rowCount));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllRecord(){
        try {
            PreparedStatement preped = connection.prepareStatement(
                    "SELECT * FROM Person",
                    ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet result = preped.executeQuery();

            while (result.next()){
                System.out.println(String.format("Rekordy z bazy %d, %s, %s, %d",
                        result.getInt("Id"),
                        result.getString(2),
                        result.getString(3),
                        result.getInt("Age")));
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
