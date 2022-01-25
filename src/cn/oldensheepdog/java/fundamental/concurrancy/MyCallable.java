package cn.oldensheepdog.java.fundamental.concurrancy;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" call()方法执行中。。。");
        return 1;
    }

    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyCallable());
        Thread thread = new Thread(futureTask);
        thread.start();

        try{
            Thread.sleep(1000);
            System.out.println("返回结果 "+futureTask.get());
        }catch (InterruptedException e) {
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" main()方法执行完成。");
    }
}
