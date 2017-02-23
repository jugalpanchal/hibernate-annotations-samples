package com.jugalpanchal.db.entities;

import java.util.ArrayList;
import java.util.Collection;

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
	private Collection<Model> models;

	public Company() {
		this.models = new ArrayList<Model>();
	}
	
	public Company(String name) {
		this();
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
	
	public void addModel(Model model) {
		this.models.add(model);
	}
}