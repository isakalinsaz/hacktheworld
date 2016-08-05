package com.sample.concurrent;

class Super {
	void test(){
		new Sub();
	}
	Super() {
		new Sub();
	}
	Super(int a) {
		new Sub();
	}
}

class Sub extends Super {
	Sub() {
		// No need to call the constructor of the superclass explicitly
		super(5);
	}
}
