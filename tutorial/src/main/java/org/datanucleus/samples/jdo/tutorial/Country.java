package org.datanucleus.samples.jdo.tutorial;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Country {
	
	@PrimaryKey
	protected String name;
	
//	protected Long population;
	
//	protected BigDecimal percentAnnualGrowthRate;
//	
//	protected Long percentInUrbanAreas;
//	
//	protected Long fertilityRate;
//	
//	protected BigDecimal percentAdultLiteracy;
//	
//	protected Long grossNationalIncomePerCapita;
	
	public Country() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public Long getPopulation() {
//		return population;
//	}
//
//	public void setPopulation(Long population) {
//		this.population = population;
//	}
	
	public String toString() {
		return "Country: [name: "+this.getName()+"]";
	}
	
}
