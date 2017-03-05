package com.jugalpanchal.db.repositories;

import org.hibernate.Session;
import com.jugalpanchal.db.entities.PersistentEntity;

public abstract class Repository<T extends PersistentEntity> {
	
	protected Session statefullSession;

	public Session getStatefullSession() {
		return statefullSession;
	}

	public Repository(Session statefullSession) {
		this.statefullSession = statefullSession;
	}
	
	/*public T get(long id) {

		T persistentEntity = null;
		try {
			//Issue: Java doesn't support. wait for java update to support it.
			//Generics are not reified at run-time. This means the information is not present at run-time.
			//http://stackoverflow.com/questions/3403909/get-generic-type-of-class-at-runtime
			//persistentEntity = (T)statefullSession.get(classType , id);
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
	}*/
}
