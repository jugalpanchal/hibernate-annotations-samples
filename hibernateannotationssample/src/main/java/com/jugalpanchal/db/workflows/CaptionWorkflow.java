package com.jugalpanchal.db.workflows;

import org.hibernate.Session;

import com.jugalpanchal.db.entities.Mission;
import com.jugalpanchal.db.entities.Vision;
import com.jugalpanchal.db.framework.Fixture;
import com.jugalpanchal.db.repositories.CaptionRepository;

public class CaptionWorkflow extends Workflow {

	public Vision getVision() throws Exception {
		Vision vision = null;
		Fixture fixture = null;
		try {
			
			fixture = new Fixture();
			Session statefullSession = fixture.getSession();

			CaptionRepository repository = new CaptionRepository(statefullSession);
			vision = repository.getVision();

		} catch (Exception ex) {
			fixture.closeSessionFactory();
			throw ex;
		} finally {
			fixture.closeSession();
		}
		return vision;
	}

	public Mission getMission() throws Exception {
		Mission mission = null;
		Fixture fixture = null;
		try {
			fixture = new Fixture();
			Session statefullSession = fixture.getSession();

			CaptionRepository repository = new CaptionRepository(statefullSession);
			mission = repository.getMission();

		} catch (Exception ex) {
			fixture.closeSessionFactory();
			throw ex;
		} finally {
			fixture.closeSession();
		}
		return mission;
	}
}
