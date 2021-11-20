/**
 * 
 */
package game;

import java.util.Comparator;


/**
 * Orders the players by their total worth (highest first)
 *
 */
public class CompareByTotalValue implements Comparator<Player> {

	@Override
	public int compare(Player o1, Player o2) {
		
		return o2.getTotalWorth() - o1.getTotalWorth();
	}

}
