package ClassPractice.JDBCPractice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

public class JDBC_81_ConnectionPoolDataSourcing {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		//Create an object of a class which implements javax.sql.DataSource
		MysqlConnectionPoolDataSource dataSource=new MysqlConnectionPoolDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		
		//Getting connection object from connection pool
		Connection connection = dataSource.getConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select empid,empname,empage,empaddress from employeedetails");
		
		System.out.println("ID\tNAME\tAGE\tADDRESS");
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
		}
		
		//Sending the connection object to connection pool
		connection.close();
	}

}
