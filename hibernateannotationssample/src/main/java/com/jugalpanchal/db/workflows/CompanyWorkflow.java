package com.jugalpanchal.db.workflows;

import java.util.List;

import org.hibernate.Session;
import com.jugalpanchal.db.entities.Company;
import com.jugalpanchal.db.framework.Fixture;
import com.jugalpanchal.db.repositories.CompanyRepository;

public class CompanyWorkflow {
	
	public Company getMediaDataById(long companyId) throws Exception {
		Company company = null;
		Fixture fixture = null;
		try {
			fixture = new Fixture();
			Session statefullSession = fixture.getSession();

			CompanyRepository repository = new CompanyRepository(statefullSession);
			company = repository.get(companyId);

		} catch (Exception ex) {
			fixture.closeSessionFactory();
			throw ex;
		} finally {
			fixture.closeStatelessSession();
		}
		return company;
	}

	public List<?> getMediaDataList() throws Exception {

		List<?> companies = null;
		Fixture fixture = null;
		try {
			fixture = new Fixture();
			Session statefullSession = fixture.getSession();

			CompanyRepository repository = new CompanyRepository(statefullSession);
			companies = repository.getAll();

		} catch (Exception ex) {
			fixture.closeSessionFactory();
			throw ex;
		} finally {
			fixture.closeSession();
		}
		return companies;
	}
}
