package com.jugalpanchal.hibernate.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import com.jugalpanchal.db.framework.Fixture;

public class schemaDbTester {

	@Test
	public void createDbTest() throws Exception {
		//It creates blank db.
		Fixture fixture = new Fixture();
		Session session = fixture.getSession();

		assertNotNull("Session is null.", session);
	}
}
