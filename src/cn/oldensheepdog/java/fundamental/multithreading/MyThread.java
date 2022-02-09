package cn.oldensheepdog.java.fundamental.multithreading;

public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" run() method is running。。。 ");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println(Thread.currentThread().getName()+" main() 方法执行结束");
    }

}
