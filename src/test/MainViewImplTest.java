package test;

import static org.junit.Assert.assertEquals;

import javax.swing.JButton;

import org.junit.Test;

import view.IMainView;
import view.MainViewImpl;
import controller.IMainController;
import controller.MainControllerImpl;

public class MainViewImplTest {
	@Test
	public void openUserManagerFormTest() {
		IMainController controller = new MainControllerImpl();
		IMainView view = new MainViewImpl(controller, null);
		view.createView();
		
		for (int i = 0; i < view.getUI().getContentPane().getComponentCount(); i++) {
			if (view.getUI().getContentPane().getComponent(i) instanceof JButton) {
				JButton x = (JButton) view.getUI().getContentPane()
						.getComponent(i);
				if (x.getText() == "�ϥΪ̺��@")
					x.doClick();
				assertEquals(x.getActionCommand(),"�ϥΪ̺��@");
				
				

			}
		}
		

	}

}
