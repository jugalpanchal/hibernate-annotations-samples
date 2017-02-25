package com.jugalpanchal.hibernate.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jugalpanchal.db.entities.Car;
import com.jugalpanchal.db.entities.Company;
import com.jugalpanchal.db.entities.Model;
import com.jugalpanchal.db.entities.User;
import com.jugalpanchal.db.framework.Fixture;
import com.jugalpanchal.db.framework.StatefullUnitOfWork;
import com.jugalpanchal.db.framework.StatelessUnitOfWork;
import com.jugalpanchal.db.repositories.UserRepository;

public class CompanyDbTransactionTester {
	
	private static User USER;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		User user = new User("Jugal");
		
		Fixture fixture = null;
		boolean isSaved = false;
		try {
			fixture = new Fixture();
			StatelessSession session = fixture.getStatelessSession();
			
			StatelessUnitOfWork unitOfWork = new StatelessUnitOfWork(session);
			session.insert(user);
			isSaved = unitOfWork.commit();
			
		} catch (Exception ex) {
			fixture.closeSessionFactory();
			throw ex;
		}finally {
			CompanyDbTransactionTester.USER = user;//Holds to tear down object.
			fixture.closeSession();
		}
		assertTrue("User is not saved.", isSaved);
	}
 
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		Fixture fixture = null;
		boolean isDeleted = false;
		try {
			fixture = new Fixture();
			Session session = fixture.getSession();
			UserRepository repository = new UserRepository(session);
			User user = repository.getUser(CompanyDbTransactionTester.USER.getId());
			
			StatefullUnitOfWork unitOfWork = new StatefullUnitOfWork(session);
			session.delete(user);
			isDeleted = unitOfWork.commit();
			
		} catch (Exception ex) {
			fixture.closeSessionFactory();
			throw ex;
		}finally {
			fixture.closeSession();
		}
		assertTrue("User is not deleted.", isDeleted);
	}
	
	@Test
	public void getCompaniesTest() throws Exception {
		
	}
	
	@Test
	public void getCompanyTest() throws Exception {
		
	}
	
	@Test
	public void saveCompanyTest() throws Exception {

		//Get user and set to every entity.
		
		Company company = new Company(USER, "Hyundai");

		Model model1 = new Model(USER, "Sonata", company);
		Model model2 = new Model(USER, "Accent", company);
		
		Car car1 = new Car(USER, "SE", model1);
		Car car2 = new Car(USER, "Eco", model1);
		
		Car car3 = new Car(USER, "Sport", model2);
		
		Fixture fixture = null;
		boolean isSaved = false;
		try {
			fixture = new Fixture();
			Session session = fixture.getSession();
			
			StatefullUnitOfWork unitOfWork = new StatefullUnitOfWork(session);
			session.save(company);//saveOrUpdate
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
