package DAOs.Category;

import DAOs.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marvin Krüger S0556109.
 */
public interface Categoryable {
    public static final String TABLENAME = "category";
    void add() throws SQLException;

    static void delete(int key) throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        stmt.executeUpdate("DELETE FROM " + TABLENAME + " WHERE id=" + String.valueOf(key) + ";");
    };

    static List<Category> getAll() throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLENAME + ";");
        List<Category> categoryList = new ArrayList<Category>();
        while (rs.next()) {
            Category c = new Category();
            c.setId(rs.getInt("id"));
            c.setName(rs.getString("name"));
            c.setPreviewImage(rs.getString("previewimage"));
            categoryList.add(c);
        }
        return categoryList;
    };
}