package com.redsky.project.board;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.redsky.project.chess.constants.STATUS;
import com.redsky.project.chess.domains.board.Board;

public class BoardTests {

	private Board board = new Board();

	@Before
	public void init() {
		board = new Board();
		board.resetBoard();
	}

	@Test
	public void testBoardBoundriesX1High() {

		String expected = STATUS.STARTING_POSITION_NOT_ON_BOARD;
		String actual = board.movePiece(9, 1, 1, 1);
		assertEquals(expected, actual);
	}

	@Test
	public void testBoardBoundriesX1Low() {
		String expected = STATUS.STARTING_POSITION_NOT_ON_BOARD;
		String actual = board.movePiece(0, 1, 1, 1);
		assertEquals(expected, actual);
	}

	@Test
	public void testBoardBoundriesY1High() {
		String expected = STATUS.STARTING_POSITION_NOT_ON_BOARD;
		String actual = board.movePiece(1, 9, 1, 1);
		assertEquals(expected, actual);
	}

	@Test
	public void testBoardBoundriesY1Low() {
		String expected = STATUS.STARTING_POSITION_NOT_ON_BOARD;
		String actual = board.movePiece(1, 0, 1, 1);
		assertEquals(expected, actual);
	}

	@Test
	public void testBoardBoundriesX2High() {
		String expected = STATUS.DESTINATION_NOT_ON_BOARD;
		String actual = board.movePiece(1, 1, 9, 1);
		assertEquals(expected, actual);
	}

	@Test
	public void testBoardBoundriesX2Low() {
		String expected = STATUS.DESTINATION_NOT_ON_BOARD;
		String actual = board.movePiece(1, 1, 0, 1);
		assertEquals(expected, actual);
	}

	@Test
	public void testBoardBoundriesY2High() {
		String expected = STATUS.DESTINATION_NOT_ON_BOARD;
		String actual = board.movePiece(1, 1, 1, 0);
		assertEquals(expected, actual);
	}

	@Test
	public void testBoardBoundriesY2Low() {
		String expected = STATUS.DESTINATION_NOT_ON_BOARD;
		String actual = board.movePiece(1, 1, 1, 0);
		assertEquals(expected, actual);
	}

	@Test
	public void testSpaceIsOccupied_Occupied() {
		assertEquals(true, board.spaceIsOccupied(0, 0));
	}

	@Test
	public void testSpaceIsOccupied_NotOccupied() {
		String status = board.movePiece(4, 4, 5, 5);
		assertEquals("ERROR: There is no piece to move at 4, 4.", status);
	}

}
