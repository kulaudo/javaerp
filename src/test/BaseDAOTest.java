package test;

import junit.framework.TestCase;
import model.BaseDAO;

import org.hibernate.Session;
import org.junit.Test;

import common.HibernateUtil;

import database.Users;

public class BaseDAOTest extends TestCase {
	BaseDAO<Users> dao = new BaseDAO<Users>();
	Users u;
	Session session;
	@Override
	protected void setUp() throws Exception {		
		super.setUp();

		u = new Users("A10", "zzz123");		
	}

	@Override
	protected void tearDown() throws Exception {	
		super.tearDown();		
		u = null;
	}

	@Test
	public void testCreate(){
		//儲存使用者u
		dao.create(u);
		//驗證u是否能從資料庫中找到
		assertTrue(dao.find(Users.class, "A10") != null);
		
	}

	@Test
	public void testUpdate() {
		//儲存使用者u
		dao.create(u);
		u.setUserName("a1");
		//將使用者u資料更新
		dao.update(u);
		//新建一使用者b來做搜尋
		Users b = dao.find(Users.class, "A10");
		//驗證是否b和為同一個User
		assertTrue((b.getUserName().toString().equals("a1")));
		
		
	}

	@Test
	public void testDelete() {
		//儲存使用者u
		dao.create(u);
		//驗證u是否能從資料庫中找到
		assertTrue(dao.find(Users.class, "A10") != null);
		//刪除使用者u
		dao.delete(u);
		//驗證使用者u是否從資料庫中刪除
		assertTrue(dao.find(Users.class, "A10") == null);
	}

	@Test
	public void testFind() {	
		//驗證使用者u的密碼是否如預期
		assertTrue(u.getPasswordCode().toString().equals("zzz123"));
		
	}	

}
