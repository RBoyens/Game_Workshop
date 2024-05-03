package com.ryan.gameWorkshopJava.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.ryan.gameWorkshopJava.models.Game;
import com.ryan.gameWorkshopJava.models.LoginUser;
import com.ryan.gameWorkshopJava.models.User;
import com.ryan.gameWorkshopJava.services.GameService;
import com.ryan.gameWorkshopJava.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {

	@Autowired
	private UserService userService;
	@Autowired
	private GameService gameService;

// Home Page
// route ("/home")

	@GetMapping("/home")
	public String dashboard(HttpSession session, Game game, Model model) {
		Long loggedInId = (Long) session.getAttribute("loggedInUser");
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:/";
		}
		ArrayList<Game> allGames = gameService.all();
		User loggedInUser = userService.findOne(loggedInId);
		model.addAttribute("loggedInUser", loggedInUser);
		model.addAttribute("allGames", allGames);
		return "dashboard.jsp";
	}

	// New Game Page
	// route ("/games/new")

	@GetMapping("/games/new")
	public String addGame(@ModelAttribute("game") Game game, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("loggedInUser");
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:/";
		}
		model.addAttribute("userId", userId);
		model.addAttribute("newLogin", new LoginUser());

		return "newGame.jsp";
	}

	@PostMapping("/games/new")
	public String newGame(@Valid @ModelAttribute(value = "game") Game game, BindingResult result) {

		if (result.hasErrors()) {
			return "newGame.jsp";
		}

		gameService.createGame(game);
		return "redirect:/home";
	}

	// Game Details Page
	// route ("/games/id")

	@GetMapping("/games/{id}")
	public String viewGame(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:/";
		}

		Game oneGame = gameService.findOne(id);
		model.addAttribute("game", oneGame);
		return "gameDetail.jsp";
	}

	// Edit Game Page
	// route ("/games/id/edit")

	@GetMapping("/games/{id}/edit")
	public String editGame(HttpSession session, Model model, @PathVariable("id") Long id) {
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:/";
		}

		User user = userService.findOne((Long) session.getAttribute("loggedInUser"));
		Game gameToUpdate = gameService.findOne(id);

		model.addAttribute("user", user);
		model.addAttribute("game", gameToUpdate);
		return "editGame.jsp";
	}

	@PutMapping("/games/{id}")
	public String updateGame(@Valid @ModelAttribute("game") Game game, BindingResult result, Model model,
			@PathVariable("id") Long id, HttpSession session) {
		if (result.hasErrors()) {
			Game gameToUpdate = gameService.findOne(id);
			model.addAttribute("game", gameToUpdate);
			return "editGame.jsp";
		}

		gameService.updateGame(game);
		return "redirect:/home";
	}

	// Delete

	@DeleteMapping("/games/{id}")
	public String deleteGame(@PathVariable("id") Long id) {

		gameService.deleteGame(id);
		return "redirect:/home";
	}
}
