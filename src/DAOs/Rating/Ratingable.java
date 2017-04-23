package DAOs.Rating;

import DAOs.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marvin Krüger S0556109.
 */
public interface Ratingable {
    public static final String TABLENAME = "rating";
    void add() throws SQLException;

    static void delete(int key) throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        stmt.executeUpdate("DELETE FROM " + TABLENAME + " WHERE idstar=" + String.valueOf(key) + ";");
    };

    static List<Rating> getAll() throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLENAME + ";");
        List<Rating> ratingList = new ArrayList<Rating>();
        while (rs.next()) {
            Rating r = new Rating();
            r.setIdstar(rs.getInt("idstar"));
            r.setStarcount1(rs.getInt("starcount1"));
            r.setStarcount2(rs.getInt("starcount2"));
            r.setStarcount3(rs.getInt("starcount3"));
            r.setStarcount4(rs.getInt("starcount4"));
            r.setStarcount5(rs.getInt("starcount5"));
            r.setIdwatcher(rs.getInt("idwatcher"));
            ratingList.add(r);
        }
        return ratingList;
    };
}