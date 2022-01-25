package cn.oldensheepdog.java.fundamental.concurrancy;

public class SynchronizeTest {
    /**
     * JDK Atomic开头的原子类、synchronized、LOCK，可以解决原子性问题
     * synchronized、volatile、LOCK，可以解决可见性问题
     * Happens-Before 规则可以解决有序性问题
     *
     * 一个运行的应用程序是一个进程，有自己独立的内存空间，操作系统资源分配的基本单位。一个进程多个线程，进程中一个执行任务是一个线程，处理器任务调度的基本单位
     *
     * 什么是上下文切换?
     * 当前任务在执行完 CPU 时间片切换到另一个任务之前会先保存自己的状态，以便下次再切换回这个任务时，可以再加载这个任务的状态。任务从保存到再加载的过程就是一次上下文切换。
     * 用户 (User) 线程：运行在前台，执行具体的任务，比如main 函数所在的线程就是一个用户线程
     * 守护 (Daemon) 线程：运行在后台，为其他前台线程服务。比如垃圾回收线程
     *
     * 解决死锁
     * 占用部分资源的线程进一步申请其他资源时，如果申请不到，可以主动释放它占有的资源。
     * */

    /**
     * 创建线程有哪几种方式？
     * 继承 Thread 类；
     * 实现 Runnable 接口；
     * 实现 Callable 接口；
     * 使用 Executors 工具类创建线程池
     * */

    /**
     * Executors提供了一系列工厂方法用于创先线程池，返回的线程池都实现了ExecutorService接口。
     * 主要有newFixedThreadPool，newCachedThreadPool，newSingleThreadExecutor，newScheduledThreadPool
     * */

    /**
     * runnable 和 callable 有什么区别？
     * 都是接口
     * 都可以编写多线程程序
     * 都采用Thread.start()启动线程
     * Runnable 接口 run 方法无返回值；Callable 接口 call 方法有返回值，是个泛型，和Future、FutureTask配合可以用来获取异步执行的结果
     * Runnable 接口 run 方法只能抛出运行时异常，且无法捕获处理；Callable 接口 call 方法允许抛出异常，可以获取异常信息
     * */

    /**
     * 线程的 run()和 start()有什么区别？
     * 每个线程都是通过某个特定Thread对象所对应的方法run()来完成其操作的，run()方法称为线程体。通过调用Thread类的start()方法来启动一个线程。
     * start() 方法用于启动线程，run() 方法用于执行线程的运行时代码。run() 可以重复调用，而 start() 只能调用一次。
     *
     * 为什么我们调用 start() 方法时会执行 run() 方法，为什么我们不能直接调用 run() 方法？
     * new 一个 Thread，线程进入了新建状态。调用 start() 方法，会启动一个线程并使线程进入了就绪状态，当分配到时间片后就可以开始运行了。
     * 调用 start 方法方可启动线程并使线程进入就绪状态，而 run 方法只是 thread 的一个普通方法调用，还是在主线程里执行。
     * new 一个 Thread，线程进入了新建状态。调用 start() 方法，会启动一个线程并使线程进入了就绪状态，当分配到时间片后就可以开始运行了。
     * start() 会执行线程的相应准备工作，然后自动执行 run() 方法的内容，这是真正的多线程工作。
     * */

    /**
     * 什么是 Callable 和 Future?
     * Callable是创建线程实现多线程的接口，Future 可以拿到异步执行任务的返回值
     * FutureTask 表示一个异步运算的任务。FutureTask 里面可以传入一个 Callable 的具体实现类，可以对这个异步运算的任务的结果进行等待获取、判断是否已经完成、取消任务等操作。只有当运算完成的时候结果才能取回，如果运算尚未完成 get 方法将会阻塞。一个 FutureTask 对象可以对调用了 Callable 和 Runnable 的对象进行包装，
     * 由于 FutureTask 也是Runnable 接口的实现类，所以 FutureTask 也可以放入线程池中。
     * */

