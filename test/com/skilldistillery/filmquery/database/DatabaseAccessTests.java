package com.skilldistillery.filmquery.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

class DatabaseAccessTests {
  private DatabaseAccessor db;

  
  @BeforeEach
  void setUp() throws Exception {
    db = new DatabaseAccessorObject();
  }

  @AfterEach
  void tearDown() throws Exception {
    db = null;
  }
  
  @Test
  void test_getFilmById_returns_film_with_id() {
    Film f = db.findFilmById(1);
    assertNotNull(f);
   assertEquals("ACADEMY DINOSAUR", f.getTitle());
  }

  @Test
  void test_getFilmById_with_invalid_id_returns_null() {
    Film f = db.findFilmById(-42);
    assertNull(f);
  }
  @Test
  void test_findActorById_with_invalid_id_returns_null() {
  Actor a = db.findActorById(-42);
  	assertNull(a);
  }
  @Test
  void test_getActor_with_return_actor() {
	  Actor a = db.findActorById(1);
	  assertNotNull(a);
	  assertEquals("Penelope", a.getFirstName()); 
	  assertEquals("Guiness", a.getLastName()); 
  }
  
  }
  
