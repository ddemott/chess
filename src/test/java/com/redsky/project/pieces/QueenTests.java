package com.redsky.project.pieces;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.redsky.project.chess.domains.board.Board;
import com.redsky.project.chess.domains.pieces.Piece;
import com.redsky.project.chess.domains.pieces.Queen;

public class QueenTests {
	private Board board = new Board();

	@Before
	public void init() {
		board = new Board();
		board.resetBoard();

		board.movePiece(3, 2, 3, 4);
		board.movePiece(3, 4, 3, 5);

		board.movePiece(4, 2, 4, 4);
		board.movePiece(4, 4, 4, 5);

		board.movePiece(5, 2, 5, 4);
		board.movePiece(5, 4, 5, 5);

		board.movePiece(2, 2, 2, 3);
		board.movePiece(7, 2, 7, 2);
	}

	@Test
	public void findKingQueenTest() {
		Piece piece = board.getPiece(4, 1);
		assertEquals(true, piece instanceof Queen);
	}

	@Test
	public void findKingBlackTest() {
		Piece piece = board.getPiece(4, 8);
		assertEquals(true, piece instanceof Queen);
	}

	@Test
	public void moveQueenUp() {
		board.movePiece(4, 1, 4, 4);
		Piece piece = board.getPiece(4, 4);
		assertEquals(true, piece instanceof Queen);
	}

	@Test
	public void moveQueenLeft() {
		board.movePiece(4, 1, 4, 4);
		board.movePiece(4, 4, 1, 4);
		Piece piece = board.getPiece(1, 4);
		assertEquals(true, piece instanceof Queen);
	}

	public void moveQueenRight() {
		board.movePiece(4, 1, 4, 4);
		board.movePiece(4, 4, 8, 4);
		Piece piece = board.getPiece(8, 4);
		assertEquals(true, piece instanceof Queen);
	}

	public void moveQueenDown() {
		board.movePiece(4, 1, 4, 4);
		board.movePiece(4, 4, 4, 2);
		Piece piece = board.getPiece(4, 2);
		assertEquals(true, piece instanceof Queen);
	}

	public void moveQueenUpRight() {
		board.movePiece(4, 1, 4, 4);
		board.movePiece(4, 4, 6, 6);
		Piece piece = board.getPiece(6, 6);
		assertEquals(true, piece instanceof Queen);
	}

	public void moveQueenDownLeft() {
		board.movePiece(4, 1, 4, 4);
		board.movePiece(4, 4, 2, 2);
		Piece piece = board.getPiece(2, 2);
		assertEquals(true, piece instanceof Queen);
	}

	public void moveQueenUpLeft() {
		board.movePiece(4, 1, 4, 4);
		board.movePiece(4, 4, 2, 6);
		Piece piece = board.getPiece(2, 6);
		assertEquals(true, piece instanceof Queen);
	}

	public void moveQueenDownRight() {
		board.movePiece(4, 1, 4, 4);
		board.movePiece(4, 4, 6, 2);
		Piece piece = board.getPiece(6, 2);
		assertEquals(true, piece instanceof Queen);
	}

}
