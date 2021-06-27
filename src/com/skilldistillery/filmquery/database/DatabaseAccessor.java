package com.skilldistillery.filmquery.database;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;
import com.skilldistillery.filmquery.entities.InventoryItem;

public interface DatabaseAccessor {
	public String findLanguageById(int langId) throws SQLException;
	
	public String findCategoryById(int filmId) throws SQLException;

	public Film findFilmById(int filmId) throws SQLException;

	public Actor findActorById(int actorId) throws SQLException;

	public List<Actor> findActorsByFilmId(int filmId) throws SQLException;

	public List<Film> findFilmsBySearchString(String searchString) throws SQLException;
	
	public List<InventoryItem> findInventoryByFilmId(int filmId) throws SQLException;

}
