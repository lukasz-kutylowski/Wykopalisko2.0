package pl.lukaszkutylowski.service;

import org.springframework.stereotype.Service;

import pl.lukaszkutylowski.dao.DAOFactory;
import pl.lukaszkutylowski.dao.VoteDAO;
import pl.lukaszkutylowski.model.Vote;

@Service
public class VoteService {

	public Vote addVote(long discovery_id, long user_id, String voteType) {
		Vote vote = new Vote();
		vote.setDiscovery_id(discovery_id);
		vote.setUser_id(user_id);
		vote.setVoteType(voteType);
		DAOFactory factory = DAOFactory.getDAOFactory();
		VoteDAO voteDao = factory.getVoteDAO();
		vote = voteDao.create(vote);
		return vote;
	}
	
	public Vote updateVote(long discovery_id, long user_id, String voteType) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		VoteDAO voteDao = factory.getVoteDAO();
		Vote voteToUpdate = voteDao.getVoteByUserIdDiscoveryId(user_id, discovery_id);
		if (voteToUpdate != null) {
			voteToUpdate.setVoteType(voteType);
			voteDao.update(voteToUpdate);
		}
		return voteToUpdate;
	}
	
	public Vote addOrUpdateVote(long discovery_id, long user_id, String voteType) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		VoteDAO voteDao = factory.getVoteDAO();
		Vote vote = voteDao.getVoteByUserIdDiscoveryId(user_id, discovery_id);
		Vote resultVote = null;
		if (vote == null) {
			resultVote = addVote(discovery_id, user_id, voteType);
		}
		return resultVote;
	}
	
	public Vote getVoteByDiscoveryUserId(long discovery_id, long user_id) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		VoteDAO voteDao = factory.getVoteDAO();
		Vote vote = voteDao.getVoteByUserIdDiscoveryId(user_id, discovery_id);
		return vote;
	}
	
	public int countVoteByIdAndVoteType(long discovery_id, String voteType) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		VoteDAO voteDao = factory.getVoteDAO();
		int voteCount = voteDao.countVoteByIdAndVoteType(discovery_id, voteType);
		return voteCount;
	}
}
