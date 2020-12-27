package pl.lukaszkutylowski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.lukaszkutylowski.controller.service.DiscoveryAddControllerService;
import pl.lukaszkutylowski.frontend.view.IndexHtmlView;
import pl.lukaszkutylowski.session.Session;

@RestController
public class DiscoveryAddController {

	private DiscoveryAddControllerService controllerService;
	private IndexHtmlView indexHtmlView;
	private Session session;
	
	@Autowired
	public DiscoveryAddController(DiscoveryAddControllerService controllerService, IndexHtmlView indexHtmlView, Session session) {
		this.controllerService = controllerService;
		this.indexHtmlView = indexHtmlView;
		this.session = session;
	}
	
	@RequestMapping(value = "/add-form", method = RequestMethod.POST)
	protected String add(@RequestParam("inputName") String name,
			@RequestParam("inputDescription") String description,
			@RequestParam("inputUrl") String url) {
		
		String username = session.getSessionUser().getUsername();
		controllerService.proceedAddDiscovery(username, name, description, url);
		
		return indexHtmlView.render();
	}
}
