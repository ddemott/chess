package com.redsky.project.chess.domains.pieces;

import java.util.List;

import com.redsky.project.chess.constants.PIECES;
import com.redsky.project.chess.domains.board.Board;
import com.redsky.project.chess.domains.board.Coordinates;
import com.redsky.project.chess.movestratagies.BishopMoveStratagy;

public class Bishop extends Piece {

	public Bishop(String color) {
		this.setColor(color);
		this.setName(PIECES.BISHOP);
	}

	@Override
	public String move(int x, int y, Board board) {
		return super.move(x, y, board);
	}

	@Override
	public List<Coordinates> getAllPossibleMoves(Board board) {
		BishopMoveStratagy bishopMoveStratagy = new BishopMoveStratagy();
		List<Coordinates> possibleMoves = bishopMoveStratagy.getAllPossibleMoves(board, this, false);

		return possibleMoves;
	}

}
