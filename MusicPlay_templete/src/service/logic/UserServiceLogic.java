package service.logic;

import domain.User;
import service.UserService;
import store.UserStore;
import store.logic.UserStoreLogic;

public class UserServiceLogic implements UserService {
	UserStore store;
	
	
	public UserServiceLogic() {
		store = new UserStoreLogic();
	}

	@Override
	public User login(User user) {
		return new UserServiceLogic().find(user.getLoginId(), user.getPassword());
	}

	@Override
	public boolean register(User user) {
		return store.create(user);
	}

	@Override
	public User find(String loginId, String password) {
		return store.read(loginId, password);
	}
	

}
