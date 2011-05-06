package com.conway;

abstract public class CellState {
	abstract boolean isAlive();
	abstract CellState nextState(int neighborCount);
}
