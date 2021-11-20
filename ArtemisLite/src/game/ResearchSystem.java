package game;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Represents research system card
 */
public class ResearchSystem extends Systems {
	
	/*
	 * Queue of all the elements of the system that can be upgraded 
	 */
	
	private Queue<String> researchElements = new LinkedList<>();
	public static final int COST_TO_BUY = 50;
	public static final int SINGLE_DEVELOPMENT_COST = 100;
	
	
	
	/*
	 * Constructor - assigns the squares type and the cost to buy/develop as well 
	 * as adding elements that can be upgraded to a queue. Each item will be polled
	 * when developed until the system reaches max development level/no more items 
	 * remain in queue
	 */
	public ResearchSystem(int squarePositionOnBoard) {
		this.setSystemType(SystemTypes.RESEARCH);
		this.setSquareType(SquareType.SYSTEM);
		this.setDevelopmentLevel(0);
		this.setCostToBuy(COST_TO_BUY); //fix
		this.setSingleDevelopmentCost(SINGLE_DEVELOPMENT_COST);
		this.setFineAmount(0); //initially will be 0 will incremeent to the cost of each upgrade
		this.setSquarePositionOnBoard(squarePositionOnBoard);
		
		researchElements.add("Flight Simulations");
		researchElements.add("Trial Launches");
		researchElements.add("Crew Training");
		researchElements.add("Laboratory Analysis");
		researchElements.add("Alternative fuel research");
		researchElements.add("Space Suit Development");
		
		
	}

	@Override
	public Queue<String> getSystemElements() {
		return this.researchElements;
	}

}
