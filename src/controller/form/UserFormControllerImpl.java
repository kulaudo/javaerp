package controller.form;

import model.UserModelImpl;

import org.hibernate.Session;

import view.IStateObservable;
import view.IStateObserver;
import view.form.IFormView;
import view.form.UsersFormViewImpl;
import common.HibernateUtil;
import common.State;
import database.Users;

public class UserFormControllerImpl implements IFormController,IStateObservable {
	private UserModelImpl model;
	private volatile static UserFormControllerImpl instance;
	private IFormView view;
	private Session session;

	// private ArrayList<IUserModel[]> data = new ArrayList<IUserModel[]>();
	public static UserFormControllerImpl getInstance() {
		// if (instance == null){
		synchronized (UserFormControllerImpl.class) {
			if (instance == null) {
				instance = new UserFormControllerImpl();
			}
		}

		return instance;

	}

	private UserFormControllerImpl() {
		session = HibernateUtil.getSessionFactory().openSession();
		model = new UserModelImpl();
		session.close();
	}

	@Override
	public IFormView getView() {
		return view;
	}

	@Override
	public void createView() {
		view = new UsersFormViewImpl(this, model);

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
