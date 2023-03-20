package Assignments.simpleCRUDApp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtility {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	public static Connection getJdbcConnection() throws SQLException, IOException{
		
		//Take the data from properties file
		FileInputStream fis=new FileInputStream("C:\\Users\\shubh\\eclipse-workspace\\iNeuron\\Ineuron\\Assignments\\simpleCRUDApp\\application.properties");
		Properties properties= new Properties();
		properties.load(fis);
		
		//Establish the connection
		Connection connection = DriverManager.getConnection(properties.getProperty("url"), 
				properties.getProperty("userName"), properties.getProperty("password")) ;
		System.out.println("Connection object created");
		return connection;
		
	}
	public static void cleanUp(Connection con, Statement stmt, ResultSet result) throws SQLException {
		//Close the connection
		if(con != null) {
			con.close();
		}
		if(stmt != null) {
			stmt.close();
		}
		if(result != null) {
			result.close();
		}
	}
}
