package com.jugalpanchal.hibernate.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jugalpanchal.db.entities.Mission;
import com.jugalpanchal.db.entities.User;
import com.jugalpanchal.db.entities.Vision;
import com.jugalpanchal.db.workflows.CaptionWorkflow;
import com.jugalpanchal.db.workflows.UserWorkflow;

public class CaptionDbTester {

	private static User USER;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		UserWorkflow workflow = new UserWorkflow();
		CaptionDbTester.USER = workflow.get(1L);
	}
	
	@Test
	public void visionGetTest() throws Exception {
		CaptionWorkflow workflow = new CaptionWorkflow();
		Vision vision = workflow.getVision();
		assertNotNull("Vision is null.", vision);
	}
	
	@Test
	public void missionGetTest() throws Exception {
		CaptionWorkflow workflow = new CaptionWorkflow();
		Mission mission = workflow.getMission();
		assertNotNull("Mission is null.", mission);
	}
	
	@Test
	public void visionSaveTest() throws Exception {
		Vision vision = new Vision(USER, new Date(), "This is vision.");
		CaptionWorkflow workflow = new CaptionWorkflow();
		boolean isSaved = workflow.saveByStatefull(vision);
		assertNotNull("Mission is not saved.", isSaved);
	}
	
	@Test
	public void missionSaveTest() throws Exception {
		Mission mission = new Mission(USER, new Date(), "This is mission.");
		CaptionWorkflow workflow = new CaptionWorkflow();
		boolean isSaved = workflow.saveByStatefull(mission);
		assertNotNull("Mission is not saved.", isSaved);
	}
}
