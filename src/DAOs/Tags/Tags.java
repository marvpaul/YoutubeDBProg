package DAOs.Tags;

import DAOs.DBConnection;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Marvin Krüger S0556109.
 */
public class Tags implements Tagsable{
    private int idtag, idvideo;

    public int getIdtag() {
        return idtag;
    }

    public void setIdtag(int idtag) {
        this.idtag = idtag;
    }

    public int getIdvideo() {
        return idvideo;
    }

    public void setIdvideo(int idvideo) {
        this.idvideo = idvideo;
    }

    @Override
    public void add() throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        stmt.executeQuery("INSERT INTO tag(idtag, idvideo) VALUES (" + this.idtag + ", " + this.idvideo + ");");
    }

    @Override
    public String toString() {
        return "Tags{" +
                "idtag=" + idtag +
                ", idvideo=" + idvideo +
                '}';
    }
}