package dev.hermyny.sa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingredient")
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	public int id;
	
	@Column
	public String name;
	
	@Column
	public int calorie;
	
	@Column
	public int quantity;
	
	@Column
	public int price;
	
	@Column
	public String type;
	
	

}
