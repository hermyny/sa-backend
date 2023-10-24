package dev.hermyny.sa.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingredient")
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	public int id;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(
	    name = "ingredient_recipe",
	    joinColumns = @JoinColumn(name = "ingredient_id"),
	    inverseJoinColumns = @JoinColumn(name = "recipe_id")
	)
	private List<Recipe> recipes = new ArrayList<>();
	
	
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

	public Ingredient() {
		
		// TODO Auto-generated constructor stub
	}

	public Ingredient(int id, List<Recipe> recipes, String name, int calorie, int quantity, int price, String type) {
		
		this.id = id;
		this.recipes = recipes;
		this.name = name;
		this.calorie = calorie;
		this.quantity = quantity;
		this.price = price;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCalorie() {
		return calorie;
	}

	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
	
	
	
	
	
	
	

}
