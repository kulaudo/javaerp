package common;

import model.BaseDAO;
import database.Users;

public class Test {
	public static void main(String[] args) {

		Users user = (Users) new BaseDAO<Users>().find(Users.class, "kulaudo");
		System.out.println(user.getEmployeeId());
	}
}
