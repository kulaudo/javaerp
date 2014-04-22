package controller;

public class LoginRunnable implements Runnable {
	IMainController main;
	ILoginController controller;
	public LoginRunnable(IMainController main){
		this.main=main;
		this.controller=new LoginControllerImpl(main);
	}

	@Override
	public void run() {
		while(!controller.getModel().isVerified()) ;

	}
	public ILoginController getLoginController(){
		return controller;
	}

}
