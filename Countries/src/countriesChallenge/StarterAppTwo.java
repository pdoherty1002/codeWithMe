package countriesChallenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StarterAppTwo {

	public static List<Country> countries = new ArrayList<>();

	public static final long MILLION = 1000000;

	public static void main(String[] args) {

		readInCountyFile();

		displayAllData(countries);

		countriesByregion(countries, "Europe");

		Collections.sort(countries, new CompareByPopulation());
		countriesByPopulation(countries);

		Collections.sort(countries, new CompareByPopulationD());
		countriesByPopulation(countries);

		countryWithHighestDensity(countries);

		averagePopulationPerRegion(countries, "europe");

		regionWithHighestPopulation(countries);

		countriesByPopulationDensity(countries);

		Collections.sort(countries, new CompareByDensity());
		densityAndCountry(countries);

		Collections.sort(countries, new CompareByName());
		countriesBeginWith(countries, "A");

		countriesLessThanOneMillion(countries);

		//topThreePopulation(countries);
		
		countriesByregion(countries, "Asia");
		
		countriesInRegionBeginWith(countries, "Asia", "c");
		
		getTotalPerRegion(countries);
		
		Collections.sort(countries, new CompareByDensity());
		densityAndCountry(countries);
	}

	/**
	 * Will read in and clean the data from the file
	 */
	public static void readInCountyFile() {

		File file = new File("countries.csv");

		FileReader fr;
		BufferedReader br;
		String countryInfo, region;
		String[] stats;

		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			// parse each data point - by comma
			// remove header values
			br.readLine();
			countryInfo = br.readLine();

			do {
				// create a country
				Country country = new Country();
				stats = countryInfo.split(",");

				// parse info into separate parts!

				// Country[0] region[1] population[2] area[3]
				// note the trim function is used to clean the data and remove any white spaces
				country.setCountryName(stats[0].trim());

				// REGION - get rid of caps and make all sub regions one region
				region = stats[1].trim();
				// change the format
				region = region.substring(0, 1).toUpperCase() + region.substring(1).toLowerCase();

				if (region.equalsIgnoreCase("eastern europe") || region.equalsIgnoreCase("western europe")) {
					country.setRegion("Europe");
				} else if (region.equalsIgnoreCase("sub-saharan africa")
						|| region.equalsIgnoreCase("northern africa")) {
					country.setRegion("Africa");
				} else {
					country.setRegion(region);
				}

				// remember the wrapper class need as data initially a string
				country.setPopulation(Integer.parseInt(stats[2]));

				country.setArea(Integer.parseInt(stats[3]));

				// now calculate the density
				country.setDensity((double) country.getPopulation() / country.getArea());

				// add to collection of countries
				countries.add(country);

				// read the next line
				countryInfo = br.readLine();

			} while (countryInfo != null);

			br.close();
			fr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param countries
	 */
	public static void displayAllData(Collection<Country> countries) {
		for (Country country : countries) {
			country.displayAll();
		}
	}

	public static void countriesByregion(Collection<Country> countries, String region) {
		System.out.println("Countries by region : " + region);
		System.out.println();
		for (Country country : countries) {
			if (country.getRegion().equalsIgnoreCase(region)) {
				country.countryAndRegion();
			}
		}
	}

	public static void countriesByPopulation(Collection<Country> countries) {
		for (Country country : countries) {
			country.countryByPopulation();
		}
	}

	public static void countryWithHighestDensity(Collection<Country> countries) {
		double highestDensity = 0;
		String highestDensityCountry = null;
		for (Country country : countries) {
			if (country.getDensity() > highestDensity) {
				highestDensity = country.getDensity();
				highestDensityCountry = country.getCountryName();
			}
		}
		System.out.printf("Country with the highes desnity is : %s \nWith a density of : %.2f", highestDensityCountry,
				highestDensity);
	}

	public static void averagePopulationPerRegion(Collection<Country> countries, String region) {
		int total = 0;
		int numberOfCountries = 0;
		double average = 0;
		for (Country country : countries) {
			if (country.getRegion().equalsIgnoreCase(region)) {
				total += country.getPopulation();
				numberOfCountries++;
			}
		}
		average = (double) total / numberOfCountries;

		System.out.printf("\nAverage population of %s is : %.0f", region, average);
		System.out.println();
	}

	public static void regionWithHighestPopulation(Collection<Country> countries) {
		List<Long> compare = new ArrayList<>();
		long totalA, totalE, totalAf, highest;
		String europe, asia, africa;
		totalA = 0;
		totalE = 0;
		totalAf = 0;
		highest = 0;
		europe = "Europe";
		asia = "Asia";
		africa = "Africa";
		for (Country country : countries) {
			if (country.getRegion().equalsIgnoreCase("Europe")) {
				totalE += country.getPopulation();
			} else if (country.getRegion().equalsIgnoreCase("Asia")) {
				totalA += country.getPopulation();
			} else if (country.getRegion().equalsIgnoreCase("Africa")) {
				totalAf += country.getPopulation();
			}
		}
		compare.add(totalA);
		compare.add(totalAf);
		compare.add(totalE);
		System.out.println(Collections.max(compare));

	}

	/**
	 * @deprecated please use densityAndCountry method
	 * @param countries
	 */
	public static void countriesByPopulationDensity(Collection<Country> countries) {
		Map<Double, String> myMap = new TreeMap<>();
		for (Country country : countries) {
			myMap.put(country.getDensity(), country.getCountryName());
		}
		for (Double key : myMap.keySet()) {
			System.out.printf("%.2f   %s", key, myMap.get(key));
			System.out.println();
		}
	}

	public static void densityAndCountry(Collection<Country> countries) {
		for (Country country : countries) {
			country.densityAndCountry();
		}
	}

	public static void countriesBeginWith(Collection<Country> countries, String firstLetter) {
		for (Country country : countries) {
			if (country.getCountryName().substring(0,1).equalsIgnoreCase(firstLetter)) {
				country.displayAll();
			}
		}
	}

	public static void countriesLessThanOneMillion(Collection<Country> countries) {
		for (Country country : countries) {
			if (country.getPopulation() < MILLION) {
				country.displayAll();
			}
		}
	}

	public static void countriesInRegionBeginWith(Collection<Country> countries, String region, String startsWith) {
		for(Country country : countries) {
			if(country.getRegion().equalsIgnoreCase(region) && country.getCountryName().substring(0,1).equalsIgnoreCase(startsWith)) {
				country.displayAll();
			}
		}
	}
	
	public static void getTotalPerRegion(Collection<Country> countries) {
		Map<String, Long> region = new HashMap<>();
		
		for(Country country : countries) {
			if(!region.containsKey(country.getRegion())) {
				region.put(country.getRegion(), (long)country.getPopulation());
			} else {
				Long currentpop = region.get(country.getRegion());
				Long updatepop = currentpop += (long)country.getPopulation();
				region.put(country.getRegion(), updatepop);
			}
		}
		System.out.println("Regions________");
		for(String r : region.keySet()) {
			System.out.println(r + " : "+region.get(r));
			System.out.println();
		}
	}

}
