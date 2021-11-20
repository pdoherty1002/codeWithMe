package game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SystemsTest {
	
	String teamName;
	int costToBuy, singleDevelopmentCost, majorDevelopmentCost, developmentLevel, fineAmount;
	
	Systems system;
	Player player;
	SystemTypes systemType;

	@BeforeEach
	void setUp() throws Exception {
		

		systemType = SystemTypes.LUNAR_EXPLORATION;
		player = new Player();
		system = new Systems() {
			
			@Override
			public Queue<String> getSystemElements() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		teamName = "testName";
		costToBuy = 100;
		singleDevelopmentCost = 200;
		majorDevelopmentCost = 600;
		developmentLevel = 2;
		fineAmount = 100;
	}

	@Test
	void testgetSetSystemType() {
		system.setSystemType(systemType);
		assertEquals(SystemTypes.LUNAR_EXPLORATION, systemType);
	}

	@Test
	void testGetSetSystemOwner() {
		system.setSystemOwner(player);
		assertEquals(player, system.getSystemOwner());
	}

	@Test
	void testGetSetCostToBuy() {
		system.setCostToBuy(costToBuy);
		assertEquals(costToBuy, system.getCostToBuy());
	}

	@Test
	void testGetSetSingleDevelopmentCost() {
		system.setSingleDevelopmentCost(singleDevelopmentCost);
		assertEquals(singleDevelopmentCost, system.getSingleDevelopmentCost());
	}

	@Test
	void testGetSetMajorDevelopmentCost() {
		system.setMajorDevelopmentCost(majorDevelopmentCost);
		assertEquals(majorDevelopmentCost, system.getMajorDevelopmentCost());
	}

	@Test
	void testGetSetDevelopmentLevel() {
		system.setDevelopmentLevel(developmentLevel);
		assertEquals(developmentLevel, system.getDevelopmentLevel());
	}

	@Test
	void testGetSetFineAmount() {
		system.setFineAmount(fineAmount);
		assertEquals(fineAmount, system.getFineAmount());
	}

}
