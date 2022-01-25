Linux命令-查看内存、GC情况及jmap 用法

查看进程占用内存、CPU使用情况
 

1、查看进程
 

#jps  查看所有java进程，输出JVM中运行的进程状态信息

命令行参数选项说明如下：
 
-q 不输出类名、Jar名和传入main方法的参数
 
-m 输出传入main方法的参数
 
-l 输出main类或Jar的全限名
 
-v 输出传入JVM的参数


 

#top   查看cpu占用高进程

top
 
Mem:  16333644k total,  9472968k used,  6860676k free,   165616k buffers
Swap:        0k total,        0k used,        0k free,  6665292k cached
 
  PID USER      PR  NI  VIRT  RES  SHR S %CPU %MEM    TIME+  COMMAND     
17850 root      20   0 7588m 112m  11m S 100.7  0.7  47:53.80 java       
 1552 root      20   0  121m  13m 8524 S  0.7  0.1  14:37.75 AliYunDun   
 3581 root      20   0 9750m 2.0g  13m S  0.7 12.9 298:30.20 java        
    1 root      20   0 19360 1612 1308 S  0.0  0.0   0:00.81 init        
    2 root      20   0     0    0    0 S  0.0  0.0   0:00.00 kthreadd    
    3 root      RT   0     0    0    0 S  0.0  0.0   0:00.14 migration/0 
 

2、top -p pid 查看某一进程下线程
首先可以通过ps命令找到进程id，比如 ps -ef | grep kafka 可以看到kafka这个程序的进程id

　　

　　可以看到是2913，现在可以使用如下命令查看内存：

top -p 2913
　　

　　这样可以动态实时的看到CPU和内存的占用率，然后按q键回到命令行

 

接下来找出该进程中最耗费CPU的Java线程

top -Hp pid  或者  ps -Lfp pid


CPU时间最长的是线程ID为21742的线程，printf %x转换为十六进制值，结果为为54ee

printf %x 21742
 

输出进程21711的堆栈信息，然后根据线程ID的十六进制值grep，可以看到CPU消耗在PollIntervalRetrySchedulerThread这个类的Object.wait()

root@ubuntu:/# jstack 21711 | grep 54ee
"PollIntervalRetrySchedulerThread" prio=10 tid=0x00007f950043e000 nid=0x54ee in Object.wait() [0x00007f94c6eda000]
 

 

 

 

3、ps -aux | grep xxx
直接使用ps命令查看： ps -aux | grep kafka 

　　

第一个标注的地方是CPU和内存占用率，后面的943100是物理内存使用量，单位是k，此时kafka大约占用943M内存

 

4、查看内存占用前10名的程序
ps aux | sort -k4,4nr | head -n 10 查看内存占用前10名的程序

 

5、监控全部或指定进程占用系统资源：pidstat
pidstat主要用于监控全部或指定进程占用系统资源的情况。

5.1 查看CPU使用情况
pidstat首次运行时显示自系统启动开始的各项统计信息，之后运行pidstat将显示自上次运行该命令以后的统计信息。用户可以通过指定统计的次数和时间来获得所需的统计信息。

# 显示所有的进程统计信息，包括idle进程。pidstat -p ALL
# 更加详细的显示了线程统计信息。pidstat -p ALL -t
# 周期采样和采样次数pidstat [option] interval [count]
除此之外还可以通过-p获取指定进程的统计信息。

pidstat还可以通过-r获取内存使用统计信息，通过-d获取IO使用统计信息。

5.2 查看内存使用情况
pidstat -p ALL -r结果如下：

15时18分21秒   UID       PID  minflt/s  majflt/s     VSZ     RSS   %MEM  Command
15时18分21秒     0         1      0.02      0.00  185316    3028   0.08  systemd
15时18分21秒     0         2      0.00      0.00       0       0   0.00  kthreadd
15时18分21秒     0         4      0.00      0.00       0       0   0.00  kworker/0:0H
15时18分21秒     0         6      0.00      0.00       0       0   0.00  mm_percpu_wq
15时18分21秒     0         7      0.00      0.00       0       0   0.00  ksoftirqd/0
15时18分21秒     0         8      0.00      0.00       0       0   0.00  rcu_sched
minflt/s: 每秒次缺页错误次数(minor page faults)，次缺页错误次数意即虚拟内存地址映射成物理内存地址产生的page fault次数。

