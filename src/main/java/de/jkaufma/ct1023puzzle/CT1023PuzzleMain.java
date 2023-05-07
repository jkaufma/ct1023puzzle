package de.jkaufma.ct1023puzzle;

import java.io.IOException;
import java.util.*;

import de.jkaufma.ct1023puzzle.model.*;


public class CT1023PuzzleMain
{
	private static boolean		allowLetterMultipleTimes	= false;
	private static int			wordMinLength				= 7;
	private static WordChecker	wordChecker					= new WordChecker(wordMinLength);


	public static void main(String[] args) throws IOException
	{
		System.out.println("Loading word list(s)...");
		wordChecker.loadWords("src/main/resources/wordlists/hippler-german-wordlist.txt");
		wordChecker.loadWords("src/main/resources/wordlists/de.txt");
		wordChecker.loadWords("src/main/resources/wordlists/words_alpha.txt");
		wordChecker.loadWords("src/main/resources/wordlists/additional_words.txt");
		System.out.println(wordChecker.getWordlistSize());
		System.out.println("Length of longest word: " + wordChecker.getLongestWordLength());

		MatrixIndex element = new MatrixIndex(0, 0);
		do
		{
			Letter letter = LetterMatrix.getLetter(element);
			LetterTrail letterTrail = new LetterTrail(letter);
			searchWords(letterTrail);
		} while (element.MoveNext());

		SortedSet<LetterTrail> foundWords = wordChecker.getFoundWords();
		System.out.println("\nFound " + foundWords.size() + " words.");
		for (LetterTrail foundWord : foundWords)
			System.out.println(foundWord.toString());

		System.out.println("\nBuilding Composita...");
		findComposita(foundWords);
	}



	public static void searchWords(LetterTrail letterTrail)
	{
		if (!wordChecker.checkForNextIteration(letterTrail))
			return;

		//	else... next iteration
		Index2d lastLetterIndex = letterTrail.getLast().getIndex();
		for (Direction direction : Direction.values())
		{
			Letter nextLetter = LetterMatrix.getLetter(lastLetterIndex.getIndex(direction));
			if (allowLetterMultipleTimes || !letterTrail.contains(nextLetter))
			{
				letterTrail.append(nextLetter);
				searchWords(letterTrail);
				letterTrail.removeLast();
			}
		}
	}



	public static void findComposita(SortedSet<LetterTrail> foundWords)
	{
		HashMap<Index2d, LetterTrail> wordsByStartPos = new HashMap<>();
		for (LetterTrail foundWord : foundWords)
			wordsByStartPos.put(foundWord.getFirst().getIndex(), foundWord);

		SortedSet<LetterTrail> foundComposita = new TreeSet<LetterTrail>();
		for (LetterTrail foundWord : foundWords)
		{
			Index2d lastLetterPos = foundWord.getLast().getIndex();
			for (Direction direction : Direction.values())
			{
				Index2d firstLetterPos2ndWord = lastLetterPos.getIndex(direction);
				LetterTrail letterTrail2ndWord = wordsByStartPos.get(firstLetterPos2ndWord);
				if (letterTrail2ndWord != null)
				{
					System.out.println(foundWord.getWord() + "-" + letterTrail2ndWord.getWord()
						+ " (" + (foundWord.lenght() + letterTrail2ndWord.lenght()) + ")");
					if (allowLetterMultipleTimes || !foundWord.contains(letterTrail2ndWord))
						foundComposita.add(new LetterTrail(foundWord, letterTrail2ndWord));
				}
			}
		}

		System.out.println("\nFound " + foundComposita.size() + " composita.");
		for (LetterTrail foundCompositum : foundComposita)
			System.out.println(foundCompositum.toString());
	}

}
