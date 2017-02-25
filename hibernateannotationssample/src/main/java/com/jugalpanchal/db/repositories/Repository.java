package com.jugalpanchal.db.repositories;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.StatelessSession;

import com.jugalpanchal.db.entities.PersistentEntity;
import com.jugalpanchal.db.entities.User;

public class Repository<T extends PersistentEntity> {
	
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
			ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		    Class<T> classType = (Class<T>) type.getActualTypeArguments()[0];
		    
			persistentEntity = (T)statefullSession.get(classType , id);
		} catch (Exception ex) {
			throw ex;
		}
		return persistentEntity;
	}

	public List<T> getAll() {
		
		List<T> persistentEntities = null;
		try {
			//persistentEntities = (T)statefullSession.get(T);

		} catch (Exception ex) {
			throw ex;
		}
		return persistentEntities;
	}
}
