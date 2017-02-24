package service.logic;

import java.util.List;

import domain.Music;
import service.UserMusicService;
import store.UserMusicStore;
import store.logic.UserMusicStoreLogic;

public class UserMusicServiceLogic implements UserMusicService{
	UserMusicStore store;
	
	public UserMusicServiceLogic() {
		store = new UserMusicStoreLogic();
	}

	@Override
	public boolean register(String userId, int musicId) {
		return store.create(userId, musicId);
	}

	@Override
	public boolean remove(String userId, int musicId) {
		return store.delete(userId, musicId);
	}

	@Override
	public List<Music> findMusicsByUser(String userId) {
		return store.readMusicsByUser(userId);
	}
	

}
