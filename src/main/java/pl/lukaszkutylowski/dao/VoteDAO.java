package pl.lukaszkutylowski.dao;

import pl.lukaszkutylowski.model.Vote;

public interface VoteDAO extends GenericDAO<Vote, Long> {

	public Vote getVoteByUserIdDiscoveryId(long user_id, long discovery_id);
	public int countVoteByIdAndVoteType(long discovery_id, String voteType);
}
