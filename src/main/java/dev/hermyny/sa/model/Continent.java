package dev.hermyny.sa.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "continent")
public class Continent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	
	@Column
	private String name;
	
	@OneToMany(
			mappedBy = "continent" ,
			cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE},
			orphanRemoval = true
			
			)
	List<Country> countries = new ArrayList<>();
	
	
	
	
	public Continent() {
		
	}

	

	public Continent(int id, String name, List<Country> countries) {
		this.id = id;
		this.name = name;
		this.countries = countries;
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



	@Override
	public String toString() {
		return "Continent [id=" + id + ", name=" + name + ", countries=" + countries + "]";
	}
	
	
	
	
}
	
	
	

