package com.jugalpanchal.db.workflows;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.StatelessSession;

import com.jugalpanchal.db.entities.PersistentEntity;
import com.jugalpanchal.db.framework.Fixture;
import com.jugalpanchal.db.framework.StatefullUnitOfWork;
import com.jugalpanchal.db.framework.StatelessUnitOfWork;

public abstract class Workflow {

	public boolean saveByStatefull(PersistentEntity persistentEntity) throws Exception {
		boolean isSaved = false;
		Fixture fixture = null;
		try {
			fixture = new Fixture();

			Session statefullSession = fixture.getSession();
			StatefullUnitOfWork unitOfWork = new StatefullUnitOfWork(
					statefullSession);

			statefullSession.saveOrUpdate(persistentEntity);
			isSaved = unitOfWork.commit();

		} catch (Exception ex) {
			throw ex;
		} finally {
			fixture.closeSession();
		}
		return isSaved;
	}

	public boolean saveByStateless(PersistentEntity persistentEntity) throws Exception {
		boolean isSaved = false;
		Fixture fixture = null;
		try {
			fixture = new Fixture();
			StatelessSession statelessSession = fixture.getStatelessSession();
			StatelessUnitOfWork unitOfWork = new StatelessUnitOfWork(
					statelessSession);
			statelessSession.insert(persistentEntity);
			isSaved = unitOfWork.commit();

		} catch (Exception ex) {
			throw ex;
		} finally {
			fixture.closeStatelessSession();
		}
		return isSaved;
	}
	
	/*
	public <T> T get() {
		T persistentEntity = null;
		
		return persistentEntity;
	}
	
	public <T> List<T> getAll() {
		List<T> persistentEntities = null;
		
		return persistentEntities;
	}*/
}
