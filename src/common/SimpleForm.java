package common;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class SimpleForm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleForm frame = new SimpleForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SimpleForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1062, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("複製");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("修改");
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("刪除");
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("取消");
		panel_3.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("儲存");
		panel_3.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("作廢");
		panel_3.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("回復");
		panel_3.add(btnNewButton_7);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JButton btnNewButton_8 = new JButton("資料重讀");
		panel_4.add(btnNewButton_8);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JButton btnNewButton_9 = new JButton("<<");
		panel_5.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("<");
		panel_5.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton(">");
		panel_5.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton(">>");
		panel_5.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("關閉");
		panel_5.add(btnNewButton_13);
		
		JPanel panel_7 = new JPanel();
		contentPane.add(panel_7, BorderLayout.CENTER);
		
		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6, BorderLayout.SOUTH);		
		
		panel_6.setBorder((Border) new BevelBorder(BevelBorder.LOWERED));
		getContentPane().add(panel_6, BorderLayout.SOUTH);
		panel_6.setPreferredSize(new Dimension(getWidth(), 16));
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		JLabel statusLabel = new JLabel("status");
		statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel_6.add(statusLabel);
	}

}
