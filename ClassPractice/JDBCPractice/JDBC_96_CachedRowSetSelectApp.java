package ClassPractice.JDBCPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JDBC_96_CachedRowSetSelectApp {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select empid,empname,emplocation,empdept,empsalary from employees");
		
		RowSetFactory rsf = RowSetProvider.newFactory();
		CachedRowSet crs=rsf.createCachedRowSet(); //disconnected rowset
		crs.populate(resultSet);
		
		connection.close();//Operation not allowed after connection is closed
		System.out.println("ID\tNAME\tLOCATION\tDEPT\tSALARY");
		while(crs.next()) {
			
			System.out.println(crs.getInt(1)+"\t"+crs.getString(2)+"\t"+crs.getString(3)+"\t\t"
		                  +crs.getString(4)+"\t"+crs.getInt(5));
		}
		
		System.out.println();
		crs.absolute(2);
		System.out.println(crs.getInt(1)+"\t"+crs.getString(2)+"\t"+crs.getString(3)+"\t\t"
                +crs.getString(4)+"\t"+crs.getInt(5));
		
		crs.relative(2);
		System.out.println(crs.getInt(1)+"\t"+crs.getString(2)+"\t"+crs.getString(3)+"\t\t"
                +crs.getString(4)+"\t"+crs.getInt(5));
	}

}
