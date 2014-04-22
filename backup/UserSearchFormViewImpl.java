package view.form;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.BaseDAO;
import database.Users;
import java.awt.FlowLayout;

public class UserSearchFormViewImpl implements IFormView {
	List<Users> list;
	JFrame frame;
	private JPanel contentPane;
	private JTable table;
	String[] columns = { "CompanyId", "UserId", "Password", "EmployeeId" };
	ArrayList<Object[]> data = new ArrayList<Object[]>();
	private JScrollPane scrollPane;
	Users selectedUsers;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserSearchFormViewImpl frame = new UserSearchFormViewImpl();
					frame.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserSearchFormViewImpl() {
		list = new BaseDAO<Users>().list("select c from Users c");
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Users u = (Users) iterator.next();

			Object[] row = new Object[] { u.getId().getCompanyId(),
					u.getId().getUserId(), u.getPasswordCode(),
					u.getEmployeeId()

			};
			data.add(row);
			for (int i = 0; i < row.length; i++) {
				// System.out.print(row[i]+"\t");

			}
			// System.out.println();

		}
		Object[][] realData = data.toArray(new Object[data.size()][]);
		for (int i = 0; i < realData.length; i++) {
			for (int j = 0; j < realData[i].length; j++) {
				System.out.println(realData[i][j]);
			}
			System.out.println();
		}

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 419, 218);
		contentPane.add(scrollPane);
		
		
		table = new JTable(realData, columns);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {				
				int selectRows = table.getSelectedRows().length; // 取得用戶所選行的行數
				int selectedRowIndex;				
				
				if (selectRows == 1) {
					selectedRowIndex = table.getSelectedRow(); // 取得用戶所選單行					
					selectedUsers= list.get(selectedRowIndex);
				}
				
			}
		});
		
		


		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(352, 233, 72, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(selectedUsers.getId().getUserId());
			}
		});
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		contentPane.add(btnNewButton);
	}

	@Override
	public void show() {
		frame.setVisible(true);

	}

	@Override
	public void dispose() {
		frame.dispose();

	}

}
