package view.form;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.script.Bindings;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.UserModelImpl;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JListBinding;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import common.Utility;

import controller.action.RefreshRecordAction;
import controller.form.IFormController;
import database.Users;

public class UsersFormViewImpl implements IFormView {

	JFrame frame;
	IFormController controller;
	UserModelImpl model;
	String[] columns = { "公司別", "員工ID", "員工工號", "員工密碼", "PaymentNo",
			"VouchDrawNo", "XcancelIdc", "XconfirmIdc", "XoperationIdc",
			"YcancelIdc", "YconfirmIdc", "YoperationIdc", "YPostingIdc" };
	private JList<Users> list;
	private JPanel panel_2;
	private JTextField txtCompany;
	private JTextField txtUserId;
	private JTextField txtEmpId;
	private JTextField txtUserName;
	private JTextField txtPass;
	private JTextField txtPaymentNoId;
	private JTextField txtVouchDrawId;
	private JTextField txtCancelIdc;
	private JTextField txtConfirmIdc;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextField txtXOerationIdc;
	private JTextField txtXPostingIdc;
	private JTextField txtXCancelIdc;
	private JTextField txtYConfirmIdc;
	private JTextField txtYPostingIdc;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblYcancelidc;
	private JLabel lblYconfirmidc;
	private JLabel lblYoperationidc;
	private JLabel lblYpostingidc;
	private JPanel panel_1;
	private JButton btNew;
	private JButton btEdit;
	private JButton button_2;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton button_8;
	private JButton button_10;
	private JButton button_11;
	private JButton button_12;
	private JButton btFilter;
	private JButton button_3;
	private JScrollPane scrollPane_1;
	private JTextField txtYOperationIdc;

