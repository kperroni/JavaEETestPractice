package database;

import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector {

	  private static final String dbName = "studentdb";
	  private static final String url = "jdbc:mysql://localhost:3306/" + dbName;
	  private static final String username = "root";
	  private static final String password = "9MAS9son18";
	
	  public static Connection getConnection() throws Exception {
		  Properties userInfo = new Properties();
		    userInfo.put("user", username);
		    userInfo.put("password", password);
		    Connection connection =
		      DriverManager.getConnection(url, userInfo);
		    return(connection);
	  }
}
