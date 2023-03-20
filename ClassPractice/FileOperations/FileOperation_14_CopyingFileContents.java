package ClassPractice.FileOperations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileOperation_14_CopyingFileContents {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = new PrintWriter("file3.txt");
		
		//Reading from the first file and writing to file3.txt
		BufferedReader br = new BufferedReader(new FileReader("File1.txt"));
		
		String line = br.readLine();
		
		while(line != null) {
			pw.println(line);
			line=br.readLine();
		}
		
		//Reading from the second file and writing to file3.txt
				br = new BufferedReader(new FileReader("File2.txt"));
				
				 line = br.readLine();
				
				while(line != null) {
					pw.println(line);
					line=br.readLine();
				}
		pw.flush();
		
		pw.close();
		br.close();
		
		System.out.println("Open file3.txt to see the results");
	}

}
