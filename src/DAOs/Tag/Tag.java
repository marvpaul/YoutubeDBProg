package DAOs.Tag;

import DAOs.DBConnection;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Marvin Krüger S0556109.
 */
public class Tag implements Tagable{
    private int id;
    private String name;

    public Tag(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

    public Tag() {
		
	}
    
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

    @Override
    public void add() throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        stmt.executeUpdate("INSERT INTO tag(id, name) VALUES (" + this.id + ", '" + this.name + "');");
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
