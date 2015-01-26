package com.eric.homework.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.eric.homework.util.HRUtil;

public class HRUtilTest {
	private static HRUtil hrUtil = new HRUtil();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testReadHotelPrice() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadOrderInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAfterDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testStringToDate() {
		assertEquals("Wed Mar 18 00:00:00 CST 2009", hrUtil.stringToDate("2009-03-18","yyyy-MM-dd"));
	}

	@Test
	public void testIsWeekendString() {
		assertEquals(true, hrUtil.isWeekend("2015-01-25"));
	}

	@Test
	public void testIsWeekendDate() {
		assertEquals(true, hrUtil.isWeekend(hrUtil.stringToDate("2015-01-25","yyyy-MM-dd")));
	}

	@Test
	public void testStringToList() {
		String str = "one,two,three";
		assertEquals("one", hrUtil.stringToList(str, ",").get(0));
	}

}
