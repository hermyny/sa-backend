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
	
	
	@Column(unique = true)
	private String pseudo;
	
	@Column(unique = true)
	private String email;
	
	@Column
	private String password;
	
	
	private boolean isActive = false;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Role role;
	
	
	
	






	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+this.role.getName()));
	}

	
	@Override
    public String getPassword() {
        return this.password;
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
		return this.isActive;
	}




	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.isActive;
	}









	
	
	
	
	
}
