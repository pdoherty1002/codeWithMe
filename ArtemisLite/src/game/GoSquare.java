package game;

/*
 * Represents Go Square
 */
public class GoSquare extends Square {
	
	/*
	 * reward for the player passing go
	 */
	
	public static final int PASS_GO_AWARD = 200;
	
	/*
	 * Constructor
	 */
	
	public GoSquare(int squarePositionOnBoard) {
		this.setSquareType(SquareType.SPACE_LAUNCH_HQ);
		this.setSquarePositionOnBoard(squarePositionOnBoard);
	}

}