majflt/s: 每秒主缺页错误次数(major page faults)，当虚拟内存地址映射成物理内存地址时，相应的page在swap中，这样的page fault为major page fault，一般在内存使用紧张时产生。

VSZ: 该进程使用的虚拟内存(以kB为单位)。

RSS: 该进程使用的物理内存(以kB为单位)。

%MEM: 该进程使用内存的百分比。

Command: 拉起进程对应的命令。

 

5.3 查看磁盘使用情况
pidstat -p ALL -d结果如下：

15时20分40秒   UID       PID   kB_rd/s   kB_wr/s kB_ccwr/s iodelay  Command
15时20分40秒     0         1     -1.00     -1.00     -1.00 243523129  systemd
15时20分40秒     0         2     -1.00     -1.00     -1.00       0  kthreadd
15时20分40秒     0         4     -1.00     -1.00     -1.00       0  kworker/0:0H
15时20分40秒     0         6     -1.00     -1.00     -1.00       0  mm_percpu_wq
15时20分40秒     0         7     -1.00     -1.00     -1.00 714512328679  ksoftirqd/0
15时20分40秒     0         8     -1.00     -1.00     -1.00 417757303594  rcu_sched
kB_rd/s: 每秒进程从磁盘读取的数据量(以kB为单位)。

kB_wr/s: 每秒进程向磁盘写的数据量(以kB为单位)。

kB_ccwr/s：每秒进程被取消向磁盘写的数据量(以kB为单位)。

Command:：拉起进程对应的命令。

 

6、jstack查看java线程
 

/opt/java8/bin/jstack
 
Usage:
    jstack [-l] <pid>
        (to connect to running process) 连接活动线程
    jstack -F [-m] [-l] <pid>
        (to connect to a hung process) 连接阻塞线程
    jstack [-m] [-l] <executable> <core>
        (to connect to a core file) 连接dump的文件
    jstack [-m] [-l] [server_id@]<remote server IP or hostname>
        (to connect to a remote debug server) 连接远程服务器
 
Options:
    -F  to force a thread dump. Use when jstack <pid> does not respond (process is hung)
    -m  to print both java and native frames (mixed mode)
    -l  long listing. Prints additional information about locks
    -h or -help to print this help message
 

jstack查看输出

/opt/java8/bin/jstack -l 28367
 
2019-06-25 15:04:46
Full thread dump Java HotSpot(TM) 64-Bit Server VM (25.77-b03 mixed mode):
 
"Attach Listener" #453 daemon prio=9 os_prio=0 tid=0x00007f9f94001000 nid=0xf30 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE
 
   Locked ownable synchronizers:
        - None
 
"grpc-default-executor-263" #452 daemon prio=5 os_prio=0 tid=0x00007f9f4c01f800 nid=0x9aa waiting on condition [0x00007f9f398bd000]
   java.lang.Thread.State: TIMED_WAITING (parking)
        at sun.misc.Unsafe.park(Native Method)
        - parking to wait for  <0x00000007400243f0> (a java.util.concurrent.SynchronousQueue$TransferStack)
        at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
        at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
        at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
        at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
        at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
        at java.lang.Thread.run(Thread.java:745)
 
   Locked ownable synchronizers:
        - None
 
"http-bio-8080-exec-10" #235 daemon prio=5 os_prio=0 tid=0x0000000001bcc800 nid=0x3c13 waiting on condition [0x00007f9f384a9000]
   java.lang.Thread.State: WAITING (parking)
        at sun.misc.Unsafe.park(Native Method)
        - parking to wait for  <0x0000000743d26638> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
        at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
        at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
        at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:104)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:32)
        at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1067)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
        at java.lang.Thread.run(Thread.java:745)
 
   Locked ownable synchronizers:
        - None
 

