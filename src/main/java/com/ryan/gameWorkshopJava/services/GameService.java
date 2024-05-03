package com.ryan.gameWorkshopJava.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.gameWorkshopJava.models.Game;
import com.ryan.gameWorkshopJava.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
// Create
	
	public Game createGame(Game game) {
		return gameRepository.save(game);
	}
	
// Read
	
	public ArrayList<Game> all(){
		return gameRepository.findAll();
	}
	
	public Game findOne (long id) {
		return gameRepository.findById(id).orElse(null);
				
	}
	
// Update
	
	public Game updateGame(Game game) {
		return gameRepository.save(game);
	}
	
// Delete
	
	public void deleteGame(Long id) {
		gameRepository.deleteById(id);
	}
}
