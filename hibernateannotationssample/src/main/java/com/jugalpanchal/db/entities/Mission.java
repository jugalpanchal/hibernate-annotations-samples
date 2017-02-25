package com.jugalpanchal.db.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("mission")
public class Mission extends Caption {

	public Mission() {
		super();
	}

	public Mission(User createdByUser, String value) {
		super(createdByUser, value);
	}
}
