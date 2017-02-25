package com.jugalpanchal.db.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("vision")
public class Vision extends Caption {

	public Vision() {
		super();
	}

	/*public Vision(Date creationDate, long creationUserId, String value) {
		super(creationDate, creationUserId, value);
	}*/
}
