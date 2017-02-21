package com.jugalpanchal.db.framework;

import org.hibernate.Transaction;

public abstract class UnitOfWork {

	protected abstract Transaction getTransaction();

	public boolean commit() {
		Transaction tx = null;
		try {

			tx = getTransaction();
			tx.commit();

		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			throw ex;
		}
		return true;
	}
}