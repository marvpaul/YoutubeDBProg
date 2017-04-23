package DAOs.Watcher;

import DAOs.DBConnection;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marvin Krüger S0556109.
 */
public interface Watcherable {

    void add() throws SQLException;

    static void delete(int key) throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        stmt.executeUpdate("DELETE FROM watcher WHERE id=" + String.valueOf(key) + ";");
    };

    static List<Watcher> getAll() throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM watcher;");
        List<Watcher> watcherList = new ArrayList<Watcher>();
        while (rs.next()) {
            Watcher w = new Watcher();
            w.setId(rs.getInt("id"));
            w.setName(rs.getString("name"));
            watcherList.add(w);
        }
        return watcherList;
    };
}
