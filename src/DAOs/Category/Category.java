package DAOs.Category;

import DAOs.DBConnection;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Marvin Krüger S0556109.
 */
public class Category implements Categoryable {
    private int id;
    private String name, previewImage;

    public int getId() {
        return id;
    }

        
    public Category(int id, String name, String previewImage) {
		super();
		this.id = id;
		this.name = name;
		this.previewImage = previewImage;
	}
    
    public Category() {
		
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

    public String getPreviewImage() {
        return previewImage;
    }

    public void setPreviewImage(String previewImage) {
        this.previewImage = previewImage;
    }

    @Override
    public void add() throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        stmt.executeUpdate("INSERT INTO category(id, name, previewimage) VALUES (" + this.id + ", '" + this.name + "', '" + previewImage + "');");
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", previewImage='" + previewImage + '\'' +
                '}';
    }
}

