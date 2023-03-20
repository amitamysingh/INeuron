package ClassPractice.JDBCPractice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JDBC_82_HikariCPConnectionPooling {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		String configFile="C:\\\\Users\\\\shubh\\\\eclipse-workspace\\\\iNeuron\\\\db.properties";
		HikariConfig config=new HikariConfig(configFile);
		
		try(HikariDataSource dataSource = new HikariDataSource(config)){
		
			Connection connection=dataSource.getConnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select empid,empname,empage,empaddress from employeedetails");
			
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
			}
		}
	}

}
