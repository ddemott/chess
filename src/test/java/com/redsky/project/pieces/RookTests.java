package com.redsky.project.pieces;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.redsky.project.chess.domains.board.Board;
import com.redsky.project.chess.domains.pieces.Empty;
import com.redsky.project.chess.domains.pieces.Piece;
import com.redsky.project.chess.domains.pieces.Rook;

public class RookTests {

	private Board board;

	@Before
	public void init() {
		board = new Board();
		board.movePiece(1, 2, 1, 4);// moving pawn
		board.movePiece(1, 4, 1, 5);// moving pawn
	}

	@Test
	public void testMoveRook_moveUp() {
		board.movePiece(1, 1, 1, 4);// moving rook
		Piece piece = board.getPiece(1, 4);
		assertEquals(true, piece instanceof Rook);
	}

	@Test
	public void testMoveRook_moveRight() {
		board.movePiece(1, 1, 1, 4);// moving rook
		board.movePiece(1, 4, 4, 4);// moving rook
		Piece piece = board.getPiece(1, 4);
		assertEquals(true, piece instanceof Empty);
		piece = board.getPiece(4, 4);
		assertEquals(true, piece instanceof Rook);
	}

	@Test
	public void testMoveRook_moveLeft() {
		board.movePiece(1, 1, 1, 4);// moving rook
		board.movePiece(1, 4, 4, 4);// moving rook
		board.movePiece(4, 4, 3, 4);// moving rook
		Piece piece = board.getPiece(1, 4);
		assertEquals(true, piece instanceof Empty);
		piece = board.getPiece(4, 4);
		assertEquals(true, piece instanceof Empty);
		piece = board.getPiece(3, 4);
		assertEquals(true, piece instanceof Rook);
	}

	@Test
	public void testMoveRook_moveDown() {
		board.movePiece(1, 1, 1, 4);
		board.movePiece(1, 4, 1, 3);
		Piece piece = board.getPiece(1, 4);
		assertEquals(true, piece instanceof Empty);
		piece = board.getPiece(1, 3);
		assertEquals(true, piece instanceof Rook);
	}

	@Test
	public void testMoveRook_illegalMove() {
		board.movePiece(1, 1, 1, 4);
		String status = board.movePiece(1, 4, 2, 5);
		assertEquals("Your Rook cannot move to the locaion of 2, 5.", status);
	}

}
