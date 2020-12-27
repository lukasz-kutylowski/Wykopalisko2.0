package pl.lukaszkutylowski.dao.SQL;

import pl.lukaszkutylowski.dao.DAOFactory;
import pl.lukaszkutylowski.dao.DiscoveryDAO;
import pl.lukaszkutylowski.dao.UserDAO;
import pl.lukaszkutylowski.dao.VoteDAO;

public class DAOFactorySQL extends DAOFactory {

	@Override
	public DiscoveryDAO getDiscoveryDAO() {
		return new DiscoveryDAOImplSQL();
	}

	@Override
	public UserDAO getUserDAO() {
		return new UserDAOImplSQL();
	}

	@Override
	public VoteDAO getVoteDAO() {
		return new VoteDAOImplSQL();
	}

}
