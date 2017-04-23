package DAOs.Comment;

import DAOs.DBConnection;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Marvin Krüger S0556109.
 */
public class Comment implements Commentable{
    private int id, idvideo, idwatcher;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdvideo() {
        return idvideo;
    }

    public void setIdvideo(int idvideo) {
        this.idvideo = idvideo;
    }

    public int getIdwatcher() {
        return idwatcher;
    }

    public void setIdwatcher(int idwatcher) {
        this.idwatcher = idwatcher;
    }

    @Override
    public void add() throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        stmt.executeQuery("INSERT INTO tag(id, name, idvideo, idwatcher) VALUES (" + this.id + ", '" + this.name + "', " +
                        idvideo + ", " + idwatcher + ");");
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", idvideo=" + idvideo +
                ", idwatcher=" + idwatcher +
                ", name='" + name + '\'' +
                '}';
    }
}
