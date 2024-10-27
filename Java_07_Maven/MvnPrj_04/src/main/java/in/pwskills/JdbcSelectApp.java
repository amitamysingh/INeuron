package in.pwskills;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSelectApp {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
//		Driver driver = new Driver();
//		DriverManager.registerDriver(driver);
//		System.out.println("Driver is registered succesfully");
		
		String url="jdbc:mysql://localhost:3306/mydb";
		String username="root";
		String password="root@123";
		
		Connection connection = DriverManager.getConnection(url,username,password);
		System.out.println("Connection object is created "+connection);
		
		Statement statement=connection.createStatement();
		System.out.println("Statement object is created "+statement);
		
		String selectQuery="select * from Employees";
		ResultSet resultSet = statement.executeQuery(selectQuery);
		System.out.println("ResultSet object is created "+resultSet);
		
		System.out.println("EMPID\tEMPNAME\tEMPAGE\tEMPADDRESS");
		while(resultSet.next()) {
			Integer id = resultSet.getInt(1);
			String name=resultSet.getString(2);
			Integer age = resultSet.getInt(3);
			String address=resultSet.getString(4);
			System.out.print(id+"\t"+name+"\t "+age+"\t "+address);
		}
		connection.close();
		
	}

}
