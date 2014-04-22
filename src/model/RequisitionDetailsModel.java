package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;

import common.HibernateUtil;
import common.State;
import common.Utility;
import controller.form.RequisitionFormControllerImpl;
import database.Requisition;
import database.RequisitionDetails;

public class RequisitionDetailsModel implements IDataSet {

	private BaseDAO<RequisitionDetails>  requDetailsDAO= new BaseDAO<RequisitionDetails>();
	private RequisitionFormControllerImpl controller;
	private ArrayList<RequisitionDetails> currentDetails;
	private RequisitionDetails currentDetail;
	private DefaultTableModel tableDetailModel;
	private String[] detailsColumns;
	private ArrayList<Object[]>  detail;
	Session session;
	
	
	
	public RequisitionDetailsModel(RequisitionFormControllerImpl controller) {
		super();
		Object[][] realData;
		this.controller=controller;
		session= HibernateUtil.getSessionFactory().openSession();
		tableDetailModel = new DefaultTableModel(null, detailsColumns);
		
		detail = getDetailsObjectArray(getCurrentDetails());
		if (detail != null) {
			realData = detail.toArray(new Object[detail.size()][]);
			tableDetailModel.setDataVector(realData, detailsColumns);
		}
		
	}
	public void newDetail(Requisition master) {
		controller.getDetailObs().setState(State.INSERT);	
		
		RequisitionDetails details = new RequisitionDetails(master);
		details.setRequKind(Utility
				.getKindBySys2(master.getSysId()));

		currentDetail = details;
		currentDetails.add(details);

	}
	@Override
	public void update(Object o) {
		requDetailsDAO.update((RequisitionDetails) o);

	}

	@Override
	public void insert(Object o) {
		requDetailsDAO.create((RequisitionDetails) o);

	}

	@Override
	public void delete(Object o) {
		requDetailsDAO.delete((RequisitionDetails) o);

	}
	
	public void saveObject(Object o) {		
		if (controller.getDetailObs().getState() == State.INSERT)
			insert(o);
		else 
			update(o);
	}
	public ArrayList<RequisitionDetails> getCurrentDetails() {
		return currentDetails;
	}

	public void setCurrentDetails(ArrayList<RequisitionDetails> currentDetails) {
		this.currentDetails = currentDetails;
	}

	public RequisitionDetails getCurrentDetail() {
			return currentDetail;
	}
	public ArrayList<Object[]> getDetailsObjectArray(
			ArrayList<RequisitionDetails> details) {
		if (details == null)
			return null;
		ArrayList<Object[]> result = new ArrayList<Object[]>();

		for (Iterator<RequisitionDetails> iterator = details.iterator(); iterator
				.hasNext();) {
			RequisitionDetails u = (RequisitionDetails) iterator.next();

			Object[] row = new Object[] { u.getId(),
					u.getWasteDepartId(),
					u.getRequKind(), u.getRequCode(), u.getRequSpeci(),
					u.getRequPack(), u.getRequUnit(), u.getRequQuantity(),
					u.getOrderQuantity(), u.getMemo(),
					u.getEstimatedTimeOfArrival(), u.getDeadlineDeliveryDate(),
					u.getRequStatus(), u.getReqObjectId(),

			};
			result.add(row);
		}
		return result;
	}
	public void setCurrentDetails(Requisition currentMaster) {
		
	    this.currentDetails=new ArrayList<RequisitionDetails>( currentMaster.getRequisitionDetailses());
	    
	    
	}
	
}
