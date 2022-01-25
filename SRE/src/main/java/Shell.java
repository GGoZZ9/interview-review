/**
* 命令中含有echo 和>>两条bash命令，而sudo只会给后面的第一个命令赋予root权限，而">>"没有权限
 * 解决：
 * 使用/bin/bash -c指定将命令转为一个完整命令执行
 * $ sudo /bin/bash -c ‘echo “kettle” >> nohup.log’
 * 扩展：
 * #!/bin/sh是#!/bin/bash的缩减版
* */

/**
 * command 1 | command 2 他的功能是把第一个命令command 1执行的结果作为command 2的输入传给command 2
 * $ls -s|sort -n
 * 按从小到大的顺序输出。
 * */

public class Shell {
}
