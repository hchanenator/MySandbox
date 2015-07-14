package org.herb.sandbox.system;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleTest {
	
	@BeforeClass
	public void setUp() {
		// code that will be invoked when this test is instantiated
	}
	
	@Test(groups = { "fast" })
	public void aFastTest() {
		System.out.println("Fast test");
	}
	
	@Test(groups = { "slow" })
	public void aSlowTest() {
		System.out.println("Slow test");
	}
}