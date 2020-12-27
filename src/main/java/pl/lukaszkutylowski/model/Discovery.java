package pl.lukaszkutylowski.model;

public class Discovery {

	private long discovery_id;
	private String name;
	private String description;
	private String url;
	private User user;
	private int vote_up;
	private int vote_down;
	
	public Discovery() {}
	
	public Discovery(Discovery discovery) {
		this.discovery_id = discovery.discovery_id;
		this.name = discovery.name;
		this.description = discovery.description;
		this.url = discovery.url;
		this.user = discovery.user;
		this.vote_up = discovery.vote_up;
		this.vote_down = discovery.vote_down;
	}

	public long getDiscovery_id() {
		return discovery_id;
	}

	public void setDiscovery_id(long discovery_id) {
		this.discovery_id = discovery_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getVote_up() {
		return vote_up;
	}

	public void setVote_up(int vote_up) {
		this.vote_up = vote_up;
	}

	public int getVote_down() {
		return vote_down;
	}

	public void setVote_down(int vote_down) {
		this.vote_down = vote_down;
	}

	@Override
	public String toString() {
		return "Discovery [discovery_id=" + discovery_id + ", name=" + name + ", description=" + description + ", url="
				+ url + ", user=" + user + ", vote_up=" + vote_up + ", vote_down=" + vote_down + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (discovery_id ^ (discovery_id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + vote_down;
		result = prime * result + vote_up;
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
		Discovery other = (Discovery) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (discovery_id != other.discovery_id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (vote_down != other.vote_down)
			return false;
		if (vote_up != other.vote_up)
			return false;
		return true;
	}
}
