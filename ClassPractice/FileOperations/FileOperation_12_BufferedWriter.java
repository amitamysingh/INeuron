package ClassPractice.FileOperations;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileOperation_12_BufferedWriter {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileWriter fw = new FileWriter("abc.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(105);
		bw.write("Neuron");
		
		bw.newLine();
		
		char[] ch= {'P', 'W', 'S', 'K', 'I', 'L', 'L', 'S'};
		bw.write(ch);
		
	}

}
