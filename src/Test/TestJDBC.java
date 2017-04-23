package Test;

import java.sql.*;

/**
 * Created by Marvin Krüger S0556109.
 */
public class TestJDBC {
    public static void main(String[] args) throws SQLException {
        try {
            connectToAndQueryDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void connectToAndQueryDatabase() throws SQLException {

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://db.f4.htw-berlin.de:5432/_s0556109__youtube",
                "_s0556109__youtube_generic",
                "12345678");

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM watcher");

        while (rs.next()) {
            String x = rs.getString(1);
            System.out.println(rs);
        }
    }
}
