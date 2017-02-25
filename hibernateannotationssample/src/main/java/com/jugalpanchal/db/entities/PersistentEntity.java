package com.jugalpanchal.db.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jugalpanchal.db.contracts.IActivateEntity;
import com.jugalpanchal.db.contracts.IPersistentEntity;
import com.jugalpanchal.db.contracts.IUser;

@MappedSuperclass
public abstract class PersistentEntity implements IPersistentEntity, IActivateEntity {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date_time", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false, updatable = false)
	private Date creationDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updation_date_time", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false, updatable = true)
	private Date updationDate;
	
	@Column(name = "created_by_user_id")
	private User createdByUser;
	
	@Column(name = "updated_by_user_id")
	private User updatedByUser;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	public PersistentEntity() {
		this.isActive = true;//Default active
	}
	
	public PersistentEntity(User createdByUser) {
		this();
		this.createdByUser = createdByUser;
	}
	
	public long getId() {
		return id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	@PrePersist
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdationDate() {
		return updationDate;
	}

	@PreUpdate
	public void setUpdationDate(Date updationDate) {
		this.updationDate = updationDate;
	}

	public IUser getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(User createdByUser) {
		this.createdByUser = createdByUser;
	}

	public IUser getUpdatedByUser() {
		return updatedByUser;
	}

	public void setUpdatedByUser(User updatedByUser) {
		this.updatedByUser = updatedByUser;
	}

	public boolean isActive() {
		return isActive;
	}
	
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
