package com.thread;

public class RunnableDemo {
	public static void main(String args[]){
		MyThread thread1=new MyThread("线程A");
		MyThread thread2=new MyThread("线程B");
		Thread t1=new Thread(thread1);  //将实现了runnable接口的对象作为参数
		Thread t2=new Thread(thread2);
		t1.start();
		t2.start();
	}
}

/**
 * 通过实现Runnable接口，新建线程类
 */

class MyThread implements  Runnable{
	private String name;
	public MyThread(String name){
		this.name=name;
	}
	@Override
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println(name+"运行次数"+i);
		}
	}

}