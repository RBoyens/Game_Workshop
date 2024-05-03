package com.ryan.gameWorkshopJava.controllers;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ryan.gameWorkshopJava.models.LoginUser;
import com.ryan.gameWorkshopJava.models.User;
import com.ryan.gameWorkshopJava.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	//General
	
		@GetMapping("/")
		public String index(HttpSession session, User user, Model model) {
			
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}

	// Registration
		
		@PostMapping("/registration")
		public String register(@Valid @ModelAttribute(value = "user") User user, BindingResult result, Model model,
				HttpSession session) {

			User userFromDb = userService.findUserByEmail(user.getEmail());
			model.addAttribute("newLogin", new LoginUser());

			if (userFromDb != null) {
				result.rejectValue("email", "unique", "Invalid Login.");
			}

			if (!user.getPassword().equals(user.getConfirmPw())) {
				result.rejectValue("password", "password_match", "Invalid Login");
			}

			if (result.hasErrors()) {
				return "index.jsp";
			}
			String encryptedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
			user.setPassword(encryptedPassword);

			Long userId = userService.createUser(user).getId();
			session.setAttribute("loggedInUser", userId);
			return "redirect:/home";
		}
		
	// Login
		
		@PostMapping("/login")
		public String login(@Valid @ModelAttribute(value = "newLogin") LoginUser logInUser, BindingResult result,
				Model model, HttpSession session) {

			User userFromDb = userService.findUserByEmail(logInUser.getEmail());
			model.addAttribute("user", new User());

			if (userFromDb == null) {
				result.rejectValue("email", "invalid", "Invalid login.");
				return "index.jsp";
			}

			if (!BCrypt.checkpw(logInUser.getPassword(), userFromDb.getPassword())) {
				result.rejectValue("password", "invalid", "Invalid login");
				return "index.jsp";
			}
			
			if (result.hasErrors()) {
				return "index.jsp";
			}

			Long userId = userFromDb.getId();
			session.setAttribute("loggedInUser", userId);
			return "redirect:/home";
		}
		
	// Logout
		
		@GetMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:/";
		}
}
