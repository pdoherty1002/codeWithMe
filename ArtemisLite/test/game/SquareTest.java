package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SquareTest {
	
	int positionOnBoard=2;
	
	Square square;
	SquareType squareType;

	@BeforeEach
	void setUp() throws Exception {
		
		squareType = SquareType.SYSTEM;
		square = new Square() {
		};
	}
	
	

	@Test
	void testGetSetSquareType() {
		square.setSquareType(squareType);
		assertEquals(SquareType.SYSTEM, square.getSquareType());
	}
	
	@Test
	void testGetSetSquarePositionOnBoard() {
		square.setSquarePositionOnBoard(positionOnBoard);
		assertEquals(positionOnBoard, square.getSquarePositionOnBoard());
	}
	


}
