package com.redsky.project.chess.movestratagies;

import java.util.ArrayList;
import java.util.List;

import com.redsky.project.chess.domains.board.Board;
import com.redsky.project.chess.domains.board.Coordinates;
import com.redsky.project.chess.domains.pieces.Piece;

public class BishopMoveStratagy {

	public List<Coordinates> getAllPossibleMoves(Board board, Piece piece, boolean singleMoveOnly) {

		List<Coordinates> possibleMoves = new ArrayList<>();

		int x = 0;
		int y = 0;

		boolean continueChecking = true;
		x = piece.getX();
		y = piece.getY();

		while (continueChecking) {
			x++;
			y++;
			if (x > 7 || y > 7) {
				break;
			}
			boolean occupied = board.spaceIsOccupied(x, y);
			if (occupied == false) {
				possibleMoves.add(new Coordinates(x, y));
			} else {
				break;
			}

			if (singleMoveOnly == true) {
				break;
			}

		}

		continueChecking = true;
		x = piece.getX();
		y = piece.getY();

		while (continueChecking) {
			x++;
			y--;
			if (x > 7 || y < 0) {
				break;
			}
			boolean occupied = board.spaceIsOccupied(x, y);
			if (occupied == false) {
				possibleMoves.add(new Coordinates(x, y));
			} else {
				break;
			}

			if (singleMoveOnly == true) {
				break;
			}

		}

		continueChecking = true;
		x = piece.getX();
		y = piece.getY();

		while (continueChecking) {
			x--;
			y++;
			if (x < 0 || y > 7) {
				break;
			}
			boolean occupied = board.spaceIsOccupied(x, y);
			if (occupied == false) {
				possibleMoves.add(new Coordinates(x, y));
			} else {
				break;
			}

			if (singleMoveOnly == true) {
				break;
			}

		}

		continueChecking = true;
		x = piece.getX();
		y = piece.getY();

		while (continueChecking) {
			x--;
			y--;
			if (x < 0 || y < 0) {
				break;
			}
			boolean occupied = board.spaceIsOccupied(x, y);
			if (occupied == false) {
				possibleMoves.add(new Coordinates(x, y));
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
