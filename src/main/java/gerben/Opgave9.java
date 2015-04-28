package gerben;

import db.ConnectDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by gerben on 28-4-15.
 */
public class Opgave9 implements Opgave {
    public void run(String[] args) {
        Connection connection = ConnectDatabase.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT DISTINCT aut.name FROM Writes w, Person aut, Movie m\n" +
                            "WHERE aut.pid = w.pid\n" +
                            "AND w.mid = m.mid\n" +
                            "AND (NOT EXISTS (SELECT d FROM Directs d\n" +
                            "WHERE m.mid = d.mid));");
            while(resultSet.next()){
                System.out.println(resultSet.getString(1));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
