package game;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Represents Ground Systems card
 */
public class GroundSystems extends Systems {
	
	/*
	 * Queue of all the elements of the system that can be upgraded 
	 */
	
	
	private Queue<String> groundSystemElements = new LinkedList<>();
	
	/*
	 * Assigns the costs to buy/develop
	 */
	
	
	public static final int COST_TO_BUY = 100;
	public static final int SINGLE_DEVELOPMENT_COST = 500;
	
	/*
	 * Constructor - assigns the squares type and the cost to buy/develop as well 
	 * as adding elements that can be upgraded to a queue. Each item will be polled
	 * when developed until the system reaches max development level/no more items 
	 * remain in queue
	 */
	
	public GroundSystems(int squarePositionOnBoard) {
		this.setSquareType(SquareType.SYSTEM);
		this.setSystemType(SystemTypes.GROUND_SYSTEMS);
		this.setDevelopmentLevel(0);
		this.setCostToBuy(COST_TO_BUY);
		this.setSingleDevelopmentCost(SINGLE_DEVELOPMENT_COST);
		this.setSquarePositionOnBoard(squarePositionOnBoard);
		
		//add the elements of the system
		groundSystemElements.add("Launch Pad");
		groundSystemElements.add("Landing Pad");
		groundSystemElements.add("Vehicle Assembly Units");
		groundSystemElements.add("Fuel Station");
		groundSystemElements.add("Communications System");
		groundSystemElements.add("Crawler Transport");
		
	}
	

	@Override
	public Queue<String> getSystemElements() {
		return groundSystemElements;
	}


	



}
