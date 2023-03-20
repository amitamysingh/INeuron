package ClassPractice.JDBCPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC_03_InsertQuery {

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
				
				//Taking user input
				Scanner sc=new Scanner(System.in);
				
				System.out.println("Enter the id: ");
				int id = sc.nextInt();
				
				System.out.println("Enter the Name: ");
				String name = sc.next();
				
				System.out.println("Enter the City: ");
				String city = sc.next();
				
				//Step4. Execute the query and process the resultSet
				String sqlInsertQuery = String.format("insert into table1(`tId`,`tName`,`tCity`)values(%d,'%s','%s')",
						id, name, city);
				int rowAffected = statement.executeUpdate(sqlInsertQuery);
				
				System.out.println("Number of rows affected: "+rowAffected);
				
				
				
				//Step5. Close the resources
						
						statement.close();
						connection.close();
						System.out.println("Closing the resources");
	}

}
