/*
 * Kurt Kangas
 * CIS 2212 Java Software Development I
 * Passphrase Generator - Generates a random passphrase with arguments specified by user using a .txt File I/O word bank.
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Exception;

public class PhraseGenerator{

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// Start of program
		Scanner input = new Scanner(System.in);
		ArrayList<String> theWords = new ArrayList<>();
		WordBank wbc = new WordBank(theWords);
		wbc.setWordsList(theWords);

		try {
			System.out.println("Random Passphrase Generator\n");
			System.out.println("I will generate random passphrases made up of random words of a specified size.\n");
			int NumberOfPassphrases = 0;
			int NumberOfWords = 0;
			int SizeOfWords = 0;
			System.out.print("How many random passphrases do you want to generate? ");
			NumberOfPassphrases = input.nextInt();
			System.out.print("How many words should be in each passphrase? ");
			NumberOfWords = input.nextInt();
			System.out.print("Enter the size of each of the words used to make the random passphrases. ");
			SizeOfWords = input.nextInt();

			if (NumberOfPassphrases > 0 && NumberOfWords > 0 && SizeOfWords > 0) {
				wbc.SizeOfWords(SizeOfWords, theWords);
				wbc.RandomWord(NumberOfPassphrases, NumberOfWords, theWords);
				System.out.println("\nHere are your random passphrases:");
				for (String items : theWords) {
					System.out.println(items);
				}
			}	
		}

		catch (Exception ex) {
			System.out.println("Invalid.");
		}


		// End of function
	}
	// End of program.
}
