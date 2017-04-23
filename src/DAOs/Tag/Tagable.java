package DAOs.Tag;

import DAOs.DBConnection;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marvin Krüger S0556109.
 */
public interface Tagable {
    public static final String TABLENAME = "tag";
    void add() throws SQLException;

    static void delete(int key) throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        stmt.executeUpdate("DELETE FROM " + TABLENAME + " WHERE id=" + String.valueOf(key) + ";");
    };

    static List<Tag> getAll() throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLENAME + ";");
        List<Tag> tagList = new ArrayList<Tag>();
        while (rs.next()) {
            Tag t = new Tag();
            t.setId(rs.getInt("id"));
            t.setName(rs.getString("name"));
            tagList.add(t);
        }
        return tagList;
    };
}