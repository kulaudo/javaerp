package view.form;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.IDetailsModel;
import model.IModel;
import model.RequisitionDetailsModel;
import model.RequisitionModel;

import org.hibernate.Session;

import view.IObserver;
import view.IStateObservable;
import view.IStateObserver;

import common.HibernateUtil;
import common.State;
import common.Utility;

import controller.DepartSearchDialogController;
import controller.action.CloseFormAction;
import controller.action.CreateFormAction;
import controller.form.IFormController;
import database.Requisition;
import database.RequisitionDetails;
import database.Users;

public class RequisitionFormViewImpl implements IFormView, IObserver{
		
	
	private class MasterObserver implements IStateObserver{
		
		IFormController controller;

		@Override
		public void update(State state) {
			getBtnCancel().setEnabled(
					(state == State.EDIT) || (state == State.INSERT));
			getBtnSave().setEnabled(
					(state == State.EDIT) || (state == State.INSERT));
			getBtnNew().setEnabled(state == State.BROWSE);			
			getBtnDelete().setEnabled(state == State.BROWSE);			
			getBtnEdit().setEnabled(state == State.BROWSE);			
			txtBudgetNo
					.setEnabled((state == State.EDIT) || (state == State.INSERT));
			txtDepartId.setEditable((state == State.EDIT)
					|| (state == State.INSERT));
			txtMark.setEnabled((state == State.EDIT) || (state == State.INSERT));
			txtDepartId.setEditable((state == State.EDIT)
					|| (state == State.INSERT));
			txtMemo.setEnabled((state == State.EDIT) || (state == State.INSERT));
			comboSys2.setEnabled((state == State.EDIT) || (state == State.INSERT));			
		}

		public MasterObserver(IFormController controller) {
			super();
			this.controller = controller;
		}
		
		
	}
	
	private class DetailObserver implements IStateObserver{
		IFormController controller;

		@Override
		public void update(State state) {			
			getBtnNewDet().setEnabled(state == State.BROWSE);
			getBtnDeleteDet().setEnabled(state == State.BROWSE);
			getBtnEditDet().setEnabled(state == State.BROWSE);
			
		}

		public DetailObserver(IFormController controller) {
			super();
			this.controller = controller;
		}
		
	}
	public class EditDetailsListener implements ActionListener {
		

		public void actionPerformed(ActionEvent arg0) {
			RequisitionDetailsJFrame detailsFrame=new RequisitionDetailsJFrame(detailsModel);			
		}
	}

	public class DetailsEditCancelListener implements ActionListener {
		private final IModel model;
		private IDetailsModel detailModel;
		private final IFormController controller;

		private DetailsEditCancelListener(RequisitionModel model,
				IFormController controller) {
			this.model = model;
			this.controller = controller;
		}

		public void actionPerformed(ActionEvent arg0) {
			if (controller instanceof IStateObservable) {
				if (((IStateObservable) controller).getState() == State.INSERT) {
					if (detailModel instanceof IDetailsModel)
						;

				}
				((IStateObservable) controller).setState(State.BROWSE);

			}
		}
	}

	public class DepartSearchListener implements ActionListener {
		private final RequisitionModel model;
		JFrame frame;

		private DepartSearchListener(RequisitionModel model, JFrame frame) {
			this.model = model;
			this.frame = frame;
		}

		public void actionPerformed(ActionEvent arg0) {
			DepartSearchDialog dsd = (DepartSearchDialog) new DepartSearchDialogController(
					frame,txtDepartId).createForm();			

		}
	}

	public class NewDetailListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {		
			