    /**
     * 线程的基本状态：new,runnable,running, block,拿到锁就是可运行状态，拿到时间片就进入运行。进入阻塞状态不会释放锁，进入等待队列会释放锁，o.wait()。在等待队列被其他线程唤醒会进入锁池，拿到锁进入可运行状态
     * 阻塞的三种情况：
     * (一). 等待阻塞：运行状态中的线程执行 wait()方法，JVM会把该线程放入等待队列(waitting queue)中，使本线程进入到等待阻塞状态；
     * (二). 同步阻塞：线程在获取 synchronized 同步锁失败(因为锁被其它线程所占用)，，则JVM会把该线程放入锁池(lock pool)中，线程会进入同步阻塞状态；
     * (三). 其他阻塞: 通过调用线程的 sleep()或 join()或发出了 I/O 请求时，线程会进入到阻塞状态。当 sleep()状态超时、join()等待线程终止或者超时、或者 I/O 处理完毕时，线程重新转入就绪状态。
     *
     * 线程调度器是一个操作系统服务，它负责为 Runnable 状态的线程分配 CPU 时间
     * 时间分片是指将可用的 CPU 时间分配给可用的 Runnable 线程的过程。分配 CPU 时间可以基于线程优先级或者线程等待的时间
     *
     * 线程调度模型
     * 分时调度模型是指让所有的线程轮流获得 cpu 的使用权，并且平均分配每个线程占用的 CPU 的时间片这个也比较好理解。
     * Java虚拟机采用抢占式调度模型，是指优先让可运行池中优先级高的线程占用CPU，如果可运行池中的线程优先级相同，那么就随机选择一个线程，使其占用CPU。处于运行状态的线程会一直运行，直至它不得不放弃 CPU。
     *
     * 线程调度策略:线程调度器选择优先级最高的线程运行，但是，如果发生以下情况，就会终止线程的运行
     * （1）线程体中调用了 yield 方法让出了对 cpu 的占用权利
     * （2）线程体中调用了 sleep 方法使线程进入睡眠状态
     * （3）线程由于 IO 操作受到阻塞
     * （4）另外一个更高优先级线程出现
     * （5）在支持时间片的系统中，该线程的时间片用完
     *
     * 与线程同步以及线程调度相关的方法
     * （1） wait()：使一个线程处于等待（阻塞）状态，并且释放所持有的对象的锁；
     * （2）sleep()：使一个正在运行的线程处于睡眠状态，是一个静态方法，调用此方法要处理 InterruptedException 异常；
     * （3）notify()：唤醒一个处于等待状态的线程，当然在调用此方法的时候，并不能确切的唤醒某一个等待状态的线程，而是由 JVM 确定唤醒哪个线程，而且与优先级无关；
     * （4）notifyAll()：唤醒所有处于等待状态的线程，该方法并不是将对象的锁给所有线程，而是让它们竞争，只有获得锁的线程才能进入就绪状态；
     *
     * sleep() 和 wait() 有什么区别？
     * 两者都可以暂停线程的执行
     * 类的不同：sleep() 是 Thread线程类的静态方法，wait() 是 Object类的方法。
     * 是否释放锁：sleep() 不释放锁；wait() 释放锁。
     * 用途不同：Wait 通常被用于线程间交互/通信，sleep 通常被用于暂停执行。
     * 用法不同：wait() 方法被调用后，线程不会自动苏醒，需要别的线程调用同一个对象上的 notify() 或者 notifyAll() 方法。sleep() 方法执行完成后，线程会自动苏醒。或者可以使用wait(long timeout)超时后线程会自动苏醒。
     *
     * 如何调用 wait() 方法的？使用 if 块还是循环？为什么
     * wait() 方法应该在循环调用，因为当线程获取到 CPU 开始执行的时候，其他条件可能还没有满足，所以在处理前，循环检测条件是否满足会更好
     *
     * 为什么 wait(), notify()和 notifyAll()必须在同步方法或者同步块中被调用？
     * 当一个线程需要调用对象的 wait()方法的时候，这个线程必须拥有该对象的锁，接着它就会释放这个对象锁并进入等待状态直到其他线程调用这个对象上的 notify()方法。
     * 同样的，当一个线程需要调用对象的 notify()方法时，它会释放这个对象的锁，以便其他在等待的线程就可以得到这个对象锁。
     * 由于所有的这些方法都需要线程持有对象的锁，这样就只能通过同步来实现，所以他们只能在同步方法或者同步块中被调用。
     *
     * Thread 类中的 yield 方法有什么作用？
     * 使当前线程从执行状态（运行状态）变为可执行态（就绪状态）
     * 线程的 sleep()方法和 yield()方法有什么区别？
     * 线程执行 sleep()方法后转入阻塞（blocked）状态，而执行 yield()方法后转入就绪（ready）状态
     * 如何停止一个正在运行的线程? 使用interrupt方法中断线程,线程中断仅仅是置线程的中断状态位，不会停止线程。需要用户自己去监视线程的状态为并做处理
     * interrupted：是静态方法，查看当前中断信号是true还是false并且清除中断信号。如果一个线程被中断了，第一次调用 interrupted 则返回 true，第二次和后面的就返回 false 了。
     * isInterrupted：查看当前中断信号是true还是false
     * 什么是阻塞式方法？阻塞式方法是指程序会一直等待该方法完成期间不做其他事情，ServerSocket 的accept()方法就是一直等待客户端连接
     *
     * 怎样唤醒一个阻塞的线程？ notify()方法则将随机解除该对象阻塞的线程，但它需要重新获取该对象的锁，直到获取成功才能往下执行,wait、notify 方法必须在 synchronized 块或方法中被调用
     * wait、notify 方法必须在 synchronized 块或方法中被调用，并且要保证同步块或方法的锁对象与调用 wait、notify 方法的对象是同一个，如此一来在调用 wait 之前当前线程就已经成功获取某对象的锁，执行 wait 阻塞后当前线程就将之前获取的对象锁释放。
     *
     * notifyAll() 调用后，会将全部线程由该对象的等待池移到锁池，然后参与锁的竞争，竞争成功则继续执行，如果不成功则留在锁池等待锁被释放后再次参与竞争。而 notify()只会唤醒一个线程，具体唤醒哪一个线程由虚拟机控制。
     *
     * 如何在两个线程间共享数据？在两个线程间共享变量即可实现共享。
     * 共享变量要求变量本身是线程安全的，然后在线程内使用的时候，如果有对共享变量的复合操作，那么也得保证复合操作的线程安全性。
     *
     * Java 如何实现多线程之间的通讯和协作？可以通过中断 和 共享变量的方式实现线程间的通讯和协作
     * 如生产者-消费者模型，当队列满时生产者需要等待队列有空间了才能继续放商品，当队列空时消费者要等待消费者通知它队列有商品了
     * Java中线程通信协作的最常见的两种方式？
     * 一.syncrhoized加锁的线程的Object类的wait()/notify()/notifyAll()
     * 二.ReentrantLock类加锁的线程的Condition类的await()/signal()/signalAll()
     *
     * 同步方法和同步块，哪个是更好的选择？
     * 同步块是更好的选择，因为它不会锁住整个对象，同步的范围越小越好。这样从侧面来说也可以避免死锁。
     * 什么是线程同步和线程互斥，有哪几种实现方式？
     * 线程同步：当一个线程对共享的数据进行操作时，应使之成为一个”原子操作“，即在没有完成相关操作之前，不允许其他线程打断它
     * 线程互斥是指对于共享的进程系统资源，在各单个线程访问时的排它性
     * 实现线程同步的方法
     * sychronized 修饰方法或代码块;使用特殊变量域volatile实现线程同步;使用重入锁实现线程同步：reentrantlock类是可重入、互斥
     *
     * 监视器(Monitor)内部，是如何做线程同步的？程序应该做哪种级别的同步？
     * 一旦方法或者代码块被 synchronized 修饰，那么这个部分就放入了监视器的监视区域，确保一次只能有一个线程执行该部分的代码，线程在获取锁之前不允许执行该部分的代码
     * 如果使用的是无界队列 LinkedBlockingQueue，也就是无界队列的话,可以近乎认为是一个无穷大的队列，可以无限存放任务
     * 有界队列比如 ArrayBlockingQueue,会根据maximumPoolSize 的值增加线程数量,还是处理不过来的话，RejectedExecutionHandler 默认是AbortPolicy
     *
     * 什么叫线程安全？servlet 是线程安全吗?
     * 某个方法在多线程环境中被调用时，能够正确地处理多个线程之间的共享变量，使程序功能正确完成。
     * Servlet 不是线程安全的，servlet 是单实例多线程的，SpringMVC 的 Controller 是线程安全的吗？不是的，和 Servlet 类似的处理流程。
     *
     * Java 程序中怎么保证多线程的运行安全？
     * 方法一：使用安全类，比如 java.util.concurrent 下的类，使用原子类AtomicInteger
     * 方法二：使用自动锁 synchronized。
     * 方法三：使用手动锁 Lock。
     *
     * 高优先级线程具有运行的高优先权，但依赖于线程调度，不一定就会先执行。是int变量 1 最低优先级，10最高
     * Java 的线程优先级调度会委托给操作系统去处理，所以与具体的操作系统优先级有关，如非特别需要，一般无需设置线程优先级。
     *
     * 线程类的构造方法、静态块是被哪个线程调用的?
     * 线程类的构造方法、静态块是被 new这个线程类所在的线程所调用的，而 run 方法里面的代码才是被线程自身所调用的。
     *
     * Java 中怎么获取一份线程 dump 文件？你如何在 Java 中获取线程堆栈？
     * 在 Linux 下，你可以通过命令 kill -3 PID （Java 进程的进程 ID）来获取 Java应用的 dump 文件。Dump文件是进程的内存镜像。可以把程序的执行状态通过调试器保存到dump文件中。
     *
     * 一个线程运行时发生异常会怎样？如果异常没有被捕获该线程将会停止执行
     *
     * Java 线程数过多会造成什么异常？
     * 线程的生命周期开销非常高
     * 消耗过多的 CPU:资源如果可运行的线程数量多于可用处理器的数量，那么有线程将会被闲置。大量空闲的线程会占用许多内存，给垃圾回收器带来压力，而且大量的线程在竞争 CPU资源时还将产生其他性能的开销。
     * 降低稳定性JVM: 在可创建线程的数量上存在一个限制，这个限制值将随着平台的不同而不同，并且承受着多个因素制约，包括 JVM 的启动参数、Thread 构造函数中请求栈的大小，以及底层操作系统对线程的限制等。如果破坏了这些限制，那么可能抛出OutOfMemoryError 异常。
     *
     * Java中垃圾回收有什么目的，什么时候进行gc
     * 垃圾回收的目的是识别并丢弃应用不再使用的对象来释放和重用资源，
     * 如果对象的引用被置为null，gc不会立即释放对象占用的内存，会在下一个垃圾回调周期中被收回
     *
     * finalize()方法什么时候被调用？析构函数(finalization)的目的是什么？
     * 1）垃圾回收器（garbage colector）决定回收某对象时，就会运行该对象的finalize()方法；并且下一次垃圾回收动作发生时，才真正回收对象占用的内存空间
     *
     * as-if-serial语义保证单线程内程序的执行结果不被改变，happens-before关系保证正确同步的多线程程序的执行结果不被改变。
     * 为了在不改变程序执行结果的前提下，尽可能地提高程序执行的并行度。
     *
     * 说说自己是怎么使用 synchronized 关键字，在项目中用到了吗
     * synchronized 关键字是用来控制线程同步的，就是在多线程的环境下，控制 synchronized 代码段不被多个线程同时执行。
     * 修饰实例方法: 作用于当前对象实例加锁，进入同步代码前要获得当前对象实例的锁
     * 修饰静态方法: 也就是给当前类加锁，会作用于类的所有对象实例，访问静态 synchronized 方法占用的锁是当前类的锁，而访问非静态 synchronized 方法占用的锁是当前实例对象锁。
     * 修饰代码块: 指定加锁对象，对给定对象加锁，进入同步代码库前要获得给定对象的锁。
     * synchronized 关键字加到 static 静态方法和 synchronized(class)代码块上都是是给 Class 类上锁。synchronized 关键字加到实例方法上是给对象实例上锁。尽量不要使用 synchronized(String a) 因为JVM中，字符串常量池具有缓存功能！
     *
     * 单例模式了解吗？来给我手写一下！给我解释一下双重检验锁方式实现单例模式的原理呗！
     * 使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行。
     *
     * synchronized 底层原理：获取锁的过程就是monitorenter ，在执行完代码块之后，要释放锁，释放锁就是执行monitorexit指令。有两个monitorexit
     * 最后一个monitorexit是保证在异常情况下，锁也可以得到释放，避免死锁。
     * synchronized可重入的原理
     * 重入锁是指一个线程获取到该锁之后，该线程可以继续获得该锁。底层原理维护一个计数器，当线程获取该锁时，计数器加一，再次获得该锁时继续加一，释放锁时，计数器减一，当计数器值为0时，表明该锁未被任何线程所持有，其它线程可以竞争获取锁。
     * 什么是自旋
     * 很多 synchronized 里面的代码只是一些很简单的代码，执行时间非常快，此时等待的线程都加锁可能是一种不太值得的操作，因为线程阻塞涉及到用户态和内核态切换的问题。既然 synchronized 里面的代码执行得非常快，不妨让等待锁的线程不要被阻塞，而是在 synchronized 的边界做忙循环，这就是自旋。如果做了多次循环发现还没有获得锁，再阻塞，这样可能是一种更好的策略。
     *
     * 多线程中 synchronized 锁升级的原理是什么？
     * 锁对象的对象头里有一个threadid字段，第一次访问时threadid为空，jvm让其持有偏向锁，将threadid设置为其线程id，
     * 再次进入的时候会先判断 threadid 是否与其线程 id 一致，如果一致则可以直接使用此对象，如果不一致，则升级偏向锁为轻量级锁，
     * 通过自旋循环一定次数来获取锁，执行一定次数之后，如果还没有正常获取到要使用的对象，此时就会把锁从轻量级升级为重量级锁
     * 锁升级是为了减低了锁带来的性能消耗
     *
     * 线程 B 怎么知道线程 A 修改了变量
     * （1）volatile 修饰变量
     * （2）synchronized 修饰修改变量的方法
     * （3）wait/notify
     * （4）while 轮询
     * 当一个线程进入一个对象的 synchronized 方法 A 之后，其它线程是否可进入此对象的 synchronized 方法 B？
     * 不能。其它线程只能访问该对象的非同步方法，同步方法则不能进入。因为非静态方法上的 synchronized 修饰符要求执行方法时要获得对象的锁，如果已经进入A 方法说明对象锁已经被取走，那么试图进入 B 方法的线程就只能在等锁池（注意不是等待池哦）中等待对象的锁。
     *
     * synchronized、volatile、CAS 比较
     * （1）synchronized 是悲观锁，属于抢占式，会引起其他线程阻塞。
     * （2）volatile 提供多线程共享变量可见性和禁止指令重排序优化。
     * （3）CAS 是基于冲突检测的乐观锁（非阻塞
     *
     * synchronized 和 Lock 有什么区别？
     * 首先synchronized是Java内置关键字，在JVM层面，Lock是个Java类；
     * synchronized 可以给类、方法、代码块加锁；而 lock 只能给代码块加锁。
     * synchronized 不需要手动获取锁和释放锁，使用简单，发生异常会自动释放锁，不会造成死锁；而 lock 需要自己加锁和释放锁，如果使用不当没有 unLock()去释放锁就会造成死锁。
     * 通过 Lock 可以知道有没有成功获取锁，而 synchronized 却无法办到。
     *
     * synchronized 和 ReentrantLock 区别是什么：两者都是可重入锁
     * synchronized 是和 if、else、for、while 一样的关键字，ReentrantLock 是类，这是二者的本质区别。既然 ReentrantLock 是类，那么它就提供了比synchronized 更多更灵活的特性，可以被继承、可以有方法、可以有各种各样的类变量
     * ReentrantLock 使用起来比较灵活，但是必须有释放锁的配合动作；
     * ReentrantLock 必须手动获取与释放锁，而 synchronized 不需要手动释放和开启锁；
     * ReentrantLock 只适用于代码块锁，而 synchronized 可以修饰类、方法、变量等。
     * 二者的锁机制其实也是不一样的。ReentrantLock 底层调用的是 Unsafe 的park 方法加锁，synchronized 操作的应该是对象头中 mark word
     *
     * Java中每一个对象都可以作为锁，这是synchronized实现同步的基础：
     * 普通同步方法，锁是当前实例对象
     * 静态同步方法，锁是当前类的class对象
     * 同步方法块，锁是括号里面的对象
     *
     * volatile 关键字的作用
     * Java 提供了 volatile 关键字来保证可见性和禁止指令重排。 volatile 提供 happens-before 的保证，确保一个线程的修改能对其他线程是可见的。当一个共享变量被 volatile 修饰时，它会保证修改的值会立即被更新到主存，当有其他线程需要读取时，它会去内存中读取新值。
     * volatile 的一个重要作用就是和 CAS 结合，保证了原子性, volatile 常用于多线程环境下的单次操作(单次读或者单次写)。
     *
     * volatile 变量和 atomic 变量有什么不同？
     * volatile 变量可以确保先行关系，即写操作会发生在后续的读操作之前, 但它并不能保证原子性。例如用 volatile 修饰 count 变量，那么 count++ 操作就不是原子性的。
     * AtomicInteger 类提供的 atomic 方法可以让这种操作具有原子性如getAndIncrement()方法会原子性的进行增量操作把当前值加一，其它数据类型和引用变量也可以进行相似操作。
     * 关键字volatile的主要作用是使变量在多个线程间可见，但无法保证原子性，对于多个线程访问同一个实例变量需要加锁进行同步。
     * 虽然volatile只能保证可见性不能保证原子性，但用volatile修饰long和double可以保证其操作原子性。
     *
     * 单例模式: 是否 Lazy 初始化：是, 是否多线程安全：是,
     *
     * 描述：对于Double-Check这种可能出现的问题（当然这种概率已经非常小了，但毕竟还是有的嘛~），
     * 解决方案是：只需要给instance的声明加上volatile关键字即可volatile关键字的一个作用是禁止指令重排，把instance声明为volatile之后，
     * 对它的写操作就会有一个内存屏障（什么是内存屏障？），这样，在它的赋值完成之前，就不用会调用读操作。
     * 注意：volatile阻止的不是singleton = newSingleton()这句话内部[1-2-3]的指令重排，而是保证了在一个写操作（[1-2-3]）完成之前，不会调用读操作（if (instance == null)）。
     *
     * synchronized 和 volatile 的区别是什么？
     * synchronized 表示只有一个线程可以获取作用对象的锁，执行代码，阻塞其他线程。
     * volatile 表示变量在 CPU 的寄存器中是不确定的，必须从主存中读取。保证多线程环境下变量的可见性；禁止指令重排序。
     * volatile 是变量修饰符；synchronized 可以修饰类、方法、变量。
     * volatile 仅能实现变量的修改可见性，不能保证原子性；而 synchronized 则可以保证变量的修改可见性和原子性。
     * volatile 不会造成线程的阻塞；synchronized 可能会造成线程的阻塞。
     * volatile标记的变量不会被编译器优化；synchronized标记的变量可以被编译器优化。
     * volatile关键字是线程同步的轻量级实现，所以volatile性能肯定比synchronized关键字要好。但是volatile关键字只能用于变量而synchronized关键字可以修饰方法以及代码块。
     * synchronized关键字在JavaSE1.6之后进行了主要包括为了减少获得锁和释放锁带来的性能消耗而引入的偏向锁和轻量级锁以及其它各种优化之后执行效率有了显著提升，实际开发中使用 synchronized 关键字的场景还是更多一些。
     * */

