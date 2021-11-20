package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import countriesChallenge.Country;

class CountryTest {
	
	String countryName, regionName;
	int population, area;
	double density;
	
	Country country;

	@BeforeEach
	void setUp() throws Exception {
		countryName = "Ireland";
		regionName = "Europe";
		population = 5000000;
		area = 50000;
		density = population/area;
		
		country = new Country();
	}

	@Test
	void testCountryDefaultConstructor() {
		country = new Country();
		assertNotNull(country);
	}

	@Test
	void testCountryConstructorWithArgs() {
		country = new Country(countryName, regionName, population, area, density);
		assertNotNull(country);
	}

	@Test
	void testGetSetCountryName() {
		country.setCountryName(countryName);
		assertEquals(countryName, country.getCountryName());
	}

	@Test
	void testGetSetRegion() {
		country.setRegion(regionName);
		assertEquals(regionName, country.getRegion());
	}

	@Test
	void testGetSetPopulation() {
		country.setPopulation(population);
		assertEquals(population, country.getPopulation());
	}

	@Test
	void testSetArea() {
		country.setArea(area);
		assertEquals(area, country.getArea());
	}

	@Test
	void testSetDensity() {
		country.setDensity(density);
		assertEquals(density, country.getDensity());
	}

}
