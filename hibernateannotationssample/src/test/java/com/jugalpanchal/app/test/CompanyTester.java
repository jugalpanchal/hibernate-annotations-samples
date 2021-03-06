package com.jugalpanchal.app.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.jugalpanchal.app.workflows.CompanyWorkflow;
import com.jugalpanchal.app.workflows.UserWorkflow;
import com.jugalpanchal.db.entities.Car;
import com.jugalpanchal.db.entities.Company;
import com.jugalpanchal.db.entities.Model;
import com.jugalpanchal.db.entities.User;
import com.jugalpanchal.db.framework.Fixture;
import com.jugalpanchal.db.framework.StatefullUnitOfWork;
import com.jugalpanchal.db.repositories.CompanyRepository;

public class CompanyTester {

	private static User USER;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		UserWorkflow workflow = new UserWorkflow();
		USER = workflow.get(1L);
	}
	
	@Test
	public void saveCompanyTest() throws Exception {

		Company company = new Company(USER, new Date(), "Hyundai");

		Model model1 = new Model(USER, new Date(), "Sonata", company);//Change to bidirection method
		Model model2 = new Model(USER, new Date(), "Accent", company);
		
		Car car1 = new Car(USER, new Date(), "SE", model1);
		Car car2 = new Car(USER, new Date(), "Eco", model1);
		Car car3 = new Car(USER, new Date(), "Sport", model2);
		
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
	
	@Ignore
	@Test
	public void getCompanyTest() throws Exception {
		CompanyWorkflow workflow = new CompanyWorkflow();
		Company company = workflow.get(1L);
		assertNotNull("There is no company.", company);
	}
	
	@Test
	public void getCompaniesTest() throws Exception {
		CompanyWorkflow workflow = new CompanyWorkflow();
		List<Company> companies = workflow.getAll();
		assertNotNull("There is no company.", companies);
	}
	
	@Ignore
	@Test
	public void modifiedCompanyTest() throws Exception {

		long companyId = 1;
		
		boolean isUpdated;
		Fixture fixture = null;
		
		try {
			fixture = new Fixture();
			Session session= fixture.getSession();
			
			CompanyRepository repository = new CompanyRepository(session);
			Company company = repository.get(companyId);
			
			company.setName("NewName");

			StatefullUnitOfWork unitOfWork = new StatefullUnitOfWork(session);
			session.update(company);
			isUpdated = unitOfWork.commit();
			
		} catch (Exception ex) {
			fixture.closeSessionFactory();
			throw ex;
		} finally {
			fixture.closeSession();
		}
		assertTrue("Company is not updated.", isUpdated);	
	}
	
	@Test
	public void deleteCompanyTest() throws Exception {
		
	}
}
