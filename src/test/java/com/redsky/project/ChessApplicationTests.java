package com.redsky.project;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.redsky.project.chess.constants.COLOR;
import com.redsky.project.chess.domains.board.Board;
import com.redsky.project.chess.domains.pieces.Pawn;
import com.redsky.project.util.Util;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChessApplicationTests {

	private Board board;
	private Util util;

	@Before
	public void init() {
		board = new Board();
		board.resetBoard();
		util = new Util();
	}

	@Test
	public void pawnStateTest() {
		Pawn pawn = new Pawn(COLOR.WHITE);
		String actual = util.getState(pawn);
		String expected = "{\"name\":\"Pawn\",\"color\":\"White\",\"x\":0,\"y\":0,\"firstMoveAvailable\":true}";
		assertEquals(expected, actual);
	}

	@Test
	public void boardStateTest() {
		String actual = util.getState(board);
		String expected = "{\"boardPieces\":[[{\"name\":\"Rook\",\"color\":\"White\",\"x\":0,\"y\":0},{\"name\":\"Pawn\",\"color\":\"White\",\"x\":0,\"y\":1,\"firstMoveAvailable\":true},{\"name\":\"\",\"color\":\"\",\"x\":0,\"y\":2},{\"name\":\"\",\"color\":\"\",\"x\":0,\"y\":3},{\"name\":\"\",\"color\":\"\",\"x\":0,\"y\":4},{\"name\":\"\",\"color\":\"\",\"x\":0,\"y\":5},{\"name\":\"Pawn\",\"color\":\"Black\",\"x\":0,\"y\":6,\"firstMoveAvailable\":true},{\"name\":\"Rook\",\"color\":\"Black\",\"x\":0,\"y\":7}],[{\"name\":\"Knight\",\"color\":\"White\",\"x\":1,\"y\":0},{\"name\":\"Pawn\",\"color\":\"White\",\"x\":1,\"y\":1,\"firstMoveAvailable\":true},{\"name\":\"\",\"color\":\"\",\"x\":1,\"y\":2},{\"name\":\"\",\"color\":\"\",\"x\":1,\"y\":3},{\"name\":\"\",\"color\":\"\",\"x\":1,\"y\":4},{\"name\":\"\",\"color\":\"\",\"x\":1,\"y\":5},{\"name\":\"Pawn\",\"color\":\"Black\",\"x\":1,\"y\":6,\"firstMoveAvailable\":true},{\"name\":\"Knight\",\"color\":\"Black\",\"x\":1,\"y\":7}],[{\"name\":\"Bishop\",\"color\":\"White\",\"x\":2,\"y\":0},{\"name\":\"Pawn\",\"color\":\"White\",\"x\":2,\"y\":1,\"firstMoveAvailable\":true},{\"name\":\"\",\"color\":\"\",\"x\":2,\"y\":2},{\"name\":\"\",\"color\":\"\",\"x\":2,\"y\":3},{\"name\":\"\",\"color\":\"\",\"x\":2,\"y\":4},{\"name\":\"\",\"color\":\"\",\"x\":2,\"y\":5},{\"name\":\"Pawn\",\"color\":\"Black\",\"x\":2,\"y\":6,\"firstMoveAvailable\":true},{\"name\":\"Bishop\",\"color\":\"Black\",\"x\":2,\"y\":7}],[{\"name\":\"Queen\",\"color\":\"White\",\"x\":3,\"y\":0},{\"name\":\"Pawn\",\"color\":\"White\",\"x\":3,\"y\":1,\"firstMoveAvailable\":true},{\"name\":\"\",\"color\":\"\",\"x\":3,\"y\":2},{\"name\":\"\",\"color\":\"\",\"x\":3,\"y\":3},{\"name\":\"\",\"color\":\"\",\"x\":3,\"y\":4},{\"name\":\"\",\"color\":\"\",\"x\":3,\"y\":5},{\"name\":\"Pawn\",\"color\":\"Black\",\"x\":3,\"y\":6,\"firstMoveAvailable\":true},{\"name\":\"Queen\",\"color\":\"Black\",\"x\":3,\"y\":7}],[{\"name\":\"King\",\"color\":\"White\",\"x\":4,\"y\":0},{\"name\":\"Pawn\",\"color\":\"White\",\"x\":4,\"y\":1,\"firstMoveAvailable\":true},{\"name\":\"\",\"color\":\"\",\"x\":4,\"y\":2},{\"name\":\"\",\"color\":\"\",\"x\":4,\"y\":3},{\"name\":\"\",\"color\":\"\",\"x\":4,\"y\":4},{\"name\":\"\",\"color\":\"\",\"x\":4,\"y\":5},{\"name\":\"Pawn\",\"color\":\"Black\",\"x\":4,\"y\":6,\"firstMoveAvailable\":true},{\"name\":\"King\",\"color\":\"Black\",\"x\":4,\"y\":7}],[{\"name\":\"Bishop\",\"color\":\"White\",\"x\":5,\"y\":0},{\"name\":\"Pawn\",\"color\":\"White\",\"x\":5,\"y\":1,\"firstMoveAvailable\":true},{\"name\":\"\",\"color\":\"\",\"x\":5,\"y\":2},{\"name\":\"\",\"color\":\"\",\"x\":5,\"y\":3},{\"name\":\"\",\"color\":\"\",\"x\":5,\"y\":4},{\"name\":\"\",\"color\":\"\",\"x\":5,\"y\":5},{\"name\":\"Pawn\",\"color\":\"Black\",\"x\":5,\"y\":6,\"firstMoveAvailable\":true},{\"name\":\"Bishop\",\"color\":\"Black\",\"x\":5,\"y\":7}],[{\"name\":\"Knight\",\"color\":\"White\",\"x\":6,\"y\":0},{\"name\":\"Pawn\",\"color\":\"White\",\"x\":6,\"y\":1,\"firstMoveAvailable\":true},{\"name\":\"\",\"color\":\"\",\"x\":6,\"y\":2},{\"name\":\"\",\"color\":\"\",\"x\":6,\"y\":3},{\"name\":\"\",\"color\":\"\",\"x\":6,\"y\":4},{\"name\":\"\",\"color\":\"\",\"x\":6,\"y\":5},{\"name\":\"Pawn\",\"color\":\"Black\",\"x\":6,\"y\":6,\"firstMoveAvailable\":true},{\"name\":\"Knight\",\"color\":\"Black\",\"x\":6,\"y\":7}],[{\"name\":\"Rook\",\"color\":\"White\",\"x\":7,\"y\":0},{\"name\":\"Pawn\",\"color\":\"White\",\"x\":7,\"y\":1,\"firstMoveAvailable\":true},{\"name\":\"\",\"color\":\"\",\"x\":7,\"y\":2},{\"name\":\"\",\"color\":\"\",\"x\":7,\"y\":3},{\"name\":\"\",\"color\":\"\",\"x\":7,\"y\":4},{\"name\":\"\",\"color\":\"\",\"x\":7,\"y\":5},{\"name\":\"Pawn\",\"color\":\"Black\",\"x\":7,\"y\":6,\"firstMoveAvailable\":true},{\"name\":\"Rook\",\"color\":\"Black\",\"x\":7,\"y\":7}]]}";
		assertEquals(expected, actual);
	}

}
