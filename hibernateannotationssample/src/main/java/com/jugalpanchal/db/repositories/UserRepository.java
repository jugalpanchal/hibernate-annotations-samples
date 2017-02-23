package com.jugalpanchal.db.repositories;

import org.hibernate.Session;

import com.jugalpanchal.db.entities.User;

public class UserRepository {
	
	private Session session;

	public UserRepository(Session session) {
		this.session = session;
	}
	
	public User getUser(long userId) {
		
		User user = (User)this.session.createQuery("select user from User user where user.id= :userId")
				.setParameter("userId",userId)
				.uniqueResult();
		return user;
	}
}
