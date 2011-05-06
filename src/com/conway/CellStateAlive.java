package com.conway;

public class CellStateAlive extends CellState {

	@Override
	boolean isAlive() {
		return true;
	}

	@Override
	CellState nextState(int neighborCount) {
		return (neighborCount == 2 || neighborCount == 3) ? this : new CellStateDead();
	}

}
