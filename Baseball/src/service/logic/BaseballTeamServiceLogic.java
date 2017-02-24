package service.logic;

import java.util.ArrayList;
import java.util.List;

import domain.BaseballTeam;
import domain.Player;
import service.BaseballTeamService;
import store.BaseballTeamStore;
import store.PlayerStore;
import store.logic.BaseballTeamStoreLogic;
import store.logic.PlayerStoreLogic;

public class BaseballTeamServiceLogic implements BaseballTeamService {
	BaseballTeamStore store;
	PlayerStore pstore;
	
	public BaseballTeamServiceLogic() {
		store = new BaseballTeamStoreLogic();
		pstore = new PlayerStoreLogic();
	}

	@Override
	public BaseballTeam findTeam(String teamId) {
		BaseballTeam bt = store.retrieve(teamId);
//		System.out.println(pstore.retrieveByTeam(bt.getTeamId()).size());
		bt.setPlayers(pstore.retrieveByTeam(bt.getTeamId()));			
		return bt;
	}

	@Override
	public List<BaseballTeam> findAllTeams() {
		return store.retrieveAll();
	}

	@Override
	public List<BaseballTeam> findAllTeamsWithPlayers() {
		List<BaseballTeam> list = store.retrieveAll();
		for(BaseballTeam bt : list){
			bt.setPlayers(pstore.retrieveByTeam(bt.getTeamId()));
		}
		return list;
	}

	@Override
	public List<BaseballTeam> findTradeTargetPalyers(String teamId) {
		List<BaseballTeam> list = store.retrieveAll();
		for(BaseballTeam bt : list){
			bt.setPlayers(pstore.retrieveByTeam(bt.getTeamId()));
		}
		
		List<BaseballTeam> realList = new ArrayList<>();
		for(BaseballTeam bt : list){
			if(!bt.getTeamId().equals(teamId)){
				realList.add(bt);
			}
		}
		return realList;
	}

	@Override
	public Player findPlayer(String playerId) {
		return pstore.retrieve(playerId);
	}

	@Override
	public void tradePlayer(String sourcePlayerId, String targetPlayerId) {
		Player sp = pstore.retrieve(sourcePlayerId);
		Player tp = pstore.retrieve(targetPlayerId);
		String temp = sp.getTeamId();
		sp.setTeamId(tp.getTeamId());
		tp.setTeamId(temp);
		
		pstore.update(sp);
		pstore.update(tp);
	}

}
