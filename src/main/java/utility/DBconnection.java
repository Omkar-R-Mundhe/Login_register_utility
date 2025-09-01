package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBconnection {
	private static String dbUsername;
	private static String dbURL;
	private static String dbPassword;
	static {
		try {
			// Load the JDBC driver once
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Properties props = new Properties();
	            InputStream input = DBconnection.class.getClassLoader().getResourceAsStream("db.properties");

	            if (input == null) {
	                throw new RuntimeException("db.properties not found");
	            }

	            try {
					props.load(input);
				} catch (IOException e) {
					e.printStackTrace();
				}
	            dbURL = props.getProperty("db.url");
	            dbUsername = props.getProperty("db.username");
	            dbPassword = props.getProperty("db.password");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(dbURL, dbUsername, dbPassword);
	}
}
