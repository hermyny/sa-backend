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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	
	@ManyToMany( mappedBy = "recipes")
	private List<Ingredient> ingredients = new ArrayList<>();
	
	
	
	@ManyToMany(mappedBy = "recipes")
	private List<User> users = new ArrayList<>();
	
	
	
	@ManyToOne(
			cascade = {CascadeType.PERSIST, CascadeType.MERGE}
			)
	@JoinColumn(name = "country_id")
	private Country country;
	
	
	
	@ManyToOne(
			cascade = {CascadeType.PERSIST, CascadeType.MERGE}
			)
	@JoinColumn(name = "category_id")
	private Category category;
	
	
	
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
	
	
	public Recipe() {
		
	}


	public Recipe(int id, List<Ingredient> ingredients, List<User> users, Country country, Category category,
			String name, String preparation, String duration, String difficulty, String budget, String image) {
		
		this.id = id;
		this.ingredients = ingredients;
		this.users = users;
		this.country = country;
		this.category = category;
		this.name = name;
		this.preparation = preparation;
		this.duration = duration;
		this.difficulty = difficulty;
		this.budget = budget;
		this.image = image;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	 
	public void addIngredient(Ingredient ingredient) {
		ingredients.add(ingredient);
		ingredient.getRecipes().add(this);
		
	}
	
	
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}


	
	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPreparation() {
		return preparation;
	}


	public void setPreparation(String preparation) {
		this.preparation = preparation;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public String getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}


	public String getBudget() {
		return budget;
	}


	public void setBudget(String budget) {
		this.budget = budget;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "Recipe [id=" + id + ", ingredients=" + ingredients + ", users=" + users + ", country=" + country
				+ ", category=" + category + ", name=" + name + ", preparation=" + preparation + ", duration="
				+ duration + ", difficulty=" + difficulty + ", budget=" + budget + ", image=" + image + "]";
	}


	
	
	
	
}
