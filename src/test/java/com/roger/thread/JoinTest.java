package com.roger.thread;

public class JoinTest {
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
				
				try {
					join1.join();// 确定join1执行完毕
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("join2");
			}
		}, "T2");
		final Thread join3 = new Thread(new Runnable() {
			@Override
			public void run() {
				
				try {
					join2.join();// 确定join2执行完毕
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("join3");
			}
		}, "T3");
		join1.start();
		join2.start();
		join3.start();
	}
}
