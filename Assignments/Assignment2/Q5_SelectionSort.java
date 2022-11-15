package Assignments.Assignment2;

public class Q5_SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {37, 24, 15, 76, 86, 62, 19, 2};
		
		for(int i=0;i<arr.length;i++) {
			int minIndex=i;
			for(int j=i;j<arr.length;j++) {
				 
				
				if(arr[j] <arr[i]) {
					minIndex=j;
					int tempVar=arr[i];
					arr[i]=arr[minIndex];
					arr[j]=tempVar;
				}
								
			}
		}
		for(int elem:arr) {
			System.out.print(elem+" ");
		}
		
	}
	

}
