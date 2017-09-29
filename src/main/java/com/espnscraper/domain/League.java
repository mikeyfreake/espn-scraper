package com.espnscraper.domain;

import java.util.List;

public class League {

	private String leagueId;
	private String name;
	private List<String> seasons;

	public League(String leagueId) {
		this.setLeagueId(leagueId);
	}

	public String getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(String leagueId) {
		this.leagueId = leagueId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getSeasons() {
		return seasons;
	}

	public void setSeasons(List<String> seasons) {
		this.seasons = seasons;
	}
	
	
	
}
