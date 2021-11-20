package game;


import java.util.LinkedList;
import java.util.Queue;

/*
 * Represents satellite and support system card
 */

public class SatelitesAndSupportSystems extends Systems {
	
	/*
	 * Queue of all the elements of the system that can be upgraded 
	 */
	
	private Queue<String> satelitesAndSupportElements = new LinkedList<>();
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
	
	public SatelitesAndSupportSystems(int squarePositionOnBoard) {
		this.setSquareType(SquareType.SYSTEM);
		this.setSystemType(SystemTypes.SATELITES_SUPPORT);
		this.setDevelopmentLevel(0);
		this.setCostToBuy(COST_TO_BUY);
		this.setSingleDevelopmentCost(SINGLE_DEVELOPMENT_COST);
		this.setSquarePositionOnBoard(squarePositionOnBoard);
		
		satelitesAndSupportElements.add("Lunar Surface Power");
		satelitesAndSupportElements.add("Lunanet Systems");
		satelitesAndSupportElements.add("Docking Station");
		satelitesAndSupportElements.add("Cargo Units");
		satelitesAndSupportElements.add("Communications Network");
		satelitesAndSupportElements.add("Foundation Surface Habitat");
	}
	
	@Override
	public Queue<String> getSystemElements() {
		return this.satelitesAndSupportElements;
	}

	

	

}
