package DAOs.Watches;

import DAOs.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marvin Krüger S0556109.
 */
public interface Watchesable {
    public static final String TABLENAME = "watches";
    void add() throws SQLException;

    static void delete(int keywatcher, int keyvideo) throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        stmt.executeUpdate("DELETE FROM " + TABLENAME + " WHERE idwatcher=" + String.valueOf(keywatcher) +
                " AND idvideo = " + keyvideo + ";");
    };

    static List<Watches> getAll() throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLENAME + ";");
        List<Watches> watchesList = new ArrayList<Watches>();
        while (rs.next()) {
            Watches w = new Watches();
            w.setIdwatcher(rs.getInt("idwatcher"));
            w.setIdvideo(rs.getInt("idvideo"));
            watchesList.add(w);
        }
        return watchesList;
    };
}