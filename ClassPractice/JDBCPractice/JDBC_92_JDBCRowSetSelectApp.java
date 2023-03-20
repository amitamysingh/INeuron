package ClassPractice.JDBCPractice;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JDBC_92_JDBCRowSetSelectApp {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		RowSetFactory rsf = RowSetProvider.newFactory();
		JdbcRowSet jrs = rsf.createJdbcRowSet();//same as resultset(connected),  but updatable and scrollable
		
		//setting url, username,password
		jrs.setUrl("jdbc:mysql://localhost:3306/mydb");
		jrs.setUsername("root");
		jrs.setPassword("root");
		
		//setting a command for execution
		jrs.setCommand("select sid, sname,sage,saddress,sgender from student");
		jrs.execute();
		
		//Retreiving the output
		System.out.println("Retreiving the output...");
		System.out.println("ID\tNAME\tAGE\tADDRESS\tGENDER");
		while(jrs.next()) {
			System.out.println(jrs.getInt(1)+"\t"+jrs.getString(2)+"\t"+jrs.getInt(3)+"\t"+jrs.getString(4)+"\t"+jrs.getString(5));
		}
		
		System.out.println();
		System.out.println("Retreiving the result in backward direction...");
		System.out.println("ID\tNAME\tAGE\tADDRESS\tGENDER");
		while(jrs.previous()) {
			System.out.println(jrs.getInt(1)+"\t"+jrs.getString(2)+"\t"+jrs.getInt(3)+"\t"+jrs.getString(4)+"\t"+jrs.getString(5));
		}
		
		//accessing the resultSet randomly
		System.out.println();
		jrs.beforeFirst();
		jrs.absolute(3);
		System.out.println(jrs.getInt(1)+"\t"+jrs.getString(2)+"\t"+jrs.getInt(3)+"\t"+jrs.getString(4)+"\t"+jrs.getString(5));
		jrs.relative(-2);
		System.out.println(jrs.getInt(1)+"\t"+jrs.getString(2)+"\t"+jrs.getInt(3)+"\t"+jrs.getString(4)+"\t"+jrs.getString(5));


	}

}
