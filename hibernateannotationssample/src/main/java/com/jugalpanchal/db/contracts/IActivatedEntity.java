package com.jugalpanchal.db.contracts;

public interface IActivatedEntity extends IPersistentEntity {
	public boolean isActivated();
	public void setActivated(boolean isActivated);
}
