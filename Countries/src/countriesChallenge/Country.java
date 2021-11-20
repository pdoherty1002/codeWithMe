package countriesChallenge;


public class Country {

	/**
	 * Name of the country
	 */
	private String countryName;
	/**
	 * Name of the countries region
	 */
	private String region;
	/**
	 * population in millions
	 */
	private int population;
	/**
	 * Country area in sq. miles
	 */
	private int area;
	/**
	 * density
	 */
	private double density;

	/**
	 * default constructor
	 */
	public Country() {

	}

	/**
	 * Constructor with args
	 * 
	 * @param countryName
	 * @param region
	 * @param population
	 * @param area
	 */
	public Country(String countryName, String region, int population, int area, double density) {
		this.countryName = countryName;
		this.region = region;
		this.population = population;
		this.area = area;
		this.density = density;
	}

	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @return the population
	 */
	public int getPopulation() {
		return population;
	}

	/**
	 * @param population the population to set
	 */
	public void setPopulation(int population) {
		this.population = population;
	}

	/**
	 * @return the area
	 */
	public int getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(int area) {
		this.area = area;
	}

	/**
	 * @return the density
	 */
	public double getDensity() {
		return density;
	}

	/**
	 * @param density the density to set
	 */
	public void setDensity(double density) {
		this.density = density;
	}
	
	public void countryAndRegion() {
		System.out.println(this.countryName + " is found in the selected region : "+this.getRegion());
		System.out.println();
	}
	
	public void countryByPopulation() {
		System.out.println(this.population+" for : "+this.countryName);
		System.out.println();
	}
	
	public void densityAndCountry() {
		System.out.printf("%.2f    %s",this.getDensity(),this.getCountryName());
		System.out.println();
	}
	

	/**
	 * 
	 */
	public void displayAll() {
		System.out.println("Name             : " + this.getCountryName());
		System.out.println("Region           : " + this.getRegion());
		System.out.println("Population       : " + this.getPopulation());
		System.out.println("Area             : " + this.getArea());
		System.out.printf("Density          : %.2f", this.getDensity());
		System.out.println("\n");
	}

}
