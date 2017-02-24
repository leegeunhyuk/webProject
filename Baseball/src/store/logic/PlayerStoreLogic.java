package store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Player;
import store.PlayerStore;
import store.factory.ConnectionFactory;
import store.utils.JdbcUtils;

public class PlayerStoreLogic implements PlayerStore {
	ConnectionFactory factory;

	public PlayerStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}

	@Override
	public void update(Player player) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("update player_tb set teamId = ? where id = ?");
			pstmt.setString(1, player.getTeamId());
			pstmt.setInt(2, Integer.parseInt(player.getPlayerId()));

			pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, pstmt);
		}

	}

	@Override
	public Player retrieve(String playerId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Player p = null;
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement(
					"select ID,TEAMID,NAME,BACKNUMBER,POSITION,HITTING,THROW from player_tb where Id = ?");
			pstmt.setString(1, playerId);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				p = new Player(rs.getString("ID"), rs.getString("NAME"), rs.getInt("BACKNUMBER"),
						rs.getString("POSITION"), rs.getString("TEAMID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, pstmt, rs);
		}

		return p;
	}

	@Override
	public List<Player> retrieveByTeam(String teamId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Player p = null;
		List<Player> list = null;
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement(
					"select ID,TEAMID,NAME,BACKNUMBER,POSITION,HITTING,THROW from player_tb where teamId = ?");
			pstmt.setString(1, teamId);

			rs = pstmt.executeQuery();
			// private String playerId;
			// private String name;
			// private int backNumber;
			// private String position;
			// private String teamId;
			list = new ArrayList<>();
			while (rs.next()) {
				p = new Player(rs.getString("ID"), rs.getString("NAME"), rs.getInt("BACKNUMBER"),
						rs.getString("POSITION"), rs.getString("TEAMID"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, pstmt, rs);
		}

		return list;
	}

}
