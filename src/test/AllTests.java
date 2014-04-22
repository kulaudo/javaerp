package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ GetEngMoneyTest.class, GetTwnMoneyTest.class,
		LoginControllerImplTest.class, LoginViewImplTest.class,
		MainViewImplTest.class, UserModelImplTest.class })
public class AllTests {

}
