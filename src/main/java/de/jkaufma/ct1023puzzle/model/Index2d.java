package de.jkaufma.ct1023puzzle.model;


public interface Index2d
{

	int I();

	int J();

	Index2d getIndex(Direction direction);

}
