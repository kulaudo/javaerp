package view.form;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;

import database.Users;

public class UsersJPanel extends JPanel {

	private BindingGroup m_bindingGroup;
	private Users users = new Users();
	private JTextField employeeIdJTextField;
	private JTextField passwordCodeJTextField;
	private JTextField paymentNoIdJTextField;
	private JTextField userNameJTextField;
	private JTextField vouchDrawNoIdJTextField;
	private JTextField xcancelIdcJTextField;
	private JTextField xconfirmIdcJTextField;
	private JTextField xoperationIdcJTextField;
	private JTextField xpostingIdcJTextField;
	private JTextField ycancelIdcJTextField;
	private JTextField yconfirmIdcJTextField;
	private JTextField yoperationIdcJTextField;
	private JTextField ypostingIdcJTextField;
	public UsersJPanel(Users newUsers) {
		this();
		setUsers(newUsers);
	}

	public UsersJPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{83, 103, 0};
		gridBagLayout.rowHeights = new int[]{21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
						
								JLabel employeeIdLabel = new JLabel("\u54E1\u5DE5ID:");
								GridBagConstraints gbc_employeeIdLabel = new GridBagConstraints();
								gbc_employeeIdLabel.anchor = GridBagConstraints.EAST;
								gbc_employeeIdLabel.insets = new Insets(0, 0, 5, 5);
								gbc_employeeIdLabel.gridx = 0;
								gbc_employeeIdLabel.gridy = 0;
								add(employeeIdLabel, gbc_employeeIdLabel);
				
						employeeIdJTextField = new JTextField();
						employeeIdJTextField.setColumns(10);
						GridBagConstraints gbc_employeeIdJTextField = new GridBagConstraints();
						gbc_employeeIdJTextField.anchor = GridBagConstraints.NORTH;
						gbc_employeeIdJTextField.fill = GridBagConstraints.HORIZONTAL;
						gbc_employeeIdJTextField.insets = new Insets(0, 0, 5, 0);
						gbc_employeeIdJTextField.gridx = 1;
						gbc_employeeIdJTextField.gridy = 0;
						add(employeeIdJTextField, gbc_employeeIdJTextField);
														
																JLabel passwordCodeLabel = new JLabel("\u5BC6\u78BC:");
																GridBagConstraints gbc_passwordCodeLabel = new GridBagConstraints();
																gbc_passwordCodeLabel.anchor = GridBagConstraints.EAST;
																gbc_passwordCodeLabel.insets = new Insets(0, 0, 5, 5);
																gbc_passwordCodeLabel.gridx = 0;
																gbc_passwordCodeLabel.gridy = 1;
																add(passwordCodeLabel, gbc_passwordCodeLabel);
												
														passwordCodeJTextField = new JTextField();
														GridBagConstraints gbc_passwordCodeJTextField = new GridBagConstraints();
														gbc_passwordCodeJTextField.anchor = GridBagConstraints.NORTH;
														gbc_passwordCodeJTextField.fill = GridBagConstraints.HORIZONTAL;
														gbc_passwordCodeJTextField.insets = new Insets(0, 0, 5, 0);
														gbc_passwordCodeJTextField.gridx = 1;
														gbc_passwordCodeJTextField.gridy = 1;
														add(passwordCodeJTextField, gbc_passwordCodeJTextField);
										
												JLabel paymentNoIdLabel = new JLabel("PaymentNoId:");
												GridBagConstraints gbc_paymentNoIdLabel = new GridBagConstraints();
												gbc_paymentNoIdLabel.anchor = GridBagConstraints.EAST;
												gbc_paymentNoIdLabel.insets = new Insets(0, 0, 5, 5);
												gbc_paymentNoIdLabel.gridx = 0;
												gbc_paymentNoIdLabel.gridy = 2;
												add(paymentNoIdLabel, gbc_paymentNoIdLabel);
										
												paymentNoIdJTextField = new JTextField();
												GridBagConstraints gbc_paymentNoIdJTextField = new GridBagConstraints();
												gbc_paymentNoIdJTextField.anchor = GridBagConstraints.NORTH;
												gbc_paymentNoIdJTextField.fill = GridBagConstraints.HORIZONTAL;
												gbc_paymentNoIdJTextField.insets = new Insets(0, 0, 5, 0);
												gbc_paymentNoIdJTextField.gridx = 1;
												gbc_paymentNoIdJTextField.gridy = 2;
												add(paymentNoIdJTextField, gbc_paymentNoIdJTextField);
										
												JLabel userNameLabel = new JLabel("\u59D3\u540D:");
												GridBagConstraints gbc_userNameLabel = new GridBagConstraints();
												gbc_userNameLabel.anchor = GridBagConstraints.EAST;
												gbc_userNameLabel.insets = new Insets(0, 0, 5, 5);
												gbc_userNameLabel.gridx = 0;
												gbc_userNameLabel.gridy = 3;
												add(userNameLabel, gbc_userNameLabel);
								
										userNameJTextField = new JTextField();
										GridBagConstraints gbc_userNameJTextField = new GridBagConstraints();
										gbc_userNameJTextField.anchor = GridBagConstraints.NORTH;
										gbc_userNameJTextField.fill = GridBagConstraints.HORIZONTAL;
										gbc_userNameJTextField.insets = new Insets(0, 0, 5, 0);
										gbc_userNameJTextField.gridx = 1;
										gbc_userNameJTextField.gridy = 3;
										add(userNameJTextField, gbc_userNameJTextField);
										
												JLabel vouchDrawNoIdLabel = new JLabel("VouchDrawNoId:");
												GridBagConstraints gbc_vouchDrawNoIdLabel = new GridBagConstraints();
												gbc_vouchDrawNoIdLabel.anchor = GridBagConstraints.EAST;
												gbc_vouchDrawNoIdLabel.insets = new Insets(0, 0, 5, 5);
												gbc_vouchDrawNoIdLabel.gridx = 0;
												gbc_vouchDrawNoIdLabel.gridy = 4;
												add(vouchDrawNoIdLabel, gbc_vouchDrawNoIdLabel);
										
												vouchDrawNoIdJTextField = new JTextField();
												GridBagConstraints gbc_vouchDrawNoIdJTextField = new GridBagConstraints();
												gbc_vouchDrawNoIdJTextField.anchor = GridBagConstraints.NORTH;
												gbc_vouchDrawNoIdJTextField.fill = GridBagConstraints.HORIZONTAL;
												gbc_vouchDrawNoIdJTextField.insets = new Insets(0, 0, 5, 0);
												gbc_vouchDrawNoIdJTextField.gridx = 1;
												gbc_vouchDrawNoIdJTextField.gridy = 4;
												add(vouchDrawNoIdJTextField, gbc_vouchDrawNoIdJTextField);
								
										JLabel xcancelIdcLabel = new JLabel("XcancelIdc:");
										GridBagConstraints gbc_xcancelIdcLabel = new GridBagConstraints();
										gbc_xcancelIdcLabel.anchor = GridBagConstraints.EAST;
										gbc_xcancelIdcLabel.insets = new Insets(0, 0, 5, 5);
										gbc_xcancelIdcLabel.gridx = 0;
										gbc_xcancelIdcLabel.gridy = 5;
										add(xcancelIdcLabel, gbc_xcancelIdcLabel);
						
								xcancelIdcJTextField = new JTextField();
								GridBagConstraints gbc_xcancelIdcJTextField = new GridBagConstraints();
								gbc_xcancelIdcJTextField.fill = GridBagConstraints.HORIZONTAL;
								gbc_xcancelIdcJTextField.anchor = GridBagConstraints.NORTHWEST;
								gbc_xcancelIdcJTextField.insets = new Insets(0, 0, 5, 0);
								gbc_xcancelIdcJTextField.gridx = 1;
								gbc_xcancelIdcJTextField.gridy = 5;
								add(xcancelIdcJTextField, gbc_xcancelIdcJTextField);
								
										JLabel xconfirmIdcLabel = new JLabel("XconfirmIdc:");
										GridBagConstraints gbc_xconfirmIdcLabel = new GridBagConstraints();
										gbc_xconfirmIdcLabel.anchor = GridBagConstraints.EAST;
										gbc_xconfirmIdcLabel.insets = new Insets(0, 0, 5, 5);
										gbc_xconfirmIdcLabel.gridx = 0;
										gbc_xconfirmIdcLabel.gridy = 6;
										add(xconfirmIdcLabel, gbc_xconfirmIdcLabel);
						
								xconfirmIdcJTextField = new JTextField();
								GridBagConstraints gbc_xconfirmIdcJTextField = new GridBagConstraints();
								gbc_xconfirmIdcJTextField.fill = GridBagConstraints.HORIZONTAL;
								gbc_xconfirmIdcJTextField.anchor = GridBagConstraints.NORTHWEST;
								gbc_xconfirmIdcJTextField.insets = new Insets(0, 0, 5, 0);
								gbc_xconfirmIdcJTextField.gridx = 1;
								gbc_xconfirmIdcJTextField.gridy = 6;
								add(xconfirmIdcJTextField, gbc_xconfirmIdcJTextField);
				
						JLabel xoperationIdcLabel = new JLabel("XoperationIdc:");
						GridBagConstraints gbc_xoperationIdcLabel = new GridBagConstraints();
						gbc_xoperationIdcLabel.anchor = GridBagConstraints.EAST;
						gbc_xoperationIdcLabel.insets = new Insets(0, 0, 5, 5);
						gbc_xoperationIdcLabel.gridx = 0;
						gbc_xoperationIdcLabel.gridy = 7;
						add(xoperationIdcLabel, gbc_xoperationIdcLabel);
						
								xoperationIdcJTextField = new JTextField();
								GridBagConstraints gbc_xoperationIdcJTextField = new GridBagConstraints();
								gbc_xoperationIdcJTextField.fill = GridBagConstraints.HORIZONTAL;
								gbc_xoperationIdcJTextField.anchor = GridBagConstraints.NORTHWEST;
								gbc_xoperationIdcJTextField.insets = new Insets(0, 0, 5, 0);
								gbc_xoperationIdcJTextField.gridx = 1;
								gbc_xoperationIdcJTextField.gridy = 7;
								add(xoperationIdcJTextField, gbc_xoperationIdcJTextField);
				
						JLabel xpostingIdcLabel = new JLabel("XpostingIdc:");
						GridBagConstraints gbc_xpostingIdcLabel = new GridBagConstraints();
						gbc_xpostingIdcLabel.anchor = GridBagConstraints.EAST;
						gbc_xpostingIdcLabel.insets = new Insets(0, 0, 5, 5);
						gbc_xpostingIdcLabel.gridx = 0;
						gbc_xpostingIdcLabel.gridy = 8;
						add(xpostingIdcLabel, gbc_xpostingIdcLabel);
		
				xpostingIdcJTextField = new JTextField();
				GridBagConstraints gbc_xpostingIdcJTextField = new GridBagConstraints();
				gbc_xpostingIdcJTextField.fill = GridBagConstraints.HORIZONTAL;
				gbc_xpostingIdcJTextField.anchor = GridBagConstraints.NORTHWEST;
				gbc_xpostingIdcJTextField.insets = new Insets(0, 0, 5, 0);
				gbc_xpostingIdcJTextField.gridx = 1;
				gbc_xpostingIdcJTextField.gridy = 8;
				add(xpostingIdcJTextField, gbc_xpostingIdcJTextField);
		
				JLabel ycancelIdcLabel = new JLabel("YcancelIdc:");
				GridBagConstraints gbc_ycancelIdcLabel = new GridBagConstraints();
				gbc_ycancelIdcLabel.anchor = GridBagConstraints.EAST;
				gbc_ycancelIdcLabel.insets = new Insets(0, 0, 5, 5);
				gbc_ycancelIdcLabel.gridx = 0;
				gbc_ycancelIdcLabel.gridy = 9;
				add(ycancelIdcLabel, gbc_ycancelIdcLabel);
		
				ycancelIdcJTextField = new JTextField();
				GridBagConstraints gbc_ycancelIdcJTextField = new GridBagConstraints();
				gbc_ycancelIdcJTextField.fill = GridBagConstraints.HORIZONTAL;
				gbc_ycancelIdcJTextField.anchor = GridBagConstraints.NORTHWEST;
				gbc_ycancelIdcJTextField.insets = new Insets(0, 0, 5, 0);
				gbc_ycancelIdcJTextField.gridx = 1;
				gbc_ycancelIdcJTextField.gridy = 9;
				add(ycancelIdcJTextField, gbc_ycancelIdcJTextField);
				
						JLabel yconfirmIdcLabel = new JLabel("YconfirmIdc:");
						GridBagConstraints gbc_yconfirmIdcLabel = new GridBagConstraints();
						gbc_yconfirmIdcLabel.anchor = GridBagConstraints.EAST;
						gbc_yconfirmIdcLabel.insets = new Insets(0, 0, 5, 5);
						gbc_yconfirmIdcLabel.gridx = 0;
						gbc_yconfirmIdcLabel.gridy = 10;
						add(yconfirmIdcLabel, gbc_yconfirmIdcLabel);
						
								yconfirmIdcJTextField = new JTextField();
								GridBagConstraints gbc_yconfirmIdcJTextField = new GridBagConstraints();
								gbc_yconfirmIdcJTextField.fill = GridBagConstraints.HORIZONTAL;
								gbc_yconfirmIdcJTextField.anchor = GridBagConstraints.NORTHWEST;
								gbc_yconfirmIdcJTextField.insets = new Insets(0, 0, 5, 0);
								gbc_yconfirmIdcJTextField.gridx = 1;
								gbc_yconfirmIdcJTextField.gridy = 10;
								add(yconfirmIdcJTextField, gbc_yconfirmIdcJTextField);
				
						JLabel yoperationIdcLabel = new JLabel("YoperationIdc:");
						GridBagConstraints gbc_yoperationIdcLabel = new GridBagConstraints();
						gbc_yoperationIdcLabel.anchor = GridBagConstraints.EAST;
						gbc_yoperationIdcLabel.insets = new Insets(0, 0, 5, 5);
						gbc_yoperationIdcLabel.gridx = 0;
						gbc_yoperationIdcLabel.gridy = 11;
						add(yoperationIdcLabel, gbc_yoperationIdcLabel);
		
				yoperationIdcJTextField = new JTextField();
				GridBagConstraints gbc_yoperationIdcJTextField = new GridBagConstraints();
				gbc_yoperationIdcJTextField.fill = GridBagConstraints.HORIZONTAL;
				gbc_yoperationIdcJTextField.anchor = GridBagConstraints.NORTHWEST;
				gbc_yoperationIdcJTextField.insets = new Insets(0, 0, 5, 0);
				gbc_yoperationIdcJTextField.gridx = 1;
				gbc_yoperationIdcJTextField.gridy = 11;
				add(yoperationIdcJTextField, gbc_yoperationIdcJTextField);
				
						JLabel ypostingIdcLabel = new JLabel("YpostingIdc:");
						GridBagConstraints gbc_ypostingIdcLabel = new GridBagConstraints();
						gbc_ypostingIdcLabel.anchor = GridBagConstraints.EAST;
						gbc_ypostingIdcLabel.insets = new Insets(0, 0, 0, 5);
						gbc_ypostingIdcLabel.gridx = 0;
						gbc_ypostingIdcLabel.gridy = 12;
						add(ypostingIdcLabel, gbc_ypostingIdcLabel);
		
				ypostingIdcJTextField = new JTextField();
				ypostingIdcJTextField.setColumns(1);
				GridBagConstraints gbc_ypostingIdcJTextField = new GridBagConstraints();
				gbc_ypostingIdcJTextField.fill = GridBagConstraints.HORIZONTAL;
				gbc_ypostingIdcJTextField.anchor = GridBagConstraints.NORTHWEST;
				gbc_ypostingIdcJTextField.gridx = 1;
				gbc_ypostingIdcJTextField.gridy = 12;
				add(ypostingIdcJTextField, gbc_ypostingIdcJTextField);

		if (users != null) {
			m_bindingGroup = initDataBindings();
		}
	}

