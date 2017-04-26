package DAOs.Video;

import DAOs.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marvin Krüger S0556109.
 */
public interface Videoable {
    public static final String TABLENAME = "video";
    void add() throws SQLException;

    static void delete(int key) throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        stmt.executeUpdate("DELETE FROM " + TABLENAME + " WHERE id=" + String.valueOf(key) + ";");
    };

    static List<Video> getAll() throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLENAME + ";");
        List<Video> videoList = new ArrayList<Video>();
        while (rs.next()) {
            Video v = new Video();
            v.setId(rs.getInt("id"));
            v.setName(rs.getString("name"));
            v.setDescription(rs.getString("description"));
            v.setDuration(rs.getString("duration"));
            v.setUrl(rs.getString("url"));
            v.setViewcount(rs.getInt("viewcount"));
            v.setIdstar(rs.getInt("idstar"));
            videoList.add(v);
        }
        return videoList;
    };
}