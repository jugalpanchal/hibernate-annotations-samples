package com.jugalpanchal.app.workflows;

import java.util.List;

import org.hibernate.Session;

import com.jugalpanchal.db.entities.MediaData;
import com.jugalpanchal.db.framework.Fixture;
import com.jugalpanchal.db.repositories.MediaDataRepository;

public class MediaDataWorkflow extends Workflow {

	public MediaData get(long mediaDataId) throws Exception {
		MediaData mediaData = null;
		Fixture fixture = null;
		try {
			fixture = new Fixture();
			Session statefullSession = fixture.getSession();

			MediaDataRepository repository = new MediaDataRepository(statefullSession);
			mediaData = repository.get(mediaDataId);

		} catch (Exception ex) {
			fixture.closeSessionFactory();
			throw ex;
		} finally {
			fixture.closeStatelessSession();
		}
		return mediaData;
	}

	public List<MediaData> getAll() throws Exception {

		List<MediaData> mediaDataList = null;
		Fixture fixture = null;
		try {
			fixture = new Fixture();
			Session statefullSession = fixture.getSession();

			MediaDataRepository repository = new MediaDataRepository(statefullSession);
			mediaDataList = repository.getAll();

		} catch (Exception ex) {
			fixture.closeSessionFactory();
			throw ex;
		} finally {
			fixture.closeSession();
		}
		return mediaDataList;
	}
}
