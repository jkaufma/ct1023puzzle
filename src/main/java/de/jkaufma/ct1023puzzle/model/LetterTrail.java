package de.jkaufma.ct1023puzzle.model;

import java.util.LinkedList;


public class LetterTrail implements Comparable<LetterTrail>
{
	private LinkedList<Letter> lettersList = new LinkedList<>();


	public LetterTrail()
	{
	}



	public LetterTrail(Letter firstLetter)
	{
		append(firstLetter);
	}



	public LetterTrail(LetterTrail... otherTrails)
	{
		for (LetterTrail t : otherTrails)
			for (Letter l : t.lettersList)
				this.lettersList.add(new Letter(l));
	}



	public boolean contains(Letter l)
	{
		return lettersList.contains(l);
	}



	public boolean contains(LetterTrail otherTrail)
	{
		for (Letter l : otherTrail.lettersList)
			if (this.lettersList.contains(l))
				return true;

		return false;
	}



	public void append(Letter l)
	{
		lettersList.add(l);
	}



	public Letter getFirst()
	{
		return lettersList.getFirst(); 
	}



	public Letter getLast()
	{
		return lettersList.getLast(); 
	}



	public void removeLast()
	{
		lettersList.removeLast();
	}



	public int lenght()
	{
		return lettersList.size();
	}



	public String getWord()
	{
		StringBuilder sb = new StringBuilder(lenght());
		for (Letter l : lettersList)
			sb.append(l.getLetter());

		return sb.toString();
	}



	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder().append(getWord());
				sb.append(" (").append(lettersList.size()).append(")\t");

		for (Letter l : lettersList)
			sb.append(l.getIndex().toString()).append(' ');

		return sb.toString();
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
		LetterTrail other = (LetterTrail) obj;
		if (lettersList == null)
		{
			if (other.lettersList != null)
				return false;
		}
		else if (!lettersList.equals(other.lettersList))
			return false;
		return true;
	}



	@Override
	public int compareTo(LetterTrail o)
	{
		int lenDiff = this.lettersList.size() - o.lettersList.size();

		return lenDiff == 0 ? this.getWord().compareTo(o.getWord()) : lenDiff;
	}

}
