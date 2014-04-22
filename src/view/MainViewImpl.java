package view;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.IUserModel;

import common.Utility;

import controller.IMainController;
import controller.action.CreateFormAction;


public class MainViewImpl implements IMainView {
	JFrame frame;
	
	IMainController controller;
	IUserModel model;
	
	CreateFormAction act;

	public MainViewImpl(IMainController controller,IUserModel model){
		this.controller=controller;
		this.model=model;
	}

	@Override
	public void show() {
		frame.setVisible(true);
		
	}



	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void createView() {


		frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("請購作業");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("請購單維護");
		act=new CreateFormAction("請購單維護",null,null,null);
		mntmNewMenuItem.addActionListener(act);	
		mnNewMenu.add(mntmNewMenuItem);
		
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("請購單審核");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		
		JMenu mnNewMenu_1 = new JMenu("採購作業");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("採購單維護");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("採購單審核");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		
		JMenu mnNewMenu_2 = new JMenu("驗收作業");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("驗收單維護");
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("驗收單審核");
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("驗收單過帳");
		mnNewMenu_2.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_3 = new JMenu("庫存維護");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("原料庫存維護");
		mnNewMenu_3.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("物料庫存維護");
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_4 = new JMenu("系統作業");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem menuItem = new JMenuItem("使用者維護");
		act=new CreateFormAction("使用者維護",null,null,null);
		menuItem.addActionListener(act);		
		mnNewMenu_4.add(menuItem);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("程式權限維護");
		mnNewMenu_4.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("部門維護");
		mnNewMenu_4.add(mntmNewMenuItem_10);
		
		JMenuItem menuItem_1 = new JMenuItem("公司別維護");
		mnNewMenu_4.add(menuItem_1);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("料號維護");
		mnNewMenu_4.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("對象編號維護");
		mnNewMenu_4.add(mntmNewMenuItem_12);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("各項代號維護");
		mnNewMenu_4.add(mntmNewMenuItem_13);
		
		
		JMenu mnNewMenu_5 = new JMenu("結束系統");		
		mnNewMenu_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(Utility.showQuestionDialog(frame, "是否確定離開?")==JOptionPane.YES_OPTION){
					controller.exit();
				}
			}
		});
		menuBar.add(mnNewMenu_5);
		JPanel contentPane;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}

	@Override
	public IMainController getController() {
		return controller;
	}

	@Override
	public IUserModel getUserModel() {		
		return model;
	}

	@Override
	public JFrame getUI() {		
		return frame;
	}

	@Override
	public boolean isVisible() {		
		return frame.isVisible();
	}
}
