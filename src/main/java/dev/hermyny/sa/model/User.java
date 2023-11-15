package dev.hermyny.sa.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "visitor")
public class User implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2315846720029971732L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(
	    name = "user_recipe",
	    joinColumns = @JoinColumn(name = "user_id"),
	    inverseJoinColumns = @JoinColumn(name = "recipe_id")
	)

	private List<Recipe> recipes = new ArrayList<>();
	
	
	
	@Column
	private String name;
	
	
	@Column
	private String pseudo;
	
	@Column(unique = true)
	private String email;
	
	@Column
	private String password;
	
	
	private boolean isActive = false;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Role role;
	
	



	public int getId() {
		return id;
	}




	public List<Recipe> getRecipes() {
		return recipes;
	}




	public String getName() {
		return name;
	}




	public String getPseudo() {
		return pseudo;
	}




	public String getEmail() {
		return email;
	}
	



	@Override
	public String getPassword() {
		return password;
	}




	public boolean isActive() {
		return isActive;
	}




	


	

	public void setId(int id) {
		this.id = id;
	}




	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}


	

	public void setName(String name) {
		this.name = name;
	}




	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public void setPassword(String password) {
		this.password = password;
	}


	
	

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}




	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+this.role.getName()));
	}




	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}




	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return this.isActive;
	}




	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return this.isActive;
	}




	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}







	@Override
	public String toString() {
		return "User [id=" + id + ", recipes=" + recipes + ", name=" + name + ", pseudo=" + pseudo + ", email=" + email
				+ ", password=" + password + ", isActive=" + isActive + ", role=" + role + "]";
	}


	
	
	
	
	
}
