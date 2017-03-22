package com.redsky.project.chess.domains.pieces;

import java.util.List;

import com.redsky.project.chess.constants.STATUS;
import com.redsky.project.chess.domains.board.Board;
import com.redsky.project.chess.domains.board.Coordinates;

public abstract class Piece {

	private String name = "";
	protected String color = "";
	private Integer x = 0;
	private Integer y = 0;

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public String move(int x, int y, Board board) {

		List<Coordinates> possibleMoves = getAllPossibleMoves(board);

		for (Coordinates coordinates : possibleMoves) {
			if (coordinates.getX().equals(x) && coordinates.getY().equals(y)) {
				int pieceX = this.getX();
				int pieceY = this.getY();
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

	public abstract List<Coordinates> getAllPossibleMoves(Board board);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
