package gerben;

import db.ConnectDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by gerben on 28-4-15.
 */
public class Opgave10 implements Opgave {

    public void run(String[] args) {
        Connection connection = ConnectDatabase.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT DISTINCT thisAut.name FROM Person thisAut, Writes thisw\n"+
                    "WHERE thisAut.pid = thisw.pid\n" +
                    "AND NOT EXISTS (SELECT aut.name FROM Writes w, Person aut, Movie m\n" +
                            "WHERE aut.pid = w.pid\n" +
                            "AND aut.name = thisAut.name\n"+
                            "AND w.mid = m.mid\n" +
                            "AND (EXISTS (SELECT d FROM Directs d\n" +
                            "WHERE m.mid = d.mid)));");
            while(resultSet.next()){
                System.out.println(resultSet.getString(1));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
