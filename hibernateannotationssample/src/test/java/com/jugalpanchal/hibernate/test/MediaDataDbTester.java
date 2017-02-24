package com.jugalpanchal.hibernate.test;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jugalpanchal.db.entities.MediaData;
import com.jugalpanchal.db.framework.Fixture;
import com.jugalpanchal.db.framework.StatefullUnitOfWork;

public class MediaDataDbTester {
	
	@Test
	public void saveBlobtest() throws Exception {

		byte[] genericBlob = null;
		MediaData mediaData = new MediaData(new Date(), 0L, genericBlob, "image", ".jpg");

		Fixture fixture = null;
		boolean isSaved = false;
		try {
			fixture = new Fixture();
			Session session = fixture.getSession();

			StatefullUnitOfWork unitOfWork = new StatefullUnitOfWork(session);
			session.save(mediaData);// saveOrUpdate
			isSaved = unitOfWork.commit();

		} catch (Exception ex) {
			fixture.closeSessionFactory();
			throw ex;
		} finally {
			fixture.closeSession();
		}
		assertTrue("Company is not saved.", isSaved);
	}

	@Test
	public void getMediaByIdTest() {

		/*String path = "http://localhost:8080/ServiceModel/rest/mediadataservice/getmediadata";
		try {

			Client client = Client.create();
			WebResource webResource = client.resource(path + "/2");
			ClientResponse response = webResource.type("application/json").get(
					ClientResponse.class);

			String mediaDataJson = response.getEntity(String.class);
			// jsonData = jsonData.substring(13, jsonData.length() - 2);

			ObjectMapper mapper = new ObjectMapper();
			MediaData mediaData = mapper.readValue(mediaDataJson,
					MediaData.class);

			byte[] mediaBlob = mediaData.getGenericBlob();
			ByteArrayInputStream bis = new ByteArrayInputStream(mediaBlob);

			BufferedImage bi = ImageIO.read(bis);
			File file = new File("D:/ClientExample/test.jpg");
			ImageIO.write(bi, "jpg", file);

			// if (response.getStatus() != 200) {
			// response.getStatus()
			// }
		} catch (Exception ex) {
		}*/
	}

	@Test
	public void uploadImageTest() {
		/*String path = "http://localhost:8080/ServiceModel/rest/mediadataservice/uploadmediadata";

		try {

			// ClientBuilder.newBuilder().register(MultiPartFeature.class)
			Client client = Client.create();
			WebResource service = client.resource(path);

			File fileToUpload = new File("D:/ClientExample/Albert.png");

			if (fileToUpload != null) {
				MultiPart multiPart = new MultiPart()
						.bodyPart(
								new BodyPart("image", MediaType.TEXT_PLAIN_TYPE))
						// type - image or audio
						.bodyPart(
								new BodyPart("png", MediaType.TEXT_PLAIN_TYPE))
						// ext - image or audio
						.bodyPart(
								new BodyPart(fileToUpload,
										MediaType.APPLICATION_OCTET_STREAM_TYPE));//fileToUpload can be bytes

				ClientResponse response = service.type("multipart/mixed").post(
						ClientResponse.class, multiPart);

				System.out.println("Response Status : "
						+ response.getEntity(String.class));
			}
			client.destroy();

		} catch (Exception ex) {
		}*/
	}

	@Test
	public void uploadedImageInInputStreamTest() {
		/*String BASE_URI = "http://localhost:8080/ServiceModel/rest/mediadataservice/upload";

		try {
			Client client = Client.create();
			WebResource service = client.resource(BASE_URI);

			InputStream in = service.get(InputStream.class);
			BufferedImage bi = ImageIO.read(in);
			File file = new File("D:/ClientExample/test.jpg");
			ImageIO.write(bi, "jpg", file);

		} catch (Exception ex) {
		}*/
	}
	
	/*
	
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
	 */
}
