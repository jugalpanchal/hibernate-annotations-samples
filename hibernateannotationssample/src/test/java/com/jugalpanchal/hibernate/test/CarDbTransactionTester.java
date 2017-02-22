package com.jugalpanchal.hibernate.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.jugalpanchal.db.entities.Car;
import com.jugalpanchal.db.framework.Fixture;
import com.jugalpanchal.db.framework.StatefullUnitOfWork;
import com.jugalpanchal.db.repositories.CarRepository;

public class CarDbTransactionTester {

	@Test
	public void getCarsTest() throws Exception {
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
		assertNotNull("There is no car.", cars);
	}
	
	@Test
	public void getCarTest() throws Exception {
		
		long carId = 1;//Input
		
		Car car = null;
		Fixture fixture = null;
		try {
			fixture = new Fixture();
			Session session  = fixture.getSession();

			CarRepository repository = new CarRepository(session);
			car = repository.getCar(carId);

		} catch (Exception ex) {
			fixture.closeSessionFactory();
			throw ex;
		} finally {
			fixture.closeSession();
		}
		assertNotNull("There is no car.", car);
	}
	
	@Test
	public void addCarTest() throws Exception {
		
	}
	
	@Test
	public void modifiedCarTest() throws Exception {
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
		assertTrue("Car is not updated.", isUpdated);
	}
	
	@Test
	public void removeCarTest() throws Exception {
		
	}
}
