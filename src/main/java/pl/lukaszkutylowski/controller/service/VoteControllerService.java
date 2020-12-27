package pl.lukaszkutylowski.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.lukaszkutylowski.model.Discovery;
import pl.lukaszkutylowski.model.User;
import pl.lukaszkutylowski.model.Vote;
import pl.lukaszkutylowski.service.DiscoveryService;
import pl.lukaszkutylowski.service.UserService;
import pl.lukaszkutylowski.service.VoteService;
import pl.lukaszkutylowski.session.Session;

@Service
public class VoteControllerService {

	private DiscoveryService discoveryService;
	private VoteService voteService;
	private UserService userService;
	private Session session;
	
	@Autowired
	public VoteControllerService (DiscoveryService discoveryService,
			VoteService voteService, UserService userService, Session session) {
		this.discoveryService = discoveryService;
		this.voteService = voteService;
		this.userService = userService;
		this.session = session;
	}
	
	public void voteProceed(String voteType, long discovery_id) {
		
		String username = session.getSessionUser().getUsername();
		
		User user = userService.getUserByUsername(username);
		Long user_id = user.getUser_id();
		
		if (username != null) {
			updateDiscovery(discovery_id, user_id, voteType);
		}
	}
	
	private void updateDiscovery(long discovery_id, long user_id, String voteType) {
		
		Discovery discoveryById = discoveryService.getDiscoveryById(discovery_id);
		Discovery updatedDiscovery = null;
		Vote vote;
		int voteCount = 0;
		if (voteType.equals("VOTE_UP")) {
			voteService.addOrUpdateVote(discovery_id, user_id, voteType);
			voteCount = voteService.countVoteByIdAndVoteType(discovery_id, voteType);
			updatedDiscovery = addVoteUp(discoveryById, voteCount);
		} else if (voteType.equals("VOTE_DOWN")) {
			voteService.addOrUpdateVote(discovery_id, user_id, voteType);
			voteCount = voteService.countVoteByIdAndVoteType(discovery_id, voteType);
			updatedDiscovery = addVoteDown(discoveryById, voteCount);
		}
		discoveryService.updateDiscovery(updatedDiscovery);
	}
	
	private Discovery addVoteUp(Discovery discovery, int voteCount) {
		Discovery discoveryCopy = discovery;
		discoveryCopy.setVote_up(voteCount);
		return discoveryCopy;
	}
	
	private Discovery addVoteDown(Discovery discovery, int voteCount) {
		Discovery discoveryCopy = discovery;
		discoveryCopy.setVote_down(voteCount);
		return discoveryCopy;
	}	
}
