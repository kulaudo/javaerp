package controller.form;

import view.IStateObservable;
import view.form.IFormView;
import controller.IController;
import database.Users;


public interface IFormController extends IController<IFormView> {	

	void createView();
	IFormView getView();
	Users getCurrentUser();	
	IStateObservable getMasterObs();
	IStateObservable getDetailObs();

}
