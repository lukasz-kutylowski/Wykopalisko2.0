package pl.lukaszkutylowski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lukaszkutylowski.frontend.view.IndexHtmlView;
import pl.lukaszkutylowski.session.Session;

@RestController
public class LogoutController {

	private IndexHtmlView indexHtmlView;
	private Session session;

	@Autowired
	public LogoutController(IndexHtmlView indexHtmlView, Session session) {
		this.indexHtmlView = indexHtmlView;
		this.session = session;
	}

	@RequestMapping(value = "/logout")
	public String logout() {
		session.deleteSession();
		return indexHtmlView.render();
	}
}
