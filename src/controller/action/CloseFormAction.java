package controller.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.form.IFormView;

public class CloseFormAction extends AbstractAction {
	IFormView view;
	

	public CloseFormAction(IFormView view) {
		super();
		this.view = view;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		view.dispose();

	}

}
