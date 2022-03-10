package cn.oldensheepdog.java.javatpoint.multithreading;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * Executors.newFixedThreadPool(5);//creating a pool of 5 threads
 * 线程池策略
 * corePoolSize：核心线程数；maximunPoolSize：最大线程数
 * 每当有新的任务到线程池时，
 * 第一步： 先判断线程池中当前线程数量是否达到了corePoolSize，若未达到，则新建线程运行此任务，且任务结束后将该线程保留在线程池中，不做销毁处理，
 * 若当前线程数量已达到corePoolSize，则进入下一步；
 * 第二步： 判断工作队列(workQueue)是否已满，未满则将新的任务提交到工作队列中，满了则进入下一步；
 * 第三步： 判断线程池中的线程数量是否达到了maxumunPoolSize，如果未达到，则新建一个工作线程来执行这个任务，如果达到了则使用饱和策略来处理这个任务。
 * 注意： 在线程池中的线程数量超过corePoolSize时，每当有线程的空闲时间超过了keepAliveTime，这个线程就会被终止。直到线程池中线程的数量不大于corePoolSize为止。
 * （由第三步可知，在一般情况下，Java线程池中会长期保持corePoolSize个线程。）
 *
 * 饱和策略
 * 当工作队列满且线程个数达到maximunPoolSize后所采取的策略
 * AbortPolicy：默认策略；新任务提交时直接抛出未检查的异常RejectedExecutionException，该异常可由调用者捕获。
 * CallerRunsPolicy：既不抛弃任务也不抛出异常，使用调用者所在线程运行新的任务。
 * DiscardPolicy：丢弃新的任务，且不抛出异常。
 * DiscardOldestPolicy：调用poll方法丢弃工作队列队头的任务，然后尝试提交新任务
 * 自定义策略：根据用户需要定制。
 * */

/**
 * Executors只是一个工厂类，它所有的方法返回的都是ThreadPoolExecutor、ScheduledThreadPoolExecutor这两个类的实例。
 * ThreadPoolExecutor ScheduledThreadPoolExecutor 是ExecutorService这个接口的两个实现类
 *
 * 1. newCachedThreadPool 创建一个线程池，当需要的时候创建新线程，当之前当线程可用时会重用之前的线程，当执行短期存活的异步任务时可用提高性能
 * 调用 execute会重用以前的线程，如果可用，如果没有可用的线程会创建新线程，并加入线程池，60s没用的线程会中断terminated并移出缓存，这样空闲
 * 足够长时间的线程池将不占用任何资源，请注意，具有相似属性但不同详细信息（例如，超时参数）的池可以使用 ThreadPoolExecutor 构造函数创建。
 * 核心线程数为0
 * 最大线程数为Integer.MAX_VALUE
 * 阻塞队列是SynchronousQueue
 * 非核心线程空闲存活时间为60秒
 * 适用于并发执行大量短期的小任务。
 *
 * 2. newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。 （核心线程数和最大线程数大小一样，阻塞队列为无界队列LinkedBlockingQueue
 * newFixedThreadPool 适用于处理CPU密集型的任务，确保CPU在长期被工作线程使用的情况下，尽可能的少的分配线程，即适用执行长期的任务。）
 * 3. newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。周期性执行任务的场景，需要限制线程数量的场景
 * 4. newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 * 适用于串行执行任务的场景，一个任务一个任务地执行。
 * */
/**
 * Executors 类，工具类、线程池的工厂类，用于创建并返回不同类型的线程池。
 * */
public class ThreadPoolExample {

    static final int MAX_TH = 3;

    // main method
    public static void main(String[] argvs) {
// Creating five new tasks
        Runnable rb1 = new Tasks("task 1");
        Runnable rb2 = new Tasks("task 2");
        Runnable rb3 = new Tasks("task 3");
        Runnable rb4 = new Tasks("task 4");
        Runnable rb5 = new Tasks("task 5");

// creating a thread pool with MAX_TH number of
// threads size the pool size is fixed
        ExecutorService pl = Executors.newFixedThreadPool(MAX_TH);

// passes the Task objects to the pool to execute (Step 3)
        pl.execute(rb1);
        pl.execute(rb2);
        pl.execute(rb3);
        pl.execute(rb4);
        pl.execute(rb5);

// pool is shutdown
        pl.shutdown();
    }
}

class Tasks implements Runnable {
    private String taskName;

    // constructor of the class Tasks
    public Tasks(String str) {
// initializing the field taskName
        taskName = str;
    }

    // Printing the task name and then sleeps for 1 sec
// The complete process is getting repeated five times
    public void run() {
        try {
            for (int j = 0; j <= 5; j++) {
                Date dt = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh : mm : ss");
                if (j == 0) {
//prints the initialization time for every task
                    System.out.println("Initialization time for the task name: "+ taskName + " = " + sdf.format(dt));
                }
                else {
// prints the execution time for every task
                    System.out.println("Time of execution for the task name: " + taskName + " = " +sdf.format(dt));
                }
// 1000ms = 1 sec
                Thread.sleep(1000);
            }
            System.out.println(taskName + " is complete.");
        }

        catch(InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}