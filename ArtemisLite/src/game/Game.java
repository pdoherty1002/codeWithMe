/**
 * 
 */
package game;

import java.util.ArrayList;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author User
 *
 */
public class Game {

	public static int CURRENTWEEK = 1;
	private int numberOfPlayers;
	public static ArrayList<Player> players;
	private static SortedMap<Integer, String> developmentHistory = new TreeMap<>();

	/*
	 * Main method - executes the game
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// generate the board
		Board board = new Board();
		// create instance of game
		Game game = new Game();
		// set up the teams
		game.gameSetUp(scanner);

		boolean playing = true;

		while (playing) {

			// check if board is complete
			if (board.isBoardComplete()) {
				System.out.println("---------------------------------------------------------------");
				System.out.println("****CONGRATULATIONS LANDING SUCCESSFUL ARTERMIS LITE PROJECT COMPLETE !****");
				System.out.println("---------------------------------------------------------------");
				break;
			}
			// loop through players and tell them to make their turn
			for (Player player : Game.players) {
				System.out.println(player.getTeamName() + " Your Turn !");

				boolean rolling = false;
				while (!rolling) {
					System.out.println("Press 1 to roll the dice !");
					try {
						int answer = scanner.nextInt();
						if (answer == 1) {
							scanner.nextLine();
							rolling = true;
						}
					} catch (InputMismatchException e) {
						scanner.nextLine();
					}
				}
				System.out.println("Rolling Dice .....");
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				game.takeTurn(player, board, scanner);
				System.out.println("---------------------------------------------------------------");
			}

			System.out.println("Week " + Game.CURRENTWEEK + " is over ! Check out the standings : \n");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// all players had their turn increment the game week
			Game.CURRENTWEEK++;
			game.playerScoreboard(Game.players);
			System.out.println("---------------------------------------------------------------");
			System.out.println("Would you like to keep playing ? y/n");
			boolean running = false;
			while (!running) {
				String keepPlaying = scanner.nextLine();
				if (keepPlaying.equalsIgnoreCase("y") || keepPlaying.equalsIgnoreCase("n")) {
					System.out.println("---------------------------------------------------------------");
					if (keepPlaying.equalsIgnoreCase("y")) {
						running = true;
					} else if (keepPlaying.equalsIgnoreCase("n")) {
						System.out.println("OK Ending Game !");
						playing = false;
						break;
					}
				}
			}

		} // the game is over
		System.out.println("The game is over ! Check out the final standings !");
		game.playerScoreboard(Game.players);
		System.out.println("Check out the history of the game and the journey of Artemis Lite ! ");
		System.out.println("---------------------------------------------------------------");
		game.developmentHistory();
		System.out.println("---------------------------------------------------------------");
		scanner.close();

	}

	/**
	 * Default Constructor for the Game
	 */
	public Game() {
		players = new ArrayList<>();
	}

	/**
	 * @return the numberOfPlayers
	 */
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	/**
	 * @param numberOfPlayers the numberOfPlayers to set
	 */
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	/*
	 * Game set up - asks the player to enter the number of teams playing and then
	 * loops through from 1 to the number of players, asking for the player name The
	 * players are created and added to the players list
	 */

	public void gameSetUp(Scanner scanner) {
		System.out.println("Welcome to Artemis Lite Game !");
		System.out.println("---------------------------------------------------------------");

		boolean asking = false;
		while (!asking) {
			System.out.println("Enter how many teams are player ! (2-4)");
			try {
				int answer = scanner.nextInt();
				if (answer >= 2 && answer <= 4) {
					System.out.println("OK! Creating " + answer + " teams!");
					numberOfPlayers = answer;
					scanner.nextLine();
					asking = true;
				} else {
					System.out.println("Enter a number between 2 and 4 !");
				}
			} catch (InputMismatchException e) {
				scanner.nextLine();
			}
		}

		int count = 1;
		String name;

		while (count <= numberOfPlayers) {
			System.out.println("Player " + count + ", Enter your team name : ");
			name = scanner.next();
			if (checkName(name))// check if name already used
				System.out.println("Name already used - try another name");
			else {
				Player player = new Player(name);
				players.add(player);
				count++;
			}
		}

		System.out.println("Great All Teams Created ! Lets get this rocket to the moon !");
		System.out.println("---------------------------------------------------------------");
	}

