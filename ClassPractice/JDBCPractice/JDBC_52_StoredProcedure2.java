package ClassPractice.JDBCPractice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_52_StoredProcedure2 {

	private static final String sqlStoredProcedure="{CALL P_GET_PRODUCT_BY_NAME(?,?)}";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection=null;
		CallableStatement cstmt = null;
		ResultSet resultSet = null;
		Scanner scanner=null;
		
		String firstProduct = null;
		String secondProduct = null;
		boolean flag = false;
		
		try {
			
			connection=JDBC_20_JDBCUtility.getJdbcConnection();
			
			
			if(connection != null)
				cstmt = connection.prepareCall(sqlStoredProcedure);
			
			//Collecting Product names to find the details from user
			scanner = new Scanner(System.in);
			if(scanner != null) {
				System.out.println("Enter the name of the first product:: ");
				firstProduct = scanner.next();
				
				System.out.println("Enter the name of the second product:: ");
				secondProduct=scanner.next();
			}
			
			//Setting the input values to the procedure
			if(cstmt != null) {
				cstmt.setString(1, firstProduct);
				cstmt.setString(2, secondProduct);
			}
			
			//Setting the data-type for the output is not required as we get resultSet
			
			//Run the procedure
			if(cstmt != null)
				cstmt.execute();
			
			//retreival of the output
			
			if(cstmt != null) {
				resultSet=cstmt.getResultSet();
			}
			
			//process the resultSet
			if(resultSet != null) {
				
				System.out.println("ID\tNAME \tPRICE \tQUANTITY");
				while( resultSet.next()) {
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+
										resultSet.getInt(3)+"\t"+resultSet.getInt(4));
					flag=true;
				}
			}
			//Displaying the nature of the result
			if(flag) {
				System.out.println("Record available and displayed");
			}else {
				System.out.println("Record not available");
			}
			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JDBC_20_JDBCUtility.cleanUp(connection, cstmt, resultSet);
			}catch(SQLException se) {
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
