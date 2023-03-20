package ClassPractice.JDBCPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_71_ExcelApp {
	
	//workbook.<sheet-name> represents table name
	private static final String EXCEL_FILE="select * from data.student";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//jdbc:Excel://location where the file is present
		String url="jdbc:Excel://E:\\Amit";
		try (Connection connection=DriverManager.getConnection("")){
			try(PreparedStatement pstmt=connection.prepareCall(EXCEL_FILE)){
				try(ResultSet resultSet=pstmt.executeQuery()){
					while(resultSet.next()) {
						System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3));
					}
				}
			}
			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
