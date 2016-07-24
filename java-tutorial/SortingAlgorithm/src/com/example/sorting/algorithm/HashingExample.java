package com.example.sorting.algorithm;

public class HashingExample {

	private String hashString1 = "1";
	private String hashString2 = "2";

	public HashingExample() {
		// TODO Auto-generated constructor stub
	}

	private void calculateHashValue() {
		int hash1Lenght = hashString1.length();
		int hash1Value = 0;
		for (int i = 0; i < hash1Lenght; i++) {
			hash1Value += (hashString1.codePointAt(i) * (Math.pow(31, hash1Lenght - 1 - i)));
		}

		int hash2Lenght = hashString2.length();
		int hash2Value = 0;
		for (int i = 0; i < hash2Lenght; i++) {
			hash2Value += (hashString2.codePointAt(i) * (Math.pow(31, hash2Lenght - 1 - i)));
		}

		System.out.println("Hash1 Value :" + hash1Value + " Hash2 Value :" + hash2Value);
		if (hash1Value == hash2Value)
			System.out.println("conclision Detected!!!");
	}

	public static void main(String[] args) {
		HashingExample hashingExample = new HashingExample();
		hashingExample.calculateHashValue();
	}
}
