package com.jugalpanchal.db.framework;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class StatefullUnitOfWork extends UnitOfWork {

	private Session session;

	public StatefullUnitOfWork(Session session) {
		this.session = session;
	}

	protected Transaction getTransaction() {
		try {
			return this.session.beginTransaction();
		} catch (Exception ex) {
			throw ex;
		}
	}
}