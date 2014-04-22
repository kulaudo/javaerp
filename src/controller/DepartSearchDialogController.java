package controller;

import javax.swing.JFrame;
import javax.swing.JTextField;

import model.DepartModel;
import view.form.BasicDialog;
import view.form.DepartSearchDialog;
import view.form.IDialogController;

public class DepartSearchDialogController implements IDialogController {
	DepartSearchDialog dsd;
	DepartModel model;
	JFrame owner;
	JTextField field;

	public DepartSearchDialogController(JFrame owner,JTextField field) {
		super();
		model=new DepartModel();
		this.owner = owner;
		this.field=field;
	}
	
	@Override
	public BasicDialog createForm() {
		
		dsd=new DepartSearchDialog(owner,model,field);
		return dsd;
	}

}
