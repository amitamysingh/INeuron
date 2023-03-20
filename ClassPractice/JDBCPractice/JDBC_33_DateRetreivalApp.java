package ClassPractice.JDBCPractice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class JDBC_33_DateRetreivalApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try {
			connection=JDBC_20_JDBCUtility.getJdbcConnection();
			
			String sqlSelectQuery="select id,username,dob,dom from users where id=?";
			
			if(connection != null)
				pstmt=connection.prepareStatement(sqlSelectQuery);
			
			if(pstmt != null) {
				pstmt.setInt(1, 1);
				
				resultSet=pstmt.executeQuery();
			}
			if(resultSet != null) {
				
				System.out.println("SID\tSNAME\tSDOB\t\tSDOM");
				//processing the resultSet
				if(resultSet.next()) {
					int sid=resultSet.getInt(1);
					String sname=resultSet.getString(2);
					java.sql.Date dob= resultSet.getDate(3);
					java.sql.Date dom = resultSet.getDate(4);
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					String strDob = sdf.format(dob);
					String strDom = sdf.format(dom);
					
					System.out.println(sid + "\t" + sname + "\t" + strDob + "\t" + strDom);
				}
			}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL or IO exception found in the code");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("Exception found in the code");
			e.printStackTrace();
		}finally {
			try {
				JDBC_20_JDBCUtility.cleanUp(connection, pstmt, resultSet);
				System.out.println("Cleaning up the resources");
			}catch(SQLException se) {
				System.out.println("SQLException occured while cleaning up the resources");
				se.printStackTrace();
				se.printStackTrace();
			}catch(Exception e) {
				System.out.println("Exception occured while cleaning up the resources");
				e.printStackTrace();
			}
		}
	}

}
