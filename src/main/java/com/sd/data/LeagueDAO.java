package com.sd.data;

import java.util.List;

public interface LeagueDAO {
	
	public List<Player> getRoster();
	
	public Player getPlayerByName(String playerName);
	public Player getPlayerBySummonerName(String summonerName);
	public Player getPlayerByPosition(String position);
	public Player getPlayerByTeam(String team);

	public void addPlayer(Player player);
	public void removePlayer(String summonerName);
	Player editPlayer(Player player);
	
}
