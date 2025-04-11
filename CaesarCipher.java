package assignment1;
// Emma Jane Power
// c20305656
import java.util.Scanner;

public class CaesarCipher {
	
	// function to encrypt plain text entered in by user 
	public static void encrypt(String plainText, int key) {
		
		// variables 
		String encryptMessage = "";
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int position;
		int cipherPosition;
		char encryptChar;
		
		// changing all the characters in the plain text to all be upper case 
		plainText = plainText.toUpperCase();
		
		// for loop is used to iterate through each character of the plain text and encrypt it 
		for (int i = 0; i < plainText.length(); i++) {
			
			/* plainText.charAt(i) is getting the character from the plain text 
			 * alphabet.indexOf() is getting the position number that the letter appears in the alphabet
			 * .indexOff() will return -1 if the character is not in the alphabet 
			 */
			position = alphabet.indexOf(plainText.charAt(i));
			 
			 // if the position doesn't equal -1 then that means the character is in the alphabet and needs to be encrypted 
			 if (position != -1) {
				 
				 /* getting the position at which the encrypted letter will be in the alphabet, 
				  * based of the key given by the user and mod 26 to ensure it loops back around the alphabet
				  */
			     cipherPosition = (key + position) % (alphabet.length());
				 
			     //getting the encryption letter at that position in the alphabet
				 encryptChar = alphabet.charAt(cipherPosition);
				 
				 //adding the encrypted letter onto the end of the encrypted text
				 encryptMessage = encryptMessage + encryptChar;
			 }// end of if statement 
			 
			 //if the position does equal -1 this may mean there is a space or special character and this does not need to be encrypted 
			 else {
				 				 
				 //add the character onto the encrypted message 
				 encryptMessage = encryptMessage + plainText.charAt(i);
				 
			 }// end of else statement 
			
		}// end of for loop
		
		//printing the encrypted text 
		System.out.println("The encrypted message:");
		System.out.println(encryptMessage);
		
	}// end of encrypt function 
	
	public static void decrypt(String cipherText, int key) {
		
		// variables
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String plainText = "";
		int position;
		int plainPosition;
		char plainChar;
		
		
		cipherText = cipherText.toUpperCase();
		
		for( int i = 0; i < cipherText.length(); i++) {
			
			position = alphabet.indexOf(cipherText.charAt(i));
			
			// if the character is in the alphabet 
			if (position != -1) {
				
				// getting the position of the decrypted letter is in the alphabet 
				plainPosition = (position - key) % (alphabet.length());
				
				if (plainPosition < 0) {
					plainPosition = alphabet.length()+ plainPosition;
				}// end inner if
				
				// getting the decrypted character 
				plainChar = alphabet.charAt(plainPosition);
				
				// adding the decrypted character onto the plainText 
				plainText = plainText + plainChar;
			}// end if
			
			else {
				 
				// if the character isn't a letter
				plainText = plainText + cipherText.charAt(i);
				 
			 }// end of else statement 
			
		}// end for 
		
		System.out.println("The decrypted message:");
		System.out.println(plainText);
		
	}// end of decrypt function 

	public static void main(String[] args) {
		
		int option;
		int key = 0;
		int correctInput = 0;
		
		// creating a scanner object to read in input 
		Scanner readIn = new Scanner(System.in);
		
		System.out.println("option 1: Encryption");
		System.out.println("option 2: decryption");
		System.out.println("please choose an option , 1 or 2");
		
		option = readIn.nextInt();
		
		switch(option){
			case 1:
				String plainText;
				System.out.println("Enter the text you would like to be encrypted:");
				
				// checking if user has entered text 
				readIn.nextLine();
				plainText = readIn.nextLine();
				if (plainText.isEmpty() == true) {
					System.out.println("no text has been entered");
					System.out.println("exiting program");
					
					System.exit(0);
				}
				
				// this while loop ensures the user enters a key between 1 - 25 inclusive before continuing 
				while (correctInput == 0) {
					
					System.out.println("please enter the key( should be between 1-25 ):");
					
					key = readIn.nextInt();
					
					
					/* this if statement checks if the number entered in by the user is between 1-25 inclusive 
					 * because if the user was to enter 0 or 26 the message would not get encrypted
					 * and if it is it increases the value of the correctInput variable to exit the while loop
					 */
					if (key >= 1 && key <=25 ) {
						correctInput++;
					}// end of if 
					else {
						System.out.println("The key you have entered is not between 1-25, please try again");
					}// end of else
				}// end of while loop
				
				// calling the encrypt function and passing the plain text and key values entered by the user 
				encrypt(plainText, key);
				
				break;
				
			case 2:
				
				String cipherText;
				
				System.out.println("Enter the text you would like to be decrypt:");
				
				
				readIn.nextLine();
				cipherText = readIn.nextLine();
				
				// checking that user has entered some text 
				if (cipherText.isEmpty() == true) {
					System.out.println("no text has been entered");
					System.out.println("exiting program");
					
					System.exit(0);
				}
				
				
				// this while loop ensures the user enters a key between 1 - 25 inclusive before continuing 
				while (correctInput == 0) {
					
					System.out.println("please enter the key( should be between 1-25 ):");
					
					key = readIn.nextInt();
					
					/* this if statement checks if the number entered in by the user is between 1-25 inclusive 
					 * and if it is it increases the value of the correctInput variable to exit the while loop
					 */
					if (key >= 1 && key <=25 ) {
						correctInput++;
					}// end of if 
					else {
						System.out.println("The key you have entered is not between 1-25, please try again");
					}// end of else
				}// end of while loop
				
				// calling the encrypt function and passing the plain text and key values entered by the user 
				decrypt(cipherText, key);
				
				break;
			
			// if user does not select a valid option 
			default:
				System.out.println("You must enter 1 to encrypt or 2 to decrypt.");
				System.out.println("exiting system");
				System.exit(0);
		}
				
		
		
		// closing the scanner 
		readIn.close();
		
		
	}// end of main 

}// end of class 
