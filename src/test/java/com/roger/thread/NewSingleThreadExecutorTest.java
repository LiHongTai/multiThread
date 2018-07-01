package com.roger.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewSingleThreadExecutorTest {
	public static void main(String[] args) {
		final Thread join1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("join1");
			}
		}, "T1");

		final Thread join2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("join2");
			}
		}, "T2");
		final Thread join3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("join3");
			}
		}, "T3");
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(join1);
		executor.submit(join2);
		executor.submit(join3);
		executor.shutdown();
	}
}
