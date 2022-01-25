package cn.oldensheepdog.java.fundamental.concurrancy.threadcommunicate;

public class Thread_one extends Thread {
    private Buffer buffer;
    public Thread_one(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        //子线程睡眠
        buffer.doWait();
        //具体操作，显示当前线程名
        String name = Thread_one.currentThread().getName();
        System.out.println(name);
    }
}
