package com.redsky.project.chess.domains.pieces;

import java.util.ArrayList;
import java.util.List;

import com.redsky.project.chess.constants.COLOR;
import com.redsky.project.chess.constants.PIECES;
import com.redsky.project.chess.constants.STATUS;
import com.redsky.project.chess.domains.board.Board;
import com.redsky.project.chess.domains.board.Coordinates;

public class Pawn extends Piece {
	private boolean firstMoveAvailable = true;

	public Pawn(String color) {
		this.setColor(color);
		this.setName(PIECES.PAWN);
	}

	@Override
	public List<Coordinates> getAllPossibleMoves(Board board) {
		List<Coordinates> possibleMoves = new ArrayList<>();

		// up the board. Used as a multiplier to reverse the direction.
		int direction = this.getColor().equals(COLOR.WHITE) ? 1 : -1;

		if (board.spaceIsOccupied(this.getX(), this.getY() + (1 * direction)) == false) {
			possibleMoves.add(new Coordinates(this.getX(), this.getY() + (1 * direction)));
			if (this.firstMoveAvailable == true) {
				if (board.spaceIsOccupied(this.getX(), this.getY() + (1 * direction)) == false) {
					possibleMoves.add(new Coordinates(this.getX(), this.getY() + (2 * direction)));
				}
			}

		}
		return possibleMoves;
	}

	@Override
	public String move(int x, int y, Board board) {

		List<Coordinates> possibleMoves = getAllPossibleMoves(board);

		for (Coordinates coordinates : possibleMoves) {
			if (coordinates.getX().equals(x) && coordinates.getY().equals(y)) {
				int pieceX = this.getX();
				int pieceY = this.getY();

				if (Math.abs(pieceY - y) == 2) {
					this.firstMoveAvailable = false;
				}

				Piece[][] boardPieces = board.getBoardPieces();
				boardPieces[x][y] = board.getBoardPieces()[pieceX][pieceY];
				this.setX(x);
				this.setY(y);
				boardPieces[pieceX][pieceY] = new Empty();
				return STATUS.OK;
			}
		}
		return "Your " + this.getName() + " cannot move to the locaion of " + (x + 1) + ", " + (y + 1) + ".";
	}

	public boolean isFirstMoveAvailable() {
		return firstMoveAvailable;
	}

	public void setFirstMoveAvailable(boolean firstMoveAvailable) {
		this.firstMoveAvailable = firstMoveAvailable;
	}

}
