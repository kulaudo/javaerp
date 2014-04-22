package test;

import junit.framework.TestCase;
import model.UserModelImpl;

import org.junit.Rule;
import org.junit.Test;

import view.ILoginView;
import view.LoginViewImpl;

import common.ExpectedSystemExit;
import common.NoExitSecurityManager;

import controller.ILoginController;
import controller.IMainController;
import controller.LoginControllerImpl;
import controller.MainControllerImpl;

public class LoginControllerImplTest extends TestCase {

	@Test
	public void testMainInLoginControllerImpl() throws Exception {
		final IMainController main = new MainControllerImpl();
		final ILoginController controller= new LoginControllerImpl(main);		
		LoginControllerImpl impl = new LoginControllerImpl(main);
		assertEquals(main, impl.getMainController());		

	}


	@Test
	public void testLogin() {
		final IMainController main = new MainControllerImpl();
		final ILoginController controller= new LoginControllerImpl(main);		
		controller.login("kulaudo", "bnufzeaw".toCharArray());		
		assertEquals(controller.getModel().getUser().getUserName(),"吳延朗");		
		assertEquals(controller.getModel().getUser().getEmployeeId(),"02990");		
	}
	
	
	
	
	
	@Rule
	public final ExpectedSystemExit exit = ExpectedSystemExit.none();


	@Test
	public void testCancel() throws Exception {
		final IMainController main = new MainControllerImpl();
		final ILoginController controller= new LoginControllerImpl(main);
		LoginControllerImpl impl = new LoginControllerImpl(main);
		System.setSecurityManager(new NoExitSecurityManager());
		impl.cancel();	
	}
}
