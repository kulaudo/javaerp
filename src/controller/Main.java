package controller;


public class Main implements Runnable{
	public static void main(String[] args) {
		Main main=new Main();
		Thread t=new Thread(main);
		t.start();
		//main.run();
		

	}

	@Override
	public void run() {
		System.out.println("open");
		IMainController mainController = new MainControllerImpl();
		
	}

}
