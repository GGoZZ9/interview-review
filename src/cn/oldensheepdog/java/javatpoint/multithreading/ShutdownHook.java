package cn.oldensheepdog.java.javatpoint.multithreading;

public class ShutdownHook {

    public static void main(String[] args)throws Exception {

        Runtime r= Runtime.getRuntime();
        r.addShutdownHook(new MyThread());

        System.out.println("Now main sleeping... press ctrl+c to exit");
        try{Thread.sleep(3000);}catch (Exception e) {}
    }
}

class MyThread extends Thread{
    public void run(){
        System.out.println("shut down hook task completed..");
    }
}