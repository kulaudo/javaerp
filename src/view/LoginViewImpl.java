package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.IUserModel;
import controller.ILoginController;

public class LoginViewImpl implements ILoginView {

	private final class LoginCancelListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			loginController.cancel();

		}
	}

	private JFrame frame;
	private JPanel contentPane;
	private ILoginController loginController;
	private IUserModel userModel;
	private String userId;

	private char[] password;
	private JTextField txtAccount;
	private JPasswordField passwordField;
	private ActionListener action = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			setUserId(txtAccount.getText());
			setPassword(passwordField.getPassword());
			System.out.println(" userid=" + userId + " password="
					+ new String(password));
			loginController.login(userId, password);
		}
	};

	public LoginViewImpl(IUserModel userModel, ILoginController controller) {
		this.userModel = userModel;
		loginController = controller;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPassword(char[] password) {
		this.password = password;

	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void createView() {
		frame = new JFrame();
		frame.setTitle("Please Login");
		frame.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 300, 200);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelAccount = new JLabel("帳號");
		labelAccount.setBounds(51, 33, 46, 15);
		contentPane.add(labelAccount);

		JLabel labelPassword = new JLabel("密碼");
		labelPassword.setBounds(51, 73, 46, 15);
		contentPane.add(labelPassword);

		txtAccount = new JTextField();
		txtAccount.setName("txtUserId");
		txtAccount.setBounds(107, 30, 96, 21);
		contentPane.add(txtAccount);
		txtAccount.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setName("txtPassword");
		passwordField.setBounds(107, 70, 96, 21);

		contentPane.add(passwordField);
		passwordField.requestFocus();

		JButton btSubmit = new JButton("Submit");
		btSubmit.addActionListener(action);
		btSubmit.setBounds(187, 128, 87, 23);

		frame.getRootPane().setDefaultButton(btSubmit);

		contentPane.add(btSubmit);

		JButton btCancel = new JButton("Cancel");
		btCancel.addActionListener(new LoginCancelListener());
		btCancel.setBounds(93, 128, 87, 23);
		contentPane.add(btCancel);
		frame.setVisible(true);

	}

	@Override
	public JFrame getUI() {
		return frame;
	}

	public String getUserId() {
		return userId;
	}

	public char[] getPassword() {
		return password;
	}

	@Override
	public void setInput(String userId, String password) {
		this.txtAccount.setText(userId);
		this.passwordField.setText(password);
	}
}
