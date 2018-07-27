package com.thread.waitAndNotify;

public class Service {
    /**
     * wait()和notify()方法，是Object类的方法。使用时，必须加上同步锁。
     * @param object
     */
    public void synWait(Object object) {
        try {
            synchronized (object) {
                System.out.println("begin wait() ThreadName="
                        + Thread.currentThread().getName());
                object.wait();
                System.out.println("  end wait() ThreadName="
                        + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void synNotify(Object object) {
        try {
            synchronized (object) {
                System.out.println("begin notify() ThreadName="
                        + Thread.currentThread().getName() + " time="
                        + System.currentTimeMillis());
                object.notify();
                Thread.sleep(5000);
                System.out.println("  end notify() ThreadName="
                        + Thread.currentThread().getName() + " time="
                        + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}