package pl.lukaszkutylowski.dao.SQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import org.springframework.stereotype.Service;
import pl.lukaszkutylowski.dao.DiscoveryDAO;
import pl.lukaszkutylowski.model.Discovery;
import pl.lukaszkutylowski.model.User;
import pl.lukaszkutylowski.util.ConnectionProvider;

@Service
public class DiscoveryDAOImplSQL implements DiscoveryDAO {

	private static final String CREATE_DISCOVERY = 
		"INSERT INTO database2i.discovery "
		+ "(name, description, url, user_id, vote_up, vote_down) "
		+ "VALUES "
		+ "(:name, :description, :url, :user_id, :vote_up, :vote_down);";
	private static final String READ_ALL_DISCOVERIES = 
		"SELECT users.user_id, username, password, is_admin, "
		+ "discovery_id, name, description, url, vote_up, vote_down "
		+ "FROM database2i.discovery "
		+ "LEFT JOIN database2i.users ON discovery.user_id = users.user_id;";
	private static final String READ_DISCOVERY = 
		"SELECT users.user_id, username, password, is_admin, "
		+ "discovery_id, name, description, url, vote_up, vote_down "
		+ "FROM database2i.discovery "
		+ "LEFT JOIN database2i.users ON discovery.user_id = users.user_id "
		+ "WHERE discovery_id = :discovery_id;";
	private static final String UPDATE_DISCOVERY = 
		"UPDATE database2i.discovery SET name = :name, description = :description, "
		+ "url = :url, user_id = :user_id, vote_up = :vote_up, "
		+ "vote_down = :vote_down WHERE discovery_id = :discovery_id;";
	private static final String DELETE_DISCOVERY =
		"DELETE FROM database2i.discovery WHERE discovery_id = :discovery_id";

	private NamedParameterJdbcTemplate template;
	
	public DiscoveryDAOImplSQL() {
		template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
	}
	
	@Override
	public Discovery create(Discovery discovery) {
		Discovery resultDiscovery = new Discovery(discovery);
		KeyHolder holder = new GeneratedKeyHolder();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("name", discovery.getName());
		paramMap.put("description", discovery.getDescription());
		paramMap.put("url", discovery.getUrl());
		paramMap.put("user_id", discovery.getUser().getUser_id());
		paramMap.put("vote_up", discovery.getVote_up());
		paramMap.put("vote_down", discovery.getVote_down());
		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
		int update = template.update(CREATE_DISCOVERY, paramSource, holder);
		if (update > 0) {
			long discovery_id = Long.parseLong(holder.getKeys().get("discovery_id").toString());
			resultDiscovery.setDiscovery_id(discovery_id);
		}
		return resultDiscovery;
	}

	@Override
	public Discovery read(Long primaryKey) {
		SqlParameterSource paramSource = new MapSqlParameterSource("discovery_id", primaryKey);
		Discovery discovery = template.queryForObject(READ_DISCOVERY, paramSource, new DiscoveryRowMapper());
		return discovery;
	}

	@Override
	public boolean update(Discovery discovery) {
		KeyHolder holder = new GeneratedKeyHolder();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("discovery_id", discovery.getDiscovery_id());
		paramMap.put("name", discovery.getName());
		paramMap.put("description", discovery.getDescription());
		paramMap.put("url", discovery.getUrl());
		paramMap.put("user_id", discovery.getUser().getUser_id());
		paramMap.put("vote_up", discovery.getVote_up());
		paramMap.put("vote_down", discovery.getVote_down());
		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
		int update = template.update(UPDATE_DISCOVERY, paramSource, holder);
		if (update > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long key) {
		SqlParameterSource paramSource = new MapSqlParameterSource("discovery_id", key);
		int isDeleted = template.update(DELETE_DISCOVERY, paramSource);
		return (isDeleted == 1) ? true : false;
	}

	@Override
	public List<Discovery> getAll() {
		List<Discovery> discoveries = template.query(READ_ALL_DISCOVERIES, new DiscoveryRowMapper());
		return discoveries;
	}

	private class DiscoveryRowMapper implements RowMapper<Discovery> {

		@Override
		public Discovery mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Discovery discovery = new Discovery();
			discovery.setDiscovery_id(resultSet.getLong("discovery_id"));
			discovery.setName(resultSet.getString("name"));
			discovery.setDescription(resultSet.getString("description"));
			discovery.setUrl(resultSet.getString("url"));
			discovery.setVote_up(resultSet.getInt("vote_up"));
			discovery.setVote_down(resultSet.getInt("vote_down"));
			
			User user = new User();
			user.setUser_id(resultSet.getLong("user_id"));
			user.setUsername(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));
			user.setIs_admin(resultSet.getBoolean("is_admin"));
			
			discovery.setUser(user);
			return discovery;
		}
	}
}
