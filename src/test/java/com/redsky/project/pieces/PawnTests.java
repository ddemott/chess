package com.redsky.project.pieces;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.redsky.project.chess.domains.board.Board;
import com.redsky.project.chess.domains.pieces.Empty;
import com.redsky.project.chess.domains.pieces.Pawn;
import com.redsky.project.chess.constants.COLOR;

public class PawnTests {

	Board board;

	@Before
	public void init() {
		board = new Board();
		board.resetBoard();
	}

	@Test
	public void testMovePawn_twoForwardFirstMove() {
		board.movePiece(1, 2, 1, 4);
		assertEquals(true, board.getPiece(1, 2) instanceof Empty);
		assertEquals(true, board.getPiece(1, 4) instanceof Pawn);
	}

	@Test
	public void testMovePawn_oneForward() {
		board.movePiece(1, 2, 1, 3);
		assertEquals(true, board.getPiece(1, 2) instanceof Empty);
		assertEquals(true, board.getPiece(1, 3) instanceof Pawn);
	}

	@Test
	public void testMovePawn_multipleMoves() {
		board.movePiece(1, 2, 1, 4);
		board.movePiece(1, 4, 1, 5);
		board.movePiece(1, 5, 1, 6);

		assertEquals(true, board.getPiece(1, 5) instanceof Empty);
		assertEquals(true, board.getPiece(1, 6) instanceof Pawn);
	}

	@Test
	public void testMovePawn_IllegalMove() {
		String status = board.movePiece(1, 2, 1, 5);
		assertEquals("Your Pawn cannot move to the locaion of 1, 5.", status);
	}

        @Test
        public void testMovePawn_twoForwardSecondMove() {
                board.movePiece(1, 2, 1, 4);
                String status = board.movePiece(1, 4, 1, 6);
                assertEquals("Your Pawn cannot move to the locaion of 1, 6.", status);
        }

        @Test
        public void testMovePawn_twoForwardBlockedByPiece() {
                // place a blocking piece two squares ahead of the pawn
                board.placePiece(0, 3, new Pawn(COLOR.WHITE));

                String status = board.movePiece(1, 2, 1, 4);

                // move should be illegal because destination is occupied
                assertEquals("Your Pawn cannot move to the locaion of 1, 4.", status);
                // ensure the pawn did not move
                assertEquals(true, board.getPiece(1, 2) instanceof Pawn);
        }

}
