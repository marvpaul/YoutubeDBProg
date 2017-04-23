package DAOs.Watcher;

import DAOs.DBConnection;

import java.sql.*;

/**
 * Created by Marvin Krüger S0556109.
 */
public class Watcher implements Watcherable {
    private int id;
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

    @Override
    public void add() throws SQLException {
        Statement stmt = DBConnection.con.createStatement();
        stmt.executeQuery("INSERT INTO watcher(id, name) VALUES (" + this.id + ", '" + this.name + "');");
    }

    @Override
    public String toString() {
        return "Watcher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
