package com.jugalpanchal.db.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company extends PersistentEntity {
	
	@Column(name = "name")
	private String name;
	
	public Company(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
