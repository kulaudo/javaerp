package controller.form;

import view.IStateObservable;
import view.IStateObserver;
import view.form.IFormView;
import view.form.ProgramAuthFormViewImpl;
import common.State;
import database.Users;

public class ProgramAuthFormControllerImpl implements IFormController,IStateObservable {

	private volatile static ProgramAuthFormControllerImpl instance;
	IFormView view;

	public static ProgramAuthFormControllerImpl getInstance() {
		if (instance == null) {
			synchronized (ProgramAuthFormControllerImpl.class) {
				if (instance == null) {
					instance = new ProgramAuthFormControllerImpl();
				}
			}
		}
		return instance;

	}

	@Override
	public IFormView getView() {
		return view;
	}

	@Override
	public void createView() {
		view = new ProgramAuthFormViewImpl();
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
