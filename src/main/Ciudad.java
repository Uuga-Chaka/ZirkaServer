package main;

import java.io.Serializable;

public class Ciudad implements Serializable {

	private static final long serialVersionUID = 1L;

	private int oxigen;
	private int population;
	private int houses;
	private String name;

	public Ciudad(int oxigen, int population, int houses, String name) {
		this.oxigen = oxigen;
		this.houses = houses;
		this.population = population;
		this.name = name;
	}

	public int getOxigen() {
		return oxigen;
	}

	public void setOxigeno(int oxigen) {
		this.oxigen = oxigen;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public int getHouses() {
		return houses;
	}

	public void setHouses(int houses) {
		this.houses = houses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
