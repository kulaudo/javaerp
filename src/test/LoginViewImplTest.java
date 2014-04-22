package test;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import junit.framework.TestCase;
import model.UserModelImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import view.LoginViewImpl;

import common.ExitException;
import common.NoExitSecurityManager;

import controller.LoginControllerImpl;
import controller.MainControllerImpl;

public class LoginViewImplTest extends TestCase {
    @Before
    protected void setUp() throws Exception 
    {
        super.setUp();
        System.setSecurityManager(new NoExitSecurityManager());
    }
    @After
    protected void tearDown() throws Exception 
    {
        System.setSecurityManager(null); // or save and restore original
        super.tearDown();
    }

	@Test
	public void testIfButtonSubmitClick() {
		final LoginViewImpl impl = new LoginViewImpl(new UserModelImpl(),
				new LoginControllerImpl(new MainControllerImpl()));
		impl.createView();
		JTextField y;
		JPasswordField z;
		for (int i = 0; i < impl.getUI().getContentPane().getComponentCount(); i++) {
			assert (impl.getUI().getContentPane().getComponent(i) != null);
			if (impl.getUI().getContentPane().getComponent(i) instanceof JTextField) {
				y = (JTextField) impl.getUI().getContentPane().getComponent(i);
				
				if (y.getName() == "txtUserId") {
					y.setText("kulaudo");
				}
			}
			if (impl.getUI().getContentPane().getComponent(i) instanceof JPasswordField) {
				z = (JPasswordField) impl.getUI().getContentPane()
						.getComponent(i);
				if (z.getName() == "txtPassword") {
					z.setText("bnufzeaw");
				}
			}
		}
		JButton x;
		for (int i = 0; i < impl.getUI().getContentPane().getComponentCount(); i++) {
			if (impl.getUI().getContentPane().getComponent(i) instanceof JButton) {
				x = (JButton) impl.getUI().getContentPane().getComponent(i);
				if (x.getText() == "Submit") {
					x.doClick();					
					assertEquals(impl.getUserId(), "kulaudo");
					assertEquals(new String(impl.getPassword()), "bnufzeaw");
				} 
			}
		}
	}
	@Test
	public void testIfButtonCancelClick() {
		final LoginViewImpl impl = new LoginViewImpl(new UserModelImpl(),
				new LoginControllerImpl(new MainControllerImpl()));
		impl.createView();
		JButton x;
		for (int i = 0; i < impl.getUI().getContentPane().getComponentCount(); i++) {
			if (impl.getUI().getContentPane().getComponent(i) instanceof JButton) {
				x = (JButton) impl.getUI().getContentPane().getComponent(i);
				if (x.getText() == "Cacbel") {
					try {
						x.doClick();
					} catch (ExitException e) {
						assertEquals("Exit Status",0,e.status);
					}
					
				}
			}
		}

	}

}
