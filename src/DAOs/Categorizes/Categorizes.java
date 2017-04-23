package DAOs.Categorizes;

import DAOs.DBConnection;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Marvin Krüger S0556109.
 */
public class Categorizes implements Categorizesable{
    private int idcategory, idvideo;

    public int getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
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
        stmt.executeQuery("INSERT INTO categorizes(idcategory, idvideo) VALUES (" + this.idcategory + ", " + this.idvideo + ");");
    }

    @Override
    public String toString() {
        return "Categorizes{" +
                "idcategory=" + idcategory +
                ", idvideo=" + idvideo +
                '}';
    }
}