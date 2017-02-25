package com.jugalpanchal.db.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.StatelessSession;

import com.jugalpanchal.db.entities.MediaData;

public class MediaDataRepository extends Repository<MediaData> {

	public MediaDataRepository(Session statefullSession) {
		super(statefullSession);
	}

	public MediaData getMediaData(StatelessSession statelessSession, long id) {

		MediaData mediaData = null;
		try {
			mediaData = (MediaData) statelessSession.createQuery("select m from MediaData m where m.id = :pId")
					.setParameter("pId", id)
					.uniqueResult();
		} catch (Exception ex) {
			throw ex;
		}
		return mediaData;
	}

	public List<?> getMediaDataList() {
		List<?> mediaDataList = null;
		try {
			mediaDataList = this.statefullSession.createQuery("select m from  MediaData  m")
					.list();

		} catch (Exception ex) {
			throw ex;
		}
		return mediaDataList;
	}

}
