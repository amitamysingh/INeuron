package ClassPractice.FileOperations;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileOperation_1_charArray {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f=new File("sachin.txt");
		FileReader fr=new FileReader(f);
		
		char[] ch=new char[(int) f.length()];
		
		//read one character and store it in an array
		fr.read(ch);
		
		for(char data:ch)
			System.out.println(data);	
		}

}