    /**
     * final, 什么是不可变对象，它对写并发应用有什么帮助？
     * 不可变对象(Immutable Objects)即对象一旦被创建它的状态（对象的数据，也即对象属性值）就不能改变，反之即为可变对象(Mutable Objects)。
     * 不可变对象的类即为不可变类(Immutable Class)。Java 平台类库中包含许多不可变类，如 String、基本类型的包装类、BigInteger 和 BigDecimal 等。
     * 不可变对象保证了对象的内存可见性，对不可变对象的读取不需要进行额外的同步手段，提升了代码执行效率。
     * */

    /**
     * Java Concurrency API 中的 Lock 接口(Lock interface)是什么？对比同步它有什么优势？
     * Lock 接口比同步方法和同步块提供了更具扩展性的锁操作。他们允许更灵活的结构，可以具有完全不同的性质，并且可以支持多个相关类的条件对象。
     * 可以使锁更公平
     *  Lock 的实现类基本都支持非公平锁(默认)和公平锁，synchronized 只支持非公平锁
     *
     * 乐观锁和悲观锁的理解及如何实现，有哪些实现方式？
     * 悲观锁：总是假设最坏的情况，每次去拿数据的时候都认为别人会修改，所以每次在拿数据的时候都会上锁，这样别人想拿这个数据就会阻塞直到它拿到锁, 关系型数据库和synchronized 关键字的实现也是悲观锁
     * 乐观锁：顾名思义，就是很乐观，每次去拿数据的时候都认为别人不会修改，所以不会上锁，但是在更新的时候会判断一下在此期间别人有没有去更新这个数据，可以使用版本号等机制。乐观锁适用于多读的应用类型，这样可以提高吞吐量
     * java.util.concurrent.atomic 包下面的原子变量类就是使用了乐观锁的一种实现方式 CAS 实现的。(AtomicInteger,AtomicBoolean,AtomicLong）
     * Compare and Swap （比较交换）即 CAS
     * CAS 操作包含三个操作数 —— 内存位置（V）、预期原值（A）和新值(B)。如果内存地址里面的值和 A 的值是一样的，那么就将内存里面的值更新成 B
     * 如果在第一轮循环中，a 线程获取地址里面的值被b 线程修改了，那么 a 线程需要自旋，到下次循环才有可能机会执行。
     * CAS 的会产生什么问题？
     * 1、ABA 问题： 2、循环时间长开销大：CAS 自旋的概率会比较大，从而浪费更多的 CPU 资源，效率低于 synchronized
     * 3 只能保证一个共享变量的原子操作：
     * */

