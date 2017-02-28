package com.jugalpanchal.db.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car extends PersistentEntity {

	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "model_id")
	private Model model;

	public Car() {
		
	}
	
	public Car(User createdByUser, Date creationDate, String name, Model model) {
		super(createdByUser, creationDate);
		this.name = name;
		this.model = model;
		this.model.addCar(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Model getModel() {
		return model;
	}
}