jstack统计线程数

/opt/java8/bin/jstack -l 28367 | grep 'java.lang.Thread.State' | wc -l
 

 

查看gc情况
1、jmap查看某个进程的对象占用对象最大情况
pid是进程号，20表示排名前二十，instances表示实例数量，bytes表示占用内存大小（1M=1024KB,1KB=1024Bytes）

 jmap -histo pid | head -n 20



 

2、jstat监控jvm内存，查看full gc频率
使用jstat命令（JVM统计监测工具）: 看看各个区内存和GC的情况

语法格式如下：
 
jstat [ generalOption | outputOptions vmid [interval[s|ms] [count]] ]
 

监控jvm，每5秒打印一次，循环100次
 

jstat -gc pid 5000 100
 
jstat -gcutil pid 5000 100
 



 





S0C：第一个幸存区的大小
S1C：第二个幸存区的大小
S0U：第一个幸存区的使用大小
S1U：第二个幸存区的使用大小
EC：伊甸园区的大小
EU：伊甸园区的使用大小
OC：老年代大小
OU：老年代使用大小
MC：方法区大小
MU：方法区使用大小
CCSC:压缩类空间大小
CCSU:压缩类空间使用大小
YGC：年轻代垃圾回收次数
YGCT：年轻代垃圾回收消耗时间
FGC：老年代垃圾回收次数
FGCT：老年代垃圾回收消耗时间
GCT：垃圾回收消耗总时间 
 
 

查看进程运行时间，频率=持续时间 /FGC

# ps -eo pid,tty,user,comm,lstart,etime | grep 24019
24019 ?        admin    java            Thu Dec 13 11:17:14 2018    01:29:43
进程id                  进程名            开始时间                    持续时间 
 

 

3、hprof查库CPU使用率，统计堆内存使用情况
语法格式如下：

java -agentlib:hprof[=options] ToBeProfiledClass
java -Xrunprof[:options] ToBeProfiledClass
javac -J-agentlib:hprof[=options] ToBeProfiledClass
 

完整的命令选项如下：

Option Name and Value  Description                    Default
---------------------  -----------                    -------
heap=dump|sites|all    heap profiling                 all
cpu=samples|times|old  CPU usage                      off
monitor=y|n            monitor contention             n
format=a|b             text(txt) or binary output     a
file=<file>            write data to file             java.hprof[.txt]
net=<host>:<port>      send data over a socket        off
depth=<size>           stack trace depth              4
interval=<ms>          sample interval in ms          10
cutoff=<value>         output cutoff point            0.0001
lineno=y|n             line number in traces?         y
thread=y|n             thread in traces?              n
doe=y|n                dump on exit?                  y
msa=y|n                Solaris micro state accounting n
force=y|n              force output to <file>         y
verbose=y|n            print messages about dumps     y
 

CPU Usage Sampling Profiling(cpu=samples)的例子：

java -agentlib:hprof=cpu=samples,interval=20,depth=3 Hello
上面每隔20毫秒采样CPU消耗信息，堆栈深度为3，生成的profile文件名称是java.hprof.txt，在当前目录。 

 

CPU Usage Times Profiling(cpu=times)的例子，它相对于CPU Usage Sampling Profile能够获得更加细粒度的CPU消耗信息，能够细到每个方法调用的开始和结束，它的实现使用了字节码注入技术（BCI）：

javac -J-agentlib:hprof=cpu=times Hello.java
 

Heap Allocation Profiling(heap=sites)的例子：

javac -J-agentlib:hprof=heap=sites Hello.java
 

Heap Dump(heap=dump)的例子，它比上面的Heap Allocation Profiling能生成更详细的Heap Dump信息：

javac -J-agentlib:hprof=heap=dump Hello.java
 

虽然在JVM启动参数中加入-Xrunprof:heap=sites参数可以生成CPU/Heap Profile文件，但对JVM性能影响非常大，不建议在线上服务器环境使用

 

 

