package controller.form;

import view.IStateObservable;
import view.IStateObserver;
import view.form.DataFilterFormViewImpl;
import view.form.IFormView;
import common.State;
import database.Users;

public class DataFilterControllerImpl implements IFormController,IStateObservable {
	private static DataFilterControllerImpl instance;
	IFormView view;
	@Override
	public void createView() {
		view = new DataFilterFormViewImpl(this);

	}

	@Override
	public IFormView getView() {		
		return view;
	}

	public static DataFilterControllerImpl getInstance() {
		if (instance == null) {
			synchronized (DataFilterControllerImpl.class) {
				if (instance == null) {
					instance = new DataFilterControllerImpl();
				}
			}
		}
		return instance;
	}

	public DataFilterControllerImpl() {
		super();
		createView();
	}

	@Override
	public State getState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setState(State state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Users getCurrentUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerStateObserver(IStateObserver s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeStateObserver(IStateObserver s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IStateObservable getMasterObs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IStateObservable getDetailObs() {
		// TODO Auto-generated method stub
		return null;
	}

}
