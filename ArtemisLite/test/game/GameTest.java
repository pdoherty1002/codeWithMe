package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {
	
	int numberOfPlayers;
	
	Game game;

	@BeforeEach
	void setUp() throws Exception {
		game = new Game();
		numberOfPlayers = 4;
	}

	@Test
	void testGame() {
		assertNotNull(game);
	}

	@Test
	void testGetSetNumberOfPlayers() {
		game.setNumberOfPlayers(numberOfPlayers);
		assertEquals(numberOfPlayers, game.getNumberOfPlayers());
	}


}
