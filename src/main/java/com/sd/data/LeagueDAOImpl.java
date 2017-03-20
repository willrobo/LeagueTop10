package com.sd.data;

import java.util.List;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.annotation.PostConstruct;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

public class LeagueDAOImpl implements LeagueDAO {

	private List<Player> roster = new ArrayList<>();
	private static final String FILE_NAME = "/WEB-INF/LoL.csv";

	@Autowired
	private WebApplicationContext wac;

	@PostConstruct
	public void init() {

		try (InputStream is = wac.getServletContext().getResourceAsStream(FILE_NAME);
				BufferedReader br = new BufferedReader(new InputStreamReader(is));) {
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] tokens = line.split(" , ");
				String summonerName = (tokens[0]);
				String playerName = tokens[1];
				String position = tokens[2];
				String team = tokens[3];
				System.out.println(summonerName);
				roster.add(new Player(summonerName, playerName, position, team));
			}

		} catch (Exception e) {
			System.err.println(e);
		}

	}

	@Override
	public void addPlayer(Player player) {
		roster.add(player);

	}

	@Override
	public void removePlayer(String name) {
		int index = 0;

		for (Player player : roster) {
			if (player.getPlayerName().equals(name)) {
				index = roster.indexOf(player);
			}
		}
		roster.remove(index);
	}

	@Override
	public Player getPlayerBySummonerName(String summonerName) {
		Player summoner = null;

		for (Player plr : roster) {
			if (plr.getSummonerName() == summonerName) {
				summoner = plr;
				break;
			}
		}
		return summoner;
	}

	@Override
	public Player getPlayerByName(String name) {
		Player summoner = null;

		for (Player plr : roster) {

			if (plr.getPlayerName().equals(name)) {
				summoner = plr;
				break;
			}
		}
		return summoner;
	}

	@Override
	public Player getPlayerByPosition(String position) {
		Player summoner = null;

		for (Player plr : roster) {

			if (plr.getPlayerName().equals(position)) {
				summoner = plr;
				break;
			}
		}
		return summoner;
	}

	@Override
	public Player editPlayer(Player player) {
		Player summoner = null;
		int index = 0;

		for (Player plr : roster) {

			if (plr.getSummonerName() == player.getSummonerName()) {
				summoner = plr;
				index = roster.indexOf(plr);
				break;
			}
		}

		summoner.setSummonerName(player.getSummonerName());
		summoner.setPlayerName(player.getPlayerName());
		summoner.setPosition(player.getPosition());
		summoner.setTeam(player.getTeam());
		roster.set(index, summoner);

		return summoner;
	}

	@Override
	public List<Player> getRoster() {
		return roster;

	}

}