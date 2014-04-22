package view.form;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.IObserver;
import controller.form.IFormController;

public class DataFilterFormViewImpl implements IFormView {
	JFrame frame;
	String bgDate, edDate, bgDepart, edDepart, bgOp, edOp, bgCf, edCf, bgPo,
			edPo;
	ArrayList<IObserver> observers;
	IFormController controller;
	private JTextField txtbgdate;
	private JTextField txteddate;
	private JTextField txtbgdepart;
	private JTextField txtedpart;
	private JLabel label;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JTextField txtbgop;
	private JTextField txtedop;
	private JTextField txtbgcf;
	private JTextField txtedcf;
	private JTextField txtbgpo;
	private JTextField txtedpo;
	private JButton btnNewButton;
	private boolean needUpdate;

	@Override
	public void show() {
		frame.setVisible(true);

	}

	@Override
	public void dispose() {
		frame.dispose();

	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public DataFilterFormViewImpl(IFormController controller) {
		super();
		observers=new ArrayList<IObserver>();
		this.controller=controller;
		frame = new JFrame();
		frame.setTitle("資料篩選");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 80, 20, 80, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("日期");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		txtbgdate = new JTextField();
		GridBagConstraints gbc_txtbgdate = new GridBagConstraints();
		gbc_txtbgdate.insets = new Insets(0, 0, 5, 5);
		gbc_txtbgdate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtbgdate.gridx = 2;
		gbc_txtbgdate.gridy = 1;
		frame.getContentPane().add(txtbgdate, gbc_txtbgdate);
		txtbgdate.setColumns(10);

		JLabel label_1 = new JLabel("~");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 1;
		frame.getContentPane().add(label_1, gbc_label_1);

		txteddate = new JTextField();
		GridBagConstraints gbc_txteddate = new GridBagConstraints();
		gbc_txteddate.insets = new Insets(0, 0, 5, 5);
		gbc_txteddate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txteddate.gridx = 4;
		gbc_txteddate.gridy = 1;
		frame.getContentPane().add(txteddate, gbc_txteddate);
		txteddate.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("部門");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

		txtbgdepart = new JTextField();
		GridBagConstraints gbc_txtbgdepart = new GridBagConstraints();
		gbc_txtbgdepart.insets = new Insets(0, 0, 5, 5);
		gbc_txtbgdepart.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtbgdepart.gridx = 2;
		gbc_txtbgdepart.gridy = 2;
		frame.getContentPane().add(txtbgdepart, gbc_txtbgdepart);
		txtbgdepart.setColumns(10);

		label = new JLabel("~");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 3;
		gbc_label.gridy = 2;
		frame.getContentPane().add(label, gbc_label);

		txtedpart = new JTextField();
		GridBagConstraints gbc_txtedpart = new GridBagConstraints();
		gbc_txtedpart.insets = new Insets(0, 0, 5, 5);
		gbc_txtedpart.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtedpart.gridx = 4;
		gbc_txtedpart.gridy = 2;
		frame.getContentPane().add(txtedpart, gbc_txtedpart);
		txtedpart.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u88FD\u55AE\u4EBA\u54E1");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);

		txtbgop = new JTextField();
		txtbgop.setColumns(10);
		GridBagConstraints gbc_txtbgop = new GridBagConstraints();
		gbc_txtbgop.insets = new Insets(0, 0, 5, 5);
		gbc_txtbgop.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtbgop.gridx = 2;
		gbc_txtbgop.gridy = 3;
		frame.getContentPane().add(txtbgop, gbc_txtbgop);

		label_2 = new JLabel("~");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 3;
		gbc_label_2.gridy = 3;
		frame.getContentPane().add(label_2, gbc_label_2);

		txtedop = new JTextField();
		txtedop.setColumns(10);
		GridBagConstraints gbc_txtedop = new GridBagConstraints();
		gbc_txtedop.insets = new Insets(0, 0, 5, 5);
		gbc_txtedop.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtedop.gridx = 4;
		gbc_txtedop.gridy = 3;
		frame.getContentPane().add(txtedop, gbc_txtedop);

		label_5 = new JLabel("審核人員");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 1;
		gbc_label_5.gridy = 4;
		frame.getContentPane().add(label_5, gbc_label_5);

		txtbgcf = new JTextField();
		txtbgcf.setColumns(10);
		GridBagConstraints gbc_txtbgcf = new GridBagConstraints();
		gbc_txtbgcf.insets = new Insets(0, 0, 5, 5);
		gbc_txtbgcf.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtbgcf.gridx = 2;
		gbc_txtbgcf.gridy = 4;
		frame.getContentPane().add(txtbgcf, gbc_txtbgcf);

		label_3 = new JLabel("~");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 3;
		gbc_label_3.gridy = 4;
		frame.getContentPane().add(label_3, gbc_label_3);

		txtedcf = new JTextField();
		txtedcf.setColumns(10);
		GridBagConstraints gbc_txtedcf = new GridBagConstraints();
		gbc_txtedcf.insets = new Insets(0, 0, 5, 5);
		gbc_txtedcf.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtedcf.gridx = 4;
		gbc_txtedcf.gridy = 4;
		frame.getContentPane().add(txtedcf, gbc_txtedcf);

		label_6 = new JLabel("過帳人員");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.EAST;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 1;
		gbc_label_6.gridy = 5;
		frame.getContentPane().add(label_6, gbc_label_6);

		txtbgpo = new JTextField();
		txtbgpo.setColumns(10);
		GridBagConstraints gbc_txtbgpo = new GridBagConstraints();
		gbc_txtbgpo.insets = new Insets(0, 0, 5, 5);
		gbc_txtbgpo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtbgpo.gridx = 2;
		gbc_txtbgpo.gridy = 5;
		frame.getContentPane().add(txtbgpo, gbc_txtbgpo);

		label_4 = new JLabel("~");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 3;
		gbc_label_4.gridy = 5;
		frame.getContentPane().add(label_4, gbc_label_4);

		txtedpo = new JTextField();
		txtedpo.setColumns(10);
		GridBagConstraints gbc_txtedpo = new GridBagConstraints();
		gbc_txtedpo.insets = new Insets(0, 0, 5, 5);
		gbc_txtedpo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtedpo.gridx = 4;
		gbc_txtedpo.gridy = 5;
		frame.getContentPane().add(txtedpo, gbc_txtedpo);

		btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 6;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
	}

	

	public String getBgDate() {
		return bgDate;
	}

	public void setBgDate(String bgDate) {
		needUpdate = (bgDate.equals(this.bgDate));
		this.bgDate = bgDate;
	}

	public String getEdDate() {

		return edDate;
	}

	public void setEdDate(String edDate) {
		needUpdate = (edDate.equals(this.edDate));
		this.edDate = edDate;
	}

	public String getBgDepart() {
		return bgDepart;
	}

	public void setBgDepart(String bgDepart) {
		needUpdate = (bgDepart.equals(this.bgDepart));
		this.bgDepart = bgDepart;
	}

	public String getEdDepart() {
		return edDepart;
	}

	public void setEdDepart(String edDepart) {
		needUpdate = (edDepart.equals(this.edDepart));
		this.edDepart = edDepart;
	}

	public String getBgOp() {
		return bgOp;
	}

	public void setBgOp(String bgOp) {
		needUpdate = (bgOp.equals(this.bgOp));
		this.bgOp = bgOp;
	}

	public String getEdOp() {
		return edOp;
	}

	public void setEdOp(String edOp) {
		needUpdate = (bgOp.equals(this.bgOp));
		this.edOp = edOp;
	}

	public void setEdCf(String edCf) {
		needUpdate = (edCf.equals(this.edCf));
		this.edCf = edCf;
	}

	public void setBgCf(String bgCf) {
		needUpdate = (bgCf.equals(this.bgCf));
		this.bgCf = bgCf;
	}

	public String getEdCf() {
		return edCf;
	}

	public String getBgCf() {
		return bgCf;
	}

	public String getBgPo() {
		return bgPo;
	}

	public void setBgPo(String bgPo) {
		needUpdate = (bgPo.equals(this.bgPo));
		this.bgPo = bgPo;
	}

	public String getEdPo() {
		return edPo;
	}

	public void setEdPo(String edPo) {
		needUpdate = (edPo.equals(this.edPo));
		this.edPo = edPo;
	}


	public void update() {
		setBgDate(txtbgdate.getText());
		setEdDate(txteddate.getText());
		setBgDepart(txtbgdepart.getText());
		setEdDepart(txtedpart.getText());
		setBgOp(txtbgop.getText());
		setEdOp(txtedop.getText());
		setBgCf(txtbgcf.getText());
		setEdCf(txtedcf.getText());
		setBgPo(txtbgpo.getText());
		setEdPo(txtedpo.getText());
		if (needUpdate) {
			setChanged();
		}

	}


	public void notifyObserver() {
		for (Iterator iterator = this.observers.iterator(); iterator.hasNext();) {
			IObserver o = (IObserver) iterator.next();
			//o.update(bgDate,edDate,bgDepart,edDepart,bgOp,edOp,bgCf,edCf,bgPo,edPo);
		}

	}


	public void setChanged() {
		notifyObserver();

	}


	public void registerObserver(IObserver o) {
		this.observers.add(o);
		
	}


	public void deleteObserver(IObserver o) {
		observers.remove(o);
		
	}

}
