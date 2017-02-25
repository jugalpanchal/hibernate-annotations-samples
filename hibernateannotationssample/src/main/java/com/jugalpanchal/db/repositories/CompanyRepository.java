package com.jugalpanchal.db.repositories;

import java.util.List;

import org.hibernate.Session;

import com.jugalpanchal.db.entities.Company;

public class CompanyRepository extends Repository<Company> {

	public CompanyRepository(Session statefullSession) {
		super(statefullSession);
	}

	public Company get(long companyId) {
		Company company = (Company)this.statefullSession.createQuery("select company from Company company where company.id= :companyId")
				.setParameter("companyId",companyId)
				.uniqueResult();
		return company;
	}

	public List<?> getAll() {
		List<?> companies = this.statefullSession.createQuery("select company from Company company")
				.list();
		return companies;
	}
}
