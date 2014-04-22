package test;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;
import model.BaseDAO;
import model.RequisitionModel;

import org.hibernate.criterion.Criterion;
import org.hibernate.internal.util.compare.CalendarComparator;
import org.junit.Test;

import common.Utility;

import controller.form.RequisitionFormControllerImpl;
import database.Requisition;

public class RequisitionModelTest extends TestCase{
	RequisitionModel model;
	private RequisitionFormControllerImpl controller;
	BaseDAO<Requisition> dao = new BaseDAO<Requisition>(); 
	

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ArrayList<Criterion> list = new ArrayList<Criterion>();		
		controller = new RequisitionFormControllerImpl();
		model= new RequisitionModel(list, controller);
		
	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
		model=null;
		controller=null;
	}



	@Test
	public void testDeleteRequisition() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}


	@Test
	public void testSaveObject() {
		Requisition r = dao.list("select r from Requisition as r").get(0);	
		//r.setConfirmDate(Utility.myDate() );
		
		r.setConfirmId("test");
		model.saveObject(r);
		assertEquals(r.getConfirmId(),"test");
	}


	@Test
	public void testNewMaster() {
		fail("Not yet implemented");
	}

	@Test
	public void testNewDetail() {
		fail("Not yet implemented");
	}


	@Test
	public void testDeleteObserver() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotifyObserver() {
		fail("Not yet implemented");
	}

	@Test
	public void testRegisterObserver() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDetailsObjectArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveRequisition() {
		
		
	}

	

}
