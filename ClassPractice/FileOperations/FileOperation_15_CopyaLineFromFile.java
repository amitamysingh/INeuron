package ClassPractice.FileOperations;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileOperation_15_CopyaLineFromFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				PrintWriter pw = new PrintWriter("file3.txt");
				
				//Reading from the first file and writing to file3.txt
				BufferedReader br1 = new BufferedReader(new FileReader("File1.txt"));
				
				String line1 = br1.readLine();
				
				
				
				//Reading from the second file and writing to file3.txt
						BufferedReader br2 = new BufferedReader(new FileReader("File2.txt"));
						
						 String line2 = br2.readLine();
						
						 while(line1 != null || line2!=null) {
							 if(line1 != null) {
								 pw.println(line1);
									line1=br1.readLine();
							 }
								
								if(line2 != null) {
									pw.println(line1);
									line1=br1.readLine();
								}
								
							}
						
				pw.flush();
				
				br1.close();
				br2.close();
				pw.close();
				
				
				System.out.println("Open file3.txt to see the results");
	}

}
