package cn.oldensheepdog.java.fundamental.concurrancy.threadcommunicate;

public class Buffer {

    public synchronized void doWait() {
        try{
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void doNotify() {
        notify();
    }
}
