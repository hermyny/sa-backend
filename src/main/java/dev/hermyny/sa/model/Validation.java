package dev.hermyny.sa.model;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "validation")
public class Validation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	private Instant creation;
	private Instant expire;
	private Instant activation;
	private String code;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Instant getCreation() {
		return creation;
	}

	public void setCreation(Instant creation) {
		this.creation = creation;
	}

	public Instant getExpire() {
		return expire;
	}

	public void setExpire(Instant expire) {
		this.expire = expire;
	}

	public Instant getActivation() {
		return activation;
	}

	public void setActivation(Instant activation) {
		this.activation = activation;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
