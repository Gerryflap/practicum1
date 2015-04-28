package Tim;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by tim on 28-4-15.
 */
public abstract class Opgave6 implements Opgave {
    public static ResultSet resultSet;

    public static void main(String[] args) throws SQLException {
        PreparedStatement writersCommonActor = null;
        writersCommonActor = TimMain.connection.prepareStatement(getQuery());
        writersCommonActor.setString(1, "Harrison Ford");
        resultSet = writersCommonActor.executeQuery();
        printQuery();
    }

    public static void printQuery() throws SQLException {
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }
    }


    public static String getQuery() {
        return  "SELECT DISTINCT pw.name FROM Writes w, Person p, Person pw, Movie m, Acts a\n" +
                "WHERE p.name LIKE ?\n" +
                "AND p.pid = a.pid\n" +
                "AND m.mid = a.mid\n" +
                "AND w.mid = m.mid\n" +
                "AND w.pid = pw.pid;\n";

    }
}
