package ClassPractice.JDBCPractice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_22_FormattedOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		
		try {
			connection = JDBC_20_JDBCUtility.getJdbcConnection();
			
			if(connection != null) 
				statement=connection.createStatement();
			
			if(statement !=null) 
					resultSet=statement.executeQuery("select sid,sname,sage,saddress,sgender from student");
			
			if(resultSet !=null) {
				System.out.println("SID\tSNAME\tSAGE\tSADDRESS\tSGENDER");
				
				while(resultSet.next()) {
					System.out.printf("%d%12s%7d%12s%12s",resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),
							resultSet.getString(4),resultSet.getString(5));
					System.out.println();
				}
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JDBC_20_JDBCUtility.cleanUp(connection, statement, resultSet);
				System.out.println("Closing all the resources");

			} catch (SQLException se) {
				// TODO Auto-generated catch block
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
