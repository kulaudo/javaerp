package view.form;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import model.IModel;

public abstract class BasicDialog extends JDialog {
	private class FilterListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String key = textField.getText();
			int index = comboBox.getSelectedIndex();

		}
	}

	private class UserSummitedListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {			
			userSummited();
		}		
	}

	private  class UserCanceledListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			userCanceled();
		}
	}
	protected JTable table;
	protected JTextField textField;
	protected String[] columns ;
	protected JPanel panel ;
	protected JComboBox comboBox;
	protected JButton btnFilter,btnSubmit,btnCancel;
	protected DefaultTableModel defaultTableModel;
	protected IModel tableModel;
	protected Object returnedValue;
	protected JScrollPane scrollPane;
	protected TableSelectionHelper helper;
	protected int valueColumn;//return value at column	

	public BasicDialog(int valueCol, IModel model) {
		tableModel = model;
		int valueColumn=valueCol;
		setModal(true);		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 490, 550);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		JLabel lblSearchKey = new JLabel("Search");
		panel_1.add(lblSearchKey);

		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		comboBox=new JComboBox<String>();
		panel_1.add(comboBox);
		btnFilter = new JButton("GO");
		btnFilter.addActionListener(new FilterListener());
		panel_1.add(btnFilter);
		scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setSize(400, 400);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		
		

		getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		JPanel panel = new JPanel();
		getContentPane().add(panel);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new UserCanceledListener());
		panel.add(btnCancel);

		btnSubmit= new JButton("OK");
		btnSubmit.addActionListener(new UserSummitedListener());
		panel.add(btnSubmit);	
		
	}

	protected void userSummited(){
		
		returnedValue= helper.getSelectedValue();
		System.out.println(returnedValue.toString());
		
	}

	protected void userCanceled(){
		returnedValue = null;		
	}
	Object getReturnValue(){
		
		return returnedValue;
	}

	public Object getReturnedValue() {
		return returnedValue;
	}

	public void setReturnedValue(Object returnedValue) {
		this.returnedValue = returnedValue;
	}

	
	

}
