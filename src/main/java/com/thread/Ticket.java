/**
 * 
 */
package com.thread;

/**
 * @author Administrator
 *
 */
class Ticket implements Runnable {//ͨ��Runnable�ӿ�ʵ�ֶ��̻߳���
    public void run() {
        for (int i = 0; i < 10; ++i) {  //����ΪʲôҪѭ������Ȼ�����ֲ���ֻ��һ��Ʊ
            sale();
        }
    }
 
    public synchronized void sale() {       //�ڷ�����ǰ����ӻ�����,��֤ͬ��
        if (count > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(count--);
        }
    }
 
    public static void main(String[] args) {
        Ticket he = new Ticket();
        Thread h1 = new Thread(he);   //��runnable������Ϊ�������½��߳�
        Thread h2 = new Thread(he);   //���������������Ʊ��
        Thread h3 = new Thread(he);
        h1.start();
        h2.start();
        h3.start();
    }
 
    private int count = 5;
}
