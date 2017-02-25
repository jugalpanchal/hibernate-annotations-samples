package com.jugalpanchal.db.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("vision")
public class Vision extends Caption {

	public Vision() {
		super();
	}

	public Vision(User createdByUser, Date creationDate, String value) {
		super(createdByUser, creationDate, value);
	}
}
