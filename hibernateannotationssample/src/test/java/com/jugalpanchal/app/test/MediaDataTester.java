package com.jugalpanchal.app.test;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jugalpanchal.app.workflows.MediaDataWorkflow;
import com.jugalpanchal.app.workflows.UserWorkflow;
import com.jugalpanchal.db.entities.MediaData;
import com.jugalpanchal.db.entities.User;

public class MediaDataTester {
	
	private static User USER;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		UserWorkflow workflow = new UserWorkflow();
		MediaDataTester.USER = workflow.get(1L);
	}
	
	@Test
	public void saveBlobtest() throws Exception {

		byte[] genericBlob = null;
		MediaData mediaData = new MediaData(USER, new Date(), genericBlob, "image", ".jpg");

		MediaDataWorkflow workflow = new MediaDataWorkflow();
		boolean isSaved = workflow.saveByStatefull(mediaData);
		
		assertTrue("Company is not saved.", isSaved);
	}
}
