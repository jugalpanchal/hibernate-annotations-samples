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
	
	public Car getCar(long carId) {//TODO: Remove method and get from base class.
		
		Car car = (Car)this.session.createQuery("select car from Car car where car.id= :carId")
				.setParameter("carId",carId)
				.uniqueResult();
		return car;
	}
	
	public List<?> getCars() {//TODO: Remove method and get from base class.
		
		List<?> cars = this.session.createQuery("select car from Car car").list();
		return cars;
	}

	public List<?> getCarByCompanyIdAndReleaseDate(long companyId, Date carReleaseDate) {
		
		List<?> cars = this.session.createQuery("select car from Car car where car.releasedate = :carReleaseDate and car.company.id = :companyId")
					.setParameter("carReleaseDate", carReleaseDate)
					.setParameter("companyId", companyId)
					.list();
		return cars;
	}
	
	public long getCarCount() {//TODO: Remove method and get from base class.
		long count = (Long) this.session.createQuery("select COUNT(*) from Car ")
				.uniqueResult();
		return count;
	}
}