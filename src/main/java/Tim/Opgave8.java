package Tim;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by tim on 28-4-15.
 */
public class Opgave8 implements Opgave {
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
        return  "SELECT WritersOfActor(?);";

    }
}
