package com.thread.waitAndNotify;

public class SynWaitThread extends Thread {
    private Object object;

    public SynWaitThread(Object object) {
        super();
        this.object = object;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.synWait(object);
    }
}


