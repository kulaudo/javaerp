package view.form;

import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.DepartModel;
import model.IModel;
import controller.DepartSearchDialogController;

public class DepartSearchDialog extends BasicDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1922872082192612869L;
	private JFrame frame;
	private JTextField field;

	public DepartSearchDialog(JFrame owner, DepartModel model,JTextField field) {		
		super(0,(IModel)model);		
		this.field=field; 
		columns = new String[] { "Depart ID", "Depart Name" };
		comboBox.setModel(new DefaultComboBoxModel(columns));
		defaultTableModel = new DefaultTableModel(((DepartModel) tableModel).getTableModel(),
				columns);
		
		table.setModel(defaultTableModel);
		helper = new TableSelectionHelper(table,	defaultTableModel,0);
		table.getModel().addTableModelListener(helper);
		table.getSelectionModel().addListSelectionListener( new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				helper.valueChanged(e);
				setReturnedValue(helper.getSelectedValue());
				
			}
		});
		setVisible(true);

		
	}

	public void setReturnedValue(Object selectedRow) {
		super.setReturnedValue(selectedRow);	
		 
	}

	@Override
	protected void userSummited() {
		super.userSummited();
		if (field!=null)
			field.setText(super.returnedValue.toString());		
		dispose();
		
	}

	

	@Override
	String getReturnValue() {
		String v= (String) returnedValue;	

		return v;
	}	
	
	
}
