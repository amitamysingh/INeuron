package ClassPractice.JDBCPractice;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_41_BlobInsertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Resources used
		Connection connection = null;
		PreparedStatement pstmt = null;
		Scanner scanner = null;
		
		//Variables used
		String name = null;
		String imageLocation = null;
		
		try {
		
			String sqlInsertQuery = "insert into persons(`pname`, `images`) values(?,?)";
			
			//Establishing the connection		
			connection=JDBC_20_JDBCUtility.getJdbcConnection();
			
			if(connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);
			
			if(pstmt != null) {
				scanner = new Scanner(System.in);
				
				if(scanner != null) {
					System.out.println("Enter the name of the person:: ");
					name = scanner.next();
					
					System.out.println("Enter the image location:: ");
					imageLocation=scanner.next();
					
					
				}
				
				//Set the input values to the query
				pstmt.setString(1, name);
				pstmt.setBinaryStream(2, new FileInputStream(new File(imageLocation)));
				
				//Execute the Query
				int rowCount=pstmt.executeUpdate();
				System.out.println("No. of rows affected:: "+rowCount);
			}
			
		}catch(SQLException | IOException sie) {
			System.out.println("SQL/IO Exception found in app...");
			sie.printStackTrace();
		}catch(Exception e) {
			System.out.println("Exception found in app...");
			e.printStackTrace();
		}finally {
			try {
				System.out.println("Cleaning up the resources...");
				scanner.close();
				JDBC_20_JDBCUtility.cleanUp(connection, pstmt, null);
			}catch(SQLException sie) {
				System.out.println("SQL/IO Exception found in clean upprocedure...");
				sie.printStackTrace();
			}catch(Exception e) {
				System.out.println("Exception found in cleanup procedure...");
				e.printStackTrace();
			}
		}
	}

}
