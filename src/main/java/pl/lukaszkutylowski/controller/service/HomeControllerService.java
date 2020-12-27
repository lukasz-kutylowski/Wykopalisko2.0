package pl.lukaszkutylowski.controller.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.lukaszkutylowski.model.Discovery;
import pl.lukaszkutylowski.service.DiscoveryService;

@Service
public class HomeControllerService {

	private DiscoveryService discoveryService;
	
	@Autowired
	public HomeControllerService (DiscoveryService discoveryService) {
		this.discoveryService = discoveryService;
	}
	
	public List<Discovery> proceedGetAllDiscoveries () {
		List<Discovery> allDiscoveries =
				discoveryService.getAllDiscoveries(new Comparator<Discovery>() {

					@Override
					public int compare(Discovery d1, Discovery d2) {
						int d1Vote = d1.getVote_up() - d1.getVote_down();
						int d2Vote = d2.getVote_up() - d2.getVote_down();
						if (d1Vote < d2Vote) {
							return 1;
						}
						return 0;
					}
					
				});
		return allDiscoveries;
	}
}
