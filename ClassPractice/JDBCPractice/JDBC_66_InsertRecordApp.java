package ClassPractice.JDBCPractice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_66_InsertRecordApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=null;
		Statement stmt=null;
		ResultSet resultSet = null;
		
		try {
			connection=JDBC_20_JDBCUtility.getJdbcConnection();
			
			if(connection != null)
				stmt=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			String sqlSelectQuery="select empid,empName,empAge,empAddress from employeedetails";
			if(stmt != null)
				resultSet=stmt.executeQuery(sqlSelectQuery);
			
			if(resultSet != null) {
				System.out.println("ResultSet before update...");
				System.out.println("ID\tNAME \tAGE\tAddress");
				while(resultSet.next()) {
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
				}
				System.out.println();
				
				resultSet.moveToInsertRow();
				resultSet.updateInt(1, 7);
				resultSet.updateString(2, "dhoni");
				resultSet.updateInt(3, 42);
				resultSet.updateString(4, "CSK");
				resultSet.insertRow();
				
				
				resultSet.beforeFirst(); //cursor before first row
				System.out.println("ResultSet after insertion...");
				System.out.println("ID\tNAME \tAGE\tAddress");
				while(resultSet.next()) {
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
				}
				
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JDBC_20_JDBCUtility.cleanUp(connection, stmt, resultSet);
			}
			catch(SQLException se) {
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
