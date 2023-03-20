package ClassPractice.FileOperations;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileOperation_13_BufferedReader {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		FileReader fr=new FileReader("abc.txt");
		BufferedReader br=new BufferedReader(fr);
		
		String line=br.readLine();
		
		while(line != null) {
			System.out.println(line);
			line=br.readLine();
		}
		br.close();
	}

}
