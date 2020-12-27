package pl.lukaszkutylowski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pl.lukaszkutylowski.AdminCredentionals;
import pl.lukaszkutylowski.controller.service.LoginControllerService;
import pl.lukaszkutylowski.frontend.view.AdminPanelHtmlView;
import pl.lukaszkutylowski.frontend.view.IndexHtmlView;
import pl.lukaszkutylowski.frontend.view.LoginHtmlView;
import pl.lukaszkutylowski.model.User;
import pl.lukaszkutylowski.session.Session;

@RestController
public class LoginController {

	private AdminPanelHtmlView adminPanelHtmlView;
	private LoginControllerService loginService;
	private IndexHtmlView indexHtmlView;
	private LoginHtmlView loginHtmlView;
	private Session session;

	@Autowired
	public LoginController(
			AdminPanelHtmlView adminPanelHtmlView,
			LoginControllerService loginService,
			IndexHtmlView indexHtmlView,
			LoginHtmlView loginHtmlView,
			Session session) {
		this.adminPanelHtmlView = adminPanelHtmlView;
		this.loginService = loginService;
		this.indexHtmlView = indexHtmlView;
		this.loginHtmlView = loginHtmlView;
		this.session = session;
	}
	
	@RequestMapping(value = "login-form", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		
		if (!loginService.validateUser(username, password)) {
			return loginHtmlView.render();
		} else {
			User authenticatedUser = new User();
			authenticatedUser.setUsername(username);
			authenticatedUser.setPassword(password);
			session.setSessionUser(authenticatedUser);
			if (session.getSessionUser().getUsername().equals(AdminCredentionals.ADMIN_USERNAME)) {
				if (session.getSessionUser().getPassword().equals(AdminCredentionals.ADMIN_PASSWORD)) {
					return adminPanelHtmlView.render();
				}
			}
			return indexHtmlView.render();
		}
	}
	
	
}
