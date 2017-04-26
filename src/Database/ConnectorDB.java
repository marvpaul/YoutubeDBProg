package Database;

import java.sql.*;

/**
 * Created by Marvin Krüger S0556109.
 */
public class ConnectorDB {
    public static Connection connectToDatabase() throws SQLException {

        Connection con = DriverManager.getConnection(

		
        	"jdbc:postgresql://db.f4.htw-berlin.de:5432/_s0556109__youtube",
                "_s0556109__youtube_generic",
                "12345678"
                
        		);

        return con;
    }
}
