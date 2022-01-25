package cn.oldensheepdog.java.fundamental.concurrancy.threadcommunicate;

public class ThreadCommunicate {

    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer();

        Thread_one thread_one = new Thread_one(buffer);
        thread_one.start(); //启动子线程

        Thread.sleep(1000); //主线程睡眠1s

        String name = Thread.currentThread().getName();
        System.out.println(name);
        buffer.doNotify(); //唤醒子线程
    }
}
