package pl.lukaszkutylowski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.lukaszkutylowski.AdminCredentionals;
import pl.lukaszkutylowski.controller.service.HomeControllerService;
import pl.lukaszkutylowski.frontend.view.*;
import pl.lukaszkutylowski.session.Session;

@RestController
public class HomeController {

	private HomeControllerService homeService;
	private IndexHtmlView indexHtmlView;
	private RegisterHtmlView registerHtmlView;
	private LoginHtmlView loginHtmlView;
	private AddHtmlView addHtmlView;
	private AdminPanelHtmlView adminPanelHtmlView;
	private Session session;
	
	@Autowired
	public HomeController(
			HomeControllerService homeService,
			IndexHtmlView indexHtmlView,
			RegisterHtmlView registerHtmlView,
			LoginHtmlView loginHtmlView,
			AddHtmlView addHtmlView,
			AdminPanelHtmlView adminPanelHtmlView,
			Session session) {
		this.homeService = homeService;
		this.indexHtmlView = indexHtmlView;
		this.registerHtmlView = registerHtmlView;
		this.loginHtmlView = loginHtmlView;
		this.addHtmlView = addHtmlView;
		this.adminPanelHtmlView = adminPanelHtmlView;
		this.session = session;
	}
	
	@GetMapping(value = "/")
	public String home() {
		if (session.getSessionUser() != null) {
			if (session.getSessionUser().getUsername().equals(AdminCredentionals.ADMIN_USERNAME)) {
				if (session.getSessionUser().getPassword().equals(AdminCredentionals.ADMIN_PASSWORD)) {
					return adminPanelHtmlView.render();
				}
			}
		}
		return indexHtmlView.render();
	}
	
	@GetMapping(value = "/register")
	public String register() {
		return registerHtmlView.render();
	}
	
	@GetMapping(value = "/add")
	public String add() {
		return addHtmlView.render();
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return loginHtmlView.render();
	}
}
