package com.jugalpanchal.db.repositories;

import java.util.List;

import org.hibernate.Session;
import com.jugalpanchal.db.entities.MediaData;

public class MediaDataRepository extends Repository<MediaData> {

	public MediaDataRepository(Session statefullSession) {
		super(statefullSession);
	}

	public MediaData get(long id) {

		MediaData mediaData = null;
		try {
			mediaData = (MediaData)this.statefullSession.createQuery("select m from MediaData m where m.id = :pId")
					.setParameter("pId", id)
					.uniqueResult();
		} catch (Exception ex) {
			throw ex;
		}
		return mediaData;
	}

	public List<MediaData> getAll() {
		List<MediaData> mediaDataList = null;
		try {
			mediaDataList = this.statefullSession.createQuery("select m from  MediaData  m")
					.list();

		} catch (Exception ex) {
			throw ex;
		}
		return mediaDataList;
	}

}
