package store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Music;
import store.UserMusicStore;
import store.factory.ConnectionFactory;

public class UserMusicStoreLogic implements UserMusicStore {
	ConnectionFactory factory;
	
	
	public UserMusicStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}

	@Override
	public boolean create(String userId, int musicId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		if(!existUserMusic(userId, musicId))return false;
		try {
			
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("insert into user_music_tb values(?,?)");
			pstmt.setInt(1, musicId);
			pstmt.setString(2, userId);
			rs = pstmt.executeQuery();
			if(rs.next())return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delete(String userId, int musicId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("delete from user_music_tb where music_Id = ? and user_Id = ?");
			pstmt.setInt(1, musicId);
			pstmt.setString(2, userId);
			rs = pstmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
		
	}

	@Override
	public boolean existUserMusic(String userId, int musicId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select music_id, user_id from user_music_tb where user_Id = ? and music_Id = ?");
			pstmt.setString(1, userId);
			pstmt.setInt(2, musicId);
			rs = pstmt.executeQuery();
			return rs.next()?false:true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public List<Music> readMusicsByUser(String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Music> list = null;
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select id, name, artist_name, album_title, image, agent_name from music_tb m, user_music_tb u where m.id = u.music_id and u.user_id = ?");
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			list = new ArrayList<>();
			Music m;
			while(rs.next()){
				m = new Music(rs.getInt("id"), rs.getString("name"),rs.getString("artist_name"),rs.getString("album_title"),rs.getString("image"),rs.getString("agent_name"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
