package view;

import javax.swing.JFrame;

import model.IUserModel;
import controller.IMainController;

public interface IMainView extends IView<IMainController> {

	void show();

	void createView();

	IMainController getController();

	IUserModel getUserModel();

	JFrame getUI();

	boolean isVisible();
}
