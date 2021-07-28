package Junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class demoTest {
	
	demo d;
	
	@Before
	public void initialization () {
		d = new demo ();
	}

	@Test
	public void test1() {
		assertEquals ("Enter Positive Number", d.primeChecker(-1));
	}
	
	@Test
	public void test2() {
		assertEquals ("Prime", d.primeChecker(0));
	}
	
	@Test
	public void test3() {
		assertEquals ("Pri", d.primeChecker(1));
	}
	
	@Test
	public void test4() {
		assertEquals ("Prime", d.primeChecker(5));
	}
	
	@Test
	public void test5() {
		assertEquals ("Not Prime", d.primeChecker(6));
	}

}
