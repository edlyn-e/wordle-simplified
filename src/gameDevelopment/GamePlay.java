package gameDevelopment;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class GamePlay {

	static Scanner guessInput = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException {
		//generating the secret word from the WordList
		WordList word = new WordList();
		String secretWord = word.generateSecretWord();
		
		// logging the secret word
		// TODO don't forget to delete this log! 
		 System.out.print("The secret word is: ");
		 System.out.print(secretWord);
		 System.out.println("\n");

		// opening line 
		System.out.println("Welcome to Wordle: Simplified");
		System.out.println("Can you guess the five letter word?");
		System.out.println("\n");
		
		int tries = 0; 
		char[] correctWord = new char[5];
		
		// saving the secret word into a character array to compare for later
		for(int i = 0; i < 5; i++) {
			correctWord[i] = secretWord.charAt(i); 
		}
		
		// printing the correct word
		// System.out.println(correctWord);
		
		char[] playerInput = new char[5]; 
		boolean gameOver = false; 
	
		
		while(!gameOver) {
			tries++; 
			String playerGuess = guessInput.nextLine().toLowerCase(); 
			
			if (playerGuess.length() < 5 ) {
				System.out.println("Oops! You haven't entered enough letters. Please enter a five letter word");
			}  
			
			if (playerGuess.length() >= 6) {
				System.out.println("Oops! You've entered too many letters. Please enter a five letter word");
			}
			
			while (playerGuess.length() < 5) {
				playerGuess = guessInput.nextLine().toLowerCase();
			}
			
			for (int i = 0; i < 5; i++) {
				correctWord[i] = secretWord.charAt(i);
				playerInput[i] = playerGuess.charAt(i); 
			}
	
			// printing each correctly positioned letter
			for (int i = 0; i < 5; i++) {
				
				if(playerInput[i] == correctWord[i]) {
					System.out.print('[');
					System.out.print(correctWord[i]);
					System.out.print(']');	
				}
					
				// printing a blank for each incorrect letter
				if(playerInput[i] != correctWord[i]) {
					System.out.print("[_]");
				}
			}
			 System.out.println("\n");
		
			 if(playerInput[0] == correctWord[0] &&
						playerInput[1] == correctWord[1] && 
						playerInput[2] == correctWord[2] && 
						playerInput[3] == correctWord[3] &&
						playerInput[4] == correctWord[4]) {
					System.out.println("\n");
				 	System.out.print("Yay! You guessed it! The secret word is indeed: ");
					System.out.print(secretWord);
					System.out.print("!");
					System.out.println("\n");
					System.out.print("You guessed it in ");
					System.out.print(tries);
					System.out.println(" attempts!");
					 gameOver = true; 
				 }
			  
			// Game over, too many guesses
			if (tries > 5) {
				gameOver = true; 
				System.out.println("Oops! Sorry, you did too many guesses. Game over");
				System.out.println("The secret word was: ");
				System.out.print(secretWord);
			}
			
		}
	}

}
