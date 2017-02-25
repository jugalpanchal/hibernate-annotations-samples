package com.jugalpanchal.db.workflows;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.StatelessSession;

import com.jugalpanchal.db.entities.PersistentEntity;
import com.jugalpanchal.db.framework.Fixture;
import com.jugalpanchal.db.framework.StatefullUnitOfWork;
import com.jugalpanchal.db.framework.StatelessUnitOfWork;
import com.jugalpanchal.db.repositories.Repository;

public abstract class Workflow<T extends PersistentEntity> {

	public boolean saveByStatefull(T persistentEntity) throws Exception {
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
			fixture.closeSessionFactory();
			throw ex;
		} finally {
			fixture.closeSession();
		}
		return isSaved;
	}
	
	public boolean saveByStatefull(List<T> persistentEntities) throws Exception {
		boolean isSaved = false;
		Fixture fixture = null;
		try {
			fixture = new Fixture();

			Session statefullSession = fixture.getSession();
			StatefullUnitOfWork unitOfWork = new StatefullUnitOfWork(
					statefullSession);
			
			persistentEntities.forEach(persistentEntity -> {
				statefullSession.saveOrUpdate(persistentEntity);	
			});
			
			isSaved = unitOfWork.commit();

		} catch (Exception ex) {
			fixture.closeSessionFactory();
			throw ex;
		} finally {
			fixture.closeSession();
		}
		return isSaved;
	}

	public boolean saveByStateless(T persistentEntity) throws Exception {
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
			fixture.closeSessionFactory();
			throw ex;
		} finally {
			fixture.closeStatelessSession();
		}
		return isSaved;
	}
	
	
	public T get(long id) throws Exception {
		T persistentEntity = null;
		
		Fixture fixture = null;
		try {
			fixture = new Fixture();
			Session statefullSession = fixture.getSession();
			
			Repository<T> repository = new Repository<T>(statefullSession);
			persistentEntity = repository.get(id);
		} catch (Exception ex) {
			fixture.closeSessionFactory();
			throw ex;
		} finally {
			fixture.closeSession();
		}
		return persistentEntity;
	}
	
	public List<T> getAll() throws Exception {
		List<T> persistentEntities = null;
		
		Fixture fixture = null;
		try {
			fixture = new Fixture();
			Session statefullSession = fixture.getSession();
			
			Repository<T> repository = new Repository<T>(statefullSession);
			persistentEntities = repository.getAll();
		} catch (Exception ex) {
			fixture.closeSessionFactory();
			throw ex;
		} finally {
			fixture.closeSession();
		}
		return persistentEntities;
	}
}
