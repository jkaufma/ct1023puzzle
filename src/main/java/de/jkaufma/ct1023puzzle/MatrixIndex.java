package de.jkaufma.ct1023puzzle;

import de.jkaufma.ct1023puzzle.model.Direction;
import de.jkaufma.ct1023puzzle.model.Index2d;


public class MatrixIndex implements Index2d
{
	private int i, j;


	public MatrixIndex(int i, int j)
	{
		if (i < 0)	i = LetterMatrix.MATRIX_SIZE - 1;
		if (j < 0)	j = LetterMatrix.MATRIX_SIZE - 1;
		if (i >= LetterMatrix.MATRIX_SIZE)	i = 0;
		if (j >= LetterMatrix.MATRIX_SIZE)	j = 0;

		this.i = i;
		this.j = j;
	}



	public MatrixIndex(MatrixIndex p)
	{
		this(p.i, p.j);
	}



	@Override
	public int I()
	{
		return i;
	}



	@Override
	public int J()
	{
		return j;
	}


	@Override
	public Index2d getIndex(Direction direction)
	{
		switch (direction)
		{
		case RIGHT:
			return getIndexRight();
		case DOWN:
			return getIndexDown();
		case LEFT:
			return getIndexLeft();
		case UP:
			return getIndexUp();
		default:
			throw new IllegalArgumentException("" + direction);
		}
	}



	protected Index2d getIndexDown()
	{
		return new MatrixIndex(i + 1, j);
	}



	protected Index2d getIndexUp()
	{
		return new MatrixIndex(i - 1, j);
	}



	protected Index2d getIndexRight()
	{
		return new MatrixIndex(i, j + 1);
	}



	protected Index2d getIndexLeft()
	{
		return new MatrixIndex(i, j - 1);
	}



	/**
	 * Walk through matrix from left to right and from top to bottom.
	 * 
	 *  @return true if there is a next field and false at the end of the matrix.
	 */
	public boolean MoveNext()
	{
		++j;
		if (j == LetterMatrix.MATRIX_SIZE)
		{
			j = 0;
			++i;
			if (i == LetterMatrix.MATRIX_SIZE)
				return false;
		}
		return true;
	}



	@Override
	public String toString()
	{
		return "(" + (i + 1) + ";" + (j + 1) + ")";
	}



	/**
	 * generated hashCode() method
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + j;
		return result;
	}


	/**
	 * generated equals() method
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatrixIndex other = (MatrixIndex) obj;
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;
		return true;
	}
}

