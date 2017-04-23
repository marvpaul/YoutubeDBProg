package DAOs.Comment;

import DAOs.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marvin Krüger S0556109.
 */
public interface Commentable {
    public static final String TABLENAME = "comment";
    void add() throws SQLException;

    static void delete(int key) throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        stmt.executeUpdate("DELETE FROM " + TABLENAME + " WHERE id=" + String.valueOf(key) + ";");
    };

    static List<Comment> getAll() throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLENAME + ";");
        List<Comment> commentList = new ArrayList<Comment>();
        while (rs.next()) {
            Comment c = new Comment();
            c.setId(rs.getInt("id"));
            c.setIdvideo(rs.getInt("idvideo"));
            c.setIdwatcher(rs.getInt("idwatcher"));
            c.setName(rs.getString("content"));
            commentList.add(c);
        }
        return commentList;
    };
}