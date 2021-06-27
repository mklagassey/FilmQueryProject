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
		boolean nextFilm = true;
		String userYorN = "y";
		int userNum;

		do {
			System.out.println("~~~ CIN-O-MATIC MAIN MENU ~~~");
			System.out.println();
			System.out.println("Please choose an option: \n" + "1) Look up film by id\n"
					+ "2) Look up film by keyword search\n" + "3) Exit");

			userNum = input.nextInt();

			switch (userNum) {
			case 1:
				System.out.println("Please enter film's unique ID # -----");
				int idNum = input.nextInt();
				Film film = db.findFilmById(idNum);
				displayFilm(film, input);
				break;
			case 2:
				System.out.println("Please enter your search criteria ------");
				String searchFor = input.next();
				List<Film> foundFilms = db.findFilmsBySearchString(searchFor);
				if (foundFilms.size() > 10) {
					System.out.println("Your search returned more than 10 films, would you like to continue? (Y/N)");
					userYorN = input.next();
				}
				if (userYorN.toLowerCase().contains("y")) {

					for (Film film2 : foundFilms) {
						nextFilm = displayFilm(film2, input);
						if (!nextFilm) {
							break;
						}
					}
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

	private boolean displayFilm(Film f, Scanner in) {
		boolean filmResult = true;
		boolean keepGoing = true;

		System.out.println();
		if (f != null) {
			System.out.println("TITLE: " + f.getTitle() + "\n" + "LANGUAGE: " + f.getLanguageName() + " " + "RELEASED: "
					+ f.getReleaseYear() + " " + "RATED: " + f.getRating() + "\n" + "DESCRIPTION:\n "
					+ f.getDescription());
			System.out.println("CAST: ");
			for (int i = 0; i < f.getActorList().size(); i++) {
				Actor actor = f.getActorList().get(i);
				if (i < f.getActorList().size() - 1) {
					System.out.print(" " + actor.getFirstName() + " " + actor.getLastName() + ",");
				} else {
					System.out.print(" " + actor.getFirstName() + " " + actor.getLastName());
					System.out.println();
				}
			}

		} else {
			System.out.println("Sorry, that film does not appear in our database. Please try again.");
			filmResult = false;
		}

		while (filmResult && keepGoing) {

			System.out.println("Would you like to:\n" + "1) See film details\n" + "2) Go to next film result\n"
					+ "3) Return to main menu");
			int choice = in.nextInt();

			switch (choice) {
			case 1:
				System.out.println(f);
				break;
			case 2:
				filmResult = false;
				break;
			case 3:
				keepGoing = false;
				break;
			default:
				System.out.println("Invalid number, please choose either 1 or 2.");
				break;
			}
		}

//		if (choice == 1) {
//			System.out.println(f);
//		} else if (choice == 3) {
//			keepGoing = false;
//		} else {
//			System.out.println("Invalid number, please choose either 1 or 2.");
//		}

		return keepGoing;

	}

}

// stuff