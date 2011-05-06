package com.conway;

public class CellStateDead extends CellState {

	@Override
	boolean isAlive() {
		return false;
	}

	@Override
	CellState nextState(int neighborCount) {
		return (neighborCount == 3) ? new CellStateAlive() : this;
	}

}
