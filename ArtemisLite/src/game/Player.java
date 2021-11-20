package game;

import java.util.ArrayList;


/*
 * Represents a player of the game
 */
public class Player {

	private String teamName;
	private int amountOfResources;
	private int positionOnBoard;
	private int amountSpentOnDevelopments; 
	private ArrayList<Systems> systemsOwned;

	/**
	 * Default constructor
	 */
	public Player() {

	}

	/**
	 * 
	 * @param teamName
	 */
	public Player(String teamName) {
		systemsOwned = new ArrayList<Systems>();
		this.teamName = teamName;
		this.positionOnBoard = 0;
		this.amountOfResources = 2500;
		this.amountSpentOnDevelopments = 0;
	}

	/**
	 * @return the amountSpentOnDevelopments
	 */
	public int getAmountSpentOnDevelopments() {
		return amountSpentOnDevelopments;
	}

	/**
	 * @param amountSpentOnDevelopments the amountSpentOnDevelopments to set
	 */
	public void setAmountSpentOnDevelopments(int amountSpentOnDevelopments) {
		this.amountSpentOnDevelopments = amountSpentOnDevelopments;
	}

	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * @param sets team name
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/**
	 * @return the amountOfResources
	 */
	public int getAmountOfResources() {
		return amountOfResources;
	}

	/**
	 * @param amountOfResources the amountOfResources to set
	 */
	public void setAmountOfResources(int amountOfResources) {
		this.amountOfResources = amountOfResources;
	}

	/**
	 * @return the positionOnBoard
	 */
	public int getPositionOnBoard() {
		return positionOnBoard;
	}

	/**
	 * @param positionOnBoard the positionOnBoard to set
	 */
	public void setPositionOnBoard(int positionOnBoard) {
		this.positionOnBoard = positionOnBoard;
	}
	

	/**
	 * @return the systemsOwned
	 */
	public ArrayList<Systems> getSystemsOwned() {
		return systemsOwned;
	}
	
	/**
	 * @return the totalWorth
	 */
	public int getTotalWorth() {
		return amountOfResources + amountSpentOnDevelopments;
	}

	
	/*
	 * Adds a new system owned
	 */
	public void addSystemOwned(Systems system) {
		systemsOwned.add(system);
	}
	
	/*
	 * rolls dice returns int 2-12
	 */
	
	public int rollDice() {
		Dice dice = new Dice();
		return dice.rollDice();
	}
	
	/*
	 * Returns the player to start square 
	 */
	public void returnToGo() {
		this.positionOnBoard = 0;
	}
	
	

	/**
	 * 
	 * @param amount
	 * Updates the players balance
	 */
	public void updatePlayerBalance(int upadteAmount) {
		int newBalance = 0;
		newBalance = getAmountOfResources() + upadteAmount;
		setAmountOfResources(newBalance);
	}

	/**
	 * Method to display the balance of a player & team name
	 */
	public void displayPlayerBalance() {
		System.out.println("Your balance is : " + getAmountOfResources());
		
	}

	/**
	 * 
	 * @param amountToPay - bill to player/square/development
	 * @return either true or false
	 */
	public boolean sufficientFunds(int amountToPay) {
		if (getAmountOfResources() > amountToPay) {
			return true;
		} else {
			return false;
		}
	}


	/**
	 * Displays players details
	 */
	public void displayAll(Square square) {
		System.out.println("Team name             : " + this.teamName);
		System.out.println("Amount of resources   : " + this.amountOfResources);
		System.out.println("Position on board     : " + this.positionOnBoard);
		System.out.println("Elements owned        : ");

	}
	
	/*
	 * Displays all the systems owned by the player
	 */
	public void displaySystemsOwned() {
		for(Systems system : systemsOwned) {
			System.out.println(system.getSystemType() + " on square " + system.getSquarePositionOnBoard());
			System.out.println("Development Level : " + system.getDevelopmentLevel());
		}
	}



	

}
