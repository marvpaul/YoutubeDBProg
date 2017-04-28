package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class which stores the Connection for current DB
 */
public class DBConnection {
    public static Connection con;
    private static final String DRIVER ="jdbc:postgresql://";
    private static final String HOST = "db.f4.htw-berlin.de:5432/";
    private static final String DBNAME = "_s0556109__youtube";
    private static final String USER =  "_s0556109__youtube_generic";
    private static final String PASSWORD = "12345678";

    /**
     * Establish a connection to DB with the given constants
     * @throws SQLException
     */
    public static void createConnection() throws SQLException {
        con = DriverManager.getConnection(
                DRIVER + HOST + DBNAME,
                USER,
                PASSWORD
        );
    }

    /**
     * Close the current connection
     */
    public static void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            System.err.print("Close connection to database failed!");
        }
    }
}
