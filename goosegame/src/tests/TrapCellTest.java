package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cells.StartCell;
import cells.TeleportCell;
import cells.TrapCell;
import goosegame.Player;

public class TrapCellTest {

	@Test
	public void testCanBeLeft() {
		TrapCell c = new TrapCell(1);
		assertTrue(! c.canBeLeft());
	}

	@Test
	public void testHandleMove() {
		TrapCell c = new TrapCell(4);
		assertTrue(4 == c.handleMove(8));
	}

	@Test
	public void testIsBusy() {
		TrapCell c = new TrapCell(1);
		assertTrue(! c.isBusy());
		Player p = new Player("name");
		c.welcomePlayer(p);
		assertTrue(c.isBusy());
	}

	@Test
	public void testWelcomePlayer() {
		Player p = new Player("name");
		StartCell c0 = new StartCell(0);
		TrapCell c1 = new TrapCell(1);
		c0.welcomePlayer(p);
		c1.welcomePlayer(p);
		assertTrue(p.getCell() == c1);
		assertTrue(c1.getPlayer() == p);
		assertTrue(c0.getPlayer() == null);
	}

}
