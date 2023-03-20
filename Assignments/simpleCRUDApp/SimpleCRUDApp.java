package Assignments.simpleCRUDApp;

import java.util.Scanner;

public class SimpleCRUDApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Selection Menu
		System.out.println("Type 1 to insert a new row into the Table");
		System.out.println("Type 2 to view the data in the table");
		System.out.println("Type 3 to update a row in the Table");
		System.out.println("Type 4 to delete a row from the Table");
		//System.out.println("Type 1 to insert a new row into the Table");
		System.out.println("Type 5 to exit this menu");
		
		Scanner scanner = new Scanner(System.in);
		int userInput=scanner.nextInt();
		
		if(userInput == 1) {
			CRUDInsert.insertDetails();
		}
		else if(userInput == 2) {
			CRUDRead.readDetails();
		}
		else if(userInput == 3) {
			CRUDUpdate.updateDetails();
		}
		else if(userInput == 4) {
			CRUDDelete.deleteDetails();
		}
		else if(userInput == 5) {
			System.exit(0);
		}
		else {
			System.out.println("Invalid operation");
		}
		
		
	}

}
