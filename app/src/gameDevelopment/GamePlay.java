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
		// TODO don't forget to comment out this log! 
		// System.out.println("The secret word is: " + secretWord + "\n");

		// opening line 
		System.out.println("Welcome to Wordle: Simplified");
		System.out.println("Can you guess the five letter word?");
		
		int tries = 0; 
		char[] correctWord = new char[5];
		
		// saving the secret word into a character array to compare for later
		for(int i = 0; i < 5; i++) {
			correctWord[i] = secretWord.charAt(i); 
		}
		
		char[] playerInput = new char[5]; 
		boolean gameOver = false; 
	
		
		// the game play itself
		while(!gameOver) {
			tries++; 
		
			System.out.println("\n" + "\n" +  "Attempt no: " + tries + "/6");
			String playerGuess = guessInput.nextLine().toLowerCase(); 
			
			if (playerGuess.length() < 5 ) {
				System.out.println( "\n" + "Oops! You haven't entered enough letters. Please enter a five letter word");
			}  
			
			if (playerGuess.length() >= 6) {
				System.out.println("\n" +  "Oops! You've entered too many letters. Please enter a five letter word");
			}
			
			while (playerGuess.length() < 5) {
				playerGuess = guessInput.nextLine().toLowerCase();
			}
			
			// saving the secretWord and playerGuess into arrays to compare to each other at exact positions 
			for (int i = 0; i < 5; i++) {
				correctWord[i] = secretWord.charAt(i);
				playerInput[i] = playerGuess.charAt(i); 
			}
	
			// comparing each letter of the playerInput to correctWord's letters
			for (int i = 0; i < 5; i++) {
				
				// printing each correctly positioned letter	
				if(playerInput[i] == correctWord[i]) {
					System.out.print("[" + correctWord[i] + "]");
				}
					
				// printing a blank for each incorrect letter
				if(playerInput[i] != correctWord[i]) {
					System.out.print("[_]");
				}
				
				// game over: too many guesses
				// placed inside the for loop so that the message doesn't display if the player correctly guesses the word on the last attempt
				if (tries > 5 && playerInput[i] != correctWord[i]) {
					gameOver = true; 
					System.out.println("\n" + "\n" + "Oops! Sorry, you did too many guesses. Game over");
					System.out.println("The secret word was: " + secretWord);
				}
			}
			 
			 // printing out win message if the player has correctly guessed all letters correctly 
			 if(playerInput[0] == correctWord[0] &&
						playerInput[1] == correctWord[1] && 
						playerInput[2] == correctWord[2] && 
						playerInput[3] == correctWord[3] &&
						playerInput[4] == correctWord[4]) {
				 	System.out.println("\n" + "\n" + "Yay! You guessed it! The secret word is indeed: " + secretWord + "!");
					System.out.println("It took you this many guesses: " + tries);
					 gameOver = true; 
				 }
			  
			
		}
	}

}
