/**
 * 
 */
package game;

import java.util.Random;

/**
 * Represents two dice - each can roll a number between 1 and 6
 *
 */
public class Dice {

	/**
	 * Default constructor
	 */
	public Dice() {

	}

	/**
	 * 
	 * @return - an int with the sum of the two randomly rolled dice.
	 */
	public int rollDice() {

		int sumOfDice = 0;

		Random random = new Random();

		sumOfDice = (random.nextInt(6) + 1) + (random.nextInt(6) + 1);

		return sumOfDice;
	}

}
