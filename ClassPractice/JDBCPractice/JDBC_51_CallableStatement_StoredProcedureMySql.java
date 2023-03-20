package ClassPractice.JDBCPractice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;


/**
 * 
 * @author shubh
 *
 * CREATE DEFINER=`root`@`localhost` PROCEDURE `P_GET_PRODUCT_DETAILS_BY_ID`(IN id INT, OUT NAME VARCHAR(20), OUT rate INT(6), OUT qnt INT(4))
BEGIN
	select pname, price, qty into NAME, rate, qnt 
                             from products where pid=id;
END
 */

public class JDBC_51_CallableStatement_StoredProcedureMySql {

	private static final String storedProcedureCall="{CALL P_GET_PRODUCT_DETAILS_BY_ID(?, ?, ?, ?)}";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=null;
		CallableStatement cstmt=null;
		Scanner scanner=null;
		
		Integer id = null;
		try {
			connection = JDBC_20_JDBCUtility.getJdbcConnection();
			
			
			if(connection != null)
				cstmt = connection.prepareCall(storedProcedureCall);
			
			scanner = new Scanner(System.in);
			if(scanner != null) {
				System.out.println("Enter the product id:: ");
				id=scanner.nextInt();
			}
			
			//setting the input
			if(cstmt != null) {
				cstmt.setInt(1, id);
			}
			
			//setting the datatype of output values
			if(cstmt != null) {
				cstmt.registerOutParameter(2, Types.VARCHAR);
				cstmt.registerOutParameter(3, Types.INTEGER);
				cstmt.registerOutParameter(4, Types.INTEGER);
			}
			
			//execute the stored procedure
			if(cstmt != null) {
				cstmt.execute();
			}
			
			//retreive the result
			if(cstmt != null) {
				System.out.println("Product Name is:: "+cstmt.getString(2));
				System.out.println("Product cost is:: "+cstmt.getInt(3));
				System.out.println("Product quantity is:: "+cstmt.getInt(4));
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JDBC_20_JDBCUtility.cleanUp(connection, cstmt, null);
			}catch(SQLException se) {
				se.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
