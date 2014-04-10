package com.kashu.learning.example.domain.annotation;

import java.io.Serializable;
import java.text.MessageFormat;

public class Bee implements Serializable {

	private Integer id;

	private String name;

	private Honey honey;

	public Bee() {

	}

	public Bee(String name) {
		this.name = name;
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

	/**
     * @return the honey
     */
	public Honey getHoney() {
		return honey;
	}

	/**
     * @param honey
     *            the honey to set
     */
	public void setHoney(Honey honey) {
		this.honey = honey;
	}

	public String toString() {
		return MessageFormat.format("{0}: id={1}, name={2}", new Object[] {
				getClass().getSimpleName(), id, name });
	}
}