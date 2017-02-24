package store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Music;
import store.MusicStore;
import store.factory.ConnectionFactory;

public class MusicStoreLogic implements MusicStore {
	private ConnectionFactory factory;

	public MusicStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}

	@Override
	public Music read(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Music m = null;
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select id, name, artist_name, album_title, image, agent_name from music_tb where id = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				m = new Music(rs.getInt("id"), rs.getString("name"), rs.getString("artist_name"),
						rs.getString("album_title"), rs.getString("image"), rs.getString("agent_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return m;
	}

	@Override
	public List<Music> readByName(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Music> list = new ArrayList<>();

		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select id, name, artist_name, album_title, image, agent_name from music_tb where name like ?");
			pstmt.setString(1, "%"+name+"%");
			rs = pstmt.executeQuery();
			Music m = null;
			
			while (rs.next()) {
				m = new Music(rs.getInt("id"), rs.getString("name"), rs.getString("artist_name"),
						rs.getString("album_title"), rs.getString("image"), rs.getString("agent_name"));
				list.add(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Music> readAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Music> list = new ArrayList<>();

		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select id, name, artist_name, album_title, image, agent_name from music_tb");
			rs = pstmt.executeQuery();
			Music m = null;
			
			while (rs.next()) {
				m = new Music(rs.getInt("id"), rs.getString("name"), rs.getString("artist_name"),
						rs.getString("album_title"), rs.getString("image"), rs.getString("agent_name"));
				list.add(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
