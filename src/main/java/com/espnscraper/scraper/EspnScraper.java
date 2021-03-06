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
	private final String FINAL_STANDINGS = "http://games.espn.com/ffl/tools/finalstandings?leagueId=";

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
		Document doc = Jsoup.connect(FINAL_STANDINGS + this.leagueId + "&seasonId=" + year).get();
		
		Season season = new Season(year);
		
		season.setTeams(getTeams(doc));
		
		return season;
	}
	
	private List<Team> getTeams(Document doc) throws IOException {
		List<Team> list = new ArrayList<Team>();
		
		Elements els = doc.select("tr[id^=rankRow]");
		
		for (Element tr : els) {
			
			Elements tds = tr.getElementsByTag("td");
			
			Integer rank = new Integer(tds.get(0).text());
			String teamName = tds.get(1).child(0).text(); 
			String owner = tds.get(2).text();
			String[] record = tds.get(4).text().split("-");
			Integer wins = new Integer(record[0]);
			Integer losses = new Integer(record[1]);
			Integer ties = record.length == 3 ? new Integer(record[2]) : 0;
			Double pf = new Double(tds.get(5).text());
			Double pa = new Double(tds.get(6).text());
			Double pfpg = new Double(tds.get(7).text());
			Double papg = new Double(tds.get(8).text());
			Double diff = new Double(tds.get(9).text());
			
			Team team = new Team(teamName, 0);
			team.setRank(rank);
			team.setOwner(owner);
			team.setWins(wins);
			team.setLosses(losses);
			team.setTies(ties);
			team.setPointsFor(pf);
			team.setPointsAgainst(pa);
			team.setPointsForPerGame(pfpg);
			team.setPointsAgainstPerGame(papg);
			team.setPointsForPlusMinus(diff);
						
			list.add(team);
		}
		
		return list;
	}
}
