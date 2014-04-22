package controller;

import model.IUserModel;


public interface ILoginController extends IController<Object> {
	 	
	    public void login(String account, char[] password);
	    
	    public void cancel();

		public IUserModel getModel();	 
	
}
