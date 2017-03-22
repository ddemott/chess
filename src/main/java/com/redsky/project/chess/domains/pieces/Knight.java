package com.redsky.project.chess.domains.pieces;

import java.util.ArrayList;
import java.util.List;

import com.redsky.project.chess.constants.PIECES;
import com.redsky.project.chess.domains.board.Board;
import com.redsky.project.chess.domains.board.Coordinates;

public class Knight extends Piece {

	public Knight(String color) {
		this.setColor(color);
		this.setName(PIECES.KNIGHT);
	}

	@Override
	public String move(int x2, int y2, Board board) {
		return super.move(x2, y2, board);
	}

	@Override
	public List<Coordinates> getAllPossibleMoves(Board board) {

		List<Coordinates> possibleMoves = new ArrayList<>();
		Coordinates coordinates = null;

		// UP
		coordinates = new Coordinates(this.getX() + 1, this.getY() + 2);
		processCoordinates(board, possibleMoves, coordinates);

		coordinates = new Coordinates(this.getX() - 1, this.getY() + 2);
		processCoordinates(board, possibleMoves, coordinates);

		// LEFT
		coordinates = new Coordinates(this.getX() - 2, this.getY() + 1);
		processCoordinates(board, possibleMoves, coordinates);

		coordinates = new Coordinates(this.getX() - 2, this.getY() - 1);
		processCoordinates(board, possibleMoves, coordinates);

		// DOWN
		coordinates = new Coordinates(this.getX() - 1, this.getY() - 2);
		processCoordinates(board, possibleMoves, coordinates);

		coordinates = new Coordinates(this.getX() + 1, this.getY() - 2);
		processCoordinates(board, possibleMoves, coordinates);

		// RIGHT
		coordinates = new Coordinates(this.getX() + 2, this.getY() + 1);
		processCoordinates(board, possibleMoves, coordinates);

		coordinates = new Coordinates(this.getX() + 2, this.getY() - 1);
		processCoordinates(board, possibleMoves, coordinates);

		return possibleMoves;
	}

	private void processCoordinates(Board board, List<Coordinates> possibleMoves, Coordinates coordinates) {
		if (checkBounds(coordinates)) {
			Piece piece = board.getBoardPieces()[coordinates.getX()][coordinates.getY()];
			if (piece instanceof Empty) {
				possibleMoves.add(coordinates);
			}
		}
	}

	public boolean checkBounds(Coordinates coordinates) {
		if (coordinates.getX() < 0 || coordinates.getX() > 7 || coordinates.getY() < 0 || coordinates.getY() > 7) {
			return false;
		} else {
			return true;
		}
	}

}
