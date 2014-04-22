package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.IUserModel;
import controller.ILoginController;
import controller.LoginControllerImpl;

public class LoginViewImpl implements ILoginView {
	JFrame frame;
	IUserModel userModel;
	
	private static final long serialVersionUID = -400421328972932652L;

	private static final Logger LOG = LoggerFactory
			.getLogger(LoginViewImpl.class);

	ILoginController loginController;

	private JButton buttonCancel;
	private JButton buttonOK;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblMessage, lbAccount, lbPassword;
	String company, username;
	char[] password;
	private JTextField txtCompany;

	public LoginViewImpl(IUserModel userModel, ILoginController controller) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				
				loginController.cancel();
			}
		});
		
		this.userModel=userModel;
		this.loginController=controller;
		getContentPane().setLayout(null);

		txtUsername = new JTextField();
		txtUsername.setBounds(105, 67, 96, 21);
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(105, 98, 96, 21);
		getContentPane().add(txtPassword);

		lbAccount = new JLabel("±b¸¹");
		lbAccount.setBounds(49, 70, 46, 15);
		getContentPane().add(lbAccount);

		lbPassword = new JLabel("±K½X");
		lbPassword.setBounds(49, 101, 46, 15);
		getContentPane().add(lbPassword);

		lblMessage = new JLabel("");
		lblMessage.setForeground(Color.RED);
		lblMessage.setBounds(87, 161, 46, 15);
		getContentPane().add(lblMessage);

		buttonOK = new JButton("OK");
		buttonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCompany(txtCompany.getText());
				setUsername(txtUsername.getText());
				setPassword(txtPassword.getPassword());
				loginController.login(company, username, password);
			}
		});		
		buttonOK.setBounds(203, 161, 87, 23);
		getContentPane().add(buttonOK);

		buttonCancel = new JButton("Cancel");
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginController.cancel();
			}
		});
		
		buttonCancel.setBounds(105, 161, 87, 23);
		getContentPane().add(buttonCancel);

		txtCompany = new JTextField();
		txtCompany.setBounds(105, 36, 96, 21);
		getContentPane().add(txtCompany);
		txtCompany.setColumns(10);

		JLabel lblCompany = new JLabel("¤½¥q");
		lblCompany.setBounds(49, 39, 46, 15);
		getContentPane().add(lblCompany);
	}
	@Override
	public void createView() {
		this.setVisible(true);
		this.setBounds(600,300,320,240);
		
	}

	public JFrame getViewUI() {
		return frame;
	}

	public ILoginController getController() {
		return loginController;
	}

	public void setController(ILoginController ctrl) {
		this.loginController = ctrl;
	}


	@Override
	public void setUsername(String username) {
		//LOG.info("SET USERNAME '" + username + "'");
		this.username=username;
	}

	public void setMessage(String message) {
		//LOG.info("SET MESSAGE '" + message + "'");
		lblMessage.setText(message);
	}

	@Override
	public void setCompany(String company) {
		this.company = company;

	}

	@Override
	public void setPassword(char[] password) {
		this.password = password;

	}

}
