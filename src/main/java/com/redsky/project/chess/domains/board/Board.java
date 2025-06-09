package com.redsky.project.chess.domains.board;

import org.springframework.stereotype.Component;

import com.redsky.project.chess.constants.COLOR;
import com.redsky.project.chess.constants.STATUS;
import com.redsky.project.chess.domains.pieces.Bishop;
import com.redsky.project.chess.domains.pieces.Empty;
import com.redsky.project.chess.domains.pieces.King;
import com.redsky.project.chess.domains.pieces.Knight;
import com.redsky.project.chess.domains.pieces.Pawn;
import com.redsky.project.chess.domains.pieces.Piece;
import com.redsky.project.chess.domains.pieces.Queen;
import com.redsky.project.chess.domains.pieces.Rook;

@Component
public class Board {

	public Board() {
		this.resetBoard();
	}

	public Piece boardPieces[][] = new Piece[8][8];

	public Piece[][] getBoardPieces() {
		return boardPieces;
	}

	public void placePiece(int x, int y, Piece piece) {
		piece.setX(x);
		piece.setY(y);
		this.boardPieces[x][y] = piece;
	}

	public void removePiece(int x, int y) {
		Empty piece = new Empty();
		placePiece(x, y, piece);
		piece.setX(x);
		piece.setY(y);
		this.boardPieces[x][y] = piece;
	}

	public void setBoardPieces(Piece[][] boardPieces) {
		this.boardPieces = boardPieces;
	}

	public String resetBoard() {
		this.placePiece(0, 0, new Rook(COLOR.WHITE));
		this.placePiece(1, 0, new Knight(COLOR.WHITE));
		this.placePiece(2, 0, new Bishop(COLOR.WHITE));
		this.placePiece(3, 0, new Queen(COLOR.WHITE));
		this.placePiece(4, 0, new King(COLOR.WHITE));
		this.placePiece(5, 0, new Bishop(COLOR.WHITE));
		this.placePiece(6, 0, new Knight(COLOR.WHITE));
		this.placePiece(7, 0, new Rook(COLOR.WHITE));

		this.placePiece(0, 1, new Pawn(COLOR.WHITE));
		this.placePiece(1, 1, new Pawn(COLOR.WHITE));
		this.placePiece(2, 1, new Pawn(COLOR.WHITE));
		this.placePiece(3, 1, new Pawn(COLOR.WHITE));
		this.placePiece(4, 1, new Pawn(COLOR.WHITE));
		this.placePiece(5, 1, new Pawn(COLOR.WHITE));
		this.placePiece(6, 1, new Pawn(COLOR.WHITE));
		this.placePiece(7, 1, new Pawn(COLOR.WHITE));

		this.placePiece(0, 2, new Empty());
		this.placePiece(1, 2, new Empty());
		this.placePiece(2, 2, new Empty());
		this.placePiece(3, 2, new Empty());
		this.placePiece(4, 2, new Empty());
		this.placePiece(5, 2, new Empty());
		this.placePiece(6, 2, new Empty());
		this.placePiece(7, 2, new Empty());

		this.placePiece(0, 3, new Empty());
		this.placePiece(1, 3, new Empty());
		this.placePiece(2, 3, new Empty());
		this.placePiece(3, 3, new Empty());
		this.placePiece(4, 3, new Empty());
		this.placePiece(5, 3, new Empty());
		this.placePiece(6, 3, new Empty());
		this.placePiece(7, 3, new Empty());

		this.placePiece(0, 4, new Empty());
		this.placePiece(1, 4, new Empty());
		this.placePiece(2, 4, new Empty());
		this.placePiece(3, 4, new Empty());
		this.placePiece(4, 4, new Empty());
		this.placePiece(5, 4, new Empty());
		this.placePiece(6, 4, new Empty());
		this.placePiece(7, 4, new Empty());

		this.placePiece(0, 5, new Empty());
		this.placePiece(1, 5, new Empty());
		this.placePiece(2, 5, new Empty());
		this.placePiece(3, 5, new Empty());
		this.placePiece(4, 5, new Empty());
		this.placePiece(5, 5, new Empty());
		this.placePiece(6, 5, new Empty());
		this.placePiece(7, 5, new Empty());

		this.placePiece(0, 6, new Pawn(COLOR.BLACK));
		this.placePiece(1, 6, new Pawn(COLOR.BLACK));
		this.placePiece(2, 6, new Pawn(COLOR.BLACK));
		this.placePiece(3, 6, new Pawn(COLOR.BLACK));
		this.placePiece(4, 6, new Pawn(COLOR.BLACK));
		this.placePiece(5, 6, new Pawn(COLOR.BLACK));
		this.placePiece(6, 6, new Pawn(COLOR.BLACK));
		this.placePiece(7, 6, new Pawn(COLOR.BLACK));

		this.placePiece(0, 7, new Rook(COLOR.BLACK));
		this.placePiece(1, 7, new Knight(COLOR.BLACK));
		this.placePiece(2, 7, new Bishop(COLOR.BLACK));
		this.placePiece(3, 7, new Queen(COLOR.BLACK));
		this.placePiece(4, 7, new King(COLOR.BLACK));
		this.placePiece(5, 7, new Bishop(COLOR.BLACK));
		this.placePiece(6, 7, new Knight(COLOR.BLACK));
		this.placePiece(7, 7, new Rook(COLOR.BLACK));

		return STATUS.OK;
	}

