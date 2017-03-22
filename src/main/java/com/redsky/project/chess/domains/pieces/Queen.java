package com.redsky.project.chess.domains.pieces;

import java.util.List;

import com.redsky.project.chess.constants.PIECES;
import com.redsky.project.chess.domains.board.Board;
import com.redsky.project.chess.domains.board.Coordinates;
import com.redsky.project.chess.movestratagies.BishopMoveStratagy;
import com.redsky.project.chess.movestratagies.RookMoveStratagy;

public class Queen extends Piece {

	public Queen(String color) {
		this.setColor(color);
		this.setName(PIECES.QUEEN);
	}

	@Override
	public String move(int x2, int y2, Board board) {
		return super.move(x2, y2, board);
	}

	@Override
	public List<Coordinates> getAllPossibleMoves(Board board) {
		RookMoveStratagy rookMoveStratagy = new RookMoveStratagy();
		List<Coordinates> possibleMoves = rookMoveStratagy.getAllPossibleMoves(board, this, false);

		BishopMoveStratagy bishopMoveStratagy = new BishopMoveStratagy();
		possibleMoves.addAll(bishopMoveStratagy.getAllPossibleMoves(board, this, false));
		return possibleMoves;
	}

}
