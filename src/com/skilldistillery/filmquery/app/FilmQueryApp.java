package com.skilldistillery.filmquery.app;

import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
	final String RESET = "\u001B[0m";
	final String GREEN_TEXT = "\u001B[32m";
	final String YELLOW_TEXT = "\u001B[33m";

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		// app.test();
		app.launch();
	}

//	private void test() {
//		Film film = db.findFilmById(1);
//		System.out.println(film);
//	}

	private void launch() {
		startUserInterface();

	}

	private void startUserInterface() {
		Scanner input = new Scanner(System.in);

		System.out.println(GREEN_TEXT);
		System.out.println("╔═══════════════════════════════════════╗");
		System.out.println("║        FILM QUERY MAIN MENU           ║");
		System.out.println("╠═══════════════════════════════════════╣");
		System.out.println("║1. Look up a film by its id            ║");
		System.out.println("║2. Look up a film by a search keyword  ║");
		System.out.println("║3. Exit the application                ║");
		System.out.println("╚═══════════════════════════════════════╝");

		System.out.print(YELLOW_TEXT + "\nEnter your choice: " + RESET);
		int choice = input.nextInt();

		switch (choice) {
		case 1:
		case 2:
		case 3:
			System.out.println("You selected " + choice);
			break;
		default:
			System.out.println("Please enter 1, 2, or 3");

		}
		input.close();
	}
}