package com.sample.concurrent.MultiTreadBenchMark;

import javax.annotation.Nonnull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Nonnull
public class App {
	private static final Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) throws InterruptedException {
		//for (int i = 1; i <= 20; i++) {
			
			MultiThread m = new MultiThread("Thread-" + 1);
			m.start();

		//}

	}
}
