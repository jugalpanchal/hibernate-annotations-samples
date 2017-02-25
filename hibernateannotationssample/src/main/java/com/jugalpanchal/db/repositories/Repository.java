package com.jugalpanchal.db.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.StatelessSession;

public abstract class Repository<T> {
	
	protected Session statefullSession;

	public Session getStatefullSession() {
		return statefullSession;
	}

	public Repository(Session statefullSession) {
		this.statefullSession = statefullSession;
	}
	
	public T get(long id) {

		T persistentEntity = null;
		try {
			//persistentEntity = (T)statefullSession.get(T, new Integer(id));
		} catch (Exception ex) {
			throw ex;
		}
		return persistentEntity;
	}

	public List<?> getAll() {
		
		List<?> persistentEntities = null;
		try {
			//persistentEntities = (T)statefullSession.get(T);

		} catch (Exception ex) {
			throw ex;
		}
		return persistentEntities;
	}
}
