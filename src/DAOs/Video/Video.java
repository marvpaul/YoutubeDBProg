package DAOs.Video;

import DAOs.DBConnection;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Marvin Krüger S0556109.
 */
public class Video implements Videoable{
    private int id, viewcount, idstar;
    private String name, duration, description, url;

    public Video(int id, int viewcount, int idstar, String name, String duration, String description, String url) {
		super();
		this.id = id;
		this.viewcount = viewcount;
		this.idstar = idstar;
		this.name = name;
		this.duration = duration;
		this.description = description;
		this.url = url;
	}
    
    public Video() {
		
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getViewcount() {
        return viewcount;
    }

    public void setViewcount(int viewcount) {
        this.viewcount = viewcount;
    }

    public int getIdstar() {
        return idstar;
    }

    public void setIdstar(int idstar) {
        this.idstar = idstar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void add() throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        stmt.executeUpdate("INSERT INTO video(id, name, duration, description, viewcount, url, idstar) VALUES ("
                + this.id + ", '" + this.name + "', '" + this.description + "',"  + this.viewcount + ", '"
                + this.url + "', " + this.idstar + ");");
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", viewcount=" + viewcount +
                ", idstar=" + idstar +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
