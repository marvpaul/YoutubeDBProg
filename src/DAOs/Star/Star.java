package DAOs.Star;

import DAOs.DBConnection;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Marvin Krüger S0556109.
 */
public class Star implements Starable{
    private int id;
    private String name, profile, image;

    
    
    public Star(int id, String name, String profile, String image) {
		super();
		this.id = id;
		this.name = name;
		this.profile = profile;
		this.image = image;
	}

    public Star() {
 		
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

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public void add() throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        stmt.executeUpdate("INSERT INTO tag(id, name, profile, image) VALUES (" + this.id + ", '" + this.name + "', '" +
                profile + "', '" + image + "');");
    }

    @Override
    public String toString() {
        return "Star{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profile='" + profile + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
