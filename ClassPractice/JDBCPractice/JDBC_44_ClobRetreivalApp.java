package ClassPractice.JDBCPractice;

import java.io.File;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

public class JDBC_44_ClobRetreivalApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		Scanner scanner=null;
		
		int id=0;
		try {
			
			connection=JDBC_20_JDBCUtility.getJdbcConnection();
			
			String sqlSelectQuery="select id,cityname,history from cities where id=?";
			if(connection != null)
				pstmt=connection.prepareStatement(sqlSelectQuery);
			
			if(pstmt != null) {
				scanner = new Scanner(System.in);
				
				if(scanner != null) {
					System.out.println("Enter the id of the city to view history:: ");
					id=scanner.nextInt();
					
					
				}
				
				pstmt.setInt(1, id);
				
				resultSet=pstmt.executeQuery();
			}
			if(resultSet != null) {
				System.out.println("ID\tNAME\tHISTORY");
				
				if(resultSet.next()) {
					int sid=resultSet.getInt(1);
					String name=resultSet.getString(2);
					Reader reader=resultSet.getCharacterStream(3);
					
					File file=new File("copied_history.pdf");
					FileWriter writer=new FileWriter(file);
					
					IOUtils.copy(reader, writer);
					
					writer.close();
					System.out.println(sid + "\t"+name+"\t" +file.getAbsolutePath());
				}else {
					System.out.println("Record not available for the given id:: "+id);
				}
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JDBC_20_JDBCUtility.cleanUp(connection, pstmt, resultSet);
			}catch(SQLException se) {
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
