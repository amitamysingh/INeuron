package ClassPractice.JDBCPractice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_63_ScrollableApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection=null;
		Statement stmt=null;
		ResultSet resultSet = null;
		
		try {
			connection=JDBC_20_JDBCUtility.getJdbcConnection();
			
			if(connection != null)
				stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			String sqlSelectQuery="select empid,empName,empAge,empAddress from employeedetails";
			if(stmt != null)
				resultSet=stmt.executeQuery(sqlSelectQuery);
			
			if(resultSet != null) {
				System.out.println("MOVING IN FORWARD DIRECTION...");
				System.out.println("ID\tNAME \tAGE\tAddress");
				while(resultSet.next()) {
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
				}
				
				System.out.println();
				System.out.println("MOVING IN BACKWARD DIRECTION...");
				System.out.println("ID\tNAME \tAGE\tAddress");
				while(resultSet.previous()) {
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
				}
				
				System.out.println();
				resultSet.first(); //Cursor will be moved to first record
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
				
				System.out.println();
				resultSet.last(); //Cursor will be moved to last record
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
				
				resultSet.first();
				
				System.out.println();
				resultSet.absolute(3); //From the beginning of the resultSet
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
				
				System.out.println();
				resultSet.relative(2); //from the current position move downwards
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
			
				resultSet.absolute(-1);
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
				
				resultSet.relative(-1);
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));

				
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
