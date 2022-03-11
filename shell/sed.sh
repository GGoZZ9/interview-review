# 找到某个时间段的log并输出到新文件
sed -n '/2022-01-01 10:10:10.688/,/2022-03-03 18:18:18.999/p' test.log > 1.txt
sed -n  '/2018-08-22 14:45:/,/2018-08-22 14:46:/p' catalina.log >/acs/48708/log/2.txt



#https://www.linuxidc.com/Linux/2019-08/160121.htm
# sed是一个强大而简单的文本解析转换工具，可以读取文本，并根据指定的条件对文本内容进行编辑，最后输出所有行或仅输出处理的某些行
#sed的工作流程主要包括：
#1. 读取：sed从输入流中读取一行内容不能够存储到临时的缓冲区中；
#2. 执行：默认情况下所有的sed命令都在模式空间中按顺序地执行，除非指定了行的地址，否则sed命令将会再所有行上依次执行；
#3. 显示：发送修改后的内容到输出流，再发送数据后，模式空间将会被清空。
#注意：在所有的文件内容都被处理完成之前，上述过程将重复执行，直至所有内容都被处理完。

# 1.输出符合条件的文本
# 输出所有内容，等同于“cat test.txt”
sed -n 'p' test.txt
#输出第三行内容
sed -n '3p' test.txt
#输出3~5行
sed -n '3,5p' test.txt
#输出所有奇数行，n表示读入下一行数据
sed -n 'p;n' test.txt
#输出所有偶数行，n表示读入下一行数据
sed -n 'n;p' test.txt
# 输出第1行~第5行之间的奇数行（第1、3、5行）
sed -n '1,5{p;n}' test.txt
#输出第10行至文件尾部之间的偶数行（包括空行）
sed -n '10,${n;p}' test.txt
# 输出包含“the”的行
sed -n '/the/p' test.txt
# 输出从第4行到第一个包含“the”的行
sed -n '4,/the/p' test.txt
# 输出包含“the”的行所在的行号（等号（=）用来输出行号）
sed -n '/the/=' test.txt
# 输出以“PI”开头的行
sed -n '/^PI/p' test.txt
# 输出包含单词wood的行，\&lt;、\&gt;代表单词边界

# 2.删除符合条件的文本
# nl命令用于计算文件的行数
# 删除第3行
nl test.txt | sed '3d'
# 删除第3~5行
nl test.txt | sed '3,5d'
# 删除包含cross的行，原本的第8行被删除
 nl test.txt | sed '/cross/d'
# 删除不包含cross的行
nl test.txt | sed '/cross/! d'
# 删除以“.”结束的行
sed '/\.$/d' test.txt
# 删除所有空行
sed '/^$/d' test.txt
#删除空行，连续的空行留一个
sed -e '/^$/{n;/^$/d}' test.txt

# 3.替换符合条件的文本
# s（字符串替换）、c（整行/整块替换）、y（字符转换）
# 将每行中的第一个the替换为THE
sed 's/the/THE/' test.txt
# 将每行中的第三个“l”替换为“L”
sed 's/l/L/2' test.txt
#将文件中所有的“the”替换为“THE”
sed 's/the/THE/g' test.txt
# 将文件中所有的“o”删除
sed 's/o//g' test.txt
# 在每行的行首插入“#”号
sed 's/^/#/' test.txt
# 在包含“the”的每行行首插入“#”号
sed '/the/s/^/#/' test.txt
# 在每行行尾插入字符串“EOF”
sed 's/$/EOF/' test.txt
# 将第3~5行中的所有“the”替换为“THE”
sed '3,5s/the/THE/g' test.txt
# 将包含“the”的所有行中的o替换为“O”
sed '/the/s/o/O/g' test.txt

# 以上“sed -i”的命令则是立即生效的！
# 替换文中第一行的内容为“1111”
sed -i '1c 1111' a.txt
# 在第一行后面插入一行内容，内容为“1111”
sed -i '1a 1111' a.txt
# 在第一行前面插入一行内容，内容为“2222”
sed -i '1i 2222' a.txt
# 删除第一行内容
sed -i '1d' a.txt
# 打印出第一行的内容
sed -n '1p' a.txt
# 将文本第一行内容“2222”替换为“3333”
sed -i '1s/2222/3333/g' a.txt

# 4.迁移符合条件的文本
# g、G将剪贴板中的数据覆盖/追加到指定行；w保存为文件；r读取指定文件；a追加指定内容。
#将包含“the”的行迁移到文件末尾，“；”用于多个操作
sed '/the/{H;d};$G' test.txt
# 将第1~5行的内容转移到第17行后
sed '1,5{H;d};17G' test.txt
# 将包含“the”的行另存为文件out.file
sed '/the/w out.file' test.txt
#将文件/etc/hostname的内容添加到包含“the”的每行以后
sed '/the/r /etc/hostname' test.txt
# 在第3行后面插入一个新行，内容为“NEW”
sed '3aNEW' test.txt
# 在包含“the”的每行后插入一个新行，内容为“NEW”
sed '/the/aNEW' test.txt
# 在第3行后面多行内容，中间的“\n”表示换行
sed '3aNEW1\nNEW2' test.txt

# 5.使用脚本编辑文件
# 将第1~5行内容转移至第17行后
sed '1,5{H;d};17G' test.txt
# 以上操作转换为脚本文件方式：
vim 1.list
1,5H
1,5d
17G

sed -f 1.list test.txt

# 6.sed直接操作文件示例
# 编写一个脚本，用来调整vsftpd服务配置：禁止匿名用户，但允许本地用户（也允许写入）登录。
vim local_only_ftp.sh
#!/bin/bash
S="/usr/share/doc/vsftpd-3.0.2/EXAMPLE/INSERNET_SITE/vsftpd.conf"
C="/etc/vsftpd/vsftpd.conf"
#指定样本文件路径、配置文件路径
[ ! -e "$C.bak" ] && cp $C $C.bak
#备份原来的配置文件，检测(配置文件.bak)是否存在，如果不存在则使用cp命令复制
sed -e '/^anonymous_enable/s/YES/NO/g' $S &gt; $C
sed -i -e '/^local_enable/s/NO/YES/g' -e '/^write_enable/s/NO/YES/g' $C
grep "listen" $C || sed -i '$alisten=YES' $A
#基于样本配置进行调整，覆盖现有文件
systemctl restart vsftpd
systemctl enable vsftpd
#重启ftp服务，并设置为开机自启动








