package de.jkaufma.ct1023puzzle;

import org.junit.Assert;
import org.junit.Test;


public class NormalizeWordTest
{

	@Test
	public void getNormalizedWord_should_return_empty_string_if_word_is_empty()
	{
		//	given
		String word = "";
		//	when
		String normalizeWord = WordChecker.getNormalizedWord(word);
		//	then
		Assert.assertEquals("", normalizeWord);
	}

	@Test
	public void getNormalizedWord_should_trim_whitespaces()
	{
		//	given
		String word = "\t";
		//	when
		String normalizeWord = WordChecker.getNormalizedWord(word);
		//	then
		Assert.assertEquals("", normalizeWord);
	}


	@Test
	public void getNormalizedWord_should_always_return_uppercase_string()
	{
		//	given
		String word = "  Alarm  ";
		//	when
		String normalizeWord = WordChecker.getNormalizedWord(word);
		//	then
		Assert.assertEquals("ALARM", normalizeWord);
	}


	@Test
	public void getNormalizedWord_should_replace_sz_with_ss()
	{
		//	given
		String word = "daß";
		//	when
		String normalizeWord = WordChecker.getNormalizedWord(word);
		//	then
		Assert.assertEquals("DASS", normalizeWord);
	}


	@Test
	public void getNormalizedWord_should_replace_umlaut_a_with_ae()
	{
		//	given
		String word = "Gesäßfäule";
		//	when
		String normalizeWord = WordChecker.getNormalizedWord(word);
		//	then
		Assert.assertEquals("GESAESSFAEULE", normalizeWord);
	}


	@Test
	public void getNormalizedWord_should_replace_umlaut_o_with_oe()
	{
		//	given
		String word = "Ösenöl";
		//	when
		String normalizeWord = WordChecker.getNormalizedWord(word);
		//	then
		Assert.assertEquals("OESENOEL", normalizeWord);
	}


	@Test
	public void getNormalizedWord_should_replace_umlaut_u_with_ue()
	{
		//	given
		String word = "Hühnerfüße";
		//	when
		String normalizeWord = WordChecker.getNormalizedWord(word);
		//	then
		Assert.assertEquals("HUEHNERFUESSE", normalizeWord);
	}

}
