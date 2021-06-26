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
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private String user = "student";
	private String pass = "student";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) throws SQLException {
		Connection conn = DriverManager.getConnection(URL, user, pass);
		Film film = null;

		List<Actor> aL = findActorsByFilmId(filmId);

		// THE COLUMNS AFTER SELECT ARE THE ONLY ONES WE CAN USE LATER, TRY * TO GET ALL
		// OF THE AVAILABLE COLUMNS
		String sql = "SELECT * FROM film WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		// THE NUMBER IS THE INDEX OF THE ? TO REPLACE WITH THE SECOND PARAM
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();

		// CAN USE NAMES OR COLUMN NUMBERS AS PARAMS OF getString()
		while (rs.next()) {
			film = new Film();
			film.setiD(rs.getInt("id"));
			film.setDescription(rs.getString("description"));
			film.setLanguageId(rs.getInt("language_id"));
			film.setLength(rs.getInt("length"));
			film.setRating(rs.getString("rating"));
			film.setReleaseYear(rs.getInt("release_year"));
			film.setRentalDuration(rs.getInt("rental_duration"));
			film.setRentalRate(rs.getDouble("rental_rate"));
			film.setReplacementCost(rs.getDouble("replacement_cost"));
			film.setSpecialFeatures(rs.getString("special_features"));
			film.setTitle(rs.getString("title"));
			film.setLanguageName(findLanguageById(film.getLanguageId()));
			film.setActorList(aL);
		}
		rs.close();
		stmt.close();
		conn.close();

		return film;
	}

	@Override
	public Actor findActorById(int actorId) throws SQLException {
		Connection conn = DriverManager.getConnection(URL, user, pass);
		Actor actor = new Actor();

		// THE COLUMNS AFTER SELECT ARE THE ONLY ONES WE CAN USE LATER, TRY * TO GET ALL
		// OF THE AVAILABLE COLUMNS
		String sql = "SELECT * FROM actor WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		// THE NUMBER IS THE INDEX OF THE ? TO REPLACE WITH THE SECOND PARAM
		stmt.setInt(1, actorId);
		ResultSet rs = stmt.executeQuery();

		System.out.println();

		// CAN USE NAMES OR COLUMN NUMBERS AS PARAMS OF getString()
		while (rs.next()) {
			actor.setiD(rs.getInt("id"));
			actor.setFirstName(rs.getString("first_name"));
			actor.setLastName(rs.getString("last_name"));

		}
		rs.close();
		stmt.close();
		conn.close();

		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) throws SQLException {
		Connection conn = DriverManager.getConnection(URL, user, pass);
		List<Actor> actorList = new ArrayList<Actor>();

		String sql = "SELECT * FROM actor JOIN film_actor ON actor.id = film_actor.actor_id "
				+ " WHERE film_actor.film_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Actor actor = new Actor(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));
			actorList.add(actor);
		}
		rs.close();
		stmt.close();
		conn.close();

		return actorList;

	}

	@Override
	public List<Film> findFilmsBySearchString(String searchString) throws SQLException {
		Connection conn = DriverManager.getConnection(URL, user, pass);
		List<Film> filmList = new ArrayList<Film>();
		List<Actor> aL = null;
		Film film = null;


		String sql = "SELECT * FROM film " + " WHERE description LIKE ? OR " + " title LIKE ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%" + searchString + "%");
		stmt.setString(2, "%" + searchString + "%");

//		System.out.println(stmt);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			film = new Film();
			film.setiD(rs.getInt("id"));
			film.setDescription(rs.getString("description"));
			film.setLanguageId(rs.getInt("language_id"));
			film.setLength(rs.getInt("length"));
			film.setRating(rs.getString("rating"));
			film.setReleaseYear(rs.getInt("release_year"));
			film.setRentalDuration(rs.getInt("rental_duration"));
			film.setRentalRate(rs.getDouble("rental_rate"));
			film.setReplacementCost(rs.getDouble("replacement_cost"));
			film.setSpecialFeatures(rs.getString("special_features"));
			film.setTitle(rs.getString("title"));
			film.setLanguageName(findLanguageById(film.getLanguageId()));
			aL = findActorsByFilmId(film.getiD());
			film.setActorList(aL);
			filmList.add(film);
		}
		rs.close();
		stmt.close();
		conn.close();

		return filmList;
	}

	@Override
	public String findLanguageById(int langId) throws SQLException {
		Connection conn = DriverManager.getConnection(URL, user, pass);
		String language = null;
		
		String sql = "SELECT * FROM language "
				+ " WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, langId);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
		language = rs.getString("name");
		}
		rs.close();
		stmt.close();
		conn.close();

		return language;
	}

}
