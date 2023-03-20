package ClassPractice.JDBCPractice;

import java.io.*;
import java.util.*;

public class JDBC_22_PreparedStatement {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream("C:\\Users\\shubh\\eclipse-workspace\\iNeuron\\application.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
		String url=properties.getProperty("url");
		String userName=properties.getProperty("userName");
		String password=properties.getProperty("password");
		
		System.out.println("URL      IS ::"+url);
		System.out.println("USER     IS ::"+userName);
		System.out.println("PASSWORD IS ::"+password);
		
		
		
	}
}
