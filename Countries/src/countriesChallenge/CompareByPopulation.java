package countriesChallenge;

import java.util.Comparator;

public class CompareByPopulation implements Comparator<Country> {

	@Override
	public int compare(Country c1, Country c2) {
		return c1.getPopulation() - c2.getPopulation();
	}
	

}