	/*
	 * Checks if player name has already been used i.e it is already in the players
	 * array list
	 */
	public boolean checkName(String name) {
		for (Player player : players) {
			if (player.getTeamName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets cost of development of system, checks if the system can be further
	 * developed and then if the inputed player has enough funds. If so, the element
	 * will be upgraded and the players balance adjusted
	 */
	public void singleDevelopment(Player player, Systems system) {
		// check if system can be further developed
		if (system.getDevelopmentLevel() < 6) {
			int cost = system.getSingleDevelopmentCost(); // get cost of development
			if (player.sufficientFunds(cost)) {// the player has enough funds
				// update players balance
				player.updatePlayerBalance(-cost);
				player.setAmountSpentOnDevelopments(player.getAmountSpentOnDevelopments() + cost);
				player.displayPlayerBalance();
				// this method gets the next element that can be upgraded and removes it from
				// the systems elements remaining and also logs the upgrade in the dev history
				String elementUpgraded = system.singleDevelopment(player, system.getSystemElements());
				system.setFineAmount(system.getFineAmount() + cost);
				developmentHistory.put(CURRENTWEEK, player.getTeamName() + " purchased " + elementUpgraded
						+ " as an upgrade for" + system.getSystemType() + " on position" + player.getPositionOnBoard());

			} else {
				System.out.println("You have insufficent funds for this development");
			}
		} else {
			System.out.println("System is already fully developed ");
		}
	}

	/**
	 * 
	 * @param system Completes a major development on system by player,if the player
	 *               has enough funds the players balance is
	 *               updated,the system details updated and the elements developed
	 *               are added to the development history map stored within the game
	 *               class. the major development will fully develop the system
	 * 
	 */
	public void majorDevelopment(Player player, Systems system) {

		int cost = system.getMajorDevelopmentCost();
		if (player.sufficientFunds(cost)) {
			player.updatePlayerBalance(-cost);
			player.displayPlayerBalance();
			player.setAmountSpentOnDevelopments(player.getAmountSpentOnDevelopments() + cost);
			system.setFineAmount(system.getMajorDevelopmentCost() + system.getFineAmount());
			// completed major dev and returns the elements upgraded in a list so that it
			// can be added to the history
			ArrayList<String> elementUpgraded = system.majorDevelopment(player, system.getSystemElements());
			for (String element : elementUpgraded) {
				developmentHistory.put(CURRENTWEEK,
						player.getTeamName() + " purchased " + element + " as an upgrade for " + system.getSystemType()
								+ " on position" + player.getPositionOnBoard());
			}
		} else {
			System.out.println("You have insufficent funds for this development.");
		}
	}

	/**
	 * 
	 * @param system If the player has enough funds, the player will be assigned the
	 *               owner of the system and their balance updated. The event will
	 *               be added to the development history
	 */
	public void purchaseSystem(Player player, Systems system) {

		if (player.sufficientFunds(system.getCostToBuy())) {
			system.setSystemOwner(player);
			system.setFineAmount(system.getCostToBuy() + system.getFineAmount());
			player.updatePlayerBalance(-system.getCostToBuy());
			System.out.println("Purchase successful !");
			player.displayPlayerBalance();
			player.addSystemOwned(system);
			player.setAmountSpentOnDevelopments(player.getAmountSpentOnDevelopments() + system.getCostToBuy());
			developmentHistory.put(CURRENTWEEK, player.getTeamName() + " purchased " + system.getSystemType()
					+ " on position" + player.getPositionOnBoard());

		} else {
			System.out.println("You have insufficent funds for this purchase.");
		}
	}

	/**
	 * 
	 * @param system Purchases system If the player has enough funds, the player
	 *               will be assigned the owner of the system and their balance
	 *               updated. The event will be added to the development history
	 */
	public void purchaseSystemAuction(Player player, int bid, Systems system) {

		if (player.sufficientFunds(bid)) {
			system.setSystemOwner(player);
			system.setFineAmount(system.getCostToBuy() + system.getFineAmount());
			player.updatePlayerBalance(-bid);
			System.out.println("Purchase successful !");
			player.displayPlayerBalance();
			player.addSystemOwned(system);
			player.setAmountSpentOnDevelopments(player.getAmountSpentOnDevelopments() + system.getCostToBuy());
			developmentHistory.put(CURRENTWEEK, player.getTeamName() + " purchased " + system.getSystemType()
					+ " on position" + player.getPositionOnBoard() + "  at an auction for " + bid + " resources !");

		} else {
			System.out.println("You have insufficent funds for this purchase.");
		}
	}

	/*
	 * Auctions a system - the highest bidder wins, the param player is the player
	 * who opted not to buy the system originally. The winner of the auction will be
	 * assigned the owner of the system and the action added to the history map via
	 * the purchaseSystem() method
	 */
	public void auctionSystem(Systems system, Player player, Scanner scanner) {

		System.out.println(
				"Auction !! Each Player has one bid each ! Choose it wisely ! You must make a bid greater than or equal to "
						+ system.getCostToBuy());

		Player auctionWinner = new Player();
		int hightestBid = 0;
		int bid = 0;
		int systemCost = system.getCostToBuy();

		for (Player otherPlayer : players) {
			if (!otherPlayer.equals(player)) {
				boolean auction = false;
				while (!auction) {
					try {
						System.out.println(otherPlayer.getTeamName() + " your turn !");
						otherPlayer.displayPlayerBalance();
						System.out.println(otherPlayer.getTeamName() + " enter a valid bid !");
						bid = scanner.nextInt();
						if (bid >= systemCost && bid > hightestBid && otherPlayer.sufficientFunds(bid)) {
							hightestBid = bid;
							auctionWinner = otherPlayer;
							scanner.nextLine();
							auction = true;
						}
					} catch (InputMismatchException e) {
						scanner.nextLine();
					}

				}

			}
		}
		if (auctionWinner.getTeamName() != null) {// i.e an auction winner has been assigned
			System.out.println(auctionWinner.getTeamName() + ", you win the auction congratulations !");
			purchaseSystemAuction(auctionWinner, bid, system);
		} else {
			System.out.println("No one submitted a good enough bid ! The square will remain unowned for now !");
		}

	}

	/**
	 * 
	 * @param playerToPay
	 * @param resourcesToPay player pays playerToPlay resourcesToPay. Both players
	 *                       balances are updated accordingly
	 */
	public void payPlayer(Player player, Player playerToPay, int resourcesToPay) {
		if (player.getAmountOfResources() > resourcesToPay) {
			playerToPay.updatePlayerBalance(resourcesToPay); // update receiving players balance
			player.updatePlayerBalance(-resourcesToPay); // update sending players balance
			System.out.println(player.getTeamName() + ", Updated Balance : ");
			player.displayPlayerBalance();
			System.out.println(playerToPay.getTeamName() + ", Updated Balance : ");
			playerToPay.displayPlayerBalance();
		} else {
			System.out.println(
					"You have insufficent funds to pay this player....for the cause of space exploration, you are not required to pay.");
		}
	}

	/*
	 * Displays the players options if the player currently owns the square This
	 * will be called if the system is below development level 3 and so the player
	 * can only undertake a minor development
	 */
	public void displayOwnershipOptions(Player player, Systems system, Scanner scanner) {
		System.out.println(system.getSystemType());

		boolean asking = false;
		while (!asking) {
			System.out.println("Press 1 to complete a minor development");
			System.out.println("Press 2 to skip");
			try {
				int answer = scanner.nextInt();
				if (answer == 1) {
					singleDevelopment(player, system);
					scanner.nextLine();
					asking = true;
				} else if (answer == 2) {
					System.out.println("Skipping !");
					scanner.nextLine();
					asking = true;
				} else {
					System.out.println("Enter a number between 1 and 2 !");
				}
			} catch (InputMismatchException e) {
				scanner.nextLine();
			}
		}
	}

	/*
	 * Displays the players options if the player currently owns the square This
	 * will be called if the system is already at development level 3 and so the
	 * player can undertake a major development
	 */
	public void displayOwnershipOptionsMajor(Player player, Systems system, Scanner scanner) {
		System.out.println(system.getSystemType());

		boolean asking = false;
		while (!asking) {
			System.out.println("Press 1 to complete a minor development");
			System.out.println("Press 2 to complete a major development");
			System.out.println("Press 3 to skip");
			try {
				int answer = scanner.nextInt();
				if (answer == 1) {
					singleDevelopment(player, system);
					scanner.nextLine();
					asking = true;
				} else if (answer == 2) {
					majorDevelopment(player, system);
					scanner.nextLine();
					asking = true;
				} else if (answer == 3) {
					System.out.println("Skipping !");
					scanner.nextLine();
					asking = true;
				} else {
					System.out.println("Enter a number between 1 and 3 !");
				}
			} catch (InputMismatchException e) {
				scanner.nextLine();
			}
		}
	}

	/*
	 * Moves the players position num steps on the board If the player has passed
	 * go, the player will collect the pass go reward.Returns the square the player has landed on
	 */
	public Square movePlayer(Player player, Board board, int num) {
		if (player.getPositionOnBoard() + num > board.getBoard().size() - 1) {// i.e you have done one lap of the board
			// find the distance to the end
			int distanceToEndOfBoard = board.getBoard().size() - 1 - player.getPositionOnBoard();
			player.setPositionOnBoard(0 + (num - distanceToEndOfBoard));
			// this will mean you have passed go also
			System.out.println("You have passed go !");
			System.out.println("Collect " + GoSquare.PASS_GO_AWARD + " resources !");
			player.updatePlayerBalance(GoSquare.PASS_GO_AWARD);
			// return the square the player is now on
			return board.getSquare(player.getPositionOnBoard());
		} else {
			player.setPositionOnBoard(player.getPositionOnBoard() + num);
			return board.getSquare(player.getPositionOnBoard());
		}
	}

	/*
	 * Display Players options when they land on a systems square
	 */
	public void displayPlayerOptions(Scanner scanner, Player player, Systems system) {
		system.displaySystemOptions(player);
		if (system.isOwned()) {// system is already owned

			// check if owned by the player
			if (system.isOwned(player) && system.getDevelopmentLevel() < 3) {
				System.out.println("You own this system !");
				displayOwnershipOptions(player, system, scanner);
			} else if (system.isOwned(player) && system.getDevelopmentLevel() >= 3) {
				System.out.println("System is owned by another player !");
				displayOwnershipOptionsMajor(player, system, scanner);
			} else {// have to pay a fine
				payPlayer(player, system.getSystemOwner(), system.getFineAmount());
			}
		} else {
			// system is unowned
			System.out.println("Would you like to buy ? y/n");
			boolean answering = true;

			while (answering) {

				String answer = scanner.next();

				if (answer.equalsIgnoreCase("y")) {
					// buy square
					purchaseSystem(player, system);
					break;
				} else if (answer.equalsIgnoreCase("n")) {
					System.out.println(
							"OK ! The system will now be auctioned, for the good of the space mission, this system must go today !");
					System.out.println("---------------------------------------------------------------");
					auctionSystem(system, player, scanner);
					break;
				} else {
					System.out.println("Invalid Entry - enter y/n");
				}
			}
		}

	}

	/*
	 * Takes in the generated chance value and does the aprropriate actions 1 -
	 * Receive a bonus 2 - pay a random player a fine 3 = return to go square and
	 * collect no bonus
	 */
	public void processChanceCard(Player player1, int num) {
		Random random = new Random();
		if (num == 1) {
			int reward = random.nextInt(1000) + 1;
			System.out.println("Receive a bonus !!\n You are a lucky winner of  " + reward + " resources !");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			player1.updatePlayerBalance(reward);
			System.out.println(player1.getTeamName() + " - your new balance is :" + player1.getAmountOfResources());
		} else if (num == 2) {
			int fine = random.nextInt(100) + 1;
			boolean running = true;
			Player player2 = new Player();
			while (running) {
				int playerIndex = random.nextInt(Game.players.size());
				if (Game.players.get(playerIndex) != player1) {
					player2 = Game.players.get(playerIndex);
					running = false;
				}
			}
			// pay the player
			System.out.println("You have been fined for breaching regulations !");
			System.out.println("Pay " + player2.getTeamName() + " " + fine + " resources !");
			System.out.println("---------------------------------------------------------------");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			payPlayer(player1, player2, fine);
		} else if (num == 3) {
			System.out.println("Return to go square ! No bonus will be collected");
			player1.returnToGo();
		}
	}

	/*
	 * Processes the square that the player has landed on, the move square already
	 * accounts for moving past go or landing on it
	 */
	public void getSquareDetails(Player player, Square square, Scanner scanner) {
		if (square instanceof Blank) {
			System.out.println("Hard luck you have landed on a deep space square ! Your turn is now over :-(");
		} else if (square instanceof ChanceSquare) {
			ChanceSquare chanceSquare = (ChanceSquare) square;
			System.out.println("You have landed on a chance square ! ");
			int chance = chanceSquare.generateChance();
			processChanceCard(player, chance);
		} else if (square instanceof Systems) {
			Systems system = (Systems) square;
			displayPlayerOptions(scanner, player, system);
		}
	}

	/**
	 * method to take turn - rolls dice returns int 2-12
	 */
	public void takeTurn(Player player, Board board, Scanner scanner) {
		// roll the dice
		Dice dice = new Dice();
		int diceThrow = dice.rollDice();
		System.out.println("You have a rolled a " + diceThrow + " ! Moving position.......");
		System.out.println("---------------------------------------------------------------");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// move the player to new position
		Square square = movePlayer(player, board, diceThrow); // move player and get new position on board
		getSquareDetails(player, square, scanner);
		//main turn is over - now if the player owns other squares 
		if(square instanceof Systems) {
			if(player.getSystemsOwned().size()>1) {
				System.out.println("---------------------------------------------------------------");
				System.out.println(player.getTeamName() + " you can now upgrade your other squares if you like ! We will cycle through them now.....");
				Systems landedSystem = (Systems) square;
				systemsOwnedUpgradeOptions(player,landedSystem,scanner);
			}
		}else {
			if(player.getSystemsOwned().size()>1) {
				System.out.println("---------------------------------------------------------------");
				System.out.println(player.getTeamName() + " - you can now upgrade your other squares if you like ! We will cycle through them now.....");
				systemsOwnedUpgradeOptions(player,scanner);
			}
		}
		
	}
	
	/*
	 * Gives the player an option to upgrade any other elements they own
	 * The systems parameter is the square the player had landed on whilst taking their turn
	 * The player cannot upgrade this square further 
	 * This method is only called if the player has landed on a system during their turn
	 * and they own more than one system i.e not the system they just landed on
	 */
	public void systemsOwnedUpgradeOptions(Player player, Systems landedSystem,Scanner scanner) {
		//get the players systems owned
		ArrayList<Systems> systemsOwned = player.getSystemsOwned();
	
		for(Systems system : systemsOwned) {
			if((system != landedSystem) && (system.getDevelopmentLevel() !=6)) {
				if(system.getDevelopmentLevel() <3) {
					System.out.println("---------------------------------------------------------------");
					player.displayPlayerBalance();
					displayOwnershipOptions(player, system, scanner);
					System.out.println("---------------------------------------------------------------");
				}else {
					System.out.println("---------------------------------------------------------------");
					player.displayPlayerBalance();
					displayOwnershipOptionsMajor(player, system, scanner);
					System.out.println("---------------------------------------------------------------");
				}
				
			}
		}
		
		
	}
	
	/*
	 * Gives the player an option to upgrade any other elements they own
	 * This method is only called if the player has landed on a system during their turn
	 * and they own more than one system i.e not the system they just landed on
	 */
	public void systemsOwnedUpgradeOptions(Player player, Scanner scanner) {
		//get the players systems owned
		ArrayList<Systems> systemsOwned = player.getSystemsOwned();
	
		for(Systems system : systemsOwned) {
			if((system.getDevelopmentLevel() !=6)) {
				if(system.getDevelopmentLevel() <3) {
					displayOwnershipOptions(player, system, scanner);
				}else {
					displayOwnershipOptionsMajor(player, system, scanner);
				}
				
			}
		}
		
		
	}

	/*
	 * Displays the player scoreboard, the player with the greatest total worth will
	 * be first
	 */

	public void playerScoreboard(List<Player> players) {

		Collections.sort(players, new CompareByTotalValue());

		int count = 1;

		for (Player player : players) {
			System.out.println(count + ".Player Name : " + player.getTeamName());
			System.out.println("Balance : " + player.getAmountOfResources());
			System.out.println("Number of Squares Owned : " + player.getSystemsOwned().size());
			player.displaySystemsOwned();
			System.out.println("Total Worth : " + player.getTotalWorth());
			System.out.println();
			count++;
		}
	}

	/*
	 * Displays the devlopment history of the game
	 */
	public void developmentHistory() {
		for (Integer week : developmentHistory.keySet()) {
			System.out.println("Week " + week + " : " + developmentHistory.get(week));
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("THE END !");
	}

}
