package de.jkaufma.ct1023puzzle;

import java.io.*;
import java.util.*;

import de.jkaufma.ct1023puzzle.model.LetterTrail;


public class WordChecker
{
	private static final int		WORD_LENGTH_LIMIT		= LetterMatrix.MATRIX_SIZE * LetterMatrix.MATRIX_SIZE;
	private final int				wordMinLength;

	private int						longestWordLength		= 0;
	private List<Character>			unavailableLetters		= new ArrayList<>();
	private Set<String>				testWords				= new HashSet<>();
	private SortedSet<LetterTrail>	foundWords				= new TreeSet<LetterTrail>();
	@SuppressWarnings ("unchecked")
	private Set<String>[]			wordBeginningsPerLenght	= new Set[WORD_LENGTH_LIMIT];


	public WordChecker(int wordMinLength)
	{
		this.wordMinLength = wordMinLength;

		for (char c = 'A'; c <= 'Z'; ++c)
		{
			if (!LetterMatrix.containsLetter(c))
				unavailableLetters.add(c);
		}
		System.out.println(unavailableLetters);
	}



	public void loadWords(String fileName) throws IOException
	{
		try (BufferedReader fr = new BufferedReader(new FileReader(fileName)))
		{
			String word;
			while ((word = fr.readLine()) != null)
			{
				String normalizedWord = getNormalizedWord(word);
				if (isValidWord(normalizedWord)  &&  !testWords.contains(normalizedWord))
				{
					testWords.add(normalizedWord);

					if (normalizedWord.length() > longestWordLength)
					{
						longestWordLength = normalizedWord.length();
						setupWordBeginningsPerLenghtSets(longestWordLength);
					}
				}
			}
		}
		
		for (String testWord : testWords)
			fillWordBeginningsPerLenghtSets(testWord);

		for (int l = 0 ; l < longestWordLength ; ++l)
			System.out.println((l + 1) + ": " + wordBeginningsPerLenght[l].size());
	}



	public int getWordlistSize()
	{
		return testWords.size();
	}



	public int getLongestWordLength()
	{
		return longestWordLength;
	}



	public SortedSet<LetterTrail> getFoundWords()
	{
		return foundWords;
	}



	public boolean checkForNextIteration(LetterTrail letterTrail)
	{
		int trailLenght = letterTrail.lenght();
		if (trailLenght > longestWordLength)
			return false;

		//	else...
		String word = letterTrail.getWord();

		if (trailLenght >= wordMinLength)
		{
			if (testWords.contains(word))
				foundWords.add(new LetterTrail(letterTrail));
		}
		return wordBeginningsPerLenght[trailLenght - 1].contains(word);
	}



	private void setupWordBeginningsPerLenghtSets(int len)
	{
		if (len > WORD_LENGTH_LIMIT)	len = WORD_LENGTH_LIMIT;

		for (int l = 0 ; l < len ; ++l)
			if (wordBeginningsPerLenght[l] == null)
				wordBeginningsPerLenght[l] = new HashSet<>();
	}



	private void fillWordBeginningsPerLenghtSets(String word)
	{
		int len = word.length() > WORD_LENGTH_LIMIT ? WORD_LENGTH_LIMIT : word.length(); 

		for (int l = 0 ; l < len ; ++l)
		{
			String wordBeginning = word.substring(0, l + 1);
			if (!wordBeginningsPerLenght[l].contains(wordBeginning))
				wordBeginningsPerLenght[l].add(wordBeginning);
		}
	}



	boolean isValidWord(String word)
	{
		return word.length() >= wordMinLength  &&  !wordContainsUnavailableChars(word);
	}



	boolean wordContainsUnavailableChars(String word)
	{
		for (char uc : unavailableLetters)
		{
			if (word.indexOf(uc) != -1)
				return true;
		}
		return false;
	}



	static String getNormalizedWord(String word)
	{
		return word.trim().toUpperCase().replace("Ä", "AE").replace("Ö", "OE").replace("Ü", "UE");
	}

}
