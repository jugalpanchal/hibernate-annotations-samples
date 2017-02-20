package com.jugalpanchal.hibernate.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {
	
	@Id
	@GeneratedValue
	private long id;

	public BaseEntity() {
		
	}
	
	public long getId() {
		return id;
	}
}
