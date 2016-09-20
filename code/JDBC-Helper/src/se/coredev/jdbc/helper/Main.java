package se.coredev.jdbc.helper;

import java.util.List;

public final class Main {


	private static final String URL = "your connection string here";
	// Pre Java 8 style
//	private static final ResultMapper<User> USER_MAPPER = new ResultMapper<User>() {
//
//		@Override
//		public User map(ResultSet resultSet) throws SQLException {
//			return new User(resultSet.getString("username"), resultSet.getString("password"));
//		}};

	// Java 8 style
	private static final ResultMapper<User> USER_MAPPER = (r -> new User(r.getString("username"), r.getString("password")));
	
	public static void main(String[] args) throws Exception {
		
		User user = new SQL(URL).query("select * from users where id = ?")
								.parameter("1001")
								.single(USER_MAPPER);
		
		System.out.println(user);
		
		
		List<User> users = new SQL(URL).query("select * from users").many(USER_MAPPER);
		users.forEach(System.out::println);
	}

}
