package gameDevelopment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordList {
	
	public String generateSecretWord() throws FileNotFoundException {
		Scanner database = new Scanner(new File("C:/Users/edlyn/OneDrive/Desktop/web-fundamentals/java/wordle-simplified/src/wordlist"));
		
		// saving data to new ArrayList
		List<String> data = new ArrayList<>(); 
			
		// making sure we can read through the word list data
		while (database.hasNext()) {
			// replacing all excess characters with an empty string
			data.add(database.nextLine().replaceAll("[^\\w]", "")); 
			}
		
		// removing all empty strings to tidy array
		data.removeAll(Arrays.asList("", null)); 
		
		// creating a random word generator 
		Random random = new Random();		
		// setting upper limit to data.size()
		String secretWord = data.get(random.nextInt(data.size()));
		
		return secretWord;
	}	
}
