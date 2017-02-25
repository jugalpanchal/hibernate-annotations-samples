package com.jugalpanchal.db.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("vision")
public class Vision extends Caption {

	public Vision() {
		super();
	}

	public Vision(User createdByUser, String value) {
		super(createdByUser, value);
	}
}
