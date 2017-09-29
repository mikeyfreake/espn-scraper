package com.espnscraper.domain;

import java.util.List;

public class Season {
	
	private String year;
	private List<Team> teams;
	
	public Season(String year) {
		this.year = year;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

}
