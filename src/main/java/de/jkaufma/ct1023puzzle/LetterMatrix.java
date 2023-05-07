package de.jkaufma.ct1023puzzle;

import java.util.HashSet;
import java.util.Set;

import de.jkaufma.ct1023puzzle.model.*;


public final class LetterMatrix
{
	public	static final int	MATRIX_SIZE = 16;
	
	private static final String MATRIX_SOURCE[] = {
			"QYURPAVEETUPMPRA",
			"RETEUMIRREHCIETW",
			"PKCUTRNOHDTNSSZD",
			"SRURNOFIEATENCHO",
			"BDIEENETBSLIEALI",
			"ERKHTOHPTUCDGNLN",
			"AKKRDASFRNASOMSN",
			"BZWETPNDAWLSDECA",
			"ETKRORLNMEDUOMRL",
			"NEMITPLUSLOCLEER",
			"DNONAPERAWDAMTIB",
			"MAATSVACLGORINAL",
			"TBTSRIAYCDPSRKRI",
			"ARUUPTLPCCABEDEE",
			"TINAIIKSIEDYCHBT",
			"UBRMNTREDLSCOCYD"
	};

	private static final Set<Character>	containedLetters	= new HashSet<>();

	private static final Letter[][]		letterMatrix		= createLetterMatrix();


	private static Letter[][] createLetterMatrix()
	{
		Letter[][] mat = new Letter[MATRIX_SIZE][MATRIX_SIZE];
		for (int i = 0 ; i < MATRIX_SIZE ; ++i)
		{
			for (int j = 0 ; j < MATRIX_SIZE ; ++j)
			{
				char c = MATRIX_SOURCE[i].charAt(j);
				mat[i][j] = new Letter(c, new MatrixIndex(i, j));
				if (!containedLetters.contains(c))
					containedLetters.add(c);
			}
		}
		return mat;
	}



	public static boolean containsLetter(char c)
	{
		return containedLetters.contains(c);
	}



	public static Letter getLetter(Index2d pos)
	{
		return letterMatrix[pos.I()][pos.J()];
	}



	//	for unit tests only
	static Letter[][] getLetterMatrix()
	{
		return letterMatrix;
	}

}
