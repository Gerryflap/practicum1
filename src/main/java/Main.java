import db.ConnectDatabase;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by gerben on 28-4-15.
 */
public class Main {
    public static void main(String[] args){
        Connection connection = ConnectDatabase.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT DISTINCT pw.name FROM Writes w, Person p, Person pw, Movie m, Acts a\n" +
                            "WHERE p.name LIKE 'Harrison Ford' \n" +
                            "AND p.pid = a.pid\n" +
                            "AND m.mid = a.mid\n" +
                            "AND w.mid = m.mid\n" +
                            "AND w.pid = pw.pid;");
            while(resultSet.next()){
                System.out.println(resultSet.getString(1));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
