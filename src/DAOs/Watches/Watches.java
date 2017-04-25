package DAOs.Watches;

import DAOs.DBConnection;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Marvin Krüger S0556109.
 */
public class Watches implements Watchesable {
    private int idwatcher, idvideo;

    
    public Watches(int idwatcher, int idvideo) {
		super();
		this.idwatcher = idwatcher;
		this.idvideo = idvideo;
	}

    public Watches() {

	}
    
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
        stmt.executeUpdate("INSERT INTO tag(idwatcher, idvideo) VALUES (" + this.idwatcher + ", " + this.idvideo + ");");
    }

    @Override
    public String toString() {
        return "Watches{" +
                "idwatcher=" + idwatcher +
                ", idvideo=" + idvideo +
                '}';
    }
}