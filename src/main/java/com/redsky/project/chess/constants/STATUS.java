package com.redsky.project.chess.constants;

public interface STATUS {
	public static final String OK = "SUCCESS";
	public static final String INVALID_MOVE_FOR_PIECE = "ERROR: Move invalid for piece type.";
	public static final String DESTINATION_NOT_ON_BOARD = "ERROR: Destination not on board.";
        public static final String STARTING_POSITION_NOT_ON_BOARD = "ERROR: Starting position not on board.";
	public static final String SPACE_STATUS_OCCUPIED_BY_YOUR_PIECE = "ERROR: Can’t move because a space is occupied by own color piece.";
        public static final String SPACE_STATUS_OCCUPIED_BY_YOUR_OPPONENTS_PIECE = "ERROR: Space is occupied by your opponent's piece";
	public static final String BLOCKED_BY_YOUR_OWN_PIECE = "ERROR: You cannot move there because you are blocked by your own piece";
	public static final String BLOCKED_BY_YOUR_OPPONENTS_PIECE = "ERROR: You cannot move there because you are blocked by your opponent's piece";
	public static final String NO_PIECE_AT = "ERROR: There is no piece to move at ";

	public static final String REMOVED_OPPONENTS_PIECE = "SUCCESS: Your move removed an opponent's piece";
}
