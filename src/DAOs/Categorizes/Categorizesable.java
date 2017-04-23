package DAOs.Categorizes;

import DAOs.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marvin Krüger S0556109.
 */
public interface Categorizesable {
    public static final String TABLENAME = "categorizes";
    void add() throws SQLException;

    static void delete(int keyvideo, int keycategory) throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        stmt.executeUpdate("DELETE FROM " + TABLENAME + " WHERE idcategory=" + String.valueOf(keycategory) + " AND idvideo=" + String.valueOf(keyvideo) + ";");
    };

    static List<Categorizes> getAll() throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLENAME + ";");
        List<Categorizes> categorizesList = new ArrayList<Categorizes>();
        while (rs.next()) {
            Categorizes c = new Categorizes();
            c.setIdcategory(rs.getInt("idcategory"));
            c.setIdvideo(rs.getInt("idvideo"));
            categorizesList.add(c);
        }
        return categorizesList;
    };
}