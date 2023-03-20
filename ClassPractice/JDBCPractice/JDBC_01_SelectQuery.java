package ClassPractice.JDBCPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_01_SelectQuery {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
//		//Step1. Load and register the driver
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		System.out.println("Loading the driver");
//		
		
		//Step2.Establish the connection
		String url = "jdbc:mysql://localhost:3306/mydb";
		String userName = "root";
		String password = "root";
		Connection connection = DriverManager.getConnection(url, userName, password);
		System.out.println("Connection object created");
		
		//Step3. Create statement Object and send the query
		Statement statement=connection.createStatement();
		System.out.println("Statement object created");
		
		//Step4. Execute the query and process the resultSet
		String sqlSelectQuery = "select tId,tName,tCity from table1";
		ResultSet resultSet = statement.executeQuery(sqlSelectQuery);
		System.out.println("ResultSet object created");
		System.out.println("tID\ttName\ttCity");
		
				while(resultSet.next()) {
					int tId=resultSet.getInt("tId");
					String tName=resultSet.getNString("tName");
					String tCity=resultSet.getString("tCity");
					System.out.println(tId +"\t"+ tName +"\t" +tCity);
				}
			
		
		
		//Step5. Close the resources
				resultSet.close();
				statement.close();
				connection.close();
				System.out.println("Closing the resources");
	}

}
