package dev.hermyny.sa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String preparation;
	
	@Column
	private String duration;
	
	@Column
	private String difficulty;
	
	@Column
	private String budget;
	
	@Column
	private String image;
	
	
	
}
