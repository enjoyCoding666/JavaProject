package com.thread;


public class ThreadDemo {
	  public static void main(String args[]){
		  ThreadTest thread1=new ThreadTest("thread1");
		  ThreadTest thread2=new ThreadTest("thread2");
		  thread1.start();
		  thread2.start();
		  
	  }
	}

/**
 * 通过继承Thread，新建线程类。
 */
	class ThreadTest extends Thread{
		private String name;
		public ThreadTest(String name){
			this.name=name;
		}
		@Override
		public void run(){
			for(int i=0;i<10;i++)
			   System.out.println(name+"计数："+i);
		}
		
		
	}