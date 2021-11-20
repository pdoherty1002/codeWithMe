package game;

/*
 * Represents the squares used on the board
 */

public abstract class Square {
	
		
	private SquareType squareType;
	private int squarePositionOnBoard;
	
	/**
	 * @return the squareType
	 */
	public SquareType getSquareType() {
		return squareType;
	}
	
	/**
	 * @param squareType the squareType to set
	 */
	public void setSquareType(SquareType squareType) {
		this.squareType = squareType;
	}

	/**
	 * @return the squarePositionOnBoard
	 */
	public int getSquarePositionOnBoard() {
		return squarePositionOnBoard;
	}

	/**
	 * @param squarePositionOnBoard the squarePositionOnBoard to set
	 */
	public void setSquarePositionOnBoard(int squarePositionOnBoard) {
		this.squarePositionOnBoard = squarePositionOnBoard;
	}
	

	
}
