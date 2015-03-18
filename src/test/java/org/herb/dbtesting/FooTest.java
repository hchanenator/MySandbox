package org.herb.dbtesting;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FooTest {

  @Test
  public void greet() {
    Assert.assertEquals(Foo.HELLO_WORLD, "Hello World");
  }
}
