package domain;

import java.io.Serializable;

/**
 * Player
 * 
 * @author Kwon-Ki Jin(kwonkijin@nextree.co.kr)
 */
public class Player implements Serializable {

	/** UID */
	private static final long serialVersionUID = 5077408582760223046L;

	private String playerId;
	private String name;
	private int backNumber;
	private String position;
	private String teamId;

	public Player() {
	}

	public Player(String playerId, String name, int backNumber, String position, String teamId) {
		this.playerId = playerId;
		this.name = name;
		this.backNumber = backNumber;
		this.position = position;
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBackNumber() {
		return backNumber;
	}

	public void setBackNumber(int backNumber) {
		this.backNumber = backNumber;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", name=" + name + ", backNumber=" + backNumber + ", position="
				+ position + ", teamId=" + teamId + "]";
	}
}
