package cn.oldensheepdog.java.fundamental.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ManualLock {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        try{
            System.out.println("获得锁");
        } catch (Exception e) {

        } finally {
            System.out.println("释放锁");
            lock.unlock();
        }
    }
}
