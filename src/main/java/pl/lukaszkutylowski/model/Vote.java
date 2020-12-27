package pl.lukaszkutylowski.model;

public class Vote {

	private long vote_id;
	private long discovery_id;
	private long user_id;
	private String type;
	
	public Vote() {}
	
	public Vote(Vote vote) {
		this.vote_id = vote.vote_id;
		this.discovery_id = vote.discovery_id;
		this.user_id = vote.user_id;
		this.type = vote.type;
	}

	public long getVote_id() {
		return vote_id;
	}

	public void setVote_id(long vote_id) {
		this.vote_id = vote_id;
	}

	public long getDiscovery_id() {
		return discovery_id;
	}

	public void setDiscovery_id(long discovery_id) {
		this.discovery_id = discovery_id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getVoteType() {
		return type;
	}

	public void setVoteType(String voteType) {
		this.type = voteType;
	}

	@Override
	public String toString() {
		return "Vote [vote_id=" + vote_id + ", discovery_id=" + discovery_id + ", user_id=" + user_id + ", voteType="
				+ type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (discovery_id ^ (discovery_id >>> 32));
		result = prime * result + (int) (user_id ^ (user_id >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + (int) (vote_id ^ (vote_id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vote other = (Vote) obj;
		if (discovery_id != other.discovery_id)
			return false;
		if (user_id != other.user_id)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (vote_id != other.vote_id)
			return false;
		return true;
	}
}
