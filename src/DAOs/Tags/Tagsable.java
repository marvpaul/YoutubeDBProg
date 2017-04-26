package DAOs.Tags;

import DAOs.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marvin Krüger S0556109.
 */
public interface Tagsable {
    public static final String TABLENAME = "tags";
    void add() throws SQLException;

    static void delete(int keytag, int keyvideo) throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        stmt.executeUpdate("DELETE FROM " + TABLENAME + " WHERE idtag=" + String.valueOf(keytag) +
                " AND idvideo = " + keyvideo + ";");
    };

    static List<Tags> getAll() throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLENAME + ";");
        List<Tags> tagsList = new ArrayList<Tags>();
        while (rs.next()) {
            Tags t = new Tags();
            t.setIdvideo(rs.getInt("idvideo"));
            t.setIdtag(rs.getInt("idtag"));
            tagsList.add(t);
        }
        return tagsList;
    };
}