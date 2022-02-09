package cn.oldensheepdog.java.fundamental.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        MyRunnable runnable = new MyRunnable();
        for (int i =0; i<5;i++){
            executorService.execute(runnable);
        }
        System.out.println("线程任务开始执行");
        executorService.shutdown();
    }
}
