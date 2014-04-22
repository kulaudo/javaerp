package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import common.Utility;
public class GetEngMoneyTest {
	@Test
	public void input_0() {
		assertEquals(Utility.getEngMoney(0), "Zero");
	}

	@Test
	public void input_23() {
		assertEquals(Utility.getEngMoney(23), "Twenty Three");
	}

	@Test
	public void input_100() {
		assertEquals(Utility.getEngMoney(100), "One Hundred");
	}

	@Test
	public void input_123() {
		assertEquals(Utility.getEngMoney(123), "One Hundred Twenty Three");
	}

	@Test
	public void input_103() {
		assertEquals(Utility.getEngMoney(103), "One Hundred And Three");
	}

	@Test
	public void input_310() {
		assertEquals(Utility.getEngMoney(310), "Three Hundred Ten");
	}

	@Test
	public void input_910639() {
		assertEquals(Utility.getEngMoney(910639), "Nine Hundred Ten Thousand Six Hundred Thirty Nine");
	}
	@Test
	public void input_12012012() {
		assertEquals(Utility.getEngMoney(12012012), "Twelve Million Twelve Thousand Twelve");
	}

}
