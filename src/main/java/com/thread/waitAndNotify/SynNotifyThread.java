package com.thread.waitAndNotify;

public class SynNotifyThread extends Thread {
    private Object object;

    public SynNotifyThread(Object object) {
        super();
        this.object = object;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.synNotify(object);
    }
}