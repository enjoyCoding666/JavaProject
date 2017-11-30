package com.thread;

public class ThreadDemo {
	  public static void main(String args[]){
		  ThreadTest thread1=new ThreadTest("thread1");
		  ThreadTest thread2=new ThreadTest("thread2");
		  thread1.start();
		  thread2.start();
		  
	  }
	}

	class ThreadTest extends Thread{
		private String name;
		public ThreadTest(String name){
			this.name=name;
		}
		public void run(){
			for(int i=0;i<10;i++)
			   System.out.println(name+"���д�����"+i);
		}
		
		
	}