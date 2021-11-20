package game;

import java.util.Random;

/*
 * Represents Chance Square
 */

public class ChanceSquare extends Square {
	
	/*
	 * Creates square card
	 */
	public ChanceSquare(int squarePositionOnBoard) {
		this.setSquareType(SquareType.CHANCE);
		this.setSquarePositionOnBoard(squarePositionOnBoard);
	}
	
	/*
	 * Generates a random number between 1 and 3. The game class then deals with this value and processes
	 * the appropriate chance option (see game class - processChanceCard())
	 */
	
	public int generateChance() {
		Random random = new Random();
		int num = random.nextInt(3)+1;
		return num;
	}
	
	
	

}
