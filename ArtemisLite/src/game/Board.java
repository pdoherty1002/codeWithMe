package game;

import java.util.ArrayList;

/*
 * Represents the games board
 */

public class Board {
	
	/*
	 * Arraylist of all the squares on the board and a final int var indicating the number of squares
	 * that are systems
	 */
	
	private ArrayList<Square> squares = new ArrayList<>();
	private final int numberOfSystemSquares = 10;
	
	/*
	 * Creates the board. Adds the board squares to the list squares
	 */
	
	public Board() {
		//create the board 
		squares.add(new GoSquare(0));
		squares.add(new ResearchSystem(1));
		squares.add(new ResearchSystem(2));
		squares.add(new ChanceSquare(3));
		squares.add(new GroundSystems(4));
		squares.add(new GroundSystems(5));
		squares.add(new Blank(6));
		squares.add(new LunarExplorationSystem(7));
		squares.add(new LunarExplorationSystem(8));
		squares.add(new LunarExplorationSystem(9));
		squares.add(new ChanceSquare(10));
		squares.add(new SatelitesAndSupportSystems(11));
		squares.add(new SatelitesAndSupportSystems(12));
		squares.add(new SatelitesAndSupportSystems(13));
		squares.add(new Blank(14));
		squares.add(new ChanceSquare(15));
	}
	
	/*
	 * Returns square type
	 */
	
	public Square getSquare(int position) {
		return squares.get(position);
	}

	/**
	 * @return the squares
	 */
	public ArrayList<Square> getBoard() {
		return squares;
	}
	
	/**
	 * @return the numberOfSystemSquares
	 */
	public int getNumberOfSystemSquares() {
		return numberOfSystemSquares;
	}
	
	
	/*
	 * CHecks if all systems on the board are fully developed
	 */
	public boolean isBoardComplete() {
		int numFullyDeveloped = 0;
		for(Square square : squares) {
			if(square instanceof Systems) {
				Systems system = (Systems) square;
				if(system.getDevelopmentLevel() == 6) {
					numFullyDeveloped++;
				}
			}
		}
		return numFullyDeveloped == getNumberOfSystemSquares();
	}

	
	

}
