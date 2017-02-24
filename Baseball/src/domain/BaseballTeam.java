package domain;

import java.io.Serializable;
import java.util.List;

/**
 * BaseballTeam
 * 
 * @author Kwon-Ki Jin(kwonkijin@nextree.co.kr)
 */
public class BaseballTeam implements Serializable {

	/** UID */
	private static final long serialVersionUID = -4089549294141550288L;

	private String teamId;
	private String name;
	private String region;
	private String manager;
	private String stadium;
	private String logo;
	private List<Player> players;

	public BaseballTeam() {
	}

	public BaseballTeam(String teamId, String name, String region, String manager, String stadium, String logo) {
		this.teamId = teamId;
		this.name = name;
		this.region = region;
		this.manager = manager;
		this.stadium = stadium;
		this.logo = logo;
	}

	public int getNumberOfPlayers() {
		if (players == null) {
			return 0;
		}

		return players.size();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	@Override
	public String toString() {
		return "BaseballTeam [teamId=" + teamId + ", name=" + name + ", region=" + region + ", manager=" + manager
				+ ", stadium=" + stadium + ", logo=" + logo + "]";
	}
	
}
