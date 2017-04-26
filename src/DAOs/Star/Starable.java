package DAOs.Star;

import DAOs.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marvin Krüger S0556109.
 */
public interface Starable {
    public static final String TABLENAME = "star";
    void add() throws SQLException;

    static void delete(int key) throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        stmt.executeUpdate("DELETE FROM " + TABLENAME + " WHERE id=" + String.valueOf(key) + ";");
    };

    static List<Star> getAll() throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLENAME + ";");
        List<Star> starList = new ArrayList<Star>();
        while (rs.next()) {
            Star s = new Star();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setProfile(rs.getString("profile"));
            s.setImage(rs.getString("image"));
            starList.add(s);
        }
        return starList;
    };
}
