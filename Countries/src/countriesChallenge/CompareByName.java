package countriesChallenge;

import java.util.Comparator;

public class CompareByName implements Comparator<Country> {

	@Override
	public int compare(Country o1, Country o2) {
		return o1.getCountryName().compareTo(o2.getCountryName());
	}
	

}
