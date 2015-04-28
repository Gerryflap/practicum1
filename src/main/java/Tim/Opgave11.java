package Tim;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by tim on 28-4-15.
 */
public class Opgave11 implements Opgave {
    public static void main(String[] args) throws SQLException {
        ResultSet statementSet = null;
        ResultSet prepStatementSet = null;
        ResultSet procedureSet = null;


        int iters=100;
        long startTime = System.currentTimeMillis();
        // voorbereidende statements buiten de loop
        Statement statement = TimMain.connection.createStatement();
        PreparedStatement prepStatement = TimMain.connection.prepareStatement(getPreparedStatement());
        Statement procedure = TimMain.connection.createStatement();

        // bijvoorbeeld Statement st = conn.createStatement();
        for (int i=0; i<iters; i++) {
            // statements die je 100x wilt doen

            //Normal Statement
            //statementSet = statement.executeQuery(getStatement());
            //Prepared Statement
            //prepStatementSet = prepStatement.executeQuery();
            //Procedure
            procedureSet = procedure.executeQuery(getProcedure());
        }
        // afrondende statements buiten de loop (bijv “st.close();”)

        System.out.println("Statement: ");
        while (statementSet != null && statementSet.next()) {
            System.out.println(statementSet.getString(1));
        }

        System.out.println("\nPrepared Statement: ");
        while (prepStatementSet != null && prepStatementSet.next()) {
            System.out.println(prepStatementSet.getString(1));
        }

        System.out.println("\nProcedure: ");
        while (procedureSet != null && procedureSet.next()) {
            System.out.println(procedureSet.getString(1));
        }

        long stopTime = System.currentTimeMillis();
        double elapsedTime = (stopTime - startTime) / (1.0*iters);
        System.out.println("\nGemeten tijd: "+elapsedTime+" ms");
    }

    public static String getStatement() throws SQLException {
        String query =
                "SELECT haut.name FROM Person haut, Writes hw\n" +
                "WHERE haut.pid = hw.pid\n" +
                "AND NOT EXISTS (SELECT aut.name FROM Person aut, Movie m, Writes w\n" +
                "WHERE aut.pid = w.pid\n"  +
                "AND aut.name = haut.name\n" +
                "AND w.mid = m.mid\n" +
                "AND (EXISTS (SELECT d FROM Directs d\n" +
                        "WHERE m.mid = d.mid)));";
        return query;
    }

    public static String getPreparedStatement() throws SQLException {
        String query =
                "SELECT haut.name FROM Person haut, Writes hw\n" +
                        "WHERE haut.pid = hw.pid\n" +
                        "AND NOT EXISTS (SELECT aut.name FROM Person aut, Movie m, Writes w\n" +
                        "WHERE aut.pid = w.pid\n"  +
                        "AND aut.name = haut.name\n" +
                        "AND w.mid = m.mid\n" +
                        "AND (EXISTS (SELECT d FROM Directs d\n" +
                        "WHERE m.mid = d.mid)));";
        return query;
    }

    public static String getProcedure() throws SQLException {
        return "SELECT opgave11gerben() \t";
    }
}
