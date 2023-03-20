package ClassPractice.JDBCPractice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC_61_TransactionApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection=null;
		Statement stmt = null;
		ResultSet resultSet = null;
		Scanner scanner = null;
		
		try {
			connection=JDBC_20_JDBCUtility.getJdbcConnection();
			
			if(connection != null)
				stmt=connection.createStatement();
			
			System.out.println("Data before transaction...");
			if(stmt != null) 
				resultSet=stmt.executeQuery("select customerName,balance from accounts");
			
			if(resultSet != null) {
				System.out.println("NAME \tBalance");
				while(resultSet.next()) {
					System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2));
				}
			}
			//Transaction begins
			System.out.println("\nTransaction begins...");
			connection.setAutoCommit(false);
			
			//Prepare the object as a single unit
			scanner=new Scanner(System.in);
			stmt.executeUpdate("update accounts set balance=balance-5000 where customerName='sachin'");
			stmt.executeUpdate("update accounts set balance=balance+5000 where customerNAme='dhoni'");
			System.out.println("Can you please confirm the transaction of 5000INR:: [YES/NO]");
			String option=scanner.next();
			
			if(option.equalsIgnoreCase("Yes")) {
				connection.commit();
				System.out.println("Transaction completed successfully");
			}else {
				connection.rollback();
				System.out.println("Transaction failed...");
			}
			
			System.out.println("\nData after transaction:: ");
			ResultSet rs=stmt.executeQuery("select customerName,balance from accounts");
			if(rs != null) {
				System.out.println("NAME \tBALANCE");
				while(rs.next()) {
					System.out.println(rs.getString(1)+"\t"+rs.getInt(2));
				}
			}
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
