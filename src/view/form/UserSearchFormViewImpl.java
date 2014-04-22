package view.form;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.BaseDAO;
import database.Users;

public class UserSearchFormViewImpl implements IFormView {
	List<Users> list;
	JDialog dialog;
	private JPanel contentPane;
	private JTable table;
	String[] columns = { "CompanyId", "UserId", "EmployeeId", "User Name" };
	ArrayList<Object[]> data = new ArrayList<Object[]>();
	private JScrollPane scrollPane;
	Users selectedUser;
	

	Users currentUser;

	/**
	 * Create the frame.
	 */
	
	public UserSearchFormViewImpl(Users user) {
		this.currentUser = user;

		list = new BaseDAO<Users>()
				.list("select users from Users");
		for (Iterator<Users> iterator = list.iterator(); iterator.hasNext();) {
			Users u = (Users) iterator.next();

			Object[] row = new Object[] {
					u.getUserId(), u.getEmployeeId(), u.getUserName()

			};
			data.add(row);

		}
		Object[][] realData = data.toArray(new Object[data.size()][]);
		for (int i = 0; i < realData.length; i++) {
			for (int j = 0; j < realData[i].length; j++) {
				System.out.println(realData[i][j]);
			}
			System.out.println();
		}

		dialog = new JDialog();
		dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		dialog.setModal(true);
		dialog.setMinimumSize(new Dimension(400, 350));
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		dialog.setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 419, 218);
		contentPane.add(scrollPane);

		table = new JTable(realData, columns);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				int selectRows = table.getSelectedRows().length;
				int selectedRowIndex;
			
				if (selectRows == 1) {
					selectedRowIndex = table.getSelectedRow();
					selectedUser=list.get(selectedRowIndex);
				}

			}
		});
		MouseAdapter adapt= new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
			
				int selectRows = table.getSelectedRows().length;
				int selectedRowIndex;
			
				if (selectRows == 1) {
					selectedRowIndex = table.getSelectedRow();
					selectedUser=list.get(selectedRowIndex);
				}
			}
			
		};

		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(352, 233, 72, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (selectedUser != null)
					System.out.println(selectedUser.getUserId());

			}
		});
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		contentPane.add(btnNewButton);
		//dialog.setVisible(true);

	}
	
	public Users getSelectedUser() {
		return selectedUser;
	}
	public boolean showModal() {
		return dialog.isModal();

	}

	@Override
	public void show() {
		dialog.setVisible(true);

	}

	@Override
	public void dispose() {
		dialog.dispose();

	}

}
