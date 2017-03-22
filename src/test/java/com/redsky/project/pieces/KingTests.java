package com.redsky.project.pieces;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.redsky.project.chess.domains.board.Board;
import com.redsky.project.chess.domains.pieces.King;
import com.redsky.project.chess.domains.pieces.Piece;

public class KingTests {

	private Board board = new Board();

	@Before
	public void init() {
		board = new Board();
		board.resetBoard();

		board.movePiece(4, 2, 4, 4);// move pawn
		board.movePiece(4, 4, 4, 5);// move pawn
		board.movePiece(4, 5, 4, 6);// move pawn

		board.movePiece(5, 2, 5, 4);// move pawn
		board.movePiece(5, 4, 5, 5);// move pawn
		board.movePiece(5, 5, 5, 6);// move pawn

		board.movePiece(6, 2, 6, 4);// move pawn
		board.movePiece(6, 4, 6, 5);// move pawn
		board.movePiece(6, 5, 6, 6);// move pawn

	}

	private String moveKingToCenterBoard() {
		String status = board.movePiece(5, 1, 5, 2);
		status = board.movePiece(5, 2, 5, 3);
		status = board.movePiece(5, 3, 5, 4);
		return status;
	}

	@Test
	public void findKingWhiteTest() {
		Piece piece = board.getPiece(5, 1);
		assertEquals(true, piece instanceof King);
	}

	@Test
	public void findKingBlackTest() {
		Piece piece = board.getPiece(5, 8);
		assertEquals(true, piece instanceof King);
	}

	@Test
	public void moveWhiteKingUp() {
		String status = board.movePiece(5, 1, 5, 2);
		assertEquals("SUCCESS", status);
		Piece piece = board.getPiece(5, 2);
		assertEquals(true, piece instanceof King);
	}

	@Test
	public void moveWhiteKingLeft() {
		moveKingToCenterBoard();// 5,4
		board.movePiece(5, 4, 4, 4);
		Piece piece = board.getPiece(4, 4);
		assertEquals(true, piece instanceof King);
	}

	@Test
	public void moveWhiteKingTwoSpaceLeft_Fail() {
		moveKingToCenterBoard();// 5,4
		String status = board.movePiece(5, 4, 3, 4);
		assertEquals("Your King cannot move to the locaion of 3, 4.", status);
	}

	@Test
	public void moveWhiteKingRight() {
		moveKingToCenterBoard();// 5,4
		board.movePiece(5, 4, 6, 4);
		Piece piece = board.getPiece(6, 4);
		assertEquals(true, piece instanceof King);
	}

	@Test
	public void moveWhiteKingTwoSpaceRight_Fail() {
		moveKingToCenterBoard();// 5,4
		String status = board.movePiece(5, 4, 7, 4);
		assertEquals("Your King cannot move to the locaion of 7, 4.", status);
	}

	@Test
	public void moveWhiteKingDown() {
		moveKingToCenterBoard();// 5,4
		board.movePiece(5, 4, 5, 3);
		Piece piece = board.getPiece(5, 3);
		assertEquals(true, piece instanceof King);
	}

	@Test
	public void moveWhiteKingTwoSpaceDown_Fail() {
		moveKingToCenterBoard();// 5,4
		String status = board.movePiece(5, 4, 5, 2);
		assertEquals("Your King cannot move to the locaion of 5, 2.", status);
	}

}
