package com.ryan.gameWorkshopJava.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.ryan.gameWorkshopJava.models.Game;

public interface GameRepository extends CrudRepository<Game, Long> {

	public ArrayList<Game>findAll();
}
