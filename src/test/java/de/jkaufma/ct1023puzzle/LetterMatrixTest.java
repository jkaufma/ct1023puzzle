package de.jkaufma.ct1023puzzle;

import org.junit.Assert;
import org.junit.Test;

import de.jkaufma.ct1023puzzle.model.Letter;

public class LetterMatrixTest
{

	@Test
	public void letterMatrixTest()
	{
		Letter[][] wordMatrix = LetterMatrix.getLetterMatrix();
		Assert.assertTrue(wordMatrix[0][0].getLetter() == 'Q');
		Assert.assertTrue(wordMatrix[2][14].getLetter() == 'Z');
		Assert.assertTrue(wordMatrix[15][15].getLetter() == 'D');
	}

}
