package service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import domain.BaseballTeam;
import domain.Player;
import service.logic.BaseballTeamServiceLogic;
import store.logic.BaseballTeamStoreLogic;
import store.logic.PlayerStoreLogic;

public class BaseballTeamServiceLogicJunit {
	BaseballTeamServiceLogic service = new BaseballTeamServiceLogic();

//	@Test
//	public void testFindTeam() {
//		BaseballTeamStoreLogic store = new BaseballTeamStoreLogic();
//		PlayerStoreLogic pstore = new PlayerStoreLogic();
//		BaseballTeam bt = store.retrieve("1");
//		bt.setPlayers(pstore.retrieveByTeam(bt.getTeamId()));
//		
//		assertEquals(5, bt.getPlayers().size());
//	}
//
//	@Test
//	public void testFindAllTeams() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testFindAllTeamsWithPlayers() {
//		int sum = 0;
//		for(BaseballTeam b : service.findAllTeamsWithPlayers()){
//			sum += b.getPlayers().size();
//		}
//		assertEquals(25, sum);
//	}
//
//	@Test
//	public void testFindTradeTargetPalyers() {
//	}
//
//	@Test
//	public void testFindPlayer() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testTradePlayer() {
//		fail("Not yet implemented");
//	}

}
