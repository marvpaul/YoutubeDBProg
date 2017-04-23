package DAOs.Watchers;

import DAOs.DBConnection;
import DAOs.Tags.Tags;
import DAOs.Watcher.Watcher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marvin Krüger S0556109.
 */
public interface Watchersable {
    public static final String TABLENAME = "watches";
    void add() throws SQLException;

    static void delete(int keywatcher, int keyvideo) throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        stmt.executeUpdate("DELETE FROM " + TABLENAME + " WHERE idwatcher=" + String.valueOf(keywatcher) +
                " AND idvideo = " + keyvideo + ";");
    };

    static List<Watchers> getAll() throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLENAME + ";");
        List<Watchers> watchersList = new ArrayList<Watchers>();
        while (rs.next()) {
            Watchers w = new Watchers();
            w.setIdwatcher(rs.getInt("idwatcher"));
            w.setIdvideo(rs.getInt("idvideo"));
            watchersList.add(w);
        }
        return watchersList;
    };
}