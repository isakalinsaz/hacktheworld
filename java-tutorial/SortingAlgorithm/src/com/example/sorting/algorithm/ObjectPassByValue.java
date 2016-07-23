package com.example.sorting.algorithm;

import java.util.HashMap;

public class ObjectPassByValue {

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ObjectPassByValue() {
		// TODO Auto-generated constructor stub
	}

	public ObjectPassByValue(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	public static void main(String[] args) {
		ObjectPassByValue hash = new ObjectPassByValue("Argela");
		
		hash.setName("Amadeus");
		System.err.println("Object:"+hash);
		foo(hash);
		System.out.println("Result:" + hash.getName());
		System.err.println("Object:"+hash);
	}

	private static void foo(ObjectPassByValue hash1) {
		hash1.setName("Kafein");
		System.err.println("Object:"+hash1);
		hash1 = new ObjectPassByValue("Ctech");
		hash1.setName("Iyzico");
		System.err.println("Object:"+hash1);
		System.out.println("Result:" + hash1.getName());
	}

}
