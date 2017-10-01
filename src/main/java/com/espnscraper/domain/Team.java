package com.espnscraper.domain;

public class Team {

	private String name;
	private String owner;
	private Integer id;
	private Integer wins;
	private Integer losses;
	private Integer ties;
	private Integer rank;
	private Double pointsFor;
	private Double pointsAgainst;
	private Double pointsForPerGame;
	private Double pointsAgainstPerGame;
	private Double pointsForPlusMinus;
	
	public Team(String name, Integer id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWins() {
		return wins;
	}

	public void setWins(Integer wins) {
		this.wins = wins;
	}

	public Integer getLosses() {
		return losses;
	}

	public void setLosses(Integer losses) {
		this.losses = losses;
	}

	public Integer getTies() {
		return ties;
	}

	public void setTies(Integer ties) {
		this.ties = ties;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Double getPointsFor() {
		return pointsFor;
	}

	public void setPointsFor(Double pointsFor) {
		this.pointsFor = pointsFor;
	}

	public Double getPointsAgainst() {
		return pointsAgainst;
	}

	public void setPointsAgainst(Double pointsAgainst) {
		this.pointsAgainst = pointsAgainst;
	}

	public Double getPointsForPerGame() {
		return pointsForPerGame;
	}

	public void setPointsForPerGame(Double pointsForPerGame) {
		this.pointsForPerGame = pointsForPerGame;
	}

	public Double getPointsAgainstPerGame() {
		return pointsAgainstPerGame;
	}

	public void setPointsAgainstPerGame(Double pointsAgainstPerGame) {
		this.pointsAgainstPerGame = pointsAgainstPerGame;
	}

	public Double getPointsForPlusMinus() {
		return pointsForPlusMinus;
	}

	public void setPointsForPlusMinus(Double pointsForPlusMinus) {
		this.pointsForPlusMinus = pointsForPlusMinus;
	}
	
}
