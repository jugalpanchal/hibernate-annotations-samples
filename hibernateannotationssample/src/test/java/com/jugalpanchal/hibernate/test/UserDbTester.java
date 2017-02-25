package com.jugalpanchal.hibernate.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jugalpanchal.db.entities.User;
import com.jugalpanchal.db.workflows.UserWorkflow;

public class UserDbTester {

	private static User USER;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		//There is one default user in db via initial_data.sql
		UserWorkflow workflow = new UserWorkflow();
		User user = workflow.get(1L);
		USER = user;
	}
	
	@Test
	public void getUser() throws Exception {

		UserWorkflow workflow = new UserWorkflow();
		User user = workflow.get(1L);
		assertNotNull("User is not available.", user);
	}
	
	@Test
	public void getUsers() throws Exception {

		UserWorkflow workflow = new UserWorkflow();
		List<User> users = workflow.getAll();
		assertNotNull("Users are not available.", users);
	}

	@Test
	public void saveUser() throws Exception {

		User user = new User(UserDbTester.USER, new Date(), "Jugal");
		UserWorkflow workflow = new UserWorkflow();
		Boolean isSaved = workflow.saveByStatefull(user);
		assertTrue("User is saved.", isSaved);
	}
}
