package com.jugalpanchal.hibernate.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.jugalpanchal.db.entities.Car;
import com.jugalpanchal.db.entities.Company;
import com.jugalpanchal.db.framework.Fixture;
import com.jugalpanchal.db.framework.StatefullUnitOfWork;
import com.jugalpanchal.db.repositories.CarRepository;

public class TransactionDbTester {
	
	@Test
	public void getCarTest() throws Exception {
		List<?> cars = null;
		Fixture fixture = null;
		try {
			fixture = new Fixture();
			Session session  = fixture.getSession();

			CarRepository repository = new CarRepository(session);
			cars = repository.getCars();

		} catch (Exception ex) {
			fixture.closeSessionFactory();
			throw ex;
		} finally {
			fixture.closeSession();
		}
		assertNotNull(cars);
	}
	
	@Test
	public void addCompanyTest() throws Exception {
		
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
		
		long carId = 1;
		
		boolean isUpdated;
		Fixture fixture = null;
		
		try {
			fixture = new Fixture();
			Session session= fixture.getSession();
			
			CarRepository repository=new CarRepository(session);
			Car car = repository.getCar(carId);
			
			car.setName("NewName");

			StatefullUnitOfWork unitOfWork = new StatefullUnitOfWork(session);
			session.update(car);
			isUpdated = unitOfWork.commit();
			
		} catch (Exception ex) {
			fixture.closeSessionFactory();
			throw ex;
		} finally {
			fixture.closeSession();
		}
		assertTrue("", isUpdated);
	}
	
	@Test
	public void deleteCompanyTest() throws Exception {
		
	}
	
	@Test
	public void addCarTest() throws Exception {
		
	}
	
	@Test
	public void modifiedCarTest() throws Exception {
		
	}
	
	@Test
	public void removeCarTest() throws Exception {
		
	}
}
