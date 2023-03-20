package ClassPractice.JDBCPractice;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_43_ClobInsertionApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		Scanner scanner=null;
		
		//variables used
		String name=null;
		String pdfLocation=null;
		
		try {
			
			connection=JDBC_20_JDBCUtility.getJdbcConnection();
			
			String sqlInsertQuery="insert into cities (`cityname`, `history`) values(?,?)";
			if(connection != null)
				pstmt=connection.prepareStatement(sqlInsertQuery);
			
			if(pstmt != null) {
				scanner=new Scanner(System.in);
				
				if (scanner!=null) {
					
					//Collecting the inputs
					System.out.println("Enter the name of the city");
					name=scanner.next();
					
					System.out.println("Enter the pdf location");
					pdfLocation=scanner.next();
					
					
				}
				//set the input values to query
				pstmt.setString(1, name);
				pstmt.setCharacterStream(2, new FileReader(new File(pdfLocation)));
				
				int rowCount=pstmt.executeUpdate();
				System.out.println("The number of rows affected:: "+rowCount);
				
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			JDBC_20_JDBCUtility.cleanUp(connection, pstmt, null);
			}catch(SQLException se) {
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
