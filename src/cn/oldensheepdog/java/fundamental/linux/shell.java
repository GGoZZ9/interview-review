package cn.oldensheepdog.java.fundamental.linux;

public class shell {
    /**
     * 找哪个线程cpu利用率最高
     * 找出cpu耗用厉害的进程pid， 终端执行top命令，然后按下shift+p 查找出cpu利用最厉害的pid号
     * pid号，top -H -p pid 。然后按下shift+p，查找出cpu利用率最厉害的线程号，比如top -H -p 1328
     * 将获取到的线程号转换成16进制
     * 使用jstack工具将进程信息打印输出，jstack pid号 > /tmp/t.dat，比如jstack 31365 > /tmp/t.dat
     * 编辑/tmp/t.dat文件，查找线程号对应的信息
     *
     * 什么是线程死锁
     * 死锁是指两个或两个以上的进程（线程）在执行过程中，由于竞争资源或者由于彼此通信而造成的一种阻塞的现象
     * 线程 A 持有资源 2，线程 B 持有资源 1，他们同时都想申请对方的资源，所以这两个线程就会互相等待而进入死锁状态
     *
     * */
}
