/**
 * 删除/var/log/下.log结尾的30天前的日志文件？
 * find /var/log/ -mtime +30 -name "*.log" -exec rm -rf {} \;  (斜杠是转义分号，{}是占位符)
 *
 * 磁盘100%，服务器上找不到对应的文件，排查思路？
 * df -h， du -sh * 等指令配合使用，发现当前系统任然存在大量可以使用的空间
 * df（英文全拼：disk free） 命令用于显示目前在 Linux 系统上的文件系统磁盘使用情况统计。
 * du （英文全拼：disk usage）命令用于显示目录或文件的大小。
 * 在linux中，当我们使用rm在linux上删除了大文件，但是，如果有进程打开了这个大文件，却没有关闭这个文件的句柄，那么：linux内核还是不会释放这个文件的磁盘空间，最后造成磁盘空间占用100%，整个系统无法正常运行。
 * 这种情况下，通过df和du命令查找的磁盘空间，两者是无法匹配的，可能df显示磁盘100%，而du查找目录的磁盘容量占用却很小。
 * 基本可以断定是某些大文件被某些程序占用了，并且这些大文件已经被删除了，但是对应的文件句柄没有被某些程序关闭，造成内核无法回收这些文件占用的空间。
 * lsof | grep deleted 指令，查看当前系统句柄未释放情况
 * list open files
 * 解决方法一 将当前线程进行重启，关闭线程，从而让句柄释放，释放空间。
 * 方法二 找到指定的文件句柄，将当前文件句柄的大小设置为空。
 * */

/**
 * 新部署的接口时好时坏
 * 初步判断原因：机器中部署的代码不一致
 * 检查 dubbo 服务注册中心，当前服务注册数量及每台机器IP地址
 * 检查 nginx 配置，确认是否有机器是不需要的，是否是临时部署的
 * 如果发现时其他备机的，ssh -p ip 免密登录，kill 调用 java 进程或 cd tomcat/bin ，执行 shutdown.sh ，jps 检查执行结果
 * 如果不是上述问题，检查tomcat 中部署的war包是否有最新代码
 * 是否是war包没有删除掉，手动执行war包替换
 * 是否发版过程中进程kill失败，手动kill进程，重启服务
 *
 *
 * */

/**
 * Eureka采用了cs的设计架构，Eureka Server作为服务注册功能的服务器，他是服务注册中心。而系统中的其他微服务，使用Eureka的客户端连接到Eureka Server并维持心跳连接。这样系统的维护人员就可以通过Eureka Server来监控系统的各个微服务是否正常运行。
 * dubbo和spring cloud都是微服务框架。
 * dubbo一般使用zookeeper作为服务发现，spring cloud一般用eureka作为服务发现。
 * 服务发现：就是不用知道服务的ip端口，通过服务名就能使用服务。
 * dubbo是RPC框架下的通信
 * springcloud 是HTTP协议的Rest Api
 * https://blog.csdn.net/xueguchen/article/details/107763892?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1.fixedcolumn&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1.fixedcolumn
 * */

/**
 * 收到用户反馈APP或网站无法访问，你会怎么处理？
 * 先到部署服务的服务器上查看服务的log，如果服务正常，查看nginx服务是否正常，服务器能否ping通
 *
 * 用户反映你开发的网站访问很慢可能会是什么原因
 * 服务器出口带宽不够用
 * 服务器负载过大忙不过来，比如说CPU和内存消耗完
 * 网站的开发代码没写好，例如mysql语句没有进行优化，导致数据库的读写相当耗费时间。
 * 数据库的瓶颈，也是很常见的一个瓶颈，这点跟上面第三个原因可以一起来说。当我们的数据库变得愈发庞大，比如好多G好多T这么大，那对于数据库的读写就会变得相当缓慢了，索引优化固然能提升一些效率，但数据库已经如此庞大的话，如果每次查询都对这么大的数据库进行全局查询
 *
 * 某个进程偶现CPU高，如何排查是哪里出现问题了？
 * 先用top命令,找到cpu占用最高的进程 PID
 * 再用ps -mp pid -o THREAD,tid,time   查询进程中,那个线程的cpu占用率高 记住TID
 * jstack 29099 >> xxx.log   打印出该进程下线程日志
 * sz xxx.log 将日志文件下载到本地
 * TID转成16进制
 * 打开下载好的 xxx.log  通过 查找方式 找到 对应线程 进行排查
 *
 * 监控工具 Grafana 可以通过influxdb监控，Prometheus采集的主机信息
 * */

/**
 * / 是根目录，.是当前目录，..是上级目录
 * shell 脚本里 for; do done 循环
 * 获取字符串长度
 * string="abcd"
 * echo ${#string} #输出 4
 * 参数传递
 * $n。n 代表一个数字，1 为执行脚本的第一个参数，2 为执行脚本的第二个参数，以此类推……
 *
 * 原生bash不支持简单的数学运算，但是可以通过其他命令来实现，例如 awk 和 expr，expr 最常用。
 * expr 是一款表达式计算工具，使用它能完成表达式的求值操作。
 * 关系运算符只支持数字，不支持字符串，除非字符串的值是数字。
 * -eq	检测两个数是否相等，相等返回 true。
 * -gt	检测左边的数是否大于右边的，如果是，则返回 true。
 * -lt	检测左边的数是否小于右边的，如果是，则返回 true。
 * 布尔运算符
 * -o	或运算，有一个表达式为 true 则返回 true
 * -a	与运算，两个表达式都为 true 才返回 true。
 *
 *  test 命令用于检查某个条件是否成立，它可以进行数值、字符和文件三个方面的测试。
 *  if test $[num1] -eq $[num2]
 * then
 *     echo '两个数相等！'
 * else
 *     echo '两个数不相等！'
 * fi
 *
 * 流程控制
 * if [ $(ps -ef | grep -c "ssh") -gt 1 ]; then echo "true"; fi
 * if condition1
 * then
 *     command1
 * elif condition2
 * then
 *     command2
 * else
 *     commandN
 * fi
 *
 * while condition
 * do
 *     command
 * done
 *
 *
 * until condition
 * do
 *     command
 * done
 *
 * case ... esac 为多选择语句，与其他语言中的 switch ... case 语句类似
 *
 * break命令允许跳出所有循环（终止执行后面的所有循环）。
 * continue命令与break命令类似，只有一点差别，它不会跳出所有循环，仅仅跳出当前循环。
 *
 * 函数
 * 1、可以带function fun() 定义，也可以直接fun() 定义,不带任何参数。
 * 2、参数返回，可以显示加：return 返回，如果不加，将以最后一条命令运行结果，作为返回值
 * demoFun(){
 *     echo "这是我的第一个 shell 函数!"
 * }
 * echo "-----函数开始执行-----"
 * demoFun
 *
 * /dev/null 是一个特殊的文件，写入到它的内容都会被丢弃；如果尝试从该文件读取内容，那么什么也读不到。但是 /dev/null 文件非常有用，将命令的输出重定向到它，会起到"禁止输出"的效果。
 * 如果希望对 stdin 和 stdout 都重定向，可以这样写：
 * command < file1 >file2
 * 如果希望将 stdout 和 stderr 合并后重定向到 file  $ command > file 2>&1
 * Shell 也可以包含外部脚本。这样可以很方便的封装一些公用的代码作为一个独立的文件。
 * . filename   # 注意点号(.)和文件名中间有一空格 或 source filename
 *
 * grep 指令用于查找内容包含指定的范本样式的文件
 * */

public class Linux {
}
