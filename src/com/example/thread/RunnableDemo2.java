package com.example.thread;

public class RunnableDemo2 {
	public static void main(String args[]){
		MyThread2 my=new MyThread2();
		new Thread(my).start();       //Runnable实现资源共享
		new Thread(my).start();
		new Thread(my).start();
	}
}


class MyThread2 implements Runnable {
	private int ticket=5;
	public void run(){
		for(int i=0;i<100;i++)
			if(ticket>0)
				System.out.println("卖票：Tickets="+ticket--);
	}
}