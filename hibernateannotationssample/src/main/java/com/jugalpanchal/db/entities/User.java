package com.jugalpanchal.db.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.jugalpanchal.db.contracts.IUser;

@Entity
@Table(name = "user")
public class User extends PersistentEntity implements IUser {
	
	@Column(name = "name")
	private String name;
	
	public User() {
	}
	
	public User(String name) {
		this();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}