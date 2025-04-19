package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid";
	private static String USER = "student";
	private static String PASS = "student";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
  @Override
  public Film findFilmById(int filmId) {
	  Film film = null;
	  String sql = "SELECT * FROM film WHERE id = ?"; 

	  try {
		   Connection conn = DriverManager.getConnection(URL, USER, PASS);
	       PreparedStatement stmt = conn.prepareStatement(sql);
	    
	    stmt.setInt(1, filmId);
	    ResultSet rs = stmt.executeQuery();
	    
	    if (rs.next()) {
	      film = new Film(
	      rs.getInt("id"),
	      rs.getString("title"),
	      rs.getString("description"),
	      rs.getInt("release_year"),
	      rs.getInt("language_id"),
	      rs.getInt("rental_duration"),
	      rs.getDouble("rental_rate"),
	      rs.getInt("length"),
	      rs.getDouble("replacement_cost"),
	      rs.getString("rating"),
	      rs.getString("special_features"));
	      
	      List<Actor> actors = findActorsByFilmId(filmId); 
	      film.setActors(actors);
	      
	    }
	  } catch (SQLException e) {
	    e.printStackTrace();
	  } 
	  return film;
	}

@Override
public Actor findActorById(int actorId) {
	 Actor actor = null;
	 String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";

	  try{
		  Connection conn = DriverManager.getConnection(URL, USER, PASS);
	       PreparedStatement stmt = conn.prepareStatement(sql);

	    stmt.setInt(1, actorId);
	    ResultSet rs = stmt.executeQuery();

	    if (rs.next()) {
	      actor = new Actor(rs.getInt("id"),
	    		  rs.getString("first_name"),
	    		  rs.getString("last_name"));
	     
	    }
	    rs.close();
	    stmt.close();
	    
	  } catch (SQLException e) {
	    e.printStackTrace();
	  }
	  return actor;
	}

@Override
public List<Actor> findActorsByFilmId(int filmId) {
	 List<Actor> actors = new ArrayList<>();
	 String sql = "SELECT * FROM actor JOIN film_actor "
	 		+ "ON actor.id = film_actor.actor_id "
	 		+ "WHERE film_actor.film_id = ?"; 
	 
	 try {
		 Connection conn = DriverManager.getConnection(URL, USER, PASS);
		 PreparedStatement stmt = conn.prepareStatement(sql);

		    stmt.setInt(1, filmId);
		    ResultSet rs = stmt.executeQuery();
		    if (rs.next()) {
			     Actor actor = new Actor(rs.getInt("id"),
			    		  rs.getString("first_name"),
			    		  rs.getString("last_name"));
			     		  actors.add(actor);
			    }
			    rs.close();
			    stmt.close();
			    
			  } catch (SQLException e) {
			    e.printStackTrace();
			  }
	return actors;
	 
	}
}
