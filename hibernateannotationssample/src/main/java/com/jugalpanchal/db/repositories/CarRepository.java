package com.jugalpanchal.db.repositories;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.jugalpanchal.db.entities.Car;

public class CarRepository extends Repository<Car> {
	
	private Session session;

	public CarRepository(Session statefullSession) {
		super(statefullSession);
	}

	public List<?> getCarByCompanyIdAndReleaseDate(long companyId, Date carReleaseDate) {
		
		List<?> cars = this.session.createQuery("select car from Car car where car.releasedate = :carReleaseDate and car.company.id = :companyId")
					.setParameter("carReleaseDate", carReleaseDate)
					.setParameter("companyId", companyId)
					.list();
		return cars;
	}
}