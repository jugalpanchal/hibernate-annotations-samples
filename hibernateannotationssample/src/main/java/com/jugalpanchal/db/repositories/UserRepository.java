package com.jugalpanchal.db.repositories;

import java.util.List;

import org.hibernate.Session;

import com.jugalpanchal.db.entities.User;

public class UserRepository extends Repository<User> {
	
	public UserRepository(Session statefullSession) {
		super(statefullSession);
	}

	public User get(long userId) {
		
		User user = (User)this.statefullSession.createQuery("select user from User user where user.id= :userId")
				.setParameter("userId",userId)
				.uniqueResult();
		return user;
	}
	
	public List<User> getAll() {
		
		List<User> users = this.statefullSession.createQuery("select user from User user")
				.list();
		return users;
	}
}
