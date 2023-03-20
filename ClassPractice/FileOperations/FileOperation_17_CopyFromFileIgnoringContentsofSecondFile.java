package ClassPractice.FileOperations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class FileOperation_17_CopyFromFileIgnoringContentsofSecondFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("Input.txt"));
		PrintWriter out = new PrintWriter("output.txt");
		
		String target = br.readLine();
		while(target != null ) {
			
			boolean isAvailable=false;
			
			BufferedReader br1=new BufferedReader(new FileReader("Output.txt"));
			String line=br1.readLine();
			
			//
			while(line != null) {
				if(line.equals(target)) {
					isAvailable=true;
					break;
				}
				
					line=br1.readLine();
			}
			if(isAvailable == false)
				pw.println(target);
			
		}
				
		pw.flush();
		
		br1.close();
		
		pw.close();
		
		
		System.out.println("Open file3.txt to see the results");

	}

}
