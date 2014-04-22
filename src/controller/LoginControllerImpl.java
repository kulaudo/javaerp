package controller;

import model.IUserModel;
import model.UserModelImpl;
import view.ILoginView;
import view.LoginViewImpl;

import common.Utility;

public class LoginControllerImpl implements ILoginController {
	private IUserModel userModel;
	private ILoginView view;
	private IMainController main;

	@Override
	public void login(String id, char[] password) {
		
		userModel.findUser(id);
		
		if (userModel.verifyUser(password)) {
			Utility.showMsgDialog(view.getUI(), userModel.getUser()
					.getEmployeeId()
					+ userModel.getUser().getUserName()
					+ "登入成功");

			view.getUI().dispose();
			
		} else
			Utility.showErrDialog(view.getUI(), "帳號或密碼錯誤，請重新輸入!!");

	}

	public void setModel(IUserModel userModel) {
		this.userModel = userModel;
	}

	@Override
	public void cancel() {
		main.exit();
	}

	public LoginControllerImpl(IMainController main) {
		this.main = main;
		userModel = new UserModelImpl();
		
		view = new LoginViewImpl(userModel, this);
		view.createView();
	}

	public IMainController getMainController() {
		return main;
	}

	public ILoginView getLoginView() {
		return view;
	}

	public void setView(ILoginView view) {
		this.view = view;

	}

	@Override
	public IUserModel getModel() {
		return userModel;
	}

}
