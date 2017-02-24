package store;

import static org.junit.Assert.*;

import org.junit.Test;

import store.logic.PlayerStoreLogic;

public class PlayerStoreJUnit {
	PlayerStoreLogic store = new PlayerStoreLogic();

//	@Test
//	public void testUpdate() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testRetrieve() {
		System.out.println(store.retrieve("5").toString());
	}

//	@Test
//	public void testRetrieveByTeam() {
//		assertEquals(5, store.retrieveByTeam("10").size());
//	}

}
