package store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.BaseballTeam;
import store.BaseballTeamStore;
import store.factory.ConnectionFactory;
import store.utils.JdbcUtils;

public class BaseballTeamStoreLogic implements BaseballTeamStore {
	ConnectionFactory factory;
	
	public BaseballTeamStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}

	@Override
	public BaseballTeam retrieve(String teamId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BaseballTeam bt = null;
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select ID, NAME, REGION, MANAGER, STADIUM, LOGO from team_tb where ID = ?");
			pstmt.setString(1, teamId);
			rs = pstmt.executeQuery();
			if(rs.next())
			bt = new BaseballTeam(rs.getInt("ID")+"", rs.getString("NAME"), rs.getString("REGION"), rs.getString("MANAGER"), rs.getString("STADIUM"), rs.getString("LOGO"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, pstmt, rs);
		}
		
		return bt;
	}

	@Override
	public List<BaseballTeam> retrieveAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BaseballTeam bt = null;
		List<BaseballTeam> list = null;
		try {
			conn = factory.createConnection();
//			ID
//			NAME
//			REGION
//			MANAGER
//			STADIUM
//			LOGO
			pstmt = conn.prepareStatement("select ID, NAME, REGION, MANAGER, STADIUM, LOGO from team_tb");
			rs = pstmt.executeQuery();
			list = new ArrayList<>();
			while(rs.next()){
				bt = new BaseballTeam(rs.getInt("ID")+"", rs.getString("NAME"), rs.getString("REGION"), rs.getString("MANAGER"), rs.getString("STADIUM"), rs.getString("LOGO"));
				list.add(bt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, pstmt, rs);
		}
		
		return list;
	}

}
