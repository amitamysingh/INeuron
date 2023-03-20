package ClassPractice.JDBCPractice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class JDBC_32_DateApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement pstmt=null;
		Scanner sc=null;
		
		
		String name=null;
		String dob=null;
		String dom=null;
		
		java.sql.Date sqlDob=null;
		java.sql.Date sqlDom=null;
		
		
		try {
			connection=JDBC_20_JDBCUtility.getJdbcConnection();
			
			String sqlInsertQuery="insert into users (username,dob,dom) values(?,?,?)";
			
			if(connection != null) 
				pstmt=connection.prepareStatement(sqlInsertQuery);
			
				
			if(pstmt != null) {
				sc=new Scanner(System.in);
				
				if(sc != null) {
					System.out.println("Enter the name of the user:: ");
					name=sc.next();
					
					System.out.println("Enter the dob(MM-dd-yyyy):: ");
					dob=sc.next();
					
					System.out.println("Enter the dom(yyyy-MM-dd):: ");
					dom=sc.next();
				}
				
				if( dob != null) {
					SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy");
					java.util.Date uDate=sdf.parse(dob);
					
					//Converting util date to SQL Date
					long value=uDate.getTime();
					sqlDob=new java.sql.Date(value);
				}
				
				if(dom != null)
					sqlDom=java.sql.Date.valueOf(dom);
				
				//Set the values in the query
				pstmt.setString(1, name);
				pstmt.setDate(2, sqlDob);
				pstmt.setDate(3, sqlDom);
				
				//Execute the query
				int rowAffected=pstmt.executeUpdate();
				System.out.println("No. of rows affected:: "+rowAffected);
			}
			
		}catch(SQLException | IOException e) {
			System.out.println("Exception occured in the App code");
			e.printStackTrace();
		}catch(ParseException pe) {
			pe.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				JDBC_20_JDBCUtility.cleanUp(connection, null, null);
				sc.close();
				System.out.println("Closing all the resources");
			}catch(SQLException se) {
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
