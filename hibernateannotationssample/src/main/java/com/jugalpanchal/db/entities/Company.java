package com.jugalpanchal.db.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "company")
public class Company extends PersistentEntity {
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "company")
	@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private Collection<Model> models = new ArrayList<Model>();

	public Company() {
	}
	
	public Company(User createdByUser, Date creationDate, String name) {
		super(createdByUser, creationDate);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Collection<Model> getModels() {
		return models;
	}

	public void setModels(Collection<Model> models) {
		this.models = models;
	}
	
	void addModel(Model model) {
		this.models.add(model);
	}
}