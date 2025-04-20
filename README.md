# FilmQueryProject

# Description
You will create a command-line application that retrieves and displays film data. It will be menu-based, allowing the user to choose actions and submit query data.

All JDBC code will be encapsulated in methods of the com.skilldistillery.filmquery.database.DatabaseAccessorObject class. As you need new database access methods, declare them first in the DatabaseAccessor interface, then implement them in DatabaseAccessorObject. Methods should return objects like Film, Actor, and List<Actor>, not String or List<String>.

All user input and display output will be in methods of com.skilldistillery.filmquery.app.FilmQueryApp (or additional application classes in that package, if you choose to create them.) Comment out app.test(); and uncomment app.launch() as a starting point.


# Technologies used
 - Java
 - SQL
 - Git/GitHub
 - Sublime Text Editor
 - zsh

# Database Diagram

![DATABASE DIAGRAM](FilmQuery/diagram.jpeg)

# Concepts Applied

# Plan

USER STORY #1
menu created. 

╔═══════════════════════════════════════╗
║        FILM QUERY MAIN MENU           ║
╠═══════════════════════════════════════╣
║1. Look up a film by its id            ║
║2. Look up a film by a search keyword  ║
║3. Exit the application.               ║
╚═══════════════════════════════════════╝

[33m
Enter your choice: [0m1
You selected 1

USER STORY #2

Get by ID complete

╔═══════════════════════════════════════╗
║          FILM BY ID NUMBER            ║
╚═══════════════════════════════════════╝
[0m
[1m  Tite: [0mACE GOLDFINGER
[1m  Year: [0m2000
[1m  Rating: [0mG
[1m  Description: [0mA Astounding Epistle of a Database Administrator And a Explorer who must Find a Car in Ancient China
[34m
════════════════════════════════════════

USER STORY #3

Film by keyword complete

╔═══════════════════════════════════════╗
║             SEARCH RESULTS            ║
╚═══════════════════════════════════════╝

Search Keyword film lookup. If no matches are found. Otherwise they see a display of films where the key word was anywhere in the title. 

USER STORY #4

Add displaying language to the film

USER STORY #5

List actors as well

