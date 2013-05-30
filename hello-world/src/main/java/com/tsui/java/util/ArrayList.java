package com.tsui.java.util;

import java.util.LinkedList;
import java.util.List;

class ArrayList{
	public static void main(String[] args)
	{
		LinkedList<String> l = new LinkedList<String>();
		l.remove();
		System.out.println("l head:" + l.size());
		l.add("123");
		System.out.println("l head:" + l.size());
		System.out.println("l head:" + l.peekFirst());
		l.add("234");
		l.add(2,"345");
		System.out.println("l head:" + l.size());
		System.out.println("l head:" + l.get(0));
		System.out.println("l head:" + l.get(1));
		System.out.println("l head:" + l.get(2));
	}
}