			detailsModel.newDetail(currentRequ);
			RequisitionDetailsJFrame detailForm= new RequisitionDetailsJFrame(detailsModel);			

		}
	}

	public class SaveListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {			
			
			Requisition r = model.getCurrentMaster();
			r.setSysId(comboSys2.getSelectedItem().toString());
			r.setRequDepartId(txtDepartId.getText());
			r.setBudgetNo(txtBudgetNo.getText());
			r.setUpdateId(txtUpdateId.getText());
			r.setConfirmId(txtCfmId.getText());
			r.setMark(txtMark.getText().charAt(0));
			r.setMemo(txtMemo.getText());
			r.setOperatorId(txtOpId.getText());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				r.setRequDate(sdf.parse(txtRequDate.getText()));
			} catch (ParseException e1) {				
				e1.printStackTrace();
			}
			

			model.saveRequisition(r);
			
			controller.getMasterObs().setState(State.BROWSE);

		}
	}

	public class EditListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			 controller.getMasterObs().setState(State.EDIT);

		}

	}

	public class NewMasterListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		
			controller.getMasterObs().setState(State.INSERT);
			model.newMaster();
			Requisition master = model.getCurrentMaster();
			listModel.addElement(master.getRequisitionId());

		}
	}

	public  class DeleteMasterListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (Utility.showQuestionDialog(null, "是否確定刪除?") == JOptionPane.YES_OPTION)
				model.deleteRequisition(model.getCurrentMaster());
			controller.getMasterObs().setState(State.BROWSE);
		}
		
	}

	public final class DetailOnClickAction extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {

			int selectedDetailRowIndex = tableDetail.getSelectedRow();
			if (selectedDetailRowIndex != -1) {
				Object[] column = detail.get(selectedDetailRowIndex);
				model.setCurrentDetail(model.getCurrentMaster(),
						(Integer) column[1]);
			}

		}

	}

	JFrame frame;
	IFormController controller;
	String[] masterColumns = { "RequisitionId", "Sys2", "RequDate", "DepartId",
			"BudgetNo", "Memo", "OperatorId", "ConfirmId", "ConfirmDate",
			"UpdateId", "UpdateDate", "Mark" };

	String[] detailsColumns = { "RequisitionId", "SequNo", 
			"DepartId", "Kind", "Code", "Speci", "Pack", "Unit",
			"RequQuantity", "OrderQuantity", "EstimatedTimeOfArrival",
			"DeadlineDeliveryDate", "RequStatus", "ReqObjectId",
			"SuggestionVendor", "SuggestionBrand", "Memo", "BomId", "BomItem",
			"CheckYesNo" };
	RequisitionModel model;
	RequisitionDetailsModel detailsModel;
	CreateFormAction act;
	MasterObserver masterObs;
	
	List<Object[]> master = new ArrayList<Object[]>();
	ArrayList<Object[]> detail = new ArrayList<Object[]>();
	Vector<Requisition> currentRowVector;
	ArrayList<Requisition> requList=new ArrayList<Requisition>(); 
	DefaultListModel<Integer> listModel = new DefaultListModel<Integer>();
	Users selectedUser;
	private JTextField txtRequDate;
	private JTextField txtBudgetNo;
	private JTextField txtMemo;
	private JTextField txtMark;
	private JTextField txtOpId;
	private JTextField txtCfmId;
	private JTextField txtUpdateId;
	private JTextField txtCfmDate;
	private JTextField txtUpdateDate;

	JComboBox comboSys2;
	private JTextField txtDepartId;
	private JTable tableDetail;
	private JButton btnNew;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnCancel;
	private JButton btnSave;
	private JButton btnQuery;
	private JButton btnNewDet;
	private JButton btnEditDet;
	private JButton btnDeleteDet;
	private JButton btnDepart;

	private JLabel lblNewLabel_8 = new JLabel("ConfirmOp ID");
	private JLabel lblNewLabel_9 = new JLabel("Update ID");
	private JLabel lblNewLabel_11 = new JLabel("Confirm Date");
	private JLabel lblNewLabel_12 = new JLabel("Update Date");
	private JPanel panel_3;
	private JList<Integer> list = new JList<Integer>();
	private Requisition currentRequ;
	private RequisitionDetails currentRequDetail;
	private DefaultTableModel tableDetailsModel;

	public RequisitionFormViewImpl(final IFormController controller,
			final RequisitionModel model, final RequisitionDetailsModel detailsModel) {
		this.controller = controller;
		this.model=model;
		this.detailsModel=detailsModel;
		this.masterObs=new MasterObserver(controller);
		this.detailObs=new DetailObserver(controller);
		currentRequ=new Requisition();
		for (Iterator<Requisition> iterator = model.getMasterList().iterator(); iterator
				.hasNext();) {
			Requisition u = (Requisition) iterator.next();

			Object[] data = new Object[] { u.getRequisitionId(), u.getSysId(),
					u.getRequDate(), u.getRequDepartId(), u.getBudgetNo(),
					u.getMemo(), u.getOperatorId(), u.getConfirmId(),
					u.getConfirmId(), u.getUpdateId(), u.getUpdateDate()

			};
			requList.add(u);
			master.add(data);
			listModel.addElement(u.getRequisitionId());			
		}

		list.setModel(listModel);
		list.repaint();
		

		frame = new JFrame();
		frame.setSize(1020, 600);
		JSplitPane splitPane = new JSplitPane();
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(splitPane_1);
		JPanel panel_2 = new JPanel();
		splitPane_1.setLeftComponent(panel_2);
		btnNew = new JButton("新增");
		btnEdit = new JButton("修改");
		btnDelete = new JButton("刪除");
		btnCancel = new JButton("取消");
		btnSave = new JButton("儲存");
		btnNew.addActionListener(new NewMasterListener());
		btnSave.addActionListener(new SaveListener());
		btnEdit.addActionListener(new EditListener());
		btnDelete.addActionListener(new DeleteMasterListener());

		panel_2.add(btnNew);
		panel_2.add(btnEdit);
		panel_2.add(btnDelete);

		btnQuery = new JButton("資料篩選");
		act = new CreateFormAction("資料篩選", null, null, null);
		btnQuery.addActionListener(act);

		btnCancel.addActionListener(new DetailsEditCancelListener(model,
				controller));
		panel_2.add(btnCancel);
		panel_2.add(btnSave);
		panel_2.add(btnQuery);

		panel_3 = new JPanel();
		splitPane_1.setRightComponent(panel_3);

		list = new JList(listModel);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				Requisition r= model.findRequisition(list.getSelectedValue());
				model.setCurrentMaster(r);		
				detailsModel.setCurrentDetails(r);			
				
			}
		});
		SpringLayout sl_panel_3 = new SpringLayout();
		sl_panel_3.putConstraint(SpringLayout.NORTH, list, 0, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, list, 0, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, list, 520, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, list, 401, SpringLayout.WEST, panel_3);
		panel_3.setLayout(sl_panel_3);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_3.add(list);

		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_2);

		JPanel panel = new JPanel();
		splitPane_2.setLeftComponent(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 81, 70, 70, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 23, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
		CloseFormAction cfa = new CloseFormAction(this);

		btnNewDet = new JButton("新增明細");
		btnNewDet.addActionListener(new NewDetailListener());

		GridBagConstraints gbc_btnNewDet = new GridBagConstraints();
		gbc_btnNewDet.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewDet.anchor = GridBagConstraints.NORTH;
		gbc_btnNewDet.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewDet.gridx = 0;
		gbc_btnNewDet.gridy = 0;
		panel.add(btnNewDet, gbc_btnNewDet);

		btnEditDet = new JButton("修改明細");
		btnEditDet.addActionListener(new EditDetailsListener());
		
		GridBagConstraints gbc_btnEditDet = new GridBagConstraints();
		gbc_btnEditDet.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnEditDet.insets = new Insets(0, 0, 0, 5);
		gbc_btnEditDet.gridx = 1;
		gbc_btnEditDet.gridy = 0;
		panel.add(btnEditDet, gbc_btnEditDet);

		btnDeleteDet = new JButton("刪除明細");
		GridBagConstraints gbc_btnDeleteDet = new GridBagConstraints();
		gbc_btnDeleteDet.insets = new Insets(0, 0, 0, 5);
		gbc_btnDeleteDet.gridx = 2;
		gbc_btnDeleteDet.gridy = 0;
		panel.add(btnDeleteDet, gbc_btnDeleteDet);
		JButton btnExit = new JButton("關閉");
		btnExit.addActionListener(cfa);

		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.insets = new Insets(0, 0, 0, 5);
		gbc_btnExit.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnExit.gridx = 5;
		gbc_btnExit.gridy = 0;
		panel.add(btnExit, gbc_btnExit);

		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_3.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_3.setContinuousLayout(true);
		splitPane_2.setRightComponent(splitPane_3);

		JPanel panel_1 = new JPanel();
		splitPane_3.setLeftComponent(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 100, 0, 0, 70, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNewLabel_3 = new JLabel("Department ID");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 1;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);

		txtDepartId = new JTextField();
		GridBagConstraints gbc_txtDepartId = new GridBagConstraints();
		gbc_txtDepartId.anchor = GridBagConstraints.WEST;
		gbc_txtDepartId.insets = new Insets(0, 0, 5, 5);
		gbc_txtDepartId.gridx = 1;
		gbc_txtDepartId.gridy = 1;
		panel_1.add(txtDepartId, gbc_txtDepartId);
		txtDepartId.setColumns(10);

		btnDepart = new JButton("");
		btnDepart.addActionListener(new DepartSearchListener(model, frame));
		btnDepart
				.setIcon(new ImageIcon(
						RequisitionFormViewImpl.class
								.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		GridBagConstraints gbc_btnDepart = new GridBagConstraints();
		gbc_btnDepart.insets = new Insets(0, 0, 5, 5);
		gbc_btnDepart.gridx = 2;
		gbc_btnDepart.gridy = 1;
		panel_1.add(btnDepart, gbc_btnDepart);

		JLabel lblNewLabel_4 = new JLabel("Budget No");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 3;
		gbc_lblNewLabel_4.gridy = 1;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);

		txtBudgetNo = new JTextField();
		txtBudgetNo.setEnabled(false);
		GridBagConstraints gbc_txtBudgetNo = new GridBagConstraints();
		gbc_txtBudgetNo.anchor = GridBagConstraints.WEST;
		gbc_txtBudgetNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtBudgetNo.gridx = 4;
		gbc_txtBudgetNo.gridy = 1;
		panel_1.add(txtBudgetNo, gbc_txtBudgetNo);
		txtBudgetNo.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Sys2");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

		comboSys2 = new JComboBox<String>();
		comboSys2.setEnabled(false);
		comboSys2.setModel(new DefaultComboBoxModel<String>(new String[] {
				"MAT", "FML", "RPA" }));
		comboSys2.setSelectedIndex(0);
		GridBagConstraints gbc_comboSys2 = new GridBagConstraints();
		gbc_comboSys2.anchor = GridBagConstraints.WEST;
		gbc_comboSys2.insets = new Insets(0, 0, 5, 5);
		gbc_comboSys2.gridx = 1;
		gbc_comboSys2.gridy = 2;
		panel_1.add(comboSys2, gbc_comboSys2);

		JLabel lblNewLabel_5 = new JLabel("Memo");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 3;
		gbc_lblNewLabel_5.gridy = 2;
		panel_1.add(lblNewLabel_5, gbc_lblNewLabel_5);

		txtMemo = new JTextField();
		txtMemo.setEnabled(false);
		GridBagConstraints gbc_txtMemo = new GridBagConstraints();
		gbc_txtMemo.anchor = GridBagConstraints.WEST;
		gbc_txtMemo.insets = new Insets(0, 0, 5, 5);
		gbc_txtMemo.gridx = 4;
		gbc_txtMemo.gridy = 2;
		panel_1.add(txtMemo, gbc_txtMemo);
		txtMemo.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Mark");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 3;
		panel_1.add(lblNewLabel_6, gbc_lblNewLabel_6);

		txtMark = new JTextField();
		txtMark.setEnabled(false);
		GridBagConstraints gbc_txtMark = new GridBagConstraints();
		gbc_txtMark.anchor = GridBagConstraints.WEST;
		gbc_txtMark.insets = new Insets(0, 0, 5, 5);
		gbc_txtMark.gridx = 1;
		gbc_txtMark.gridy = 3;
		panel_1.add(txtMark, gbc_txtMark);
		txtMark.setColumns(1);

		JLabel lblNewLabel_7 = new JLabel("Operator ID");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 4;
		panel_1.add(lblNewLabel_7, gbc_lblNewLabel_7);

		txtOpId = new JTextField();
		txtOpId.setEnabled(false);
		GridBagConstraints gbc_txtOpId = new GridBagConstraints();
		gbc_txtOpId.anchor = GridBagConstraints.WEST;
		gbc_txtOpId.insets = new Insets(0, 0, 5, 5);
		gbc_txtOpId.gridx = 1;
		gbc_txtOpId.gridy = 4;
		panel_1.add(txtOpId, gbc_txtOpId);
		txtOpId.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Requisition Date");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 4;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

		txtRequDate = new JTextField();
		txtRequDate.setEnabled(false);
		GridBagConstraints gbc_txtRequDate = new GridBagConstraints();
		gbc_txtRequDate.anchor = GridBagConstraints.WEST;
		gbc_txtRequDate.insets = new Insets(0, 0, 5, 5);
		gbc_txtRequDate.gridx = 4;
		gbc_txtRequDate.gridy = 4;
		panel_1.add(txtRequDate, gbc_txtRequDate);
		txtRequDate.setColumns(10);

		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 5;
		panel_1.add(lblNewLabel_8, gbc_lblNewLabel_8);

		txtCfmId = new JTextField();
		txtCfmId.setEnabled(false);
		GridBagConstraints gbc_txtCfmId = new GridBagConstraints();
		gbc_txtCfmId.anchor = GridBagConstraints.WEST;
		gbc_txtCfmId.insets = new Insets(0, 0, 5, 5);
		gbc_txtCfmId.gridx = 1;
		gbc_txtCfmId.gridy = 5;
		panel_1.add(txtCfmId, gbc_txtCfmId);
		txtCfmId.setColumns(10);

		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 3;
		gbc_lblNewLabel_11.gridy = 5;
		panel_1.add(lblNewLabel_11, gbc_lblNewLabel_11);

		txtCfmDate = new JTextField();
		txtCfmDate.setEnabled(false);
		GridBagConstraints gbc_txtCfmDate = new GridBagConstraints();
		gbc_txtCfmDate.anchor = GridBagConstraints.WEST;
		gbc_txtCfmDate.insets = new Insets(0, 0, 5, 5);
		gbc_txtCfmDate.gridx = 4;
		gbc_txtCfmDate.gridy = 5;
		panel_1.add(txtCfmDate, gbc_txtCfmDate);
		txtCfmDate.setColumns(10);

		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 6;
		panel_1.add(lblNewLabel_9, gbc_lblNewLabel_9);

		txtUpdateId = new JTextField();
		txtUpdateId.setEnabled(false);
		GridBagConstraints gbc_txtUpdateId = new GridBagConstraints();
		gbc_txtUpdateId.anchor = GridBagConstraints.WEST;
		gbc_txtUpdateId.insets = new Insets(0, 0, 5, 5);
		gbc_txtUpdateId.gridx = 1;
		gbc_txtUpdateId.gridy = 6;
		panel_1.add(txtUpdateId, gbc_txtUpdateId);
		txtUpdateId.setColumns(10);

		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_12.gridx = 3;
		gbc_lblNewLabel_12.gridy = 6;
		panel_1.add(lblNewLabel_12, gbc_lblNewLabel_12);

		txtUpdateDate = new JTextField();
		txtUpdateDate.setEnabled(false);
		GridBagConstraints gbc_txtUpdateDate = new GridBagConstraints();
		gbc_txtUpdateDate.anchor = GridBagConstraints.WEST;
		gbc_txtUpdateDate.insets = new Insets(0, 0, 5, 5);
		gbc_txtUpdateDate.gridx = 4;
		gbc_txtUpdateDate.gridy = 6;
		panel_1.add(txtUpdateDate, gbc_txtUpdateDate);
		txtUpdateDate.setColumns(10);
		tableDetail = new JTable(this.tableDetailsModel);
		TableSelectionHelper helper=new TableSelectionHelper(tableDetail,tableDetailsModel,0);
		

		tableDetail.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableDetail.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		JScrollPane scrollPane2 = new JScrollPane(tableDetail);
		splitPane_3.setRightComponent(scrollPane2);

		initDataBindings();

	}

	public Users getSelectedUser() {
		return selectedUser;
	}

	@Override
	public void show() {
		frame.setVisible(true);

	}

	@Override
	public void dispose() {
		frame.dispose();
	}

	@Override
	public void update(Object currentMaster) {
		if (currentMaster instanceof Requisition) {
			Requisition master = (Requisition) currentMaster;			
			txtRequDate.setText(new SimpleDateFormat("yyyy-MM-dd")
					.format(master.getRequDate()));
			txtBudgetNo.setText(master.getBudgetNo());
			txtMemo.setText(master.getMemo());
			txtMark.setText(master.getMark().toString());
			txtOpId.setText(master.getOperatorId());
			txtCfmId.setText(master.getConfirmId());
			txtUpdateId.setText(master.getUpdateId());
			txtDepartId.setText(master.getRequDepartId());
			if (master.getConfirmDate()!= null)
				txtCfmDate.setText(Utility.getMyDate(master.getConfirmDate()));
			if (master.getUpdateDate() != null)
				txtUpdateDate.setText(Utility.getMyDate(master.getUpdateDate()));

			comboSys2.setSelectedIndex(Utility
					.getSys2Index(master.getSysId()));			
			
		} 

	}

	private void updateDetails() {
		detail = detailsModel.getDetailsObjectArray(detailsModel.getCurrentDetails());

		if (detail != null) {
			Object[][] realData = detail.toArray(new Object[detail.size()][]);
			if (realData != null)
				tableDetailsModel.setDataVector(realData, detailsColumns);
		}
	}

	public JButton getBtnNew() {
		return btnNew;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public JButton getBtnQuery() {
		return btnQuery;
	}

	public JButton getBtnNewDet() {
		return btnNewDet;
	}

	public JButton getBtnEditDet() {
		return btnEditDet;
	}

	public JButton getBtnDeleteDet() {
		return btnDeleteDet;
	}
	
	public MasterObserver getMasterObs() {
		return masterObs;
	}

	public void setMasterObs(MasterObserver masterObs) {
		this.masterObs = masterObs;
	}
	DetailObserver detailObs;
	 
	public DetailObserver getDetailObs() {
		return detailObs;
	}

	public void setDetailObs(DetailObserver detailObs) {
		this.detailObs = detailObs;
	}
	protected void initDataBindings() {
	}
}
