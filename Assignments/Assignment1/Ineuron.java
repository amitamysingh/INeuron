package Assignments.Assignment1;

public class Ineuron {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=10;
		//Pattern I
		for(int i=0;i<n;i++) {
			for(int j=0; j<n; j++) {
				if(i==0 || j==(n-1)/2 || i==(n-1)) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}//Pattern N
			
				for(int j=0; j<n; j++) {
					if(j==0 || i==j || j==(n-1)) {
						System.out.print("*");
					}else {
						System.out.print(" ");
					}
				}//Pattern E
				
					for(int j=0; j<n; j++) {
						if(j==0 || i==0 || i==(n-1)/2 || i==(n-1)) {
							System.out.print("*");
						}else {
							System.out.print(" ");
						}
					}	
					//Pattern U
						for(int j=0; j<n; j++) {
							if((j==0 && i!=(n-1))  
									|| (i==(n-1) && j!=(n-1) && j!=0) 
									|| (j==(n-1) && i!=(n-1))) {
								System.out.print("*");
							}else {
								System.out.print(" ");
							}
						}//Pattern R
					
							for(int j=0; j<n; j++) {
								if((j==0 && i!=0) 
										|| (i==0 && j!=0 && j!=n-1) 
										|| (j==n-1 && i<(n-1)/2 && i!=0) 
										||(i==(n-1)/2 && j<(n-1)) 
										|| (j==i && i>(n-1)/2)) {
									System.out.print("*");
								}else {
									System.out.print(" ");
								}
							}//Pattern O
							
								for(int j=0; j<n; j++) {
									if((i==0 && j!=0 && j!=(n-1))
											|| (j==0 && i!=(n-1) && i!=0)  
											|| (i==(n-1) && j!=(n-1) && j!=0) 
											|| (j==(n-1) && i!=0 && i!=(n-1))) {
										System.out.print("*");
									}else {
										System.out.print(" ");
									}
								}	for(int j=0; j<n; j++) {
									if(j==0 || i==j || j==(n-1)) {
										System.out.print("*");
									}else {
										System.out.print(" ");
									}
								}
								System.out.println();
				}
	}
}
