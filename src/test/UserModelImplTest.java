package test;

import static org.junit.Assert.assertEquals;
import model.IUserModel;
import model.UserModelImpl;

import org.junit.Test;

public class UserModelImplTest {

	@Test
	public void testVerifyUser() {
		
		final String userId = "kulaudo";
		final String pass = "123";
		final char[] password = "123".toCharArray();
		final IUserModel model = new UserModelImpl(userId);		
		model.verifyUser(password);
		assertEquals(pass, new String(password));
		assertEquals(model.getUser().getUserName(), "吳延朗");
		assertEquals(model.getUser().getPasswordCode(), "bnufzeaw");
		assertEquals(model.getUser().getEmployeeId(), "02990");
		assertEquals(model.getUser().getUserId(), "kulaudo");
		
	}
}
