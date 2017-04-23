package DAOs.Watchers;

import DAOs.DBConnection;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Marvin Krüger S0556109.
 */
public class Watchers implements Watchersable{
    private int idwatcher, idvideo;

    public int getIdwatcher() {
        return idwatcher;
    }

    public void setIdwatcher(int idwatcher) {
        this.idwatcher = idwatcher;
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
        stmt.executeQuery("INSERT INTO tag(idwatcher, idvideo) VALUES (" + this.idwatcher + ", " + this.idvideo + ");");
    }

    @Override
    public String toString() {
        return "Watchers{" +
                "idwatcher=" + idwatcher +
                ", idvideo=" + idvideo +
                '}';
    }
}