package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
//    app.test();
		app.launch();
	}

	private void test() throws SQLException {
		Film film = db.findFilmById(0);
		System.out.println(film);
//    Actor actor = db.findActorById(1);
//    System.out.println(actor);
//    List<Actor> actorList = db.findActorsByFilmId(1);
//    for (Actor actor : actorList) {
//		System.out.println(actor);
//	}
	}

	private void launch() throws SQLException {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) throws SQLException {
		boolean keepGoing = true;
		do {
			
		int userChoice;
		System.out.println("Please choose an option: \n" + "1) Look up film by id\n"
				+ "2) Look up film by keyword search\n" + "3) Exit");

		userChoice = input.nextInt();

		switch (userChoice) {
		case 1:
			System.out.println("Please enter film's unique ID # -----");
			int idNum = input.nextInt();
			Film film = db.findFilmById(idNum);
			displayFilm(film);
			break;
		case 2:
			System.out.println("Please enter your search criteria ------");
			String searchFor = input.next();
			List<Film> foundFilms = db.findFilmsBySearchString(searchFor);
			for (Film film2 : foundFilms) {
				displayFilm(film2);
			}
			break;
		case 3:
			System.out.println("Thanks for using CIN-O-MATIC, come back soon!");
			keepGoing = false;
			break;

		default:
			System.out.println("Sorry, try again. That number is invalid.");
			break;
		}
		} while (keepGoing);

	}
	

	private void displayFilm(Film f) {
		if (f != null) {
			System.out.println("TITLE: " + f.getTitle() + " " + 
					"LANGUAGE: " + f.getLanguageName()+ " " +
					"RELEASED: " + f.getReleaseYear() + " " + 
					"RATED: " + f.getRating() + "\n " + 
					"----> DESCRIPTION: " + f.getDescription()
					);
			System.out.println("CAST: ");
			for (int i = 0 ; i < f.getActorList().size() ; i++) {
				Actor actor = f.getActorList().get(i);
				if (i < f.getActorList().size() - 1) {
					System.out.print(actor.getFirstName() + " " + actor.getLastName() + ", ");
				} else {
					System.out.print(actor.getFirstName() + " " + actor.getLastName());
					System.out.println();
				}
//				System.out.println();
			}
		} else {
			System.out.println("Sorry, that film does not appear in our database. Please try again.");
		}
	}

}

// stuff