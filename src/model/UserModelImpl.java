package model;

import database.Users;

public class UserModelImpl implements IUserModel {
	BaseDAO<Users> dao = new BaseDAO<Users>();
	

	
	String id;
	Users currentUser;
	boolean isVerified = false;

	public UserModelImpl() {
		super();
	}

	public UserModelImpl(String id) {
		this();	

		currentUser = dao.find(Users.class, id);

	}

	@Override
	public Users getUser() {

		return currentUser;

	}

	@Override
	public void setUser(Users user) {
		currentUser = user;

	}

	@Override
	public boolean verifyUser(char[] password) {
		if (currentUser == null) {
			return false;
		}
		else if (currentUser.getPasswordCode().equalsIgnoreCase(new String(password))){
			isVerified=true;
			return true;
		}
			
		else {
			return false;
		}
	}

	@Override
	public boolean isVerified() {
		return isVerified;
	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub

	}

	@Override
	public Users findUser(String id) {
		Users user = dao.find(Users.class, id);		
		currentUser = user;		
		return user;
	}

}
