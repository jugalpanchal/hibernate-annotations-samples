package com.jugalpanchal.db.framework;

import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

public class StatelessUnitOfWork extends UnitOfWork {

	private StatelessSession statelessSession;

	public StatelessUnitOfWork(StatelessSession statelessSession) {
		this.statelessSession = statelessSession;
	}

	protected Transaction getTransaction() {
		try {
			return this.statelessSession.beginTransaction();
		} catch (Exception ex) {
			throw ex;
		}
	}
}
