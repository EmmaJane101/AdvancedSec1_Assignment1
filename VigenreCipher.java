package assignment1;
// Emma Jane Power
// c20305656
import java.util.Scanner;

public class VigenreCipher {
			
	// method to encrypt
	public static void encrypt(String plainText, String key) {
		
		// variables 
		String encryptText = "";
	    char p, k, e;
	    int shift;
		
		for( int i = 0, j = 0; i < plainText.length(); i++) {
			
			p = plainText.charAt(i);
			k = key.charAt(j % key.length());
			
			if (Character.isLetter(p)) {
								
				shift = k - 'A';
				e = (char)((p + shift - 'A')% 26 + 'A');
				encryptText = encryptText + e;
				j++;
				
			} // end if 
			else {
				
				// if the character is not a letter add it to the encrypted text 
				encryptText = encryptText + p;
				
			}// end else
			
		}// end for
		
		System.out.println("The encrypted message :");
		System.out.println(encryptText);
		
	}// end encrypt method
	
	public static void decrypt(String encrypText, String key) {
		
		String plainText = "";
		char eChar, kChar, pChar;
		int shift;
		
		for (int i = 0, j = 0; i < encrypText.length(); i++) {
			
			eChar = encrypText.charAt(i);
			kChar = key.charAt(j % key.length());
			
			if (Character.isLetter(eChar)) {
				
				shift = kChar - 'A';
				pChar = (char)((eChar - shift - 'A' + 26) % 26 + 'A');
				plainText = plainText + pChar;
				j++;
				
			}// end if
			else {
				
				// if the character is not a letter add it to the plainText 
				plainText = plainText + eChar;
			}
			
		}// end for
		
		System.out.println("decrypted message: " + plainText);
		
	}// end of decrypt method

	public static void main(String[] args) {
		
		// variables
		String plainText;
		String encrypText;
		String key = "";
		int option;
		
		System.out.println("please choose an option , 1 or 2");
		System.out.println("option 1: Encryption");
		System.out.println("option 2: decryption");
		
		// creating a scanner object to read in input 
		Scanner readIn = new Scanner(System.in);
		
		option = readIn.nextInt();
		
		switch(option) {
			
			// encryption
			case 1:
				readIn.nextLine();
				System.out.println("Enter the text you would like to be encrypted:");
			
				plainText = readIn.nextLine();
			
				System.out.println("please enter the keyword:");
			
				key = readIn.nextLine();
			
				// converting the text and key to upper case 
				plainText = plainText.toUpperCase();
				key = key.toUpperCase();
						
				// calling the encrypt function and passing the plain text and key values entered by the user 
				encrypt(plainText, key);
			
				break;
			
			// decryption
			case 2:
				
				readIn.nextLine();
				System.out.println("Enter the text you would like to decrypt:");
			
				encrypText = readIn.nextLine();
			
				System.out.println("please enter the keyword:");
			
				key = readIn.nextLine();
			
				// converting the text and key to be upper case 
				encrypText = encrypText.toUpperCase();
				key = key.toUpperCase();
			
				
				decrypt(encrypText,key );
				
				break;
				
			// if the user does not enter a valid option 	
			default:
				System.out.println("You must enter 1 to encrypt or 2 to decrypt.");
				System.out.println("exiting system");
				System.exit(0);
			
		}// end of switch
			
				
		// closing the scanner 
		readIn.close();

	}// end of main
	
}// end of class
