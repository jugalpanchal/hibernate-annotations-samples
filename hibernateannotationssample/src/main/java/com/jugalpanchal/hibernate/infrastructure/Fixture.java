package com.jugalpanchal.hibernate.infrastructure;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.cfg.Configuration;

public class Fixture {

	private static SessionFactory factory;

	private Session session;
	private StatelessSession statelessSession;
	private String configFile = "hibernate.cfg.xml";

	public Fixture() throws Exception {

		if (Fixture.factory == null || (Fixture.factory.isClosed())) {
			Fixture.factory = this.buildSessionFactory();
		}
	}

	private SessionFactory buildSessionFactory() throws Exception {
		Configuration configuration = new Configuration();
		configuration.configure(this.configFile);

		return configuration.buildSessionFactory();
	}

	public Session getSession() throws Exception {
		this.closeSession();

		if (this.session == null)
			this.session = Fixture.factory.openSession();
		return this.session;
	}

	public StatelessSession getStatelessSession() throws Exception {
		this.closeStatelessSession();

		if (this.statelessSession == null)
			this.statelessSession = Fixture.factory.openStatelessSession();
		return this.statelessSession;
	}

	public void closeSession() throws Exception {
		if (this.session != null && this.session.isOpen()) {
			this.session.clear();
			this.session.close();
			this.session = null;
		}
	}

	public void closeStatelessSession() throws Exception {
		if (this.statelessSession != null) {
			this.statelessSession.close();
			this.statelessSession = null;
		}
	}

	public void closeSessionFactory() throws Exception {
		if (Fixture.factory != null && !Fixture.factory.isClosed()) {
			Fixture.factory.close();
			Fixture.factory = null;
		}
	}
}
