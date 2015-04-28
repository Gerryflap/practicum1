package gerben;

import db.ConnectDatabase;

import java.sql.*;

/**
 * Created by gerben on 28-4-15.
 */
public class Opgave6 implements Opgave{


    public void run(String[] args) {
        String name;
        if(args.length > 1) {
            name = args[0] + " " + args[1];
        } else {
            name = "Harrison Ford";
        }
        String query =
                "SELECT DISTINCT pw.name FROM Writes w, Person p, Person pw, Movie m, Acts a\n" +
                "WHERE p.name LIKE ? \n" +
                "AND p.pid = a.pid\n" +
                "AND m.mid = a.mid\n" +
                "AND w.mid = m.mid\n" +
                "AND w.pid = pw.pid;";

        Connection connection = ConnectDatabase.getInstance().getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);

            ResultSet resultSet = statement.executeQuery();
            resultSet.setFetchSize(5);

            while(resultSet.next()){
                System.out.println(resultSet.getString(1));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
