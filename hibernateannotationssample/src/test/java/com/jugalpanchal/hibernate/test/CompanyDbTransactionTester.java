package com.jugalpanchal.hibernate.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import com.jugalpanchal.db.entities.Company;
import com.jugalpanchal.db.framework.Fixture;
import com.jugalpanchal.db.framework.StatefullUnitOfWork;

public class CompanyDbTransactionTester {
	
	@Test
	public void getCompaniesTest() throws Exception {
		
	}
	
	@Test
	public void getCompanyTest() throws Exception {
		
	}
	
	@Test
	public void saveCompanyTest() throws Exception {
		
		Company honda = new Company("Honda");
		
		Fixture fixture = null;
		boolean isSaved = false;
		try {
			fixture = new Fixture();
			Session session = fixture.getSession();
			
			StatefullUnitOfWork unitOfWork = new StatefullUnitOfWork(session);
			session.save(honda);//saveOrUpdate
			isSaved = unitOfWork.commit();
			
		} catch (Exception ex) {
			fixture.closeSessionFactory();
			throw ex;
		}finally {
			fixture.closeSession();
		}
		assertTrue("Company is not saved.", isSaved);
	}
	
	@Test
	public void modifiedCompanyTest() throws Exception {
		
	}
	
	@Test
	public void deleteCompanyTest() throws Exception {
		
	}
}