	public Piece getPiece(int x, int y) {
		x = x - 1;
		y = y - 1;
		Piece[][] pieces = getBoardPieces();
		return pieces[x][y];
	}

	/**
	 * Checks to see if a space on the board has a piece on it.
	 * 
	 * @param x
	 * @param y
	 * @return true if there is a piece on it else return false if empty.
	 */
	public boolean spaceIsOccupied(int x, int y) {
		// fail();
		// return false;

		Piece[][] pieces = getBoardPieces();
		Piece piece = pieces[x][y];

		if (piece instanceof Empty) {
			return false;
		} else {
			return true;
		}
	}

	public String checkBoardBoundries(int x1, int y1, int x2, int y2) {

		if (x1 < 0 || x1 > 7) {
			return STATUS.STARTING_POSITION_NOT_ON_BOARD;
		}

		if (x2 < 0 || x2 > 7) {
			return STATUS.DESTINATION_NOT_ON_BOARD;
		}

		if (y1 < 0 || y1 > 7) {
			return STATUS.STARTING_POSITION_NOT_ON_BOARD;
		}

		if (y2 < 0 || y2 > 7) {
			return STATUS.DESTINATION_NOT_ON_BOARD;
		}
		return STATUS.OK;

	}

	public void adjustCoordinates(Integer x1, Integer y1, Integer x2, Integer y2) {
		x1--;
		y1--;
		x2--;
		y2--;
	}

        /**
         * All places on the board are marked by x,y coordinates and start at 1 and end at 8.
	 * 
	 * @param x1
	 *            starting x position
	 * @param y1
	 *            starting y position
	 * @param x2
	 *            ending x position
	 * @param y2
	 *            ending y position
	 * @return status
	 * 
	 */

	public String movePiece(Integer x1, Integer y1, Integer x2, Integer y2) {
		// adjust values before move for zero based to be 1 based.
		x1 = x1 - 1;
		y1 = y1 - 1;
		x2 = x2 - 1;
		y2 = y2 - 1;

		// is the move within the boundaries
		String status = checkBoardBoundries(x1, y1, x2, y2);
		// if we found an error. E.g If status is NOT OK
		if (!status.equals(STATUS.OK)) {
			return status;
		}

		Piece piece = this.getBoardPieces()[x1][y1];
		if (spaceIsOccupied(x1, y1) == false) {
			return STATUS.NO_PIECE_AT + (x1 + 1) + ", " + (y1 + 1) + ".";
		}
		return piece.move(x2, y2, this);
	}
}
