package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {
	
	String teamName;
	int amountOfResources, validPositionOnBoard, invalidPositionOnBoard,amountSpentOnDevelopments;
	Player player;
	Player player2;
	

	@BeforeEach
	void setUp() throws Exception {
		teamName = "validTeamName";
		amountOfResources = 2500;
		validPositionOnBoard = 2;
		invalidPositionOnBoard = 20;
		amountSpentOnDevelopments = 1000;
		
		player = new Player();
		player2 = new Player(teamName);
		
	}

	@Test
	void testPlayer() {
		assertNotNull(player);
	}

	@Test
	void testPlayerString() {
		assertNotNull(player2);
	}

	@Test
	void testGetSetAmountSpentOnDevelopments() {
		player.setAmountSpentOnDevelopments(amountSpentOnDevelopments);
		assertEquals(amountSpentOnDevelopments, player.getAmountSpentOnDevelopments());
	}

	@Test
	void testGetSetTeamName() {
		player.setTeamName(teamName);
		assertEquals(teamName, player.getTeamName());
	}

	@Test
	void testGetSetAmountOfResources() {
		player.setAmountOfResources(amountOfResources);
		assertEquals(amountOfResources, player.getAmountOfResources());
	}

	@Test
	void testGetSetPositionOnBoard() {
		player.setPositionOnBoard(validPositionOnBoard);
		assertEquals(validPositionOnBoard, player.getPositionOnBoard());
	}

}
