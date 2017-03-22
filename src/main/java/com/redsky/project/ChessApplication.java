package com.redsky.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChessApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChessApplication.class, args);
	}

	// @Scope("session")
	// public Board resetBoard() {
	// Board board = new Board();
	// board.resetBoard();
	// return board;
	// }

}
