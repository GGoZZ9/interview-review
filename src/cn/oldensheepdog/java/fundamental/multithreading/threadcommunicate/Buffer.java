package cn.oldensheepdog.java.fundamental.multithreading.threadcommunicate;

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
