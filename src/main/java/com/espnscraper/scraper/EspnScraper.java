package com.espnscraper.scraper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.espnscraper.domain.League;
import com.espnscraper.domain.Season;
import com.espnscraper.domain.Team;

public class EspnScraper {

	private String leagueId;
	
	private final String LEAGUE_HOMEPAGE = "http://games.espn.com/ffl/leagueoffice?leagueId=";
	private final String SEASON_STANDINGS = "http://games.espn.com/ffl/tools/finalstandings?leagueId=";

	public EspnScraper(String leagueId) {
		this.leagueId = leagueId;
	}
	
	public League getLeague() throws IOException {
		Document doc = Jsoup.connect(LEAGUE_HOMEPAGE + this.leagueId).get();
		
		League league = new League(this.leagueId);
		league.setName(doc.getElementsByClass("league-team-names").get(0).getElementsByTag("h1").text());
		
		List<String> seasons = new ArrayList<String>();
		for (Element el : doc.select("#seasonHistoryMenu").get(0).getElementsByTag("option"))
			seasons.add(el.text());
		league.setSeasons(seasons);
		
		return league;
	}
	
	public Season getSeason(String year) throws IOException {
		Document doc = Jsoup.connect(SEASON_STANDINGS + this.leagueId + "&seasonId=" + year).get();
		
		Season season = new Season(year);
		
		season.setTeams(getTeams(doc));
		
		return season;
	}
	
	private List<Team> getTeams(Document doc) throws IOException {
		List<Team> list = new ArrayList<Team>();
		
		Elements els = doc.select("[name^=rowRank1]");
		
		for (Element el : els) {
			
		}
		
		return list;
	}
}
