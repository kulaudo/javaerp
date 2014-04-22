package view;

import javax.swing.JFrame;

public interface ILoginView extends IView {

	public void setInput(String account,String userId);

	public void createView();

	public JFrame getUI();
	
}
