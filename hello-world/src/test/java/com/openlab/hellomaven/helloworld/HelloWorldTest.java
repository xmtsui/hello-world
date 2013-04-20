package com.openlab.hellomaven.helloworld;
import static org.junit.Assert.assertEquals; 
import org.junit.Test;

public class HelloWorldTest {
  @Test
  public void testSayHello()
  {
    HelloWorld helloWorld = new HelloWorld();
    assertEquals(helloWorld.sayHello(), "Hello world");
  }
}


