package controller.form;

import java.util.ArrayList;

import model.RequisitionDetailsModel;
import model.RequisitionModel;

import org.hibernate.criterion.Criterion;

import view.IObserver;
import view.IStateObserver;
import view.form.IFormView;
import view.form.RequisitionFormViewImpl;

import common.State;

import controller.MainControllerImpl;
import database.Users;

public class RequisitionFormControllerImpl implements IFormController {
	
	StateObservable masterObs = new StateObservable();
	StateObservable detailObs= new StateObservable();	

	private volatile static RequisitionFormControllerImpl instance;
	RequisitionFormViewImpl view;
	IFormController dataFilterController;
	RequisitionModel model;
	RequisitionDetailsModel detailsModel;
	Users currentUser;
	
	public Users getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(Users currentUser) {
		this.currentUser = currentUser;
	}

	public static RequisitionFormControllerImpl getInstance() {
		if (instance == null) {
			synchronized (RequisitionFormControllerImpl.class) {
				if (instance == null) {
					instance = new RequisitionFormControllerImpl();
				}
			}
		}
		return instance;
	}

	@Override
	public void createView() {
		view = new RequisitionFormViewImpl(this, model, detailsModel);
		
			masterObs.registerStateObserver(view.getMasterObs());
			detailObs.registerStateObserver( view.getDetailObs());
		
		if(view instanceof IObserver){
			model.registerObserver((IObserver) view);
		}
		masterObs.setState(State.BROWSE);
		detailObs.setState(State.BROWSE);
	}

	@Override
	public IFormView getView() {
		return view;
	}

	public RequisitionFormControllerImpl() {
		super();
		currentUser=MainControllerImpl.getCurrentUser();
		ArrayList<Criterion> l = new ArrayList<Criterion>();	
		model = new RequisitionModel(l,this);
		model.setCurrentUser(currentUser);
		detailsModel = new RequisitionDetailsModel(this);		
	}
	public StateObservable getMasterObs() {
		return masterObs;
	}

	public void setMasterObs(StateObservable masterObs) {
		this.masterObs = masterObs;
	}

	public StateObservable getDetailObs() {
		return detailObs;
	}

	public void setDetailObs(StateObservable detailObs) {
		this.detailObs = detailObs;
	}



}
