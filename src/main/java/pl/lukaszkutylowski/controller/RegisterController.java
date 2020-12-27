package pl.lukaszkutylowski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import pl.lukaszkutylowski.frontend.view.IndexHtmlView;
import pl.lukaszkutylowski.frontend.view.RegisterFailHtmlView;
import pl.lukaszkutylowski.model.User;
import pl.lukaszkutylowski.service.UserService;

@RestController
public class RegisterController {

	private IndexHtmlView indexHtmlView;
	private RegisterFailHtmlView registerFailHtmlView;
	private UserService userService;
	
	@Autowired
	public RegisterController(UserService userService, IndexHtmlView indexHtmlView, RegisterFailHtmlView registerFailHtmlView) {
		this.userService = userService;
		this.indexHtmlView = indexHtmlView;
		this.registerFailHtmlView = registerFailHtmlView;
	}
	
	@RequestMapping(value = "/register-form", method = RequestMethod.POST)
	public String doRegister(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		
		User checkUserIsNull;
		
		try {
			checkUserIsNull = (User) userService.getUserByUsername(username);
			checkUserIsNull.toString();
			return registerFailHtmlView.render();
		} catch (NullPointerException e) {
			userService.addUser(username, password);
			return indexHtmlView.render();
		}
		
	}
}
