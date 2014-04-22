package controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import model.IUserModel;
import view.IMainView;
import view.MainViewImpl;
import controller.form.IFormController;
import database.Users;



public class MainControllerImpl implements IMainController{	
	LoginRunnable loginTask;
	ILoginController loginController;
	IUserModel userModel;
	IMainView view;
	static Users user;
	ArrayList<IFormController> formContollers;

	

	@Override
	public void logout() {
		userModel.clean();

	}

	@Override
	public void exit() {
		System.exit(0);

	}

	public MainControllerImpl() {
		loginTask=new LoginRunnable(this);
		Thread t= new Thread(loginTask);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}		
		this.loginController=loginTask.getLoginController();
		this.userModel=loginTask.getLoginController().getModel();
		user=userModel.getUser();
		view=new MainViewImpl(this,userModel);
		view.createView();
		view.show();
		
	}

	@Override
	public IMainView getView() {
		return view;
		
	}

	public static Users getCurrentUser() {
		return user;
	}

	@Override
	public ArrayList<IFormController> getControllers() {		
		return formContollers;
	}

	@Override
	public void doCommand(ActionEvent event) {
		
		
	}



	

}
