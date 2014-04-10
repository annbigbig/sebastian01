package com.kashu.learning.example.domain.annotation;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="thoney")
public class Honey implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String name;

	private String taste;

	@OneToMany(mappedBy="honey")
	private Set<Bee> bees = new HashSet<Bee>();

	public Honey() {

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

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	/**
     * @return the bees
     */
	public Set<Bee> getBees() {
		return bees;
	}

	/**
     * @param bees
     *            the bees to set
     */
	public void setBees(Set<Bee> bees) {
		this.bees = bees;
	}

	public String toString() {
		return "Honey: " + getId() + " Name: " + getName() + " Taste: "
				+ getTaste();
	}

}