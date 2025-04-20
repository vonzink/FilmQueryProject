# FilmQueryProject

![MOVIE IMAGE](./images/movie.png)

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
 - MAMP
 - Maven
 - JDBC

# Database Diagram

![DATABASE DIAGRAM](./images/ERDiagram.png)

# Concepts Applied

# Plan

USER STORY #1

menu created. 
Used boolean to keep menu on and reloading. 
used switch for the 3 options
used try/catch to make sure 1,2, or 3 is entered
```
╔═══════════════════════════════════════╗
║        FILM QUERY MAIN MENU           ║
╠═══════════════════════════════════════╣
║1. Look up a film by its id            ║
║2. Look up a film by a search keyword  ║
║3. Exit the application.               ║
╚═══════════════════════════════════════╝
```
USER STORY #2

Get by ID complete
Created Method for this. 
used try/catch for film not found a input mismatch.


```
╔═══════════════════════════════════════╗
║          FILM BY ID NUMBER            ║
╚═══════════════════════════════════════╝

════════════════════════════════════════
```
USER STORY #3

Film by keyword complete
created new method
Created new method in DatabaseAccessorObject
```
╔═══════════════════════════════════════╗
║             SEARCH RESULTS            ║
╚═══════════════════════════════════════╝
```


USER STORY #4

created a new Method in DatabaseAccessorObject
updated constructor and replaced getLangage in output.

USER STORY #5

created by adding a loop to my app methods.

# NOTES

## user story #1
this was fairly straight forward.. found some color profiles on google to help make the output fancy.. kinda fun.. 
started with a if statement and then quickly when with a switch.. 
I added a while loop to keep the menu popping up. I added the try catch a little later when cleaning up bad input. 

## user story #2
made its own method to keep it cleaner in the switch.
This wasnt to bad, I used the labs for the method structure
Biggest struggle with this one ended up being clearing the scanner which took me awhile to figure out

## user story #3
copied  story 2 and adapted it to take a String. used the hint in the slack to figure out the setString.. Biggest issue here is that i was getting some really nasty SQL errors that were looped. turns out i needed to close out the connections. 
```
	java.sql.DriverManager.getConnection(DriverManager.java:683)
	at java.sql/java.sql.DriverManager.getConnection(DriverManager.java:230)
	at com.skilldistillery.filmquery.database.DatabaseAccessorObject.findActorsByFilmId(DatabaseAccessorObject.java:88)
	at com.skilldistillery.filmquery.database.DatabaseAccessorObject.findFilmByKeyword(DatabaseAccessorObject.java:133)
```
## user story #4
this one was challanging, I started with trying to adjust the SQL command to JOIN and return a string.. I kept breaking my code.. I ended up created a seperate method, adjusting my constructors, and calling it in my array methods. not sure if that was the optimal solution but it seems work. 

## user story #5
looping through the array for the actors wasnt to bad, I kept getting 1 actor in my list because my method in the Database Accessor Object was a "if" instead of a "while". 

![MOVIE IMAGE](./images/movie.png)

ZVZ
