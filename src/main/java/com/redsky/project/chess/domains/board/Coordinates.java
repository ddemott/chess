package com.redsky.project.chess.domains.board;

import com.redsky.project.chess.constants.ACTION;

public class Coordinates {
	private Integer x = 0;
	private Integer y = 0;
	private String status = "";
	private ACTION action = ACTION.DO_NOTHING;

	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Coordinates(int x, int y, String status, ACTION action) {
		this.x = x;
		this.y = y;
		this.status = status;
		this.action = action;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ACTION getAction() {
		return action;
	}

	public void setAction(ACTION action) {
		this.action = action;
	}

}
