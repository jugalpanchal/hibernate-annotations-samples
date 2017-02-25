package com.jugalpanchal.db.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("mission")
public class Mission extends Caption {

	public Mission() {
		super();
	}

	public Mission(User createdByUser, Date creationDate, String value) {
		super(createdByUser, creationDate, value);
	}
}
