package com.sb.gestoradb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class Unity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "O nome é necessário. Digite como a Unidade é conhecida popularmente.")
	@Length(min=3, max=100, message = "O nome deve conter entre 3 e 100 caracteres. Por Favor, digite outro.")
	private String name;
	
	@NotEmpty(message = "Uma breve descrição é necessária. Digite os meios de contato e o que a unidade oferece aos seus clientes.")
	@Length(min=5, max=2000000, message = "A descrição deve conter entre 5 e 2.000.000 caracteres. Por Favor, corrija o texto.")
	private String description;

	@OneToMany(mappedBy = "unity")
	private List<Player> players = new ArrayList<>();

	public Unity() {
		super();
	}

	public Unity(Integer id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Unity other = (Unity) obj;
		return Objects.equals(id, other.id);
	}

}
