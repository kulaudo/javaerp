package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import view.IObservable;
import view.IObserver;
import common.HibernateUtil;
import common.State;
import common.Utility;
import controller.form.IFormController;
import controller.form.RequisitionFormControllerImpl;
import database.Requisition;
import database.RequisitionDetails;
import database.Users;

public class RequisitionModel implements IModel, IDataSet, IObservable {

	private ArrayList<IObserver> observers = new ArrayList<IObserver>();
	BaseDAO<Requisition> requDAO = new BaseDAO<Requisition>();
	ArrayList<Requisition> masterList;
	List<Criterion> filter;
	Requisition currentMaster;
	public RequisitionDetails currentDetail;

	State state;
	Users currentUser;
	IFormController controller;

	public RequisitionModel(List<Criterion> criteria,
			RequisitionFormControllerImpl controller) {
		super();
		filter = criteria;
		masterList = (ArrayList<Requisition>) requDAO.advlist(
				Requisition.class, filter);
		masterList = getMasterResult(criteria);
		this.controller = controller;
	}

	public ArrayList<Requisition> getMasterResult(List<Criterion> criteria) {
		ArrayList<Requisition> tempMaster = (ArrayList<Requisition>) requDAO
				.advlist(Requisition.class, criteria);
		return tempMaster;
	}

	public void setFilter(List<Criterion> filter) {
		this.filter = filter;
	}

	public List<Criterion> getFilter() {
		return filter;
	}

	public ArrayList<Requisition> getMasterList() {
		return masterList;
	}

	public void setMaster(ArrayList<Requisition> master) {
		this.masterList = master;
	}

	public void deleteRequisition(Requisition requ) {
		this.requDAO.delete(requ);
	}

	@Override
	public void update(Object o) {
		requDAO.update((Requisition) o);
	}

	@Override
	public void insert(Object o) {
		requDAO.create((Requisition) o);
	}

	@Override
	public void delete(Object o) {
		requDAO.delete((Requisition) o);
	}

	public void saveObject(Object o) {
		if (controller.getMasterObs().getState() == State.INSERT)
			insert(o);
		else
			update(o);
	}

	public void setCurrentMaster(Requisition master) {
		this.currentMaster = master;
		notifyObserver();
	}

	public Requisition getCurrentMaster() {
		return currentMaster;
	}

	public void newMaster() {
		controller.getMasterObs().setState(State.INSERT);
		Requisition requisition = new Requisition("MAT", new Date(), "", "",
				"", currentUser.getEmployeeId(), "", "", null, null,
				new Character('X'), null);

		masterList.add(requisition);
		setCurrentMaster(requisition);

	}

	@Override
	public void deleteObserver(IObserver o) {
		if (o != null) {
			int i = observers.indexOf(o);
			if (i >= 0)
				observers.remove(i);
		}
	}

	@Override
	public void notifyObserver() {
		for (int i = 0; i < observers.size(); i++) {
			IObserver observer = (IObserver) observers.get(i);

			observer.update((Object) currentMaster);
		}

	}

	@Override
	public void registerObserver(IObserver o) {
		observers.add(o);

	}

	public void saveRequisition(Requisition master) {
		saveObject(master);
	}

	public void setCurrentUser(Users currentUser) {
		this.currentUser = currentUser;

	}

	public void refresh() {

	}

	public void setCurrentDetail(Requisition currentMaster2, Integer id) {
		ArrayList<RequisitionDetails> detail = new ArrayList<RequisitionDetails>(
				currentMaster.getRequisitionDetailses());
		for (Iterator iterator = detail.iterator(); iterator.hasNext();) {
			RequisitionDetails requisitionDetails = (RequisitionDetails) iterator
					.next();
			if (requisitionDetails.getId().equals(id)) {
				requisitionDetails.setCurrentDetail(this);

			}
		}

	}

	public Requisition findRequisition(Integer i) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Query query;
		List list;

		session.beginTransaction();

		query = session
				.createQuery("select r from Requisition as r where r.requisitionId="
						+ i);
		list = query.list();
		Requisition r = (Requisition) list.get(0);
		
//		try {
//			session.getTransaction().commit();
//		
//		} finally {
//			session.close();
//		}
		return r;

	}

}
