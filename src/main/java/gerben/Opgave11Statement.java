package gerben;

import db.ConnectDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by gerben on 28-4-15.
 */
public class Opgave11Statement implements Opgave {


    public void run(String[] args) {
        //System.out.println("Statement: ");

        int iters = 100;
        long startTime = System.currentTimeMillis();


        String query =
                "SELECT DISTINCT thisAut.name FROM Person thisAut, Writes thisw\n"+
                "WHERE thisAut.pid = thisw.pid\n" +
                "AND NOT EXISTS (SELECT aut.name FROM Writes w, Person aut, Movie m\n" +
                "WHERE aut.pid = w.pid\n" +
                "AND aut.name = thisAut.name\n"+
                "AND w.mid = m.mid\n" +
                "AND (EXISTS (SELECT d FROM Directs d\n" +
                "WHERE m.mid = d.mid)));";

        Connection connection = ConnectDatabase.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // voorbereidende statements buiten de loop
        // bijvoorbeeld Statement st = conn.createStatement();


        for (int i=0; i<iters; i++) {

            try {
                ResultSet resultSet = statement.executeQuery(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }



        }



        // afrondende statements buiten de loop (bijv “st.close();”)
        long stopTime = System.currentTimeMillis();
        double elapsedTime = (stopTime - startTime) / (1.0*iters);
        System.out.print(elapsedTime + " ms \t");
    }
}
