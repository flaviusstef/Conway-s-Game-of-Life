package com.conway;
import org.junit.*;
import static org.junit.Assert.*;


public class CellTest {

	@Test
	public void bootstrap() {
		Cell cell = new Cell();
		assertTrue(cell.isAlive());
		assertEquals(0, cell.getNeighborCount());
	}
		
	@Test
	public void shouldDieIfUnderpopulated() {
		Cell cell = new Cell();
		addNeighbors(cell, 1);

		cell.evolve();
		
		assertFalse(cell.isAlive());
	}

	@Test
	public void shouldLiveIfTwoNeighbors() {
		Cell cell = new Cell();

		addNeighbors(cell, 2);
		cell.evolve();

		assertTrue(cell.isAlive());
	}
	
	@Test
	public void shouldLiveIfThreeNeighbors() {
		Cell cell = new Cell();

		addNeighbors(cell, 3);
		cell.evolve();

		assertTrue(cell.isAlive());
	}

	@Test
	public void shouldDieIfFourNeighbors() {
		Cell cell = new Cell();

		addNeighbors(cell, 4);
		cell.evolve();

		assertFalse(cell.isAlive());
	}
	
	@Test
	public void shouldBecomeAliveIfThreeNeighbors(){
		Cell cell = new Cell();
		cell.kill();
		
		addNeighbors(cell, 3);
		cell.evolve();
		
		assertTrue(cell.isAlive());
	}
	
	@Test
	public void shouldNotBecomeAliveIfTwoNeighbors(){
		Cell cell = new Cell();
		cell.kill();
		
		addNeighbors(cell, 2);
		cell.evolve();
		
		assertFalse(cell.isAlive());
	}
	
	@Test
	public void shouldRememberANeighbor() {
		Cell cell = new Cell();
		Cell neighbor = new Cell();
		cell.addNeighbor(neighbor);
		
		boolean found = cell.isNeighborWith(neighbor);
		
		assertTrue(found);
	}
	
	@Test
	public void shouldRememberTwoNeighbors() {
		Cell cell = new Cell();
		Cell firstNeighbor = new Cell();
		Cell secondNeighbor = new Cell();
		cell.addNeighbor(firstNeighbor);
		cell.addNeighbor(secondNeighbor);
		
		boolean found = cell.isNeighborWith(firstNeighbor) && cell.isNeighborWith(secondNeighbor);
		
		assertTrue(found);
	}
	
	@Test
	public void shouldRememberLeftNeighbor(){
		Cell cell = new Cell();
		Cell neighbor = new Cell();
		
		cell.addNeighbor(neighbor, Position.LEFT);
		
		assertTrue(cell.hasNeighborAt(Position.LEFT));
	}

	private void addNeighbors(Cell cell, int i) {
		for(int count = 0; count < i; ++count){
			cell.addNeighbor(new Cell());
		}
	}

}