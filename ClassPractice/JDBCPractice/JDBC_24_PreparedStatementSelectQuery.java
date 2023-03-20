package ClassPractice.JDBCPractice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_24_PreparedStatementSelectQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		Scanner scanner=null;
		int sid=0;
		
		try {
			connection=JDBC_20_JDBCUtility.getJdbcConnection();
			
			//Select Query
			String sqlSelectQuery="select sid,sname,sage,saddress,sgender from student where sid =?";
			if(connection != null) 
				pstmt=connection.prepareStatement(sqlSelectQuery);
			
			if(pstmt != null) {
				
				scanner = new Scanner(System.in);
				
				System.out.print("Enter the student id:: ");
				sid=scanner.nextInt();
				
				//Use precompiled query to set the values
				pstmt.setInt(1, sid);
				
				//Execute the query
				resultSet=pstmt.executeQuery();
				
			}
			if(resultSet != null) {
				System.out.println("SID\tSNAME\tSAGE\tSADDRESS\tSGENDER");
				
				if(resultSet.next()) {
					System.out.println(resultSet.getInt(1) +"\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3) +"\t"
						+ resultSet.getString(4) +"\t"+ resultSet.getString(5));
					
				}else {
					System.out.println("Record not available for the given id:: " +sid);
				}
			}
		}	
		catch(SQLException se) {
			System.out.println("SQL Exception inside coding block");
			se.printStackTrace();
		}catch(IOException ie) {
			System.out.println("IO Exception inside coding block");
			ie.printStackTrace();
		}catch(Exception e) {
			System.out.println("Exception inside coding block");
			e.printStackTrace();
		}finally {
			try {
				JDBC_20_JDBCUtility.cleanUp(connection, pstmt, resultSet);
				System.out.println("Cleaning up the resources");
			}catch(SQLException se) {
				System.out.println("SQL Exception inside cleanup method");
				se.printStackTrace();
			}catch(Exception e) {
				System.out.println("Exception inside cleanup method");
				e.printStackTrace();
			}
		}
		
	}

}
