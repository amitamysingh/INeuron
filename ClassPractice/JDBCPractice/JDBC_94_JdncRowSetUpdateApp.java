package ClassPractice.JDBCPractice;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JDBC_94_JdncRowSetUpdateApp {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		RowSetFactory rsf = RowSetProvider.newFactory();
		JdbcRowSet jrs=rsf.createJdbcRowSet();
		
		//Set jdbc url,Username,password and getting the connection
		jrs.setUrl("jdbc:mysql://localhost:3306/mydb");
		jrs.setUsername("root");
		jrs.setPassword("root");
		
		//setting command for jrs execution
		jrs.setCommand("select empid,empname,emplocation,empdept,empsalary from employees");
		jrs.execute();
		
		while(jrs.next()) {
			int actualSalary=jrs.getInt(5);
			if(actualSalary<20000) {
				int updatedSalary=actualSalary+2000;
				jrs.updateInt(5, updatedSalary);
				jrs.updateRow();
			}
		}
		System.out.println("Records updated successfully...");
		jrs.close();
		
	}

}
