package com.msft.contest;

class URL {
	private String path;

	public URL(String path) {
		this.path = path;
	}

	public String toString() {
		return this.path + " new Path";
	}
}


public class test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		URL url = new URL("http://www.baidu.com");
		System.out.println(url.toString());
	}
}


