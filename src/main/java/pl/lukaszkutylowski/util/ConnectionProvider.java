package pl.lukaszkutylowski.util;

import org.postgresql.ds.PGSimpleDataSource;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionProvider {

	private static PGSimpleDataSource dataSourceP;

	private static Connection getConnection() throws SQLException {
		return getDataSource().getConnection();
	}
	
	public static DataSource getDataSource() {
		if (dataSourceP == null) {
			try {
				Class.forName("org.postgresql.Driver");
				dataSourceP = new PGSimpleDataSource();
				dataSourceP.setUrl("jdbc:postgresql:// [url - deleted by developer]");
				dataSourceP.setUser("[username - deleted by developer]");
				dataSourceP.setPassword("[password - deleted by developer]");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dataSourceP;
	}
}