jmap 用法
 

概述
命令jmap是一个多功能的命令。它可以生成 java 程序的 dump 文件， 也可以查看堆内对象示例的统计信息、查看 ClassLoader 的信息以及 finalizer 队列。



参数：

option： 选项参数。
pid： 需要打印配置信息的进程ID。
executable： 产生核心dump的Java可执行文件。
core： 需要打印配置信息的核心文件。
server-id 可选的唯一id，如果相同的远程主机上运行了多台调试服务器，用此选项参数标识服务器。
remote server IP or hostname 远程调试服务器的IP地址或主机名。
option

no option： 查看进程的内存映像信息,类似 Solaris pmap 命令。
heap： 显示Java堆详细信息
histo[:live]： 显示堆中对象的统计信息
clstats：打印类加载器信息
finalizerinfo： 显示在F-Queue队列等待Finalizer线程执行finalizer方法的对象
dump:<dump-options>：生成堆转储快照
F： 当-dump没有响应时，使用-dump或者-histo参数. 在这个模式下,live子参数无效.
help：打印帮助信息
J<flag>：指定传递给运行jmap的JVM的参数
 

 

1、no option
命令：jmap pid
描述：查看进程的内存映像信息,类似 Solaris pmap 命令。

使用不带选项参数的jmap打印共享对象映射，将会打印目标虚拟机中加载的每个共享对象的起始地址、映射大小以及共享对象文件的路径全称。这与Solaris的pmap工具比较相似。

 



 

 

2、heap查看内存使用情况
命令：jmap -heap pid
描述：显示Java堆详细信息

打印一个堆的摘要信息，包括使用的GC算法、堆配置信息和各内存区域内存使用信息

 

C:\Users\jjs>jmap -heap 5932
Attaching to process ID 5932, please wait...
Debugger attached successfully.
Server compiler detected.
JVM version is 25.91-b15
 
using thread-local object allocation.
Parallel GC with 4 thread(s)
 
#堆内存配置信息
Heap Configuration:
   MinHeapFreeRatio         = 0
   MaxHeapFreeRatio         = 100
   MaxHeapSize              = 1073741824 (1024.0MB)
   NewSize                  = 42991616 (41.0MB)
   MaxNewSize               = 357564416 (341.0MB)
   OldSize                  = 87031808 (83.0MB)
   NewRatio                 = 2
   SurvivorRatio            = 8
   MetaspaceSize            = 21807104 (20.796875MB)
   CompressedClassSpaceSize = 1073741824 (1024.0MB)
   MaxMetaspaceSize         = 17592186044415 MB
   G1HeapRegionSize         = 0 (0.0MB)
 
#堆内存使用情况
Heap Usage:
#年轻代
PS Young Generation
Eden Space:
   capacity = 60293120 (57.5MB)
   used     = 44166744 (42.120689392089844MB)
   free     = 16126376 (15.379310607910156MB)
   73.25337285580842% used
From Space:
   capacity = 5242880 (5.0MB)
   used     = 0 (0.0MB)
   free     = 5242880 (5.0MB)
   0.0% used
To Space:
   capacity = 14680064 (14.0MB)
   used     = 0 (0.0MB)
   free     = 14680064 (14.0MB)
   0.0% used
#年老代
PS Old Generation
   capacity = 120061952 (114.5MB)
   used     = 19805592 (18.888084411621094MB)
   free     = 100256360 (95.6119155883789MB)
   16.496143590935453% used
 
20342 interned Strings occupying 1863208 bytes.
 

using parallel threads in the new generation.  ##新生代采用的是并行线程处理方式
 
using thread-local object allocation.   
 
Concurrent Mark-Sweep GC   ##同步并行垃圾回收
 
Heap Configuration:  ##堆配置情况
 
MinHeapFreeRatio = 40 ##最小堆使用比例
 
MaxHeapFreeRatio = 70 ##最大堆可用比例
 
MaxHeapSize      = 2147483648 (2048.0MB) ##最大堆空间大小
 
