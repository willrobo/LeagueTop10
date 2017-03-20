package com.sd.data;

public class Player {
	
	private String team;
	private String summonerName;
	private String playerName;
	private String position;


	public Player() {
	}

	public Player(String summonerName, String playerName, String position, String team) {
		
		this.team = team;
		this.summonerName = summonerName;
		this.playerName = playerName;
		this.position = position;

	}
	
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getSummonerName() {
		return summonerName;
	}

	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Player [team=" + team + ", summonerName=" + summonerName + ", playerName=" + playerName + ", position="
				+ position + "]";
	}

}