package ClassPractice.JDBCPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC_20_JDBCUtility {


		private JDBC_20_JDBCUtility() {}
		
		static {
			//Step1. Loading and register the driver
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			}catch(ClassNotFoundException ce) {
				ce.printStackTrace();
			}
		}
			
			public static Connection getJdbcConnection() throws SQLException, IOException{
				
				//Take the data from properties file
				FileInputStream fis=new FileInputStream("C:\\\\Users\\\\shubh\\\\eclipse-workspace\\\\iNeuron\\\\application.properties");
				Properties properties=new Properties();
				properties.load(fis);
				
				//Step2. Establish the connection
				Connection connection=DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("userName"),
						properties.getProperty("password"));
				System.out.println("Connection Object created");
				
				return connection;
				
			}
			public static void cleanUp(Connection con, Statement stmt, ResultSet result) throws SQLException{
				//Step6. Close the resources
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
