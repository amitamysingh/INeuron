package ClassPractice.JDBCPractice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_67_UpdateRecordApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection=null;
		Statement stmt=null;
		ResultSet resultSet = null;
		
		try {
			connection=JDBC_20_JDBCUtility.getJdbcConnection();
			
			if(connection != null)
				stmt=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			String sqlSelectQuery="select sid,sname,sage,saddress,sgender from student";
			if(stmt != null)
				resultSet=stmt.executeQuery(sqlSelectQuery);
			
			if(resultSet != null) {
				System.out.println("ResultSet before update...");
				System.out.println("ID\tNAME \tAGE\tADDRESS\tGENDER");
				while(resultSet.next()) {
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4)+"\t"+resultSet.getString(5));
				}
				
				System.out.println();
				resultSet.beforeFirst(); //cursor before first row
				
				while(resultSet.next()) {
					int originalAge=resultSet.getInt(3);
					if(originalAge<33) {
						int incrementAge=originalAge+1;
						resultSet.updateInt(3, incrementAge);
						resultSet.updateRow();
					}
				}
				
				System.out.println();
				resultSet.beforeFirst();
				System.out.println("ResultSet after updation...");
				System.out.println("ID\tNAME \tAGE\tADDRESS\tGENDER");
				while(resultSet.next()) {
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4)+"\t"+resultSet.getString(5));
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
