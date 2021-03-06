package cn.oldensheepdog.java.fundamental.multithreading;

public class ThreadLocalTest {

    // 线程本地存储变量
    private static final ThreadLocal<Integer> THREAD_LOCAL_NUM = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) {
        for (int i=0;i<3;i++){
            Thread thread = new Thread() {
                @Override
                public void run() {
                    add10ByThreadLocal();
                }
            };
            thread.start();
        }
    }

    // 线程本地存储变量加5
    private static void add10ByThreadLocal() {
        for (int i=0;i<5;i++){
            Integer n = THREAD_LOCAL_NUM.get();
            n+=1;
            THREAD_LOCAL_NUM.set(n);
            System.out.println(Thread.currentThread().getName()+" : ThreadLocal Num="+n);
        }
    }
}
