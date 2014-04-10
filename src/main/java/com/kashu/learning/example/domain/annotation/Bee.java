package com.kashu.learning.example.domain.annotation;

import java.io.Serializable;
import java.text.MessageFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbee")
public class Bee implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String name;

	@ManyToOne
	@JoinColumn(name="honey_id")
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