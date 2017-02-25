package com.jugalpanchal.db.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("mission")
public class Mission extends Caption {

	public Mission() {
		super();
	}

	/*public Mission(Date creationDate, long creationUserId, String value) {
		super(creationDate, creationUserId, value);
	}*/
}
