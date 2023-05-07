package de.jkaufma.ct1023puzzle;

import org.junit.Assert;
import org.junit.Test;

import de.jkaufma.ct1023puzzle.model.Direction;
import de.jkaufma.ct1023puzzle.model.Index2d;


public class MatrixIndexTest
{

	@Test
	public void testConstructor()
	{
		MatrixIndex x00 = new MatrixIndex(0, 0);
		Assert.assertEquals(0, x00.I());
		Assert.assertEquals(0, x00.J());

		MatrixIndex x10 = new MatrixIndex(1, 0);
		Assert.assertEquals(1, x10.I());
		Assert.assertEquals(0, x10.J());

		MatrixIndex x01 = new MatrixIndex(0, 1);
		Assert.assertEquals(0, x01.I());
		Assert.assertEquals(1, x01.J());

		MatrixIndex xff = new MatrixIndex(15, 15);
		Assert.assertEquals(15, xff.I());
		Assert.assertEquals(15, xff.J());

		MatrixIndex m16 = new MatrixIndex(16, 25);
		Assert.assertEquals(0, m16.I());
		Assert.assertEquals(0, m16.J());

		MatrixIndex m_1 = new MatrixIndex(-1, -13);
		Assert.assertEquals(15, m_1.I());
		Assert.assertEquals(15, m_1.J());
	}


	@Test
	public void testGetIndexDown()
	{
		//	given
		MatrixIndex x11 = new MatrixIndex(1, 1);
		//	when
		Index2d x21 = x11.getIndex(Direction.DOWN);
		//	then
		Assert.assertEquals(2, x21.I());
		Assert.assertEquals(1, x21.J());
		Assert.assertEquals(1, x11.I());
		Assert.assertEquals(1, x11.J());
	}


	@Test
	public void testGetIndexUp()
	{
		//	given
		MatrixIndex x11 = new MatrixIndex(1, 1);
		//	when
		Index2d x01 = x11.getIndex(Direction.UP);
		//	then
		Assert.assertEquals(0, x01.I());
		Assert.assertEquals(1, x01.J());
		Assert.assertEquals(1, x11.I());
		Assert.assertEquals(1, x11.J());
	}


	@Test
	public void testGetIndexRight()
	{
		//	given
		MatrixIndex x11 = new MatrixIndex(1, 1);
		//	when
		Index2d x12 = x11.getIndex(Direction.RIGHT);
		//	then
		Assert.assertEquals(1, x12.I());
		Assert.assertEquals(2, x12.J());
		Assert.assertEquals(1, x11.I());
		Assert.assertEquals(1, x11.J());
	}


	@Test
	public void testGetIndexLeft()
	{
		//	given
		MatrixIndex x11 = new MatrixIndex(1, 1);
		//	when
		Index2d x10 = x11.getIndex(Direction.LEFT);
		//	then
		Assert.assertEquals(1, x10.I());
		Assert.assertEquals(0, x10.J());
		Assert.assertEquals(1, x11.I());
		Assert.assertEquals(1, x11.J());
	}


	@Test(expected = NullPointerException.class)
	public void getIndex_should_throw_NullpointerException_when_direction_is_null()
	{
		//	given
		MatrixIndex x11 = new MatrixIndex(1, 1);
		//	when
		x11.getIndex(null);
		//	then
		Assert.fail();
	}


	@Test
	public void moveNext_should_increment_j()
	{
		//	given
		MatrixIndex x = new MatrixIndex(0, 0);
		//	when
		boolean moveNext = x.MoveNext();
		//	then
		Assert.assertTrue(moveNext);
		Assert.assertEquals(0, x.I());
		Assert.assertEquals(1, x.J());
	}


	@Test
	public void moveNext_should_increment_i()
	{
		//	given
		MatrixIndex x = new MatrixIndex(0, LetterMatrix.MATRIX_SIZE - 1);
		//	when
		boolean moveNext = x.MoveNext();
		//	then
		Assert.assertTrue(moveNext);
		Assert.assertEquals(1, x.I());
		Assert.assertEquals(0, x.J());
	}


	@Test
	public void moveNext_should_return_false_for_last_index()
	{
		//	given
		MatrixIndex x = new MatrixIndex(LetterMatrix.MATRIX_SIZE - 1, LetterMatrix.MATRIX_SIZE - 1);
		//	when
		boolean moveNext = x.MoveNext();
		//	then
		Assert.assertFalse(moveNext);
		Assert.assertEquals(LetterMatrix.MATRIX_SIZE, x.I());
		Assert.assertEquals(0, x.J());
	}

}
