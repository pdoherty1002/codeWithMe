package countriesChallenge;

import java.util.Comparator;

public class CompareByDensity implements Comparator<Country> {

	@Override
	public int compare(Country c1, Country c2) {
		return (int)c2.getDensity() - (int)c1.getDensity();
	}

}
