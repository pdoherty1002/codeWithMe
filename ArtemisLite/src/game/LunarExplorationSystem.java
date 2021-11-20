package game;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Represents lunar exploration system card
 */

public class LunarExplorationSystem extends Systems {
	
	/*
	 * Queue of all the elements of the system that can be upgraded 
	 */
	
	private Queue<String> lunarExplorationElements = new LinkedList<>();
	
	/*
	 * Assigns the costs to buy/develop
	 */
	
	public static final int COST_TO_BUY = 100;
	public static final int SINGLE_DEVELOPMENT_COST = 200;
	
	
	/*
	 * Constructor - assigns the squares type and the cost to buy/develop as well 
	 * as adding elements that can be upgraded to a queue. Each item will be polled
	 * when developed until the system reaches max development level/no more items 
	 * remain in queue
	 */
	
	public LunarExplorationSystem(int squarePositionOnBoard) {
		this.setSquareType(SquareType.SYSTEM);
		this.setSystemType(SystemTypes.LUNAR_EXPLORATION);
		this.setDevelopmentLevel(0);
		this.setCostToBuy(COST_TO_BUY);
		this.setSingleDevelopmentCost(SINGLE_DEVELOPMENT_COST);
		this.setSquarePositionOnBoard(squarePositionOnBoard);
		
		
		lunarExplorationElements.add("Exploration Rover");
		lunarExplorationElements.add("Lunar Terrain Vehicle");
		lunarExplorationElements.add("Lunar Lander");
		lunarExplorationElements.add("Life Support Systems");
		lunarExplorationElements.add("Geology Tools");
		lunarExplorationElements.add("Service Module");
		
	}

	
	@Override
	public Queue<String> getSystemElements() {
		return lunarExplorationElements;
	}

}
