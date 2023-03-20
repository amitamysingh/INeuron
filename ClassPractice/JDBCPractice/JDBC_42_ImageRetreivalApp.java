package ClassPractice.JDBCPractice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

public class JDBC_42_ImageRetreivalApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		Scanner scanner=null;
		
		try {
			
			connection = JDBC_20_JDBCUtility.getJdbcConnection();
			
			String sqlSelectQuery="select id,pname,images from persons where id=?";
			if(connection !=null) 
				pstmt= connection.prepareStatement(sqlSelectQuery);
			
			if(pstmt != null) {
				scanner=new Scanner(System.in);
				System.out.println("Enter the id of the person you want to see the image:: ");
				int id=scanner.nextInt();
				
			
				pstmt.setInt(1, id);
				resultSet = pstmt.executeQuery();
				
				if(resultSet != null) {
					if(resultSet.next()) {
						System.out.println("ID\tNAME\tIMAGES");
						int sid=resultSet.getInt(1);
						String sname=resultSet.getString(2);
						InputStream is = resultSet.getBinaryStream(3);
						
						File file=new File("copied.jpg");
						FileOutputStream fos=new FileOutputStream(file);
						
//						byte[] b = new byte[1024];
//						//Reads some number of bytes from the inputstream and stores them into the buffer array b.
//						//If the length of b is 0, then no byte is read and 0 is returned
//						while(is.read(b) > 0) {
//							fos.write(b);
//						}
						//Replacement of the above code block
						IOUtils.copy(is, fos);
						
//						int i=is.read();
//						while(i!=-1) {
//							fos.write(i);
//							i=is.read();
//						}
						
						fos.close();
						System.out.println(sid+"\t"+sname+"\t"+file.getAbsolutePath());
					}else {
						System.out.println("Record is not available for the given id:: "+id);
					}
				}
				
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}

}