    /**
     * 什么是死锁？当线程 A 持有独占锁a，并尝试去获取独占锁 b 的同时，线程 B 持有独占锁 b，并尝试获取独占锁 a 的情况下，就会发生 AB 两个线程由于互相持有对方需要的锁，而发生的阻塞现象
     * 独占资源，对已获得的资源不释放，不强行剥夺，循环等待，满足以上条件就会死锁
     * 防止死锁：设置超时时间 tryLock， 使用 concurrent 并发类，不要几个功能使用同一把锁，减少同步代码块
     * 活锁：由于条件不满足导致一直尝试，实体不断改变状态
     * 饥饿：线程一直无法获得资源，无法执行的状态。原因：线程优先级低
     * */

    /**
     * AQS（AbstractQueuedSynchronizer）是一个用来构建锁和同步器的框架
     *
     * 读写锁有以下三个重要的特性：
     * （1）公平选择性：支持非公平（默认）和公平的锁获取方式，吞吐量还是非公平优于公平。
     * （2）重进入：读锁和写锁都支持线程重进入。
     * （3）锁降级：遵循获取写锁、获取读锁再释放写锁的次序，写锁能够降级成为读锁。
     * */

    /**
     * ConcurrentHashMap是Java中的一个线程安全且高效的HashMap实现。平时涉及高并发如果要用map结构，利用了锁分段的思想提高了并发度。
     * 它到底是如何实现线程安全的？
     * JDK1.8后，ConcurrentHashMap抛弃了原有的Segment 分段锁，而采用了 CAS + synchronized 来保证并发安全性。
     * ConcurrentHashMap 中采用了一种粒度更细的加锁机制，可以称为分段锁，在这种锁机制下，允许任意数量的读线程并发地访问 map，
     * 并且执行读操作的线程和写操作的线程也可以并发的访问 map，同时允许一定数量的写操作线程并发地修改 map，所以它可以在并发环境下实现更高的吞吐量。
     * */

