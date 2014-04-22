package controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import view.IMainView;
import controller.form.IFormController;

public interface IMainController extends IController<IMainView> {
	public void logout();
	public void exit();
	public IMainView getView();
	public ArrayList<IFormController> getControllers();
	void doCommand(ActionEvent event);
}
