package com.tsui.java.corestudy;
import java.util.Stack;
import java.util.Iterator;
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;
class TestStack extends Vector{
	public static void main(String[] args)
	{
		Stack<String> s = new Stack<String>();
		s.push("Hello");
		s.push("World");
		System.out.println("peek:" + s.peek());

		Vector v = new Vector();
		v.addElement("yes");
		v.addElement(new Integer(1));
		Iterator i = v.iterator();
		while(i.hasNext())
			System.out.println(i.next());

		List l = new ArrayList();
		l.add("yes");
		l.add(new Integer(1));
		Iterator i1 = l.iterator();
		while(i1.hasNext())
			System.out.println(i1.next());
		//System.out.println(v.elementData.length);
	}
}