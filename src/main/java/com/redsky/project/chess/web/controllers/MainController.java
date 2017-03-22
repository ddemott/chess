package com.redsky.project.chess.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.redsky.project.chess.domains.board.Board;
import com.redsky.project.chess.domains.misc.Status;
import com.redsky.project.chess.web.services.ChessService;

@RestController
@RequestMapping("/chess")
public class MainController {

	@Autowired
	private ChessService chessService;

	@ResponseBody
	@RequestMapping(value = { "/status", "/boardstatus" })
	public Board status() {
		return chessService.getChessBoard();
	}

	@ResponseBody
	@RequestMapping("/move/x1/{x1}/y1/{y1}/x2/{x2}/y2/{y2}")
	public Status movePiece(@PathVariable("x1") Integer x1, @PathVariable("y1") Integer y1,
			@PathVariable("x2") Integer x2, @PathVariable("y2") Integer y2) {

		String returnStatus = chessService.move(x1, y1, x2, y2);
		Status statusObject = new Status();
		statusObject.setAction("Move Piece:From " + x1 + ", " + y1 + " to " + x2 + " ," + y2);
		statusObject.setStatus(returnStatus);

		return statusObject;
	}

	@ResponseBody
	@RequestMapping(value = { "/reset", "/resetboard", "/quit" })
	public Status resetBoard() {
		String returnStatus = chessService.resetBoard();
		Status statusObject = new Status();
		statusObject.setAction("Reset Board");
		statusObject.setStatus(returnStatus);

		return statusObject;
	}

}