    /**
     * 同步容器
     * Vector，Hashtable，以及 Collections.synchronizedSet，synchronizedList 等方法返回的容器。可以通过查看 Vector，Hashtable
     * 等这些同步容器的实现代码，可以看到这些容器实现线程安全的方式就是将它们的状态封装起来，并在需要同步的方法上加上关键字 synchronized。
     * */

    /**
     * SynchronizedMap 一次锁住整张表来保证线程安全，所以每次只能有一个线程来访为 map。
     * ConcurrentHashMap 使用分段锁来保证在多线程下的性能。
     * ConcurrentHashMap 中则是一次锁住一个桶。ConcurrentHashMap 默认将hash 表分为 16 个桶，诸如 get，put，remove 等常用操作只锁当前需要用到的桶。
     *
     * ConcurrentHashMap 使用了一种不同的迭代方式。在这种迭代方式中，当iterator 被创建后集合再发生改变就不再是抛出ConcurrentModificationException，取而代之的是在改变时 new 新的数据从而不影响原有的数据，iterator 完成后再将头指针替换为新的数据 ，这样 iterator线程可以使用原来老的数据，而写线程也可以并发的完成改变。
     * CopyOnWriteArrayList(免锁容器)的好处之一是当多个迭代器同时遍历和修改这个列表时，不会抛出 ConcurrentModificationException。在CopyOnWriteArrayList 中，写入将导致创建整个底层数组的副本，而源数组将保留在原地，使得复制的数组在被修改时，读取操作可以安全地执行。
     * ThreadLocal 是一个本地线程副本变量工具类，在每个线程中都创建了一个 ThreadLocalMap 对象，简单说 ThreadLocal 就是一种以空间换时间的做法，每个线程可以访问自己内部 ThreadLocalMap 对象内的 value。通过这种方式，避免资源在多线程间共享
     * 经典的使用场景是为每个线程分配一个 JDBC 连接 Connection。这样就可以保证每个线程的都在各自的 Connection 上进行数据库的操作，不会出现 A 线程关了 B线程正在使用的 Connection； 还有 Session 管理 等问题
     * 线程局部变量是局限于线程内部的变量，属于线程自身所有，不在多个线程间共享。Java 提供 ThreadLocal 类来支持线程局部变量，是一种实现线程安全的方式。但是在管理环境下（如 web 服务器）使用线程局部变量的时候要特别小心，在这种情况下，工作线程的生命周期比任何应用变量的生命周期都要长。任何线程局部变量一旦在工作完成后没有释放，Java 应用就存在内存泄露的风险
     * ThreadLocal内存泄漏分析与解决方案
     * 每次使用完ThreadLocal，都调用它的remove()方法，清除数据。因为key 会被清理掉，而 value 不会被清理掉，value 永远无法被GC 回收
     * */

