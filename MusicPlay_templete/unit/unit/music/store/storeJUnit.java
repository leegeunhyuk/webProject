package unit.music.store;

import static org.junit.Assert.*;

import org.junit.Test;

import store.MusicStore;
import store.logic.MusicStoreLogic;

public class storeJUnit {

	MusicStore store;

	public storeJUnit() {
		store = new MusicStoreLogic();
	}

//	 @Test
//	 public void testRead() {
//		 System.out.println(store.read(2).toString());
//		 assertTrue(store.read(1) != null);
//	 }
	//
	 @Test
	 public void testReadByName() {
		 assertEquals(3, store.readByName("이").size());
		 
	 }

//	@Test
//	public void testReadAll() {
//		System.out.println(store.readAll().size());
//		assertEquals(20, store.readAll().size());
//	}

}
