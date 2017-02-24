package store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.User;
import store.UserStore;
import store.factory.ConnectionFactory;

public class UserStoreLogic implements UserStore {
	private ConnectionFactory factory;
	
	
	public UserStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}

	@Override
	public boolean create(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("insert into user_tb values(?,?,?)");
			pstmt.setString(1, user.getLoginId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			rs = pstmt.executeQuery();
			if(rs.next())return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public User read(String id, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User u = null;
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select loginid, password, name from user_tb where loginid = ? and password = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				u = new User(rs.getString("loginId"), rs.getString("password"), rs.getString("name"));
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		
		
		return u;
	}

}
