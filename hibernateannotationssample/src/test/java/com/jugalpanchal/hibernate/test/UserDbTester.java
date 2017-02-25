package com.jugalpanchal.hibernate.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.jugalpanchal.db.entities.User;
import com.jugalpanchal.db.workflows.UserWorkflow;

public class UserDbTester {

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

		User user = new User(null, new Date(), "Jugal");
		UserWorkflow workflow = new UserWorkflow();
		Boolean isSaved = workflow.saveByStatefull(user);
		assertTrue("User is saved.", isSaved);
	}
	
	@Test
	public void saveUsers() throws Exception {

		/*List<User> users = new ArrayList<User>() {{
			add(new User(null, new Date(), "Jugal"));
			add(new User(null, new Date(), "John"));
			add(new User(null, new Date(), "Alan"));
		}};
		
		UserWorkflow workflow = new UserWorkflow();
		Boolean isSaved = workflow.saveByStatefull(users);
		assertTrue("User is saved.", isSaved);*/
	}
}
