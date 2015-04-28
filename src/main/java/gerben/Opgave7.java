package gerben;

import db.ConnectDatabase;

import java.sql.*;

/**
 * Created by gerben on 28-4-15.
 */
public class Opgave7 implements Opgave{

    public void run(String[] args) {
        String name;
        if(args.length > 1) {
            name = args[0] + " " + args[1];
        } else {
            name = "Harrison Ford";
        }
        String query =
                "SELECT AuthorsOfActor(?);";

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
