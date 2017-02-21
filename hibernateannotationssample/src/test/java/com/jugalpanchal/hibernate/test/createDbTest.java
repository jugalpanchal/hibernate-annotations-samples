package com.jugalpanchal.hibernate.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import com.jugalpanchal.hibernate.infrastructure.Fixture;

public class createDbTest {

	@Test
	public void test() throws Exception {
		//It creates blank db.
		Fixture fixture = new Fixture();
		Session session = fixture.getSession();

		assertNotNull("Session is null.", session);
	}
}
