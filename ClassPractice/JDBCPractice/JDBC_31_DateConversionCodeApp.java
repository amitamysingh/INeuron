package ClassPractice.JDBCPractice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class JDBC_31_DateConversionCodeApp {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		//Take input from the user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the date:: (MM-yyyy-dd)");
		String sdate=sc.next();
		
		//Convert the date format from String format to java.util.Date
		SimpleDateFormat sdf = new SimpleDateFormat("MM-yyyy-dd");
		java.util.Date uDate = sdf.parse(sdate);
		
		
		//Convert the java.util.Date to java.sql.Date
		long value=uDate.getTime();
		java.sql.Date sqlDate=new java.sql.Date(value);
		
		//Printing all 3 formats of Date
		System.out.println("String format is ::"+sdate);
		System.out.println("java.util format is ::"+uDate);
		System.out.println("java.sql format is ::"+sqlDate);
		
	}

}
