package pl.lukaszkutylowski.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.lukaszkutylowski.model.User;
import pl.lukaszkutylowski.service.DiscoveryService;
import pl.lukaszkutylowski.service.UserService;

@Service
public class DiscoveryAddControllerService {

	private DiscoveryService discoveryService;
	private UserService userService;
	
	@Autowired
	public DiscoveryAddControllerService (DiscoveryService discoveryService, UserService userService) {
		this.discoveryService = discoveryService;
		this.userService = userService;
	}
	
	public void proceedAddDiscovery(String username, String name, String description, String url) {
		User authenticatedUser = createAuthenticatedUserInstance(username);
		if (username != null) {
			discoveryService.addDiscovery(name, description, url, authenticatedUser);
		}
	}
	
	private User createAuthenticatedUserInstance(String username) {
		return (User) userService.getUserByUsername(username);
	}
}