    /**
     * 什么是阻塞队列？阻塞队列BlockingQueue的实现原理是什么？如何使用阻塞队列来实现生产者-消费者模型？
     * 支持两个附加操作的队列： 在队列为空时，获取元素的线程会等待队列变为非空。当队列满时，存储元素的线程会等待队列可用
     * Java 5 之前实现同步存取时，可以使用普通的一个集合，然后在使用线程的协作和线程同步可以实现生产者，消费者模式，主要的技术就是用好，wait,notify,notifyAll,sychronized 这些关键字
     * java 5 之后，可以使用阻塞队列来实现
     * 最经典的场景就是 socket 客户端数据的读取和解析
     * */

    /**
     * 面向对象编程中，创建和销毁对象是很费时间的,虚拟机将试图跟踪每一个对象，以便能够在对象销毁后进行垃圾回收
     * 尽可能减少创建和销毁对象的次数，特别是一些很耗资源的对象创建和销毁，这就是”池化资源”技术产生的原因。
     * newSingleThreadExecutor 这个唯一的线程因为异常结束，那么会有一个新的线程来替代它
     * newFixedThreadPool 每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小,如果希望在服务器上使用线程池，建议使用 newFixedThreadPool方法来创建线程池，这样能获得更好的性能。
     * newCachedThreadPool 如果线程池的大小超过了处理任务所需要的线程，那么就会回收部分空闲（60 秒不执行任务）的线程，当任务数增加时，此线程池又可以智能的添加新线程来处理任务,线程池大小完全依赖于操作系统（或者说 JVM）能够创建的最大线程大小。
     * newScheduledThreadPool 创建一个大小无限的线程池
     * 减少对象创建销毁的开销 提高响应速度
     *
     * 线程池都有哪些状态？
     * RUNNING：这是最正常的状态，接受新的任务，处理等待队列中的任务。
     * SHUTDOWN：不接受新的任务提交，但是会继续处理等待队列中的任务。
     * STOP：不接受新的任务提交，不再处理等待队列中的任务，中断正在执行任务的线程。
     * TIDYING：所有的任务都销毁了，workCount 为 0，线程池的状态在转换为 TIDYING 状态时，会执行钩子方法 terminated()。
     * TERMINATED：terminated()方法结束后，线程池的状态就会变成这个。
     *
     * 线程池中 submit() 和 execute() 方法有什么区别？
     * execute()只能执行 Runnable 类型的任务。submit()可以执行 Runnable 和 Callable 类型的任务。
     * submit()方法可以返回持有计算结果的 Future 对象，而execute()没有
     *
     * ThreadPoolExecutor创建线程池方式只有一种，就是走它的构造函数，参数自己指定
     * Executors 各个方法的弊端： newFixedThreadPool 和 newSingleThreadExecutor:
     * 主要问题是堆积的请求处理队列可能会耗费非常大的内存，甚至 OOM
     * newCachedThreadPool 和 newScheduledThreadPool:
     * 主要问题是线程数最大数是 Integer.MAX_VALUE，可能会创建数量非常多的线程，甚至 OOM。
     * 创建线程池 用 ThreadPoolExecutor()
     * corePoolSize ：核心线程数，线程数定义了最小可以同时运行的线程数量。
     * maximumPoolSize ：线程池中允许存在的工作线程的最大数量
     * workQueue：当新任务来的时候会先判断当前运行的线程数量是否达到核心线程数，如果达到的话，任务就会被存放在队列中
     *
     * ThreadPoolExecutor 饱和策略定义:建议使用 ThreadPoolExecutor.CallerRunsPolicy当最大池被填满时，此策略为我们提供可伸缩队列。
     * */

