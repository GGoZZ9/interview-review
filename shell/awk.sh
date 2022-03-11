# 截取某个时间段内的日志内容  从nginx日志中获取2014:04:01日 21:30至21:50的日志内容
cat web.log | grep "01/Apr/2014" | awk -F':' '$2 = 21 && $3 >= 30 && $3 <= 50' > log.txt

>> 可以在文件尾添加文本

#1.awk命令的语法及概述
#awk 选项  '模式或条件 { 编辑指令 }' 文件1 文件2 …
#//过滤并输出文件符合条件的内容
#awk  -f  脚本文件 文件1 文件2 …
#//从脚本中调用编辑指令，过滤并输出内容

#awk从输入文件或者标准输入中读入信息，与sed一样，信息的读入也是逐行读取的。不同的是，awk命令将文本文件中的一行视为一个记录，而将一行中的某一部分（
# 列）作为记录的一个字段。为了操作这些不同的字段（列），awk借用shell中类似于位置变量的方法，用$1、$2…$9顺序的表示不同列，$0表示整行。
# 不同字段与不同字段可以通过指定的方式进行分隔，awk默认的分隔符是空格。awk命令允许使用“-F分隔符”的形式来指定分隔符。

# awk包含几个特殊的内建变量
# FS: 指定每行文件的字段分隔符，默认为空格或制表符
# NF: 当前处理的行的字段个数
# NR: 当前处理的行的行号 （序数）
# $0: 当前处理的行的整行内容
# $n: 当前处理的行的第n个字段（第n列）
# FILENAME: 被处理的文件名
# RS: 数据记录分隔，默认为\n , 即每行为一条记录

# 1）按行输出文本
# 输出所有内容，等同于“cat test.txt”
awk '{print}' test.txt
awk '{print $0}' test.txt
# 输出第1~3行的内容
awk 'NR==1,NR==3{print}' test.txt
awk '(NR&gt;=1) && (NR&lt;=3) {print}' test.txt
# 输出第1行、第3行的内容
awk 'NR==1 || NR==3{print}' test.txt
# 输出所有奇数行的内容
awk '(NR%2)==1 {print}' test.txt
# 输出所有偶数行的内容
awk '(NR%2)==0 {print}' test.txt
# 输出以“root”开头的行
awk '/^root/{print}' /etc/passwd
# 输出以“nologin”结尾的行
awk '/nologin$/{print}' /etc/passwd
# 统计以/bin/bash结尾的行数
awk 'BEGIN {x=0} ;/\/bin\/bash$/{x++};END {print x}' /etc/passwd
grep -c "/bin/bash$" /etc/passwd
# 统计以空格分隔的文件段落数 命令较多时，使用“BEGIN……END”
awk 'BEGIN{RS=""}; END{print NR}' /etc/squid/squid.conf

# 2）按字段输出文本
#输出每行中（以空格分隔）的第3个字段
awk '{print $3}' test.txt
# 输出每行中（以空格分隔）的第1个和第3个字段
awk '{print $1,$3}' test.txt
# 输出/etc/shadow文件中（以“：”分隔）的第二个字段（密码为空的用户
awk -F ":" '$2==""{print}' /etc/shadow
awk 'BEGIN {FS=":"}; $2=""{print}' /etc/shadow
# 输出以“：”分隔且第7个字段中包含“/bash”的行的第1个字段
awk -F ":" '$7~"/bash"{print $1}' /etc/passwd
# 输出包含8个字段且第1个字段中包含“nfs”的行的第1、2个字段
awk '($1~"nfs") && (NF==8) {print $1,$2}' /etc/services
# 输出第7个字段既不为“/bin/bash”也不为“/bin/nologin”的所有行
awk -F ":" '($7!="/bin/bash") && ($7!="/sbin/nologin") {print}' /etc/passwd

# 3）通过管道，双引号调用Shell命令
# 调用“wc -l”命令统计使用“bash”的用户个数
awk -F: '/bash$/{print | "wc -l"}' /etc/passwd
grep -c "bash$" /etc/passwd
# 调用“w”命令，并统计在线用户数
awk 'BEGIN {while ("w" | getline) n++ ; {print n-2}}'
# 调用“hostname”命令，并输出当前用户名
awk 'BEGIN { "hostname" | getline ; print $0}'

# 4）使用awk命令进行简单的数学运算
awk 'BEGIN{ a=6;b=3;print"(a + b)=",(a + b)}'
awk 'BEGIN{ a=6;b=3;print"(a - b)=",(a - b)}'
awk 'BEGIN{ a=6;b=3;print"(a / b)=",(a / b)}'
awk 'BEGIN{ a=6;b=3;print"(a % b)=",(a % b)}'
