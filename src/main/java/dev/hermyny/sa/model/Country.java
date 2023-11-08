package dev.hermyny.sa.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String name;
	
	
	@OneToMany(
			mappedBy = "country" ,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE},
			orphanRemoval = true
			
			)
	List<Recipe> recipes = new ArrayList<>();
	
	
	
	@ManyToOne(
			cascade = {CascadeType.PERSIST, CascadeType.MERGE}
			)
	@JoinColumn(name = "continent_id")
	private Continent continent;
	
	
	
	public Country() {
		
	}
	



	public Country(int id, String name, List<Recipe> recipes, Continent continent) {
		super();
		this.id = id;
		this.name = name;
		this.recipes = recipes;
		this.continent = continent;
	}







	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}




	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", recipes=" + recipes + ", continent=" + continent + "]";
	}


	



	
	
	
}
