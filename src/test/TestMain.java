package test;

import javax.swing.JOptionPane;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//UserSearchFormViewImpl impl=new UserSearchFormViewImpl(new Users(new UsersId("kulaudo", "AA"), null, null));
		int s = JOptionPane.showOptionDialog(null, "Test", "title", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"test"}, 0);

	}
}