NewSize          = 268435456 (256.0MB) ##新生代分配大小
 
MaxNewSize       = 268435456 (256.0MB) ##最大可新生代分配大小
 
OldSize          = 5439488 (5.1875MB) ##老生代大小
 
NewRatio         = 2  ##新生代比例
 
SurvivorRatio    = 8 ##新生代与suvivor的比例
 
PermSize         = 134217728 (128.0MB) ##perm区大小
 
MaxPermSize      = 134217728 (128.0MB) ##最大可分配perm区大小
 
Heap Usage: ##堆使用情况
 
New Generation (Eden + 1 Survivor Space):  ##新生代（伊甸区 + survior空间）
capacity = 241631232 (230.4375MB)  ##伊甸区容量
 
used     = 77776272 (74.17323303222656MB) ##已经使用大小
 
free     = 163854960 (156.26426696777344MB) ##剩余容量
 
32.188004570534986% used ##使用比例
 
Eden Space:  ##伊甸区 
 
capacity = 214827008 (204.875MB) ##伊甸区容量
 
used     = 74442288 (70.99369812011719MB) ##伊甸区使用
 
free     = 140384720 (133.8813018798828MB) ##伊甸区当前剩余容量
 
34.65220164496263% used ##伊甸区使用情况
 
From Space: ##survior1区
 
capacity = 26804224 (25.5625MB) ##survior1区容量
 
used     = 3333984 (3.179534912109375MB) ##surviror1区已使用情况
 
free     = 23470240 (22.382965087890625MB) ##surviror1区剩余容量
 
12.43827838477995% used ##survior1区使用比例
 
To Space: ##survior2 区
 
capacity = 26804224 (25.5625MB) ##survior2区容量
 
used     = 0 (0.0MB) ##survior2区已使用情况
 
free     = 26804224 (25.5625MB) ##survior2区剩余容量
 
0.0% used ## survior2区使用比例
 
concurrent mark-sweep generation: ##老生代使用情况
 
capacity = 1879048192 (1792.0MB) ##老生代容量
 
used     = 30847928 (29.41887664794922MB) ##老生代已使用容量
 
free     = 1848200264 (1762.5811233520508MB) ##老生代剩余容量
 
1.6416783843721663% used ##老生代使用比例
 
Perm Generation: ##perm区使用情况
 
capacity = 134217728 (128.0MB) ##perm区容量
 
used     = 47303016 (45.111671447753906MB) ##perm区已使用容量
 
free     = 86914712 (82.8883285522461MB) ##perm区剩余容量
 
35.24349331855774% used ##perm区使用比例
 

　　

 

3、histo查看内存中对象数量及大小　　
命令：jmap -histo[:live] pid
描述：显示堆中对象的统计信息

可以使用管道 | more来一段一段地输出信息。其中包括每个Java类、对象数量、内存大小(单位：字节)、完全限定的类名。打印的虚拟机内部的类名称将会带有一个’*’前缀。如果指定了live子选项，则只计算活动的对象。

　　#查看所有对象  jmap ‐histo <pid> | more
 
　　#查看活跃（存活？）对象  jmap ‐histo:live <pid> | more
 

　　

　　对象说明：

　　　　B byte

　　　　C char

　　　　D double

　　　　F float

　　　　I int

　　　　J long

　　　　Z boolean

