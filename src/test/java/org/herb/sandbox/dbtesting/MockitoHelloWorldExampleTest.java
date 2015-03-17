/**
 * 
 */
package org.herb.sandbox.dbtesting;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

import org.herb.dbtesting.Foo;
import org.testng.annotations.Test;

/**
 * @author herb
 *
 */
public class MockitoHelloWorldExampleTest {

	@Test
	public void fooGreets() {
		Foo foo = mock(Foo.class);
		when(foo.greet()).thenReturn(foo.HELLO_WORLD);
		System.out.println("Foo greets: " + foo.greet());
		assertEquals(foo.greet(), foo.HELLO_WORLD);
	}
	
}
