package com.jugalpanchal.app.workflows;

import java.util.List;

import org.hibernate.Session;

import com.jugalpanchal.db.entities.User;
import com.jugalpanchal.db.framework.Fixture;
import com.jugalpanchal.db.repositories.UserRepository;

public class UserWorkflow extends Workflow {

	public User get(long userId) throws Exception {
		User user = null;
		Fixture fixture = null;
		try {
			fixture = new Fixture();
			Session statefullSession = fixture.getSession();

			UserRepository repository = new UserRepository(statefullSession);
			user = repository.get(userId);

		} catch (Exception ex) {
			fixture.closeSessionFactory();
			throw ex;
		} finally {
			fixture.closeStatelessSession();
		}
		return user;
	}

	public List<User> getAll() throws Exception {
		List<User> users = null;
		Fixture fixture = null;
		try {
			fixture = new Fixture();
			Session statefullSession = fixture.getSession();

			UserRepository repository = new UserRepository(statefullSession);
			users = repository.getAll();

		} catch (Exception ex) {
			fixture.closeSessionFactory();
			throw ex;
		} finally {
			fixture.closeSession();
		}
		return users;
	}

}
