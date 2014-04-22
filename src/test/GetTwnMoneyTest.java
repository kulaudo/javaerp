package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GetTwnMoneyTest {

	private String getTwnMoney(int i) {
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

	@Test
	public void test_input_0() {
		assertEquals(getTwnMoney(0), "零");
	}

	@Test
	public void test_input_1() {
		assertEquals(getTwnMoney(1), "壹");
	}

	@Test
	public void test_input_2() {
		assertEquals(getTwnMoney(2), "貳");
	}

	@Test
	public void test_input_10() {
		assertEquals(getTwnMoney(10), "壹拾");
	}
	@Test
	public void test_input_11() {
	assertEquals(getTwnMoney(11), "壹拾壹");
	}

	@Test
	public void test_input_20() {
	assertEquals(getTwnMoney(20), "貳拾");
	}

	@Test
	public void test_input_99() {
	assertEquals(getTwnMoney(99), "玖拾玖");
	}

	@Test
	public void test_input_100() {
	assertEquals(getTwnMoney(100), "壹佰");
	}

	@Test
	public void test_input_203() {
	assertEquals(getTwnMoney(203), "貳佰零參");
	}

	@Test
	public void test_input_1001() {
	assertEquals(getTwnMoney(1001), "壹仟零壹");
	}

	@Test
	public void test_input_123456() {
	assertEquals(getTwnMoney(123456), "壹拾貳萬參仟肆佰伍拾陸");
	}

	@Test
	public void test_input_120305() {
	assertEquals(getTwnMoney(120305), "壹拾貳萬零參佰零伍");
	}

	@Test
	public void test_input_10000() {
	assertEquals(getTwnMoney(10000), "壹萬");
	}

	@Test
	public void test_input_100000000() {
	assertEquals(getTwnMoney(100000000), "壹億");
	}

	@Test
	public void test_input_100001000() {
	assertEquals(getTwnMoney(100001000), "壹億零壹仟");
	}


}