	protected BindingGroup initDataBindings() {
		BeanProperty<Users, java.lang.String> employeeIdProperty = BeanProperty
				.create("employeeId");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty = BeanProperty
				.create("text");
		AutoBinding<Users, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ, users,
						employeeIdProperty, employeeIdJTextField, textProperty);
		autoBinding.bind();
		//
		BeanProperty<Users, java.lang.String> passwordCodeProperty = BeanProperty
				.create("passwordCode");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty_1 = BeanProperty
				.create("text");
		AutoBinding<Users, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding_1 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ, users,
						passwordCodeProperty, passwordCodeJTextField,
						textProperty_1);
		autoBinding_1.bind();
		//
		BeanProperty<Users, java.lang.String> paymentNoIdProperty = BeanProperty
				.create("paymentNoId");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty_2 = BeanProperty
				.create("text");
		AutoBinding<Users, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding_2 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ, users,
						paymentNoIdProperty, paymentNoIdJTextField,
						textProperty_2);
		autoBinding_2.bind();
		//
		BeanProperty<Users, java.lang.String> userNameProperty = BeanProperty
				.create("userName");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty_3 = BeanProperty
				.create("text");
		AutoBinding<Users, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding_3 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ, users,
						userNameProperty, userNameJTextField, textProperty_3);
		autoBinding_3.bind();
		//
		BeanProperty<Users, java.lang.String> vouchDrawNoIdProperty = BeanProperty
				.create("vouchDrawNoId");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty_4 = BeanProperty
				.create("text");
		AutoBinding<Users, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding_4 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ, users,
						vouchDrawNoIdProperty, vouchDrawNoIdJTextField,
						textProperty_4);
		autoBinding_4.bind();
		//
		BeanProperty<Users, java.lang.String> xcancelIdcProperty = BeanProperty
				.create("xcancelIdc");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty_5 = BeanProperty
				.create("text");
		AutoBinding<Users, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding_5 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ, users,
						xcancelIdcProperty, xcancelIdcJTextField,
						textProperty_5);
		autoBinding_5.bind();
		//
		BeanProperty<Users, java.lang.String> xconfirmIdcProperty = BeanProperty
				.create("xconfirmIdc");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty_6 = BeanProperty
				.create("text");
		AutoBinding<Users, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding_6 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ, users,
						xconfirmIdcProperty, xconfirmIdcJTextField,
						textProperty_6);
		autoBinding_6.bind();
		//
		BeanProperty<Users, java.lang.String> xoperationIdcProperty = BeanProperty
				.create("xoperationIdc");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty_7 = BeanProperty
				.create("text");
		AutoBinding<Users, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding_7 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ, users,
						xoperationIdcProperty, xoperationIdcJTextField,
						textProperty_7);
		autoBinding_7.bind();
		//
		BeanProperty<Users, java.lang.String> xpostingIdcProperty = BeanProperty
				.create("xpostingIdc");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty_8 = BeanProperty
				.create("text");
		AutoBinding<Users, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding_8 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ, users,
						xpostingIdcProperty, xpostingIdcJTextField,
						textProperty_8);
		autoBinding_8.bind();
		//
		BeanProperty<Users, java.lang.String> ycancelIdcProperty = BeanProperty
				.create("ycancelIdc");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty_9 = BeanProperty
				.create("text");
		AutoBinding<Users, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding_9 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ, users,
						ycancelIdcProperty, ycancelIdcJTextField,
						textProperty_9);
		autoBinding_9.bind();
		//
		BeanProperty<Users, java.lang.String> yconfirmIdcProperty = BeanProperty
				.create("yconfirmIdc");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty_10 = BeanProperty
				.create("text");
		AutoBinding<Users, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding_10 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ, users,
						yconfirmIdcProperty, yconfirmIdcJTextField,
						textProperty_10);
		autoBinding_10.bind();
		//
		BeanProperty<Users, java.lang.String> yoperationIdcProperty = BeanProperty
				.create("yoperationIdc");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty_11 = BeanProperty
				.create("text");
		AutoBinding<Users, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding_11 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ, users,
						yoperationIdcProperty, yoperationIdcJTextField,
						textProperty_11);
		autoBinding_11.bind();
		//
		BeanProperty<Users, java.lang.String> ypostingIdcProperty = BeanProperty
				.create("ypostingIdc");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty_12 = BeanProperty
				.create("text");
		AutoBinding<Users, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding_12 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ, users,
						ypostingIdcProperty, ypostingIdcJTextField,
						textProperty_12);
		autoBinding_12.bind();
		//
		BindingGroup bindingGroup = new BindingGroup();
		bindingGroup.addBinding(autoBinding);
		bindingGroup.addBinding(autoBinding_1);
		bindingGroup.addBinding(autoBinding_2);
		bindingGroup.addBinding(autoBinding_3);
		bindingGroup.addBinding(autoBinding_4);
		bindingGroup.addBinding(autoBinding_5);
		bindingGroup.addBinding(autoBinding_6);
		bindingGroup.addBinding(autoBinding_7);
		bindingGroup.addBinding(autoBinding_8);
		bindingGroup.addBinding(autoBinding_9);
		bindingGroup.addBinding(autoBinding_10);
		bindingGroup.addBinding(autoBinding_11);
		bindingGroup.addBinding(autoBinding_12);
		//
		return bindingGroup;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users newUsers) {
		setUsers(newUsers, true);
	}

	public void setUsers(Users newUsers, boolean update) {
		users = newUsers;
		if (update) {
			if (m_bindingGroup != null) {
				m_bindingGroup.unbind();
				m_bindingGroup = null;
			}
			if (users != null) {
				m_bindingGroup = initDataBindings();
			}
		}
	}
}
