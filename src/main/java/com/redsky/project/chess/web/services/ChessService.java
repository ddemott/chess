package com.redsky.project.chess.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redsky.project.chess.domains.board.Board;

@Service("chessService")
public class ChessService {

	@Autowired
	private Board board;

	public ChessService() {
	}

	public Board getChessBoard() {
		return board;
	}

	public String resetBoard() {
		return board.resetBoard();
	}

	public String move(int x1, int y1, int x2, int y2) {
		return board.movePiece(x1, y1, x2, y2);
	}

}
