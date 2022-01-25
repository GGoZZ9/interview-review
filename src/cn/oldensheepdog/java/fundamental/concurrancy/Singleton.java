package cn.oldensheepdog.java.fundamental.concurrancy;

public class Singleton {
    private volatile static Singleton uniqueInstance;

    private Singleton() {}
    // 双层校验锁实现对象单例
    public static Singleton getUniqueInstance() {
        // 先判断对象是否实例过
        if (uniqueInstance == null){
            // 类对象加锁
            synchronized (Singleton.class){
                if (uniqueInstance ==null){
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

    // 三步执行，对象的创建不是一步完成的，是一个复合操作
//    为 uniqueInstance 分配内存空间
//    初始化 uniqueInstance
//    将 uniqueInstance 指向分配的内存地址
    //由于Volatile禁止JVM对指令进行重排序。所以创建对象的过程仍然会按照指令1-2-3的有序执行。
}
