package pl.lukaszkutylowski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import pl.lukaszkutylowski.controller.service.VoteControllerService;
import pl.lukaszkutylowski.frontend.view.IndexHtmlView;

@RestController
public class VoteController {

	private VoteControllerService voteService;
	private IndexHtmlView indexHtmlView;
	
	@Autowired
	public VoteController(VoteControllerService voteService, IndexHtmlView indexHtmlView) {
		this.voteService = voteService;
		this.indexHtmlView = indexHtmlView;
	}
	
	@RequestMapping(value = "/vote-up", method = RequestMethod.POST)
	public String voteUp(@RequestParam("discovery_id") long discovery_id) {
		
		String voteType = "VOTE_UP";
		voteService.voteProceed(voteType, discovery_id);
		return indexHtmlView.render();
	}
	
	@RequestMapping(value = "/vote-down", method = RequestMethod.POST)
	public String voteDown(@RequestParam("discovery_id") long discovery_id) {
		
		String voteType = "VOTE_DOWN";
		voteService.voteProceed(voteType, discovery_id);
		return indexHtmlView.render();
	}
	
	
}
