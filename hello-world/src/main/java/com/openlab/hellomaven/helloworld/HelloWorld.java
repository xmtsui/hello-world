package com.openlab.hellomaven.helloworld;

/*
 * Author: tsui
 * Date: 2013-04-08
 */
public class HelloWorld {
	public String sayHello() {
		return "Hello world";
	}

	public static void main(String[] args) {

		HelloWorld hw = new HelloWorld();
		System.out.println(hw.sayHello());
		// System.out.println("Hello World");
	}// end of main
}// end of class

