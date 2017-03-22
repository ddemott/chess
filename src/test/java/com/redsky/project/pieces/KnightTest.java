package com.redsky.project.pieces;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.redsky.project.chess.constants.PIECES;
import com.redsky.project.chess.constants.STATUS;
import com.redsky.project.chess.domains.board.Board;
import com.redsky.project.chess.domains.pieces.Piece;

public class KnightTest {

	private Board board = new Board();

	@Before
	public void init() {
		board = new Board();
		board.resetBoard();
	}

	// up
	@Test
	public void moveUpRight() {
		String status = board.movePiece(2, 1, 3, 3);
		Piece piece = board.getPiece(3, 3);
		assertEquals(STATUS.OK, status);
		assertEquals(PIECES.KNIGHT, piece.getName());
	}

	@Test
	public void moveUpLeft() {
		String status = board.movePiece(2, 1, 3, 3);
		status = board.movePiece(3, 3, 2, 5);
		Piece piece = board.getPiece(2, 5);
		assertEquals(STATUS.OK, status);
		assertEquals(PIECES.KNIGHT, piece.getName());
	}

	// down
	@Test
	public void moveDownLeft() {
		board.movePiece(2, 1, 3, 3);
		board.movePiece(3, 3, 2, 5);
		String status = board.movePiece(2, 5, 1, 3);
		Piece piece = board.getPiece(1, 3);
		assertEquals(STATUS.OK, status);
		assertEquals(PIECES.KNIGHT, piece.getName());
	}

	@Test
	public void moveDownRight() {
		String status = board.movePiece(2, 1, 3, 3);
		status = board.movePiece(3, 3, 2, 5);
		Piece piece = board.getPiece(2, 5);
		assertEquals(STATUS.OK, status);
		assertEquals(PIECES.KNIGHT, piece.getName());
	}

	// right
	@Test
	public void moveRightUp() {
		String status = board.movePiece(2, 1, 3, 3);
		status = board.movePiece(3, 3, 4, 5);
		Piece piece = board.getPiece(4, 5);
		assertEquals(STATUS.OK, status);
		assertEquals(PIECES.KNIGHT, piece.getName());
	}

	@Test
	public void moveRightDown() {
		board.movePiece(2, 1, 3, 3);
		board.movePiece(3, 3, 4, 5);
		String status = board.movePiece(4, 5, 6, 4);

		Piece piece = board.getPiece(6, 4);
		assertEquals(STATUS.OK, status);
		assertEquals(PIECES.KNIGHT, piece.getName());
	}

	// left
	@Test
	public void moveLeftUp() {
		String status = board.movePiece(2, 1, 3, 3);
		status = board.movePiece(3, 3, 4, 5);
		status = board.movePiece(4, 5, 2, 6);
		Piece piece = board.getPiece(2, 6);
		assertEquals(STATUS.OK, status);
		assertEquals(PIECES.KNIGHT, piece.getName());
	}

	@Test
	public void moveLeftDown() {
		String status = board.movePiece(2, 1, 3, 3);
		status = board.movePiece(3, 3, 4, 5);
		status = board.movePiece(4, 5, 2, 4);
		Piece piece = board.getPiece(2, 4);
		assertEquals(STATUS.OK, status);
		assertEquals(PIECES.KNIGHT, piece.getName());
	}

}