    /**
     * 什么是原子操作？在 Java Concurrency API 中有哪些原子类(atomic classes)？
     * 不可被中断的一个或一系列操作
     * 原子类：AtomicBoolean，AtomicInteger，AtomicLong，AtomicReference
     * 原子数组：AtomicIntegerArray，AtomicLongArray，AtomicReferenceArray
     * 原子属性更新器：AtomicLongFieldUpdater，AtomicIntegerFieldUpdater，AtomicReferenceFieldUpdater
     *
     * Atomic包中的类基本的特性就是在多线程环境下，当有多个线程同时对单个（包括基本类型及引用类型）变量进行操作时，具有排他性，即当多个线程同时对该变量的值进行更新时，仅有一个线程能成功，而未成功的线程可以向自旋锁一样，继续尝试，一直等到执行成功。
     * AtomicInteger 类主要利用 CAS (compare and swap) + volatile 和 native 方法来保证原子操作，从而避免 synchronized 的高开销，执行效率大为提升。
     * */

    /**
     * 并发工具
     * CyclicBarrier 和 CountdownLatch 有什么区别？
     * CountDownLatch与CyclicBarrier都是用于控制并发的工具类，都可以理解成维护的就是一个计数器，但是这两者还是各有不同侧重点的
     * Semaphore与Exchanger
     * Semaphore 就是一个信号量，它的作用是限制某段代码块的并发数。Semaphore有一个构造函数，可以传入一个 int 型整数 n，表示某段代码最多只有 n 个线程可以访问，如果超出了 n，那么请等待
     * 线程间交换数据的工具Exchanger 用于两个线程间交换数据。它提供了一个交换的同步点，在这个同步点两个线程能够交换数据
     *
     * */

    public static void main(String[] args) {
        deadLockDemo();
    }

    public static void deadLockDemo() {
        Object resource1 = new Object();
        Object resource2 = new Object();

        new Thread(()->{
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "got resource1");
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "got resource2");
                }
            }
        }, "线程1").start();

        new Thread(()->{
            synchronized (resource2) {
                System.out.println(Thread.currentThread() +"got resource2");
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"waiting get resource1");
                synchronized (resource1){
                    System.out.println(Thread.currentThread()+"got resource1");
                }
            }
        }, "线程2").start();

        new Thread(()->{
            synchronized (resource1){
                System.out.println(Thread.currentThread()+"got resource1");
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                synchronized (resource2){
                    System.out.println(Thread.currentThread()+"got resource2");
                }
            }
        }, "线程2").start();
    }
}
