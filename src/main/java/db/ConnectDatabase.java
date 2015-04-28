package db;

import java.sql.*;


/**
 * Created by tristan on 24-4-15.
 */
public class ConnectDatabase {

    public static final String USERNAME = "db76";

    public static final String PASSWORD = Password.PASSWORD;

    public static final String DATABASE = "db76";

    private static final String HOSTNAME = "castle.ewi.utwente.nl";

    public static ConnectDatabase instance = null;

    protected ConnectDatabase(){

    }

    public static ConnectDatabase getInstance(){
        if(instance == null){
            instance = new ConnectDatabase();
        }
        return instance;
    }

    /**
     * Returns a new connection. Reminder: the connection should be closed.
     * @return Connection
     */
    public Connection getConnection() {
        String dbUrl = "jdbc:postgresql://"+ HOSTNAME +"/" + DATABASE;
        String dbClass = "org.postgresql.Driver";
        String username = USERNAME;
        String password = PASSWORD;
        Connection connection = null;
        try {
            Class.forName(dbClass);
            connection = DriverManager.getConnection(dbUrl,
                    username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public String testConnection() {
        Connection connection = getConnection();
        String query = "SELECT * FROM users";

        String tableName = "";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                tableName += resultSet.getString(2) + ", ";
            }
            connection.close();
        } catch (SQLException e) {
            tableName += e.getNextException();
        }
        return "Table entries: " + tableName;
    }
}
