package common;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class LoadingWindow extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8301287107878638674L;

	/**
	 * Create the panel.
	 */
	public LoadingWindow() {
		setBackground(Color.BLUE);
		setLayout(null);
		
		JLabel label = new JLabel("��ƳB�z��");
		label.setForeground(Color.YELLOW);
		label.setBounds(135, 40, 200, 48);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("�з���", Font.PLAIN, 40));
		add(label);

	}
}
