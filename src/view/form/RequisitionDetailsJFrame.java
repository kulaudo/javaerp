package view.form;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.BaseDAO;
import model.RequisitionDetailsModel;
import model.RequisitionModel;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;

import common.HibernateUtil;
import database.RequisitionDetails;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

import java.util.Date;

public class RequisitionDetailsJFrame extends JFrame {
	
	private BaseDAO<RequisitionDetails> dao=new  BaseDAO<RequisitionDetails>();

	private BindingGroup m_bindingGroup;
	private JPanel m_contentPane;
	private RequisitionDetails requisitionDetails ;
	private JTextField reqObjectIdJTextField;
	private JTextField requCodeJTextField;
	private JTextField requPackJTextField;
	private JTextField requSpeciJTextField;
	private JTextField requUnitJTextField;
	private JTextField wasteDepartIdJTextField;
	private JEditorPane memoJEditorPane;
	private JButton button_4;
	private RequisitionDetailsModel model;
	private JLabel requEstDate;
	private JTextField estimatedTimeOfArrivalJTextField;
	private JLabel requQuantityLabel;
	private JTextField requQuantityJTextField;

	DefaultTableModel tableDetailModel;

	/**
	 * Create the frame.
	 */
	public RequisitionDetailsJFrame(RequisitionDetailsModel model) {
		this.model=model;
		this.requisitionDetails=model.getCurrentDetail().getCurrentDetail();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 433, 419);
		m_contentPane = new JPanel();
		setContentPane(m_contentPane);
		//
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 200, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 31, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0 };
		m_contentPane.setLayout(gridBagLayout);

		JLabel reqObjectIdLabel = new JLabel("ReqObjectId:");
		GridBagConstraints labelGbc_0 = new GridBagConstraints();
		labelGbc_0.insets = new Insets(5, 5, 5, 5);
		labelGbc_0.gridx = 0;
		labelGbc_0.gridy = 0;
		m_contentPane.add(reqObjectIdLabel, labelGbc_0);

		reqObjectIdJTextField = new JTextField();
		GridBagConstraints componentGbc_0 = new GridBagConstraints();
		componentGbc_0.insets = new Insets(5, 0, 5, 5);
		componentGbc_0.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_0.gridx = 1;
		componentGbc_0.gridy = 0;
		m_contentPane.add(reqObjectIdJTextField, componentGbc_0);

		JLabel requCodeLabel = new JLabel("RequCode:");
		GridBagConstraints labelGbc_1 = new GridBagConstraints();
		labelGbc_1.insets = new Insets(5, 5, 5, 5);
		labelGbc_1.gridx = 0;
		labelGbc_1.gridy = 1;
		m_contentPane.add(requCodeLabel, labelGbc_1);

		requCodeJTextField = new JTextField();
		GridBagConstraints componentGbc_1 = new GridBagConstraints();
		componentGbc_1.insets = new Insets(5, 0, 5, 5);
		componentGbc_1.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_1.gridx = 1;
		componentGbc_1.gridy = 1;
		m_contentPane.add(requCodeJTextField, componentGbc_1);

		JLabel requPackLabel = new JLabel("RequPack:");
		GridBagConstraints labelGbc_2 = new GridBagConstraints();
		labelGbc_2.insets = new Insets(5, 5, 5, 5);
		labelGbc_2.gridx = 0;
		labelGbc_2.gridy = 2;
		m_contentPane.add(requPackLabel, labelGbc_2);

		requPackJTextField = new JTextField();
		GridBagConstraints componentGbc_2 = new GridBagConstraints();
		componentGbc_2.insets = new Insets(5, 0, 5, 5);
		componentGbc_2.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_2.gridx = 1;
		componentGbc_2.gridy = 2;
		m_contentPane.add(requPackJTextField, componentGbc_2);

		JLabel requSpeciLabel = new JLabel("RequSpeci:");
		GridBagConstraints labelGbc_3 = new GridBagConstraints();
		labelGbc_3.insets = new Insets(5, 5, 5, 5);
		labelGbc_3.gridx = 0;
		labelGbc_3.gridy = 3;
		m_contentPane.add(requSpeciLabel, labelGbc_3);

		requSpeciJTextField = new JTextField();
		GridBagConstraints componentGbc_3 = new GridBagConstraints();
		componentGbc_3.insets = new Insets(5, 0, 5, 5);
		componentGbc_3.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_3.gridx = 1;
		componentGbc_3.gridy = 3;
		m_contentPane.add(requSpeciJTextField, componentGbc_3);

		JLabel requUnitLabel = new JLabel("RequUnit:");
		GridBagConstraints labelGbc_4 = new GridBagConstraints();
		labelGbc_4.insets = new Insets(5, 5, 5, 5);
		labelGbc_4.gridx = 0;
		labelGbc_4.gridy = 4;
		m_contentPane.add(requUnitLabel, labelGbc_4);

		requUnitJTextField = new JTextField();
		GridBagConstraints componentGbc_4 = new GridBagConstraints();
		componentGbc_4.insets = new Insets(5, 0, 5, 5);
		componentGbc_4.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_4.gridx = 1;
		componentGbc_4.gridy = 4;
		m_contentPane.add(requUnitJTextField, componentGbc_4);

		JLabel wasteDepartIdLabel = new JLabel("WasteDepartId:");
		GridBagConstraints labelGbc_5 = new GridBagConstraints();
		labelGbc_5.insets = new Insets(5, 5, 5, 5);
		labelGbc_5.gridx = 0;
		labelGbc_5.gridy = 5;
		m_contentPane.add(wasteDepartIdLabel, labelGbc_5);

		wasteDepartIdJTextField = new JTextField();
		GridBagConstraints componentGbc_5 = new GridBagConstraints();
		componentGbc_5.insets = new Insets(5, 0, 5, 5);
		componentGbc_5.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_5.gridx = 1;
		componentGbc_5.gridy = 5;
		m_contentPane.add(wasteDepartIdJTextField, componentGbc_5);
		
		requQuantityLabel = new JLabel("RequQuantity");
		GridBagConstraints gbc_requQuantityLabel = new GridBagConstraints();
		gbc_requQuantityLabel.insets = new Insets(0, 0, 5, 5);
		gbc_requQuantityLabel.gridx = 0;
		gbc_requQuantityLabel.gridy = 6;
		m_contentPane.add(requQuantityLabel, gbc_requQuantityLabel);
		
		requQuantityJTextField = new JTextField();
		GridBagConstraints gbc_requQuantityJTextField = new GridBagConstraints();
		gbc_requQuantityJTextField.insets = new Insets(0, 0, 5, 5);
		gbc_requQuantityJTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_requQuantityJTextField.gridx = 1;
		gbc_requQuantityJTextField.gridy = 6;
		m_contentPane.add(requQuantityJTextField, gbc_requQuantityJTextField);
		requQuantityJTextField.setColumns(10);
		
		requEstDate = new JLabel("EstimatedTimeOfArrival");
		GridBagConstraints gbc_requEstDate = new GridBagConstraints();
		gbc_requEstDate.anchor = GridBagConstraints.EAST;
		gbc_requEstDate.insets = new Insets(0, 0, 5, 5);
		gbc_requEstDate.gridx = 0;
		gbc_requEstDate.gridy = 7;
		m_contentPane.add(requEstDate, gbc_requEstDate);
		
		estimatedTimeOfArrivalJTextField = new JTextField();
		GridBagConstraints gbc_estimatedTimeOfArrivalJTextField = new GridBagConstraints();
		gbc_estimatedTimeOfArrivalJTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_estimatedTimeOfArrivalJTextField.insets = new Insets(0, 0, 5, 5);
		gbc_estimatedTimeOfArrivalJTextField.gridx = 1;
		gbc_estimatedTimeOfArrivalJTextField.gridy = 7;
		m_contentPane.add(estimatedTimeOfArrivalJTextField, gbc_estimatedTimeOfArrivalJTextField);
		estimatedTimeOfArrivalJTextField.setColumns(10);

		JLabel memoLabel = new JLabel("Memo:");
		GridBagConstraints labelGbc_6 = new GridBagConstraints();
		labelGbc_6.fill = GridBagConstraints.VERTICAL;
		labelGbc_6.insets = new Insets(5, 5, 0, 5);
		labelGbc_6.gridx = 0;
		labelGbc_6.gridy = 8;
		m_contentPane.add(memoLabel, labelGbc_6);

		memoJEditorPane = new JEditorPane();
		GridBagConstraints componentGbc_6 = new GridBagConstraints();
		componentGbc_6.insets = new Insets(5, 0, 0, 5);
		componentGbc_6.fill = GridBagConstraints.BOTH;
		componentGbc_6.gridx = 1;
		componentGbc_6.gridy = 8;
		m_contentPane.add(memoJEditorPane, componentGbc_6);
		
		button_4 = new JButton("儲存");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dao.update(requisitionDetails);
			}
		});
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.gridx = 2;
		gbc_button_4.gridy = 8;
		m_contentPane.add(button_4, gbc_button_4);

		if (requisitionDetails != null) {
			m_bindingGroup = initDataBindings();
		}
		setVisible(true);
	}


	public database.RequisitionDetails getRequisitionDetails() {
		return requisitionDetails;
	}

	public void setRequisitionDetails(
			database.RequisitionDetails newRequisitionDetails) {
		setRequisitionDetails(newRequisitionDetails, true);
	}

	public void setRequisitionDetails(
			database.RequisitionDetails newRequisitionDetails, boolean update) {
		requisitionDetails = newRequisitionDetails;
		if (update) {
			if (m_bindingGroup != null) {
				m_bindingGroup.unbind();
				m_bindingGroup = null;
			}
			if (requisitionDetails != null) {
				m_bindingGroup = initDataBindings();
			}
		}
	}
	protected BindingGroup initDataBindings() {
		BeanProperty<RequisitionDetails, String> reqObjectIdProperty = BeanProperty.create("reqObjectId");
		BeanProperty<JTextField, String> textProperty = BeanProperty.create("text");
		AutoBinding<RequisitionDetails, String, JTextField, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, requisitionDetails, reqObjectIdProperty, reqObjectIdJTextField, textProperty);
		autoBinding.bind();
		//
		BeanProperty<RequisitionDetails, String> requCodeProperty = BeanProperty.create("requCode");
		BeanProperty<JTextField, String> textProperty_1 = BeanProperty.create("text");
		AutoBinding<RequisitionDetails, String, JTextField, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, requisitionDetails, requCodeProperty, requCodeJTextField, textProperty_1);
		autoBinding_1.bind();
		//
		BeanProperty<RequisitionDetails, String> requPackProperty = BeanProperty.create("requPack");
		BeanProperty<JTextField, String> textProperty_2 = BeanProperty.create("text");
		AutoBinding<RequisitionDetails, String, JTextField, String> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, requisitionDetails, requPackProperty, requPackJTextField, textProperty_2);
		autoBinding_2.bind();
		//
		BeanProperty<RequisitionDetails, String> requSpeciProperty = BeanProperty.create("requSpeci");
		BeanProperty<JTextField, String> textProperty_3 = BeanProperty.create("text");
		AutoBinding<RequisitionDetails, String, JTextField, String> autoBinding_3 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, requisitionDetails, requSpeciProperty, requSpeciJTextField, textProperty_3);
		autoBinding_3.bind();
		//
		BeanProperty<RequisitionDetails, String> requUnitProperty = BeanProperty.create("requUnit");
		BeanProperty<JTextField, String> textProperty_4 = BeanProperty.create("text");
		AutoBinding<RequisitionDetails, String, JTextField, String> autoBinding_4 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, requisitionDetails, requUnitProperty, requUnitJTextField, textProperty_4);
		autoBinding_4.bind();
		//
		BeanProperty<RequisitionDetails, String> wasteDepartIdProperty = BeanProperty.create("wasteDepartId");
		BeanProperty<JTextField, String> textProperty_5 = BeanProperty.create("text");
		AutoBinding<RequisitionDetails, String, JTextField, String> autoBinding_5 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, requisitionDetails, wasteDepartIdProperty, wasteDepartIdJTextField, textProperty_5);
		autoBinding_5.bind();
		//
		BeanProperty<RequisitionDetails, String> memoProperty = BeanProperty.create("memo");
		BeanProperty<JEditorPane, String> textProperty_6 = BeanProperty.create("text");
		AutoBinding<RequisitionDetails, String, JEditorPane, String> autoBinding_6 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, requisitionDetails, memoProperty, memoJEditorPane, textProperty_6);
		autoBinding_6.bind();
		//
		BeanProperty<RequisitionDetails, Date> requisitionDetailsBeanProperty = BeanProperty.create("estimatedTimeOfArrival");
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		AutoBinding<RequisitionDetails, Date, JTextField, String> autoBinding_7 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, requisitionDetails, requisitionDetailsBeanProperty, estimatedTimeOfArrivalJTextField, jTextFieldBeanProperty);
		autoBinding_7.bind();
		//
		BeanProperty<RequisitionDetails, Float> requisitionDetailsBeanProperty_1 = BeanProperty.create("requQuantity");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty.create("text");
		AutoBinding<RequisitionDetails, Float, JTextField, String> autoBinding_8 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, requisitionDetails, requisitionDetailsBeanProperty_1, requQuantityJTextField, jTextFieldBeanProperty_1);
		autoBinding_8.bind();
		//
		BindingGroup bindingGroup = new BindingGroup();
		//
		bindingGroup.addBinding(autoBinding);
		bindingGroup.addBinding(autoBinding_1);
		bindingGroup.addBinding(autoBinding_2);
		bindingGroup.addBinding(autoBinding_3);
		bindingGroup.addBinding(autoBinding_4);
		bindingGroup.addBinding(autoBinding_5);
		bindingGroup.addBinding(autoBinding_6);
		bindingGroup.addBinding(autoBinding_7);
		bindingGroup.addBinding(autoBinding_8);
		return bindingGroup;
	}
}
