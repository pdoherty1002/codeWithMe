package game;

/*
 * Represents Blank Card
 */

public class Blank extends Square {
	
	public Blank(int squarePositionOnBoard) {
		this.setSquareType(SquareType.DEEP_SPACE);
		this.setSquarePositionOnBoard(squarePositionOnBoard);
	}

}
