package com.jugalpanchal.db.repositories;

import org.hibernate.Session;

import com.jugalpanchal.db.entities.Company;

public class CompanyRepository extends Repository<Company> {

	public CompanyRepository(Session statefullSession) {
		super(statefullSession);
	}

}
