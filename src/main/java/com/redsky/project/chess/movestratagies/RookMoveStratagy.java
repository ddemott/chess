package com.redsky.project.chess.movestratagies;

import java.util.ArrayList;
import java.util.List;

import com.redsky.project.chess.domains.board.Board;
import com.redsky.project.chess.domains.board.Coordinates;
import com.redsky.project.chess.domains.pieces.Piece;

public class RookMoveStratagy {

	public List<Coordinates> getAllPossibleMoves(Board board, Piece piece, boolean singleMoveOnly) {

		List<Coordinates> possibleMoves = new ArrayList<>();

		// UP
		for (int i = piece.getY() + 1; i <= 7; i++) {
			boolean bool = board.spaceIsOccupied(piece.getX(), i);
			if (bool == false) {
				possibleMoves.add(new Coordinates(piece.getX(), i));
			} else {
				break;
			}

			if (singleMoveOnly == true) {
				break;
			}
		}

		// DOWN
		for (int i = piece.getY() - 1; i >= 0; i--) {
			boolean bool = board.spaceIsOccupied(piece.getX(), i);
			if (bool == false) {
				possibleMoves.add(new Coordinates(piece.getX(), i));
			} else {
				break;
			}

			if (singleMoveOnly == true) {
				break;
			}
		}

		// RIGHT
		for (int i = piece.getX() + 1; i <= 7; i++) {
			boolean bool = board.spaceIsOccupied(i, piece.getY());
			if (bool == false) {
				possibleMoves.add(new Coordinates(i, piece.getY()));
			} else {
				break;
			}

			if (singleMoveOnly == true) {
				break;
			}
		}

		// LEFT
		for (int i = piece.getX() - 1; i >= 0; i--) {
			boolean spaceOccupied = board.spaceIsOccupied(i, piece.getY());
			if (spaceOccupied == false) {
				possibleMoves.add(new Coordinates(i, piece.getY()));
			} else {
				break;
			}

			if (singleMoveOnly == true) {
				break;
			}
		}

		return possibleMoves;
	}

}