	/**
	 * Create the frame.
	 */
	public UsersFormViewImpl(IFormController controller, UserModelImpl group) {
		this.controller = controller;
		this.model = group;
		JPanel contentPane;
		JPanel rightPanel;

		// JTable table;
		Users user;
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 766, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		RefreshRecordAction refreshRecordAction = new RefreshRecordAction();
		refreshRecordAction.setEnabled(true);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(10, 10, 730, 480);
		contentPane.add(splitPane);

		JPanel leftPanel = new JPanel();
		splitPane.setLeftComponent(leftPanel);
		GridBagLayout gbl_leftPanel = new GridBagLayout();
		gbl_leftPanel.columnWidths = new int[] { 258, 0 };
		gbl_leftPanel.rowHeights = new int[] { 0, -191, 0, 0 };
		gbl_leftPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_leftPanel.rowWeights = new double[] { 0.0, 1.0, 1.0,
				Double.MIN_VALUE };
		leftPanel.setLayout(gbl_leftPanel);

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		leftPanel.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btFilter = new JButton("\u8CC7\u6599\u7BE9\u9078");
		btFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_1.add(btFilter);

		btNew = new JButton("\u65B0\u589E");
		btNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		panel_1.add(btNew);

		btEdit = new JButton("\u4FEE\u6539");
		panel_1.add(btEdit);

		button_2 = new JButton("\u522A\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Utility.showQuestionDialog(frame, "確定刪除?") == JOptionPane.YES_OPTION)
					;

			}
		});
		panel_1.add(button_2);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		leftPanel.add(scrollPane, gbc_scrollPane);

		list = new JList<Users>();
		scrollPane.setViewportView(list);

		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 2;
		leftPanel.add(scrollPane_1, gbc_scrollPane_1);

		table = new JTable();
		scrollPane_1.setViewportView(table);

		rightPanel = new JPanel();
		splitPane.setRightComponent(rightPanel);
		GridBagLayout gbl_rightPanel = new GridBagLayout();
		gbl_rightPanel.columnWidths = new int[] { 377, 0 };
		gbl_rightPanel.rowHeights = new int[] { 36, 409, 0 };
		gbl_rightPanel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_rightPanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		rightPanel.setLayout(gbl_rightPanel);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		rightPanel.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 81, 0, 0 };
		gbl_panel.rowHeights = new int[] { 23, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		button_10 = new JButton("\u5132\u5B58");
		GridBagConstraints gbc_button_10 = new GridBagConstraints();
		gbc_button_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_10.anchor = GridBagConstraints.NORTH;
		gbc_button_10.insets = new Insets(0, 0, 0, 5);
		gbc_button_10.gridx = 0;
		gbc_button_10.gridy = 0;
		panel.add(button_10, gbc_button_10);

		button_11 = new JButton("\u53D6\u6D88");
		GridBagConstraints gbc_button_11 = new GridBagConstraints();
		gbc_button_11.anchor = GridBagConstraints.NORTH;
		gbc_button_11.insets = new Insets(0, 0, 0, 5);
		gbc_button_11.gridx = 1;
		gbc_button_11.gridy = 0;
		panel.add(button_11, gbc_button_11);

		button_8 = new JButton("\u904E\u5E33");
		GridBagConstraints gbc_button_8 = new GridBagConstraints();
		gbc_button_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_8.anchor = GridBagConstraints.NORTH;
		gbc_button_8.insets = new Insets(0, 0, 0, 5);
		gbc_button_8.gridx = 2;
		gbc_button_8.gridy = 0;
		panel.add(button_8, gbc_button_8);

		button_3 = new JButton("\u8F49\u56DE");
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 0, 5);
		gbc_button_3.gridx = 3;
		gbc_button_3.gridy = 0;
		panel.add(button_3, gbc_button_3);

		button_12 = new JButton("\u95DC\u9589");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		GridBagConstraints gbc_button_12 = new GridBagConstraints();
		gbc_button_12.insets = new Insets(0, 0, 0, 5);
		gbc_button_12.anchor = GridBagConstraints.NORTH;
		gbc_button_12.gridx = 5;
		gbc_button_12.gridy = 0;
		panel.add(button_12, gbc_button_12);

		panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		rightPanel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 30, 0, 153, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JLabel lblNewLabel = new JLabel("Company ID");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);

		txtCompany = new JTextField();
		GridBagConstraints gbc_txtCompany = new GridBagConstraints();
		gbc_txtCompany.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCompany.insets = new Insets(0, 0, 5, 0);
		gbc_txtCompany.gridx = 2;
		gbc_txtCompany.gridy = 1;
		panel_2.add(txtCompany, gbc_txtCompany);
		txtCompany.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("User ID");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);

		txtUserId = new JTextField();
		GridBagConstraints gbc_txtUserId = new GridBagConstraints();
		gbc_txtUserId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUserId.insets = new Insets(0, 0, 5, 0);
		gbc_txtUserId.gridx = 2;
		gbc_txtUserId.gridy = 2;
		panel_2.add(txtUserId, gbc_txtUserId);
		txtUserId.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Employee ID");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);

		txtEmpId = new JTextField();
		GridBagConstraints gbc_txtEmpId = new GridBagConstraints();
		gbc_txtEmpId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmpId.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmpId.gridx = 2;
		gbc_txtEmpId.gridy = 3;
		panel_2.add(txtEmpId, gbc_txtEmpId);
		txtEmpId.setColumns(10);

		lblNewLabel_3 = new JLabel("User Name");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 4;
		panel_2.add(lblNewLabel_3, gbc_lblNewLabel_3);

		txtUserName = new JTextField();
		GridBagConstraints gbc_txtUserName = new GridBagConstraints();
		gbc_txtUserName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUserName.insets = new Insets(0, 0, 5, 0);
		gbc_txtUserName.gridx = 2;
		gbc_txtUserName.gridy = 4;
		panel_2.add(txtUserName, gbc_txtUserName);
		txtUserName.setColumns(10);

		lblNewLabel_4 = new JLabel("Password");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 5;
		panel_2.add(lblNewLabel_4, gbc_lblNewLabel_4);

		txtPass = new JTextField();
		GridBagConstraints gbc_txtPass = new GridBagConstraints();
		gbc_txtPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPass.insets = new Insets(0, 0, 5, 0);
		gbc_txtPass.gridx = 2;
		gbc_txtPass.gridy = 5;
		panel_2.add(txtPass, gbc_txtPass);
		txtPass.setColumns(10);

		lblNewLabel_5 = new JLabel("PaymentNo Id");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 6;
		panel_2.add(lblNewLabel_5, gbc_lblNewLabel_5);

		txtPaymentNoId = new JTextField();
		GridBagConstraints gbc_txtPaymentNoId = new GridBagConstraints();
		gbc_txtPaymentNoId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPaymentNoId.insets = new Insets(0, 0, 5, 0);
		gbc_txtPaymentNoId.gridx = 2;
		gbc_txtPaymentNoId.gridy = 6;
		panel_2.add(txtPaymentNoId, gbc_txtPaymentNoId);
		txtPaymentNoId.setColumns(10);

		lblNewLabel_6 = new JLabel("VouchDraw ID");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 7;
		panel_2.add(lblNewLabel_6, gbc_lblNewLabel_6);

		txtVouchDrawId = new JTextField();
		GridBagConstraints gbc_txtVouchDrawId = new GridBagConstraints();
		gbc_txtVouchDrawId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVouchDrawId.insets = new Insets(0, 0, 5, 0);
		gbc_txtVouchDrawId.gridx = 2;
		gbc_txtVouchDrawId.gridy = 7;
		panel_2.add(txtVouchDrawId, gbc_txtVouchDrawId);
		txtVouchDrawId.setColumns(10);

		lblNewLabel_7 = new JLabel("xCancelIdc");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 8;
		panel_2.add(lblNewLabel_7, gbc_lblNewLabel_7);

		txtCancelIdc = new JTextField();
		GridBagConstraints gbc_txtCancelIdc = new GridBagConstraints();
		gbc_txtCancelIdc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCancelIdc.insets = new Insets(0, 0, 5, 0);
		gbc_txtCancelIdc.gridx = 2;
		gbc_txtCancelIdc.gridy = 8;
		panel_2.add(txtCancelIdc, gbc_txtCancelIdc);
		txtCancelIdc.setColumns(10);

		lblNewLabel_8 = new JLabel("xConfirmIdc");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 9;
		panel_2.add(lblNewLabel_8, gbc_lblNewLabel_8);

		txtConfirmIdc = new JTextField();
		GridBagConstraints gbc_txtConfirmIdc = new GridBagConstraints();
		gbc_txtConfirmIdc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtConfirmIdc.insets = new Insets(0, 0, 5, 0);
		gbc_txtConfirmIdc.gridx = 2;
		gbc_txtConfirmIdc.gridy = 9;
		panel_2.add(txtConfirmIdc, gbc_txtConfirmIdc);
		txtConfirmIdc.setColumns(10);

		lblNewLabel_9 = new JLabel("xOperationIdc");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 1;
		gbc_lblNewLabel_9.gridy = 10;
		panel_2.add(lblNewLabel_9, gbc_lblNewLabel_9);

		txtXOerationIdc = new JTextField();
		GridBagConstraints gbc_txtXOerationIdc = new GridBagConstraints();
		gbc_txtXOerationIdc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXOerationIdc.insets = new Insets(0, 0, 5, 0);
		gbc_txtXOerationIdc.gridx = 2;
		gbc_txtXOerationIdc.gridy = 10;
		panel_2.add(txtXOerationIdc, gbc_txtXOerationIdc);
		txtXOerationIdc.setColumns(10);

		lblNewLabel_10 = new JLabel("xPostingIdc");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 1;
		gbc_lblNewLabel_10.gridy = 11;
		panel_2.add(lblNewLabel_10, gbc_lblNewLabel_10);

		txtXPostingIdc = new JTextField();
		GridBagConstraints gbc_txtXPostingIdc = new GridBagConstraints();
		gbc_txtXPostingIdc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXPostingIdc.insets = new Insets(0, 0, 5, 0);
		gbc_txtXPostingIdc.gridx = 2;
		gbc_txtXPostingIdc.gridy = 11;
		panel_2.add(txtXPostingIdc, gbc_txtXPostingIdc);
		txtXPostingIdc.setColumns(10);

		lblYcancelidc = new JLabel("yCancelIdc");
		GridBagConstraints gbc_lblYcancelidc = new GridBagConstraints();
		gbc_lblYcancelidc.anchor = GridBagConstraints.EAST;
		gbc_lblYcancelidc.insets = new Insets(0, 0, 5, 5);
		gbc_lblYcancelidc.gridx = 1;
		gbc_lblYcancelidc.gridy = 12;
		panel_2.add(lblYcancelidc, gbc_lblYcancelidc);

		txtXCancelIdc = new JTextField();
		GridBagConstraints gbc_txtXCancelIdc = new GridBagConstraints();
		gbc_txtXCancelIdc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXCancelIdc.insets = new Insets(0, 0, 5, 0);
		gbc_txtXCancelIdc.gridx = 2;
		gbc_txtXCancelIdc.gridy = 12;
		panel_2.add(txtXCancelIdc, gbc_txtXCancelIdc);
		txtXCancelIdc.setColumns(10);

		lblYconfirmidc = new JLabel("yConfirmIdc");
		GridBagConstraints gbc_lblYconfirmidc = new GridBagConstraints();
		gbc_lblYconfirmidc.anchor = GridBagConstraints.EAST;
		gbc_lblYconfirmidc.insets = new Insets(0, 0, 5, 5);
		gbc_lblYconfirmidc.gridx = 1;
		gbc_lblYconfirmidc.gridy = 13;
		panel_2.add(lblYconfirmidc, gbc_lblYconfirmidc);

		txtYConfirmIdc = new JTextField();
		GridBagConstraints gbc_txtYConfirmIdc = new GridBagConstraints();
		gbc_txtYConfirmIdc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYConfirmIdc.insets = new Insets(0, 0, 5, 0);
		gbc_txtYConfirmIdc.gridx = 2;
		gbc_txtYConfirmIdc.gridy = 13;
		panel_2.add(txtYConfirmIdc, gbc_txtYConfirmIdc);
		txtYConfirmIdc.setColumns(10);

		lblYoperationidc = new JLabel("yOperationIdc");
		GridBagConstraints gbc_lblYoperationidc = new GridBagConstraints();
		gbc_lblYoperationidc.anchor = GridBagConstraints.EAST;
		gbc_lblYoperationidc.insets = new Insets(0, 0, 5, 5);
		gbc_lblYoperationidc.gridx = 1;
		gbc_lblYoperationidc.gridy = 14;
		panel_2.add(lblYoperationidc, gbc_lblYoperationidc);

		txtYOperationIdc = new JTextField();
		GridBagConstraints gbc_txtYOperationIdc = new GridBagConstraints();
		gbc_txtYOperationIdc.insets = new Insets(0, 0, 5, 0);
		gbc_txtYOperationIdc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYOperationIdc.gridx = 2;
		gbc_txtYOperationIdc.gridy = 14;
		panel_2.add(txtYOperationIdc, gbc_txtYOperationIdc);
		txtYOperationIdc.setColumns(10);

		lblYpostingidc = new JLabel("yPostingIdc");
		GridBagConstraints gbc_lblYpostingidc = new GridBagConstraints();
		gbc_lblYpostingidc.insets = new Insets(0, 0, 0, 5);
		gbc_lblYpostingidc.gridx = 1;
		gbc_lblYpostingidc.gridy = 15;
		panel_2.add(lblYpostingidc, gbc_lblYpostingidc);

		txtYPostingIdc = new JTextField();
		GridBagConstraints gbc_txtYPostingIdc = new GridBagConstraints();
		gbc_txtYPostingIdc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYPostingIdc.gridx = 2;
		gbc_txtYPostingIdc.gridy = 15;
		panel_2.add(txtYPostingIdc, gbc_txtYPostingIdc);
		txtYPostingIdc.setColumns(10);

		initDataBindings();
	}

	@Override
	public void show() {
		frame.setVisible(true);
	}

	@Override
	public void dispose() {
		this.frame.dispose();

	}

	protected void initDataBindings() {
		
	}
}
