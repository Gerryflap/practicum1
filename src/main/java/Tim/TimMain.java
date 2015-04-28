package Tim;

import db.ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by tim on 28-4-15.
 */
public class TimMain {
    static String[] str = null;
    public static Connection connection = ConnectDatabase.getInstance().getConnection();

    public static void main(String[] args) {
        try {
            Opgave8.main(str);



            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
