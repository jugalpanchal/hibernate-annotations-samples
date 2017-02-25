package com.jugalpanchal.db.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jugalpanchal.db.contracts.IActivateEntity;
import com.jugalpanchal.db.contracts.IPersistentEntity;
import com.jugalpanchal.db.contracts.IUser;

@MappedSuperclass
public class PersistentEntity implements IPersistentEntity, IActivateEntity {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date_time")//, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false, updatable = false)
	private Date creationDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updation_date_time")//, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false, updatable = true)
	private Date updationDate;
	
	@ManyToOne
	@JoinColumn(name = "created_by_user_id")
	private User createdByUser;
	
	@ManyToOne
	@JoinColumn(name = "updated_by_user_id")
	private User updatedByUser;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	public PersistentEntity() {
		this.isActive = true;//Default active
	}
	
	public PersistentEntity(User createdByUser, Date creationDate) {
		this();
		this.createdByUser = createdByUser;
		this.creationDate = creationDate;
	}
	
	public long getId() {
		return id;
	}
	
	/*@PrePersist
	protected void onCreate() {
		this.creationDate = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updationDate = new Date();
	}*/

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public Date getUpdationDate() {
		return updationDate;
	}

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