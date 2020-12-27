package pl.lukaszkutylowski.dao;

import pl.lukaszkutylowski.dao.SQL.DAOFactorySQL;
import pl.lukaszkutylowski.exception.NoSuchDbTypeException;

public abstract class DAOFactory {

	public static final int SQL_DAO_FACTORY = 1;
	
	public abstract DiscoveryDAO getDiscoveryDAO();
	public abstract UserDAO getUserDAO();
	public abstract VoteDAO getVoteDAO();
	
	public static DAOFactory getDAOFactory() {
		DAOFactory factory = null;
		
		try {
			factory = getDAOFactory(SQL_DAO_FACTORY);
		} catch (NoSuchDbTypeException e) {
			e.printStackTrace();
		}
		
		return factory;
	}
	
	private static DAOFactory getDAOFactory(int type) throws NoSuchDbTypeException {
		switch(type) {
			case SQL_DAO_FACTORY:
				return new DAOFactorySQL();
		default:
			throw new NoSuchDbTypeException();
		}
	}
}
