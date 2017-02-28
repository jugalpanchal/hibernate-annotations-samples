package com.jugalpanchal.db.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "model")
public class Model extends PersistentEntity {

	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "model")
	@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private Collection<Car> cars = new ArrayList<Car>();

	public Model() {
	}
	
	public Model(User createdByUser, Date creationDate, String name, Company company) {
		super(createdByUser, creationDate);
		this.name = name;
		this.company = company;
		this.company.addModel(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Company getCompany() {
		return company;
	}
	
	public Collection<Car> getCars() {
		return cars;
	}

	public void setCars(Collection<Car> cars) {
		this.cars = cars;
	}
	
	void addCar(Car car) {
		this.cars.add(car);
	}
}