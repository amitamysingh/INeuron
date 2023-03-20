package ClassPractice.JDBCPractice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_23_PreparedStatamentInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		
		try {
			//Establishing the connection 
			connection=JDBC_20_JDBCUtility.getJdbcConnection();
			System.out.println("Connection established");
			
			//The query which has to be compiled
			String sqlInsertQuery="insert into student (`sname`,`sage`,`saddress`,`sgender`) values (?,?,?,?)";
			//
			if(connection != null) {
				//Prepared statement which has to be compiled once and run many times
				pstmt=connection.prepareStatement(sqlInsertQuery);
			}
			if(pstmt != null) {
				
				//Use precompiled query to set the values
				pstmt.setString(1, "kohli");
				pstmt.setInt(2, 32);
				pstmt.setString(3, "RCB");
				pstmt.setString(4, "M");
				
				//Execute the query
				int rowCount= pstmt.executeUpdate();
				System.out.println("Number of rows updated " + rowCount);
			}
			
		}catch(IOException ie) {
			ie.printStackTrace();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				JDBC_20_JDBCUtility.cleanUp(connection, pstmt, null);
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}

}
