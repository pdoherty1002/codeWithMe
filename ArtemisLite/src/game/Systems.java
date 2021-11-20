package game;

import java.util.ArrayList;
import java.util.Queue;

/*
 * Represents a generic system
 */

public abstract class Systems extends Square {

	private SystemTypes systemType;
	private Player systemOwner;
	private int costToBuy;
	private int singleDevelopmentCost;
	private int majorDevelopmentCost = singleDevelopmentCost * (6-getDevelopmentLevel());
	private int developmentLevel;
	private int fineAmount;
	

	/**
	 * @return the systemType
	 */
	public SystemTypes getSystemType() {
		return systemType;
	}

	/**
	 * @return the systemOwner
	 */
	public Player getSystemOwner() {
		return systemOwner;
	}

	/**
	 * @return the playerOwner
	 */
	public String getSystemOwnerName() {
		if (this.systemOwner == null) {
			return "Unowned";
		} else {
			return this.systemOwner.getTeamName();
		}
	}

	/**
	 * @return the costToBuy
	 */
	public int getCostToBuy() {
		return costToBuy;
	}

	/**
	 * @return the singleDevelopmentCost
	 */
	public int getSingleDevelopmentCost() {
		return singleDevelopmentCost;
	}

	/**
	 * @return the majorDevelopmentCost
	 */
	public int getMajorDevelopmentCost() {
		return majorDevelopmentCost;
	}

	/**
	 * @return the developmentLevel
	 */
	public int getDevelopmentLevel() {
		return developmentLevel;
	}

	/**
	 * @param systemType the systemType to set
	 */
	public void setSystemType(SystemTypes systemType) {
		this.systemType = systemType;
	}

	/**
	 * @param playerOwner the playerOwner to set
	 */
	public void setSystemOwner(Player systemOwner) {
		this.systemOwner = systemOwner;
	}

	/**
	 * @param costToBuy the costToBuy to set
	 */
	public void setCostToBuy(int costToBuy) {
		this.costToBuy = costToBuy;
	}

	/**
	 * @param singleDevelopmentCost the singleDevelopmentCost to set
	 */
	public void setSingleDevelopmentCost(int singleDevelopmentCost) {
		this.singleDevelopmentCost = singleDevelopmentCost;
	}

	/**
	 * @param majorDevelopmentCost the majorDevelopmentCost to set
	 */
	public void setMajorDevelopmentCost(int majorDevelopmentCost) {
		this.majorDevelopmentCost = majorDevelopmentCost;
	}

	/**
	 * @param developmentLevel the developmentLevel to set
	 */
	public void setDevelopmentLevel(int developmentLevel) {
		this.developmentLevel = developmentLevel;
	}

	/**
	 * @return the fineAmount
	 */
	public int getFineAmount() {
		return fineAmount;
	}

	/**
	 * @param fineAmount the fineAmount to set
	 */
	public void setFineAmount(int fineAmount) {
		this.fineAmount = fineAmount;
	}

	/*
	 * Returns the systems elements to be upgraded
	 */
	public abstract Queue<String> getSystemElements();

	/*
	 * Performs a single development and returns the element upgraded
	 */
	public String singleDevelopment(Player player, Queue<String> elements) {
		this.developmentLevel++;
		String element = elements.poll();
		// developmentHistory.put(Game.CURRENTWEEK,"Element : " + elements.poll() +
		// "\nUpgraded by :" + player.getTeamName());
		System.out.println("Minor Development Complete !\nElement Developed : " + element);
		System.out.println("New Development Level : " + this.getDevelopmentLevel());
		return element;

	}

	/*
	 * Performs a major development (Develops all the remaining elements of system),
	 * this can only be called when the system is at dev level 3
	 * returns an array of the elements upgraded
	 */
	public ArrayList<String> majorDevelopment(Player player, Queue<String> elements) {
		
		int numElementsRemaining = elements.size();
		ArrayList<String> elementsUpgraded = new ArrayList<>();
		for (int i = 0; i <numElementsRemaining ; i++) {
			String element = elements.poll();
			// developmentHistory.put(Game.CURRENTWEEK,"Element : " + elements.poll() +
			// "\nUpgraded by :" + player.getTeamName());
			System.out.println("Development Complete !\nElement Developed : " + element);
			elementsUpgraded.add(element);
		}
		System.out.println("New Development Level : " + 6);
		return elementsUpgraded;
	}

	/*
	 * Returns false if system owner is null
	 */
	public boolean isOwned() {
		if (this.getSystemOwner() == null) {
			return false;
		} else {
			return true;
		}
	}

	/*
	 * Checks if square is owned by inputted player
	 */
	public boolean isOwned(Player player) {
		if (this.getSystemOwner().getTeamName() == player.getTeamName()) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Displays the players options for the system
	 */

	public void displaySystemOptions(Player player) {
		if (!this.isOwned()) {
			System.out.println("You have landed on a " + this.getSystemType() + " square !");
			System.out.println("The square is unowned !");
			System.out.println("Your balance : " + player.getAmountOfResources());
			System.out.println("Cost To Buy : " + this.getCostToBuy());
		} else {
			if (getSystemOwner().equals(player)) {// owned by the player
				System.out.println("You have landed on a " + this.getSystemType() + " square !");
				System.out.println("Development Level : " + this.getDevelopmentLevel() + "/6");
				System.out.println("-----------------------------------------------------------");
				System.out.println("Your balance : " + player.getAmountOfResources());
				System.out.println("You own this square ! Costs to upgrade are : ");
				if (this.getDevelopmentLevel() > 3) {
					System.out.println("Major Development Cost : " + this.getMajorDevelopmentCost());
				}
				System.out.println("Single Development Cost : " + this.getSingleDevelopmentCost());
			} else {// owned by another player
				System.out.println("You have landed on a " + this.getSystemType() + " square !");
				System.out.println(this.getSystemOwnerName() + " owns this square !");
				System.out.println("You pay them a fine of " + this.getFineAmount() + " resources !");
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
