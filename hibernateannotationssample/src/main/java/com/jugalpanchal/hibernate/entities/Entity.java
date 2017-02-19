package com.jugalpanchal.hibernate.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public abstract class Entity {
	
	@Id
	@GeneratedValue
	private long id;

	public long getId() {
		return id;
	}
}
