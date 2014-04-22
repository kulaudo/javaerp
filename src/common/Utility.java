package common;

import java.awt.Window;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;

public class Utility {
	static LoadingWindow lw = new LoadingWindow();

	public static void showMsgDialog(Window window, String string) {
		JOptionPane.showMessageDialog(window, string, null,
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static void showErrDialog(Window window, String string) {
		JOptionPane.showMessageDialog(window, string, null,
				JOptionPane.ERROR_MESSAGE);
	}

	public static int showQuestionDialog(Window window, String string) {
		return JOptionPane.showConfirmDialog(window, string, null,
				JOptionPane.YES_NO_OPTION);
	}

	public static void showLoadingWindow() {
		lw.setVisible(true);
	}

	public static void hideLoadingWindow() {
		lw.setVisible(false);
	}

	public static String getTwnMoney(int i) {

		final String[] digit = { "零", "壹", "貳", "參", "肆", "伍", "陸", "柒", "捌",
				"玖" };
		final String[] twOE = { "", "拾", "佰", "仟" };
		final String[] twWan = { "", "萬", "億" };
		String result = "";
		String sMoney = String.valueOf(i);
		int len = sMoney.length();
		if (i == 0)
			result = "零";
		else {
			int temp = i;
			int e = 0; // 0="" 1=拾 2=佰 3=仟
			int f = 0; // 0="" 1="萬" 2= "億" 3="兆"
			for (int n = 1; n <= len; n++) { // 由個位數做起

				if (e % 4 == 0)
					result = digit[temp % 10] + twOE[e] + twWan[f] + result;
				else
					result = digit[temp % 10] + twOE[e] + result;
				e++;
				if (e == 4) {
					e = 0;
					f++;
				}
				temp /= 10;
			}

			result = result.replace("零兆", "兆");
			result = result.replace("零億", "億");
			result = result.replace("零萬", "零");
			result = result.replaceAll("零拾", "零");
			result = result.replaceAll("零佰", "零");
			result = result.replaceAll("零仟", "零");
			result = result.replace("兆億", "兆");
			result = result.replace("億萬", "億");
			result = result.replace("兆萬", "兆");

			while (result.contains("零零"))
				result = result.replaceAll("零零", "零");

			while (result.charAt(result.length() - 1) == '零')
				result = result.substring(0, result.length() - 1);
		}
		return result;
	}

	public static String getEngMoney(int i) {
		int hundreds = i / 100;
		int tens = (i % 100) / 10;
		int ones = i % 10;

		String[] words = new String[] { "", "One", "Two", "Three", "Four",
				"Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
				"Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
				"Seventeen", "Eighteen", "Nineteen" };
		String[] tenWords = new String[] { "", "Ten", "Twenty", "Thirty",
				"Fifty", "Seventy", "Forty", "Sixty", "Eighty", "Ninety" };

		if (i == 0)
			return "Zero";
		else if (hundreds < 10) {
			if (i < 20)
				return words[(int) i];
			else {
				if (hundreds == 0)
					return tenWords[tens] + " " + words[ones];
				else if (tens == 0 && hundreds > 0) {
					if (ones == 0)
						return words[hundreds] + " Hundred";

					else
						return words[hundreds] + " Hundred And " + words[ones];

				} else if (ones != 0)
					return words[hundreds] + " Hundred " + tenWords[tens] + " "
							+ words[ones];
				else
					return words[hundreds] + " Hundred " + tenWords[tens];
			}
		} else if (i < 1000000) {
			if (i % 1000 == 0)
				return getEngMoney(i / 1000) + " Thousand";
			else
				return getEngMoney(i / 1000) + " Thousand "
						+ getEngMoney(i % 1000);
		} else if (i < 1000000000) {
			if (i % 1000000 == 0)
				return getEngMoney(i / 1000000) + " Million";
			else
				return getEngMoney(i / 1000000) + " Million "
						+ getEngMoney(i % 1000000);
		}

		return null;

	}

	public static Character getKindBySys2(String sys2) {
		if (sys2.equals("mat"))
			return '2';
		else if (sys2.equals("fml"))
			return '1';
		else if (sys2.equals("rpa"))
			return '8';

		return null;
	}

//	public static   String getMaxID(String id,String table) {		
//
//		Query query = HibernateUtil
//				.getSessionFactory()
//				.getCurrentSession()
//				.createSQLQuery(
//						"select max(" + id + ") from "
//								+ table + " as table");
//		List result=query.list();
//		return result.get(0).toString();
//		
//
//	}
	public static int getSys2Index(String sys2) {
		if (sys2.equalsIgnoreCase("MAT"))
			return 1;
		else if (sys2.equalsIgnoreCase("MAT"))
			return 2;
		else if (sys2.equalsIgnoreCase("ASS"))
			return 8;
		else
			return 0;
	}
	
	public static String myNewDate(){	
		
		return getMyDate(new Date());
		
	}
	public static String getMyDate(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		return format.format(date);
	}

}
