package ClassPractice.JDBCPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_04_UpdateQuery {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
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
				String sqlUpdateQuery = "update table1 set tName='John' where tId=4";
				int rowAffected = statement.executeUpdate(sqlUpdateQuery);
				
				System.out.println("Number of rows affected: "+rowAffected);
				
				
				
				//Step5. Close the resources
						
						statement.close();
						connection.close();
						System.out.println("Closing the resources");
	}

}
