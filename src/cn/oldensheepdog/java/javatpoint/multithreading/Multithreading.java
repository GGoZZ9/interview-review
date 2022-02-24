package cn.oldensheepdog.java.javatpoint.multithreading;

/**
 * A component of Java that decides which thread to run or execute and which thread to wait is called a thread scheduler in Java
 * There are some criteria that decide which thread will execute first. There are two factors for scheduling a thread i.e. Priority and Time of arrival.
 * First Come First Serve Scheduling:
 * Time-slicing scheduling: Usually, the First Come First Serve algorithm is non-preemptive,
 * which is bad as it may lead to infinite blocking (also known as starvation).
 * To avoid that, some time-slices are provided to the threads so that after some time, the running thread has to give up the CPU.
 * Preemptive-Priority Scheduling:
 * algorithm
 *
 * Each thread starts in a separate call stack.
 * Invoking the run() method from the main thread, the run() method goes onto the current call stack rather than at the beginning of a new call stack.
 * The current thread remains in the wait state until the thread on which the join() method is invoked called is dead or the wait for the specified time frame(in milliseconds + nanos) is over.
 *
 * It is evident by looking at the output of the program that tasks 4 and 5 are executed only when the thread has an idle thread. Until then, the extra tasks are put in the queue.
 *
 * The method that returns the instance of a class is known as factory method.
 *
 * Note that when the application is terminated normally the shutdown hooks are called (all threads of the application is finished or terminated).
 * Also, when the operating system is shut down or the user presses the ctrl + c the shutdown hooks are invoked.
 *
 * different between runnable and thread:
 * The most common difference is:
 * When you extend Thread class, you can’t extend any other class which you require. (As you know, Java does not allow inheriting more than one class). When you implement Runnable, you can save a space for your class to extend any other class in future or now.
 * However, the significant difference is.
 * When you extends Thread class, each of your thread creates unique object and associate with it.
 * When you implements Runnable, it shares the same object to multiple threads.
 * */
public class Multithreading {
}
