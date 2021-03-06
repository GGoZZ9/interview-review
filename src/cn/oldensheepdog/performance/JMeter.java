package cn.oldensheepdog.performance;

/**
 * ref: https://www.redline13.com/blog/2018/05/guide-jmeter-thread-groups/#:~:text=A%20Thread%20Group%20is%20a%20set%20of%20threads,is%20maintained%20and%20over%20what%20period%20of%20time.
 * https://cloud.tencent.com/developer/article/1702352
 * https://zhuanlan.zhihu.com/p/114452719
 * https://blog.csdn.net/laofashi2015/article/details/78552663 添加变量，按比例分配vu
 *
 * 1. Thread Group
 * Thread Properties
 * Number of Threads: the total number of vu vu数就是线程数
 * Ramp-Up Period: how long to take to reach the full number of threads 到达全部线程数需要多少时间
 * Loop Count: It is the number of executions for the script. How many times to run of a script 测试脚本迭代次数
 * Delay Thread Creation Until Needed: If this option is checked, the ramp-up delay and startup delay are performed before
 * the thread data is created. If not checked, all the data required for the threads is created before starting the execution of a test.
 * Scheduler: This schedules the tests. You can set custom duration and startup delay to create the threads in this section.
 *
 * 2. Arrivals Thread Group: Arrival is the start of thread iteration.
 *
 * Target Rate: the number of new arrivals per minute 每分钟新到达数
 * Ramp-up Time: how long to take to reach target arrival rate   到达目标到达率需要多少时间
 * Ramp-up Steps:  It refers to the granularity 粒度间隔 of the arrivals increased rate. More steps results in a smoother pattern. 到达率增加的间隔
 * Hold Target Rate Time: The duration which you want to run the tests for. 测试执行的持续时间，达到到达数之后的时间 （比如这是3分钟，Ramp-up Time 是2分钟，那么test一共跑5分钟）
 *
 * Thread Iteration Limit: This limits the number of iterations.
 * Concurrency Limit: This limits the number of threads.
 *
 * This thread group is suitable for goal oriented scenarios. For example, if you want to see how your e-commerce application behaves when 50 orders are placed every second.
 * 此线程组适用于面向目标的方案。例如，如果您想查看电子商务应用程序在每秒下达 50 个订单时的行为。
 *
 * 我们的测试分3部分：
 * 0-30 seconds
 * 30-60 seconds
 * 60-180 seconds
 *
 * Target Rate=120/min，Ramp-up Time=1min，Ramp-up Steps=2，Hold Target Rate Time=2min
 * 用两个阶梯，1分钟，达到每分钟到达数120，每个阶梯30s，60s后达到每分钟120，前30秒达到每分钟60，前30秒的半分钟就是30
 * 后30秒达到每分钟120，每半分钟60，30-60秒就是60
 * 到1分钟时达到每分钟120，持续2分钟，就是240
 *
 * 总到达数=(0-30s的到达数)+(30-60s的到达数)+(60-180s的到达数)
 * 在测试计划中,爬坡阶梯是2，爬坡率是1分钟，意味着1分钟里用2个阶梯达到120个到达数，所以前30秒到达率是每分钟60个，30秒就是30个，
 * 在30-60秒，到达率是120，到达数是(120*30/60=60)
 * 在60-180秒，每分钟到达120，2分钟到达240
 * 所以，arrivals的总数=30+60+240=330
 *
 * 3. Concurrency Thread Group 可用于阶梯式加压测试
 * This Thread group is also suitable for goal oriented scenarios, but the goal here is to have control over the number of concurrent users over a period of time.
 * 此线程组也适用于面向目标的方案，但此处的目标是控制一段时间内的并发用户数。
 *
 * Target Concurrency: 爬坡后需要维持的并发用户数
 * Ramp Up Time: 爬坡时间
 * Ramp Up Steps: 爬坡阶梯，并发用户数增加率的时间间隔, 0意味着均匀增加，线程间delay时间一致
 * Hold Target Rate Time: 并发用户维持时间
 * Thread Iterations Limit: 迭代数
 *
 * Target Concurrency=100， Ramp Up Time=5，Ramp Up Steps=5， Hold Target Rate Time=5
 * 总数100vu，每分钟20vu，爬坡阶梯5个，一分钟一个爬坡，到100个vu之后所有并发用户run 5分钟
 *
 * 4. Freeform Arrivals Thread Group
 * It is similar to arrivals thread group, the difference is that this thread group does not have ramp up time and steps options.
 *
 *
 *
 * 面试题：多个场景，登录 10%，付款 20%，购物 30% 等，添加3个Thread Group, 三个场景总用户数100，定义user defined variables: number 100, 在线程组的Number of Threads 里调用定义的变量乘百分比
 *
 * */
public class JMeter {
}
