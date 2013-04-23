package com.msft.contest.pre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * 
 */
@SuppressWarnings("rawtypes")
public class test1 {
	@SuppressWarnings("unchecked")
	public static void main(String args[]) {
		boolean[] test = new boolean[10];
		// boolean test = new boolean();
		for (boolean i : test) {
			 System.out.println(i);
		}
		System.out.println(1 << -1);
		System.out.println(-1 >> 1);
		System.out.println(Integer.toBinaryString(3));
		System.out.println(0 | -1);

		
		List arraylist = new ArrayList();
		List linkedlist = new LinkedList();
		
		arraylist.add(0, "a");
		arraylist.add(1, "b");
		arraylist.add(2, "c");
		
		arraylist.add(1,"d");
		for(Iterator i = arraylist.iterator();i.hasNext();)
		{
			System.out.println(i.next());
		}
		
		linkedlist.add(0, "a");
		linkedlist.add(1, "b");
		linkedlist.add(2, "c");
		
		linkedlist.add(1,"d");
		for(Iterator i = linkedlist.iterator();i.hasNext();)
		{
			System.out.println(i.next());
		}
		Stack tt = new Stack();
		tt.add("123");
		tt.add("1233");
		tt.add("12334");
		tt.add("123345");
		
		System.out.println(tt.toString());
		System.out.println(tt.get(3));
		System.out.println(tt.peek());
		
		System.out.println("==========");
		java.util.TreeSet t= new TreeSet();
		t.add("123");
		t.add("1234");
		t.add("124");
		t.add("1235");
		System.out.println(t.toString());
		System.out.println(t.size());
		
		java.util.TreeMap<String, String> map = new TreeMap();
		map.put("a","abcd");
		map.put("b", "Abc");
		map.put("c","bbb");
		map.put("d", "BBBB");
		map.put("e", "BBBB");
		Set k = map.descendingKeySet();
		Iterator i = k.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		
		System.out.println("==========");
		HashMap<String, String> hm = new HashMap<String,String>();
		hm.put(null, null);
		Map hmm = new Hashtable<String,String>();
		hmm.put(null, null);
		
	}// end of main
}// end of class