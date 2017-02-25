package com.jugalpanchal.db.repositories;

import org.hibernate.Session;

import com.jugalpanchal.db.entities.Mission;
import com.jugalpanchal.db.entities.Vision;

public class CaptionRepository {
	
	public Vision getVision(Session statefullSession) {

		Vision vision = null;
		try {
			vision = (Vision) statefullSession.createQuery(
					"select p from Vision p").uniqueResult();

		} catch (Exception ex) {
			throw ex;
		}
		return vision;
	}

	public Mission getMission(Session statefullSession) {

		Mission mission = null;
		try {
			mission = (Mission) statefullSession.createQuery(
					"select p from Mission p").uniqueResult();

		} catch (Exception ex) {
			throw ex;
		}
		return mission;
	}
}
