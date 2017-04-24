package DAOs.Rating;

import DAOs.DBConnection;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Marvin Krüger S0556109.
 */
/*
TODO: Warum hat ein Rating eine Watcher id
 */
public class Rating implements Ratingable{
    private int idstar,starcount1, starcount2, starcount3, starcount4, starcount5, idwatcher;

    
    public Rating(int idstar, int starcount1, int starcount2, int starcount3, int starcount4, int starcount5,
			int idwatcher) {
		super();
		this.idstar = idstar;
		this.starcount1 = starcount1;
		this.starcount2 = starcount2;
		this.starcount3 = starcount3;
		this.starcount4 = starcount4;
		this.starcount5 = starcount5;
		this.idwatcher = idwatcher;
	}

    public Rating() {
		
	}
    
	public int getIdstar() {
        return idstar;
    }

    public void setIdstar(int idstar) {
        this.idstar = idstar;
    }

    public int getStarcount1() {
        return starcount1;
    }

    public void setStarcount1(int starcount1) {
        this.starcount1 = starcount1;
    }

    public int getStarcount2() {
        return starcount2;
    }

    public void setStarcount2(int starcount2) {
        this.starcount2 = starcount2;
    }

    public int getStarcount3() {
        return starcount3;
    }

    public void setStarcount3(int starcount3) {
        this.starcount3 = starcount3;
    }

    public int getStarcount4() {
        return starcount4;
    }

    public void setStarcount4(int starcount4) {
        this.starcount4 = starcount4;
    }

    public int getStarcount5() {
        return starcount5;
    }

    public void setStarcount5(int starcount5) {
        this.starcount5 = starcount5;
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
        stmt.executeUpdate("INSERT INTO tag(idstar, starcount1, starcount2, starcount3, starcount4, starcount5, idwatcher) VALUES (" + this.idstar + ", " + this.starcount1 + ", " + this.starcount2+
                ", " + this.starcount3 + ", " + this.starcount4 + ", " + this.starcount5+ ", " + this.idwatcher + ");");
    }

    @Override
    public String toString() {
        return "Rating{" +
                "idstar=" + idstar +
                ", starcount1=" + starcount1 +
                ", starcount2=" + starcount2 +
                ", starcount3=" + starcount3 +
                ", starcount4=" + starcount4 +
                ", starcount5=" + starcount5 +
                ", idwatcher=" + idwatcher +
                '}';
    }
}
