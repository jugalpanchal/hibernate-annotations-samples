package com.jugalpanchal.db.workflows;

import org.hibernate.Session;

import com.jugalpanchal.db.entities.Caption;
import com.jugalpanchal.db.entities.Mission;
import com.jugalpanchal.db.entities.Vision;
import com.jugalpanchal.db.framework.Fixture;
import com.jugalpanchal.db.framework.StatefullUnitOfWork;
import com.jugalpanchal.db.repositories.CaptionRepository;

public class CaptionWorkflow {

	public boolean save(Caption caption) throws Exception {
		boolean isSaved = false;
		Fixture fixture = null;
		try {
			fixture = new Fixture();

			Session statefullSession = fixture.getSession();
			StatefullUnitOfWork unitOfWork = new StatefullUnitOfWork(
					statefullSession);

			statefullSession.saveOrUpdate(caption);
			isSaved = unitOfWork.commit();

		} catch (Exception ex) {
			fixture.closeSessionFactory();
			throw ex;
		} finally {
			if (fixture != null)
				fixture.closeSession();
		}
		return isSaved;
	}

	public Vision getVision() throws Exception {
		Vision vision = null;
		Fixture fixture = null;
		try {
			
			fixture = new Fixture();
			//String str = fixture.getDate();
			Session statefullSession = fixture.getSession();

			CaptionRepository repository = new CaptionRepository();
			vision = repository.getVision(statefullSession);

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

			CaptionRepository repository = new CaptionRepository();
			mission = repository.getMission(statefullSession);

		} catch (Exception ex) {
			fixture.closeSessionFactory();
			throw ex;
		} finally {
			fixture.closeSession();
		}
		return mission;
	}
}
