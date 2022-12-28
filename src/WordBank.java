/*
 * Kurt Kangas
 * CIS 2212 Java Software Development I
 * Passphrase Generator - Generates a random passphrase with arguments specified by user using a .txt File I/O word bank.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordBank{

	// Attributes (instance variables)
	private int Number;
	private ArrayList<String> wordsList = new ArrayList<String>();

	// Constructors
	public WordBank(ArrayList<String> wordsList) {
		this.wordsList = wordsList;
	}

	public WordBank(int number, ArrayList<String> wordsList) {
		Number = number;
		this.wordsList = wordsList;
	}

	// Behavior (Methods)
	private ArrayList <String> SetList(ArrayList<String> aList) {
		File file = new File("WordList.txt");
		Scanner input;
		try {
			input = new Scanner(file);
			while(input.hasNext()) {
				String Word = input.next();
				aList.add(Word);
			}

			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return aList;
	}

	public ArrayList<String> SizeOfWords(int number, ArrayList<String> aList) {
		ArrayList <String> tempList = new ArrayList<>();
		for (int i = 0; i < aList.size(); i++) {
			String Word = aList.get(i);
			if (Word.length() == number) {
				tempList.add(Word);
			}
		}
		aList.clear();
		for (int i = 0; i < tempList.size(); i++)
		{
			String Word = tempList.get(i);
			aList.add(Word);
		}
		return aList;
	}

	public ArrayList<String> RandomWord(int number, int wordsperline, ArrayList<String> aList) {
		ArrayList <String> tempList = new ArrayList<>();

		for (int i = 0; i < number; i++) {
			String Line = "";
			String OldElement = "";
			for (int j = 0; j < wordsperline; j++) {
				Random r = new Random();
				int randomitem = r.nextInt(aList.size());
				String randomElement = aList.get(randomitem);
				if (randomElement.equals(OldElement))
				{
					r = new Random();
					randomitem = r.nextInt(aList.size());
					randomElement = aList.get(randomitem);
				}
				OldElement = randomElement;
				Line += randomElement;
			}
			tempList.add(Line);
		}
		aList.clear();
		for (int i = 0; i < tempList.size(); i++)
		{
			String Word = tempList.get(i);
			aList.add(Word);
		}
		return aList;
	}

	public int getNumber() {
		return Number;
	}

	public void setNumber(int number) {
		Number = number;
	}

	public ArrayList<String> getWordsList() {
		return wordsList;
	}

	public void setWordsList(ArrayList<String> wordsList) {

		this.wordsList = SetList(wordsList);
	}

}

