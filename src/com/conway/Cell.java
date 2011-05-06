package com.conway;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cell {
	private CellState state = new CellStateAlive();
	private List<Cell> neighbors = new ArrayList<Cell>();
	private Map<Position, Cell> positionedNeighbors = new HashMap<Position, Cell>();

	public boolean isAlive() {
		return state.isAlive();
	}

	public void evolve() {
		state = state.nextState(getNeighborCount());
	}

	public void kill() {
		state = new CellStateDead();
	}

	public void addNeighbor(Cell neighbor) {
		neighbors.add(neighbor);
	}

	public int getNeighborCount() {
		return neighbors.size();
	}

	public boolean isNeighborWith(Cell neighbor) {
		return neighbors.contains(neighbor);
	}

	public void addNeighbor(Cell neighbor, Position position) {
		positionedNeighbors.put(position, neighbor);
		
	}

	public boolean hasNeighborAt(Position position) {
		return positionedNeighbors.containsKey(position);
	}
}
