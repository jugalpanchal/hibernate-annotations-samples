package com.jugalpanchal.db.repositories;

import org.hibernate.Session;

import com.jugalpanchal.db.entities.Caption;
import com.jugalpanchal.db.entities.Mission;
import com.jugalpanchal.db.entities.Vision;

public class CaptionRepository extends Repository<Caption> {
	
	public CaptionRepository(Session statefullSession) {
		super(statefullSession);
	}

	public Vision getVision() {

		Vision vision = null;
		try {
			vision = (Vision) this.statefullSession.createQuery("select p from Vision p")
					.uniqueResult();

		} catch (Exception ex) {
			throw ex;
		}
		return vision;
	}

	public Mission getMission() {

		Mission mission = null;
		try {
			mission = (Mission) this.statefullSession.createQuery("select p from Mission p")
					.uniqueResult();

		} catch (Exception ex) {
			throw ex;
		}
		return mission;
	}
}
