package com.redsky.project.chess.domains.pieces;

import java.util.List;

import com.redsky.project.chess.domains.board.Board;
import com.redsky.project.chess.domains.board.Coordinates;

public class Empty extends Piece {

	public Empty() {
		this.setColor(color);
		this.setName("");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String move(int x2, int y2, Board board) {
		return null;
	}

	@Override
	public List<Coordinates> getAllPossibleMoves(Board board) {
		return null;
	}

}
