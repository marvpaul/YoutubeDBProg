package DAOs;

import Database.ConnectorDB;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Marvin Krüger S0556109.
 */
public class DBConnection {
    public static Connection con;
    public static void createConnection() throws SQLException {
        con = ConnectorDB.connectToDatabase();
    }
}
