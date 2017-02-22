package com.jugalpanchal.db.entities;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.jugalpanchal.db.contracts.IPersistentEntity;
import com.jugalpanchal.db.contracts.IUser;

@MappedSuperclass
public abstract class PersistentEntity implements IPersistentEntity {
	
	@Id
	@GeneratedValue
	private long id;

	public PersistentEntity() {
		
	}
	
	public long getId() {
		return id;
	}

	@Override
	public Date getCreationDate() {
		return null;
	}

	@Override
	public Date getUpdationDate() {
		return null;
	}

	@Override
	public IUser getCreatedByUser() {
		return null;
	}

	@Override
	public IUser getModifiedByUser() {
		return null;
	}
}
