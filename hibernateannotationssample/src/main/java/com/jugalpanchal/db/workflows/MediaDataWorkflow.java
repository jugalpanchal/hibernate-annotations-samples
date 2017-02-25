package com.jugalpanchal.db.workflows;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.imageio.ImageIO;

import org.hibernate.Session;
import org.hibernate.StatelessSession;

import com.jugalpanchal.db.entities.MediaData;
import com.jugalpanchal.db.framework.Fixture;
import com.jugalpanchal.db.framework.StatelessUnitOfWork;
import com.jugalpanchal.db.repositories.MediaDataRepository;

public class MediaDataWorkflow extends Workflow {

	public MediaData getMediaDataById(long mediaDataId) throws Exception {
		MediaData mediaData = null;
		Fixture fixture = null;
		try {
			fixture = new Fixture();
			StatelessSession statelessSession = fixture.getStatelessSession();

			MediaDataRepository repository = new MediaDataRepository();
			mediaData = repository.getMediaData(statelessSession, mediaDataId);

		} catch (Exception ex) {
			fixture.closeSessionFactory();
			throw ex;
		} finally {
			if (fixture != null)
				fixture.closeStatelessSession();
		}
		return mediaData;
	}

	public List<MediaData> getMediaDataList() throws Exception {

		List<MediaData> mediadataList = null;
		Fixture fixture = null;
		try {
			fixture = new Fixture();
			Session statefullSession = fixture.getSession();

			MediaDataRepository repository = new MediaDataRepository();
			mediadataList = repository.getMediaDataList(statefullSession);

		} catch (Exception ex) {
			fixture.closeSessionFactory();
			throw ex;
		} finally {
			if (fixture != null)
				fixture.closeSession();
		}
		return mediadataList;

	}

	public long saveMediaData(MediaData mediaData) throws Exception {
		long id = 0;
		Fixture fixture = null;
		try {
			fixture = new Fixture();
			StatelessSession statelessSession = fixture.getStatelessSession();

			StatelessUnitOfWork unitOfWork = new StatelessUnitOfWork(
					statelessSession);
			statelessSession.insert(mediaData);
			boolean isSaved = unitOfWork.commit();
			if (isSaved)
				id = mediaData.getId();
		} catch (Exception ex) {
			fixture.closeSessionFactory();
			throw ex;
		} finally {
			if (fixture != null)
				fixture.closeStatelessSession();
		}
		return id;
	}

	public byte[] convertToByteArray(InputStream uploadedInputStream)
			throws Exception {
		byte[] genericBlob = null;
		try {
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			int nRead;
			byte[] data = new byte[16384];
			while ((nRead = uploadedInputStream.read(data, 0, data.length)) != -1) {
				buffer.write(data, 0, nRead);
			}
			buffer.flush();
			genericBlob = buffer.toByteArray();
		} catch (Exception ex) {
			throw ex;
		}
		return genericBlob;
	}

	private void convertToByte() throws IOException {
		try {
			// URL url = new URL("https://google.com/images/Jersey_yellow.png");
			// BufferedImage bi = ImageIO.read(url);

			File fileToUpload = new File("D:/ClientExample/Albert.png");
			BufferedImage bi = ImageIO.read(fileToUpload);

			ByteArrayOutputStream bas = new ByteArrayOutputStream();
			ImageIO.write(bi, "png", bas);
			byte[] logo = bas.toByteArray();
		} catch (Exception ex) {
			throw ex;
		}
	}

	private void saveToFile(InputStream uploadedInputStream,
			String uploadedFileLocation) throws Exception {

		try {
			int read = 0;
			byte[] bytes = new byte[1024];

			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (Exception ex) {
			throw ex;
		}
	}
}
