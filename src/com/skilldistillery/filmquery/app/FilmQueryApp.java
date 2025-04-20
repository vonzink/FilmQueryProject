package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
	private final String RESET = "\u001B[0m";
	private final String GREEN_TEXT = "\u001B[32m";
	private final String YELLOW_TEXT = "\u001B[33m";
	
    
    private final String RED_TEXT = "\u001B[31m";
    private final String BLUE_TEXT = "\u001B[34m";
    String PURPLE_TEXT = "\u001B[35m";
    String CYAN_TEXT = "\u001B[36m";
    String BLACK_TEXT = "\u001B[30m";
    String WHITE_TEXT = "\u001B[37m";
    
    String BLACK_BG = "\u001B[40m";
    String RED_BG = "\u001B[41m";
    String GREEN_BG = "\u001B[42m";
    String YELLOW_BG = "\u001B[43m";
    String BLUE_BG = "\u001B[44m";
    String PURPLE_BG = "\u001B[45m";
    String CYAN_BG = "\u001B[46m";
    String WHITE_BG = "\u001B[47m";
    private final String BOLD = "\u001B[1m";
    String ITALIC = "\u001B[3m";

	private Film film;
	private DatabaseAccessor db = new DatabaseAccessorObject();
	private Scanner input = new Scanner(System.in);

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
		boolean running = true;
		while (running) {

			System.out.println(GREEN_TEXT);
			System.out.println("╔═══════════════════════════════════════╗");
			System.out.println("║        FILM QUERY MAIN MENU           ║");
			System.out.println("╠═══════════════════════════════════════╣");
			System.out.println("║1. Look up a film by it's id           ║");
			System.out.println("║2. Look up a film by a search keyword  ║");
			System.out.println("║3. Exit the application                ║");
			System.out.println("╚═══════════════════════════════════════╝");
			System.out.println();
			System.out.print(YELLOW_TEXT + "Enter your choice: " + RESET);
			
			try {
				int choice = input.nextInt();

				switch (choice) {
				case 1:
					filmById();
					break; 
				case 2:
					filmByKeyword();
					break; 
				case 3:
					System.out.println("Goodbye!");
					running = false;
					break;
				default:
					System.out.println("Please enter 1, 2, or 3");
					}
			} catch (Exception e) {
				input.nextLine(); 
				System.out.println("Please enter 1, 2, or 3");
			}
		}
	}
	private void filmById() {
		film = null; 
		System.out.println("Please enter the film ID: ");
		
			try {
				int filmId = input.nextInt();
				input.nextLine(); 
				
				film = db.findFilmById(filmId);

				if (film == null) {
					System.out.println(); 
					System.out.println(RED_TEXT + "- film not found - ");
				} else {
			System.out.println();
			System.out.println(BLUE_TEXT);
			System.out.println("╔═══════════════════════════════════════╗");
			System.out.println("║          FILM BY ID NUMBER            ║");
			System.out.println("╚═══════════════════════════════════════╝");
			System.out.println(RESET);
			System.out.println(BOLD +"  Tite: " + RESET + film.getTitle());
			System.out.println(BOLD +"  Year: "+ RESET + film.getYear());
			System.out.println(BOLD +"  Rating: "+ RESET  + film.getRating());
			System.out.println(BOLD +"  Description: "+ RESET + film.getDescription());
			System.out.println(BLUE_TEXT);
			System.out.println("════════════════════════════════════════");
			System.out.println(RESET);
				}
	} catch (Exception e) {
		input.nextLine(); 
		System.out.println(); 
		System.out.println(RED_TEXT + "-- film not found -- ");
		}
	}
	
	private void filmByKeyword() {
		film = null; 
		input.nextLine(); 
		System.out.println("Search: ");		
		String keywordFilm = input.nextLine(); 

		try {
			List<Film> films = db.findFilmByKeyword(keywordFilm); 
			
			if(films.isEmpty()) {
				System.out.println();
				System.out.println(RED_TEXT + " - film not found - ");
			} else {
				for (Film f : films){
				System.out.println();
				System.out.println(PURPLE_TEXT);
				System.out.println("╔═══════════════════════════════════════╗");
				System.out.println("║             SEARCH RESULTS            ║");
				System.out.println("╚═══════════════════════════════════════╝");
				System.out.println(RESET);
				System.out.println(BOLD +"  Tite: " + RESET + f.getTitle());
				System.out.println(BOLD +"  Year: "+ RESET + f.getYear());
				System.out.println(BOLD +"  Rating: "+ RESET  + f.getRating());
				System.out.println(BOLD +"  Description: "+ RESET + f.getDescription());
				System.out.println(PURPLE_TEXT);
				System.out.println("════════════════════════════════════════");
				System.out.println(RESET);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}