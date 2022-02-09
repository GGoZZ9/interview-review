package cn.oldensheepdog.java.fundamental.multithreading;

import java.util.Date;

public class MyRunnableForThreadPool implements Runnable{

    private String command;

    public MyRunnableForThreadPool(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +" Start. Time= "+new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName()+ "End. Time = "+new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
