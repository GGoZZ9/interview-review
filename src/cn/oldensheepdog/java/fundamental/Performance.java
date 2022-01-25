package cn.oldensheepdog.java.fundamental;

public class Performance {
    /**
     * 性能测试是要测试系统或服务是否满足既定目标，不是为了把非要压出问题，按照业务要求和流量要求设计场景
     * 比如几个脚本的混合场景，满足业务要求的最大流量，发压，看系统的各项指标，QPS，内存，CPU，IO等，是否在期待
     * 的范围内。数据库是否有连接数设置不够的问题。
     * 如果是压数据库，可以用服务，设置数据库的连接数到比较大的值，用服务场景去发压，或者用LoadRunner直接连数据库
     * 不建议用LR，因为不能模拟用户场景
     * */

    /**
     * Thread Group
     * Number of threads 待启动线程数
     * Ramp-Up Period 所有线程启动完成时间
     * Loop Count 所有请求执行的整体执行时间，必须勾选Scheduler才能设置，必须勾选Forever才能起作用
     *
     * Concurrency Thread Group
     * Target Concurrency 目标并发线程数 100
     * Ramp Up Time 加速时间 3
     * Ramp-Up Steps Count 加速步骤计数 5
     * Hold Target Rate Time 保持目标速率时间 6
     * 3分钟内分5步加速，每步20个用户，直到达到100个用户，达到100个线程后所有线程继续运行并一起打到服务器6分钟
     * */
}
