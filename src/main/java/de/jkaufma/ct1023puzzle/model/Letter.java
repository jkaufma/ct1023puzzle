package de.jkaufma.ct1023puzzle.model;


public class Letter
{
	private final char		letterChar;
	private final Index2d	index;


	public Letter(char letterChar, Index2d index)
	{
		this.letterChar = letterChar;
		this.index = index;
	}



	public Letter(Letter o)
	{
		this(o.letterChar, o.index);
	}



	public char getLetter()
	{
		return letterChar;
	}



	public Index2d getIndex()
	{
		return index;
	}



	@Override
	public String toString()
	{
		return letterChar + " " + index.toString();
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
		Letter other = (Letter) obj;
		if (letterChar != other.letterChar)
			return false;
		if (index == null)
		{
			if (other.index != null)
				return false;
		}
		else if (!index.equals(other.index))
			return false;
		return true;
	}

}
