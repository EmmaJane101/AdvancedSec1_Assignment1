package assignment1;
// Emma Jane Power
// c20305656
public class HillCipher {

	public static void main(String args[]) {
		
		// variables
		String plainText = "EMMA";
		int[][] plainText2D = new int [2][plainText.length()];
		int itr1 = 0;
		int itr2 = 0;
		
		System.out.println("Plain text: "+plainText);
		
		// putting the plain text into a matrix 
		for(int i = 0; i < plainText.length(); i++) {
			if(i%2 == 0) {
				plainText2D[0][itr1] = ((int)plainText.charAt(i)) - 65;
				itr1++;
			}else {
				plainText2D[1][itr2] = ((int)plainText.charAt(i)) - 65;
				itr2++;
			}// if-else
		}// else 
				
		// printing the plainText matrix 
		for(int i = 0; i < 2; i++) {
		
			for (int j = 0; j < plainText.length() / 2; j++) {
				
				System.out.print((char)(plainText2D[i][j]+ 65)+ " ");
				
			}// inner for loop end
		
			System.out.println();
		
		}// outer for loop end
			
		// variables 
		int itr3 = 0;
		String key = "MBLE";
		int[][] key2D = new int[2][2];
		
		System.out.println("Key word: "+key);
		
		// creating a matrix for they key
		for( int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				
				key2D[i][j] = (int)key.charAt(itr3) - 65;
				itr3++;
				System.out.print((char)(key2D[i][j]+ 65)+ " ");
				
			}// inner for loop end
			
			System.out.println();
			
		}// outer for loop end 
		
			
		// matrix variable 
		int[][] cipherText2D = new int[2][plainText.length()/2];
		
		// multiplying the matrices to get the cipher 
		for( int i = 0; i < 2; i++) {
			for (int j = 0; j < plainText.length()/2; j++) {
				for( int k = 0; k < 2; k++) {
					
					cipherText2D[i][j] += key2D[i][k] * plainText2D[k][j];
				
				}// end of k for loop
				
				cipherText2D[i][j] %= 26;
				
			}// end of j for loop
			
		}// end of i for loop 
		
		// putting the cipher matrix into a string 
		String cipherText = "";
		for (int i = 0; i < 2; i++) {
			
			for( int j = 0; j < plainText.length()/2; j++) {
				
				cipherText += (char)(cipherText2D[i][j] + 65);
				
			}// inner for loop end 
			
		}// outer for loop end 
		
		System.out.println("cipherText: "+cipherText);
		                                
	}// end of main 
	
}// end of class 