　　　　[ 数组，如[I表示int[]

　　　　[L+类名 其他对象

 

 

注意事项：jmap -dump:live 以及 jmap -histo:live都会触发Full GC
https://www.iteye.com/blog/langzi-xl-798905
 

 

4、clstats打印类加载器信息
命令：jmap -clstats pid
描述：打印类加载器信息。-clstats是-permstat的替代方案，在JDK8之前，-permstat用来打印类加载器的数据
打印Java堆内存的永久保存区域的类加载器的智能统计信息。对于每个类加载器而言，它的名称、活跃度、地址、父类加载器、它所加载的类的数量和大小都会被打印。此外，包含的字符串数量和大小也会被打印。

 



 

也可以使用jmap -permstat pid，如果运行在64位JVM上，需要指定-J-d64命令选项参数

打印进程的类加载器和类加载器加载的持久代对象信息，输出：类加载器名称、对象是否存活（不可靠）、对象地址、父类加载器、已加载的类大小等信息，如下图：



 

5、finalizerinfo打印等待终结的对象信息
命令：jmap -finalizerinfo pid
描述：打印等待终结的对象信息。Number of objects pending for finalization: 0 说明当前F-QUEUE队列中并没有等待Fializer线程执行final

 



 

 

6、将内存使用情况dump到文件中
命令：#用法： jmap -dump:format=b,file=dumpFileName <pid>
描述：生成堆转储快照dump文件。可以用 memory analyse 查看

以hprof二进制格式转储Java堆到指定filename的文件中。live子选项是可选的。如果指定了live子选项，堆中只有活动的对象会被转储。想要浏览heap dump，你可以使用jhat(Java堆分析工具)读取生成的文件。

这个命令执行，JVM会将整个heap的信息dump写入到一个文件，heap如果比较大的话，就会导致这个过程比较耗时，并且执行的过程中为了保证dump的信息是可靠的，所以会暂停应用， 线上系统慎用。

 

jmap -dump:format=b,file=../tmp/dump.dat 29720

　　

 　　

 

 

7、通过jhat对dump文件进行分析
我们将jvm的内存dump到文件中，这个文件是一个二进制的文件，不方便查看，这时我们可以借助于jhat工具进行查看。

#用法： jhat -port <port> <file>
jhat -port 29729 ../tmp/dump.dat
　　打开浏览器进行访问：http://localhost:29729/

　　



　　在最后面有OQL查询功能，查询链接  http://xxx:29729/oql/：

　　 

　　点击下面选项：

　　

 　　进入页面，输入下面语句查询字符串大于10000，点击Execute按钮，查询结果：

select s from java.lang.String s where s.value.length >= 10000
　　

OQL查询语句示例（可以通过OQL Help来查看一些语句示例）：



 

 

5、通过MAT工具对dump文件进行分析（idea使用JProfiler）
5.1  MAT工具介绍
　　MAT(Memory Analyzer Tool)，一个基于Eclipse的内存分析工具，是一个快速、功能丰富的JAVA heap分析工具，它可以帮助我们查找内存泄漏和减少内存消耗。使用内存分析工具从众多的对象中进行分析，快速的计算出在内存中对象的占用大小，看看是谁阻止了垃圾收集器的回收工作，并可以通过报表直观的查看到可能造成这种结果的对象。

5.2  下载安装　　
　　下载地址：https://www.eclipse.org/mat/downloads.php

 

　　

　　解压后得到的文件列表：

 　　

5.3  使用
　　①双击启动 MemoryAnalyzer.exe应用程序

　　　　

　　②打开一个dump文件

　　　　 

　　③操作如图两步

　　　　

　　④查看Overview

 　　　　

　　⑤查看Histogram

　　　　

　　⑥查看对象以及它的依赖  dominator_tree

 　　　　

　　⑦查看可能存在内存泄露的分析

 　　　　 

 

参考
Linux CPU占用率监控工具小结

Linux下查看某一进程所占用内存的方法jvm查看full gc频率jmap命令

Linux 下 CPU 监控工具：https://mp.weixin.qq.com/s/97rp9QLt54X2LQinn2aXeA

JVM性能调优监控工具jps、jstack、jmap、jhat、jstat、hprof 使用详解：https://mp.weixin.qq.com/s/J54XrpTo04N4oaVpFl2raQ

jvm 性能调优工具之 jmap：https://www.jianshu.com/p/a4ad53179df3

jmap的使用以及内存溢出分析：https://www.cnblogs.com/Zzzzn/p/12403764.html、https://blog.csdn.net/a772304419/article/details/103992788

jmap :live为啥会触发Full GC：https://www.iteye.com/blog/langzi-xl-798905
