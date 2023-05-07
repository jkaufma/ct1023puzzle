package de.jkaufma.ct1023puzzle;

import org.junit.Assert;
import org.junit.Test;


public class WordCheckerTest
{

	@Test
	public void isValidWord_should_return_false_if_word_length_less_than_wordMinLength()
	{
		//	given
		int wordMinLength = 5;
		WordChecker wordChecker = new WordChecker(wordMinLength);
		//	when
		boolean validWord = wordChecker.isValidWord("valid");
		//	then
		Assert.assertTrue(validWord);

		//	when
		validWord = wordChecker.isValidWord("nope");
		//	then
		Assert.assertFalse(validWord);
	}


	@Test
	public void wordContainsUnavailableCharsTest()
	{
		WordChecker wordChecker = new WordChecker(2);
		Assert.assertFalse(wordChecker.wordContainsUnavailableChars("ABCDEFGHIKLMNOPQRSTUVWYZ"));
		Assert.assertTrue(wordChecker.wordContainsUnavailableChars("JAJA"));
		Assert.assertTrue(wordChecker.wordContainsUnavailableChars("LUX"));
	}

}
