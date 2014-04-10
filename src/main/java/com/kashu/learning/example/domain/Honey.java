package com.kashu.learning.example.domain;
/**
 * Example class
 * @author Sebastian Hennebrueder
 * created Jan 16, 2006
 * copyright 2006 by http://www.laliluna.de
 */

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Honey implements Serializable {

	private Integer id;

	private String name;

	private String taste;

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