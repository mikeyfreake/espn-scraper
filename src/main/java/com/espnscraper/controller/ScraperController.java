package com.espnscraper.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.espnscraper.domain.League;
import com.espnscraper.domain.Season;
import com.espnscraper.scraper.EspnScraper;

@RestController
@RequestMapping("/api")
public class ScraperController {

	@RequestMapping("/{leagueId}")
	public League getLeagueInfo(@PathVariable(value="leagueId") String leagueId) {
        
		EspnScraper scraper = new EspnScraper(leagueId);
		League league = null;
		try {
			league = scraper.getLeague();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return league;
    }
	
	@RequestMapping("/{leagueId}/{year}")
	public Season getSeason(@PathVariable(value="leagueId") String leagueId, @PathVariable(value="year") String year) {
		
		EspnScraper scraper = new EspnScraper(leagueId);
		Season season = null;
		try {
			season = scraper.getSeason(year);
		} catch (IOException e) {
			//TODO
			e.printStackTrace();
			return null;
		}
		
		return season;
	}
}
