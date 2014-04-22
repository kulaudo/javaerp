package model;

import database.Users;

public interface IUserModel extends IModel{	

	public void setUser(Users user);

	public boolean isVerified();

	public void clean();

	boolean verifyUser(char[] password);

	Users getUser();

	Users findUser(String id);


}
