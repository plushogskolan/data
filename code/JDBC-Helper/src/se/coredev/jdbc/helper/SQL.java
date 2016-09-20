package se.coredev.jdbc.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * User user = SQL.url(url).sql(GET_USER_QUERY) .parameter("1001")
 * .parameter("anca01") .single(USER_RESULT_MAPPER);
 * 
 * List<User> users = SQL(url).sql(GET_ALL_USERS_QUERY)
 * .many(USER_RESULT_MAPPER);
 */
public final class SQL {

	private final String url;
	private final List<Object> parameters;
	private String query;

	public SQL(String url) {
		this.url = url;
		this.parameters = new ArrayList<>();
	}

	public SQL query(String query) {
		this.query = query;
		return this;
	}

	public SQL parameter(Object parameter) {
		parameters.add(parameter);
		return this;
	}

	public <T> List<T> many(ResultMapper<T> mapper) throws SQLException {
		try (Connection connection = DriverManager.getConnection(url);
		     PreparedStatement statement = prepareStatement(connection);
		     ResultSet resultSet = statement.executeQuery()) {
		
			List<T> result = new ArrayList<>();
			
			while(resultSet.next()){
				result.add(mapper.map(resultSet));
			}
			
			return result;
		}
	}
	
	public <T> T single(ResultMapper<T> mapper) throws SQLException {
		
		try (Connection connection = DriverManager.getConnection(url);
		     PreparedStatement statement = prepareStatement(connection);
		     ResultSet resultSet = statement.executeQuery()) {
			
			if(resultSet.next()) {
				return mapper.map(resultSet);
			}
			
			throw new RuntimeException("Could not get single value from query:" + query);
		}
	}
	
	private PreparedStatement prepareStatement(Connection connection) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(query);
		
		for(int i = 0; i < parameters.size(); i++) {
			statement.setObject(i + 1, parameters.get(i));
		}
		
		return statement;
	}

}













