package ClassPractice.JDBCPractice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class JDBC_62_SavePoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		Statement stmt=null;
		ResultSet resultSet = null;
		
		try {
			connection=JDBC_20_JDBCUtility.getJdbcConnection();
			
			if(connection != null)
				stmt=connection.createStatement();
			
			
			System.out.println("Transaction begins");
			
			connection.setAutoCommit(false);
			
			stmt.executeUpdate("insert into politicians (partyName, candidateName) values('BJP', 'MODI')");
			stmt.executeUpdate("insert into politicians (partyName, candidateName) values('INC', 'Tharoor')");
			
			Savepoint savePoint=connection.setSavepoint();
			stmt.executeUpdate("insert into politicians (partyName, candidateName) values('BJP', 'LALU')");
			System.out.println("OOP's something went wrong");
			connection.rollback(savePoint);
			System.out.println("Operations are rolled back to savepoint");
			connection.commit();
			
			System.out.println("Transactions completed...");
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JDBC_20_JDBCUtility.cleanUp(connection, stmt, resultSet);
			}catch(SQLException se) {
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
