package com.redsky.project.pieces;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.redsky.project.chess.domains.board.Board;

public class BishopTests {

	private Board board = new Board();

	@Before
	public void init() {
		board = new Board();
		board.resetBoard();
		board.movePiece(2, 2, 2, 3);// move pawn
		board.movePiece(4, 2, 4, 3);// move pawn
	}

	@Test
	public void testMoveBishop_legalMove_upright() {
		board.movePiece(3, 1, 6, 4);// move bishop up left
		assertEquals(true, board.getPiece(6, 4).getName().equals("Bishop"));
	}

	@Test
	public void testMoveBishop_legalMove_downright() {
		board.movePiece(3, 1, 6, 4);// move bishop up left
		board.movePiece(6, 4, 7, 3);
		assertEquals(true, board.getPiece(7, 3).getName().equals("Bishop"));
	}

	@Test
	public void testMoveBishop_legalMove_downleft() {
		board.movePiece(3, 1, 6, 4);// move bishop up left
		board.movePiece(6, 4, 5, 3);// move bishop up left
		assertEquals(true, board.getPiece(5, 3).getName().equals("Bishop"));
	}

	@Test
	public void testMoveBishop_legalMove_upleft() {
		board.movePiece(3, 1, 6, 4);// move bishop up left
		board.movePiece(6, 4, 4, 6);// move bishop up left
		assertEquals(true, board.getPiece(4, 6).getName().equals("Bishop"));
	}

	@Test
	public void testMoveBishop_illegalMove_up() {
		board.movePiece(3, 1, 8, 6);// move bishop up left
		String status = board.movePiece(8, 6, 8, 7);
		assertEquals("Your Bishop cannot move to the locaion of 8, 7.", status);
	}

}
