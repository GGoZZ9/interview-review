#find . -mmin - 60 -type f 表示找到当前文件夹下60分钟内修改过的普通文件
#-type f 指定了文件类型为普通文件，否则会将当前文件夹也列入结果
#通过管道将find的结果输出给后续命令，并通过xargs -i 将该结果 放至 { } 中

# 将当前文件夹下60分钟内修改过的文件复制到 /home/usr/test
find . -mmin -60 -type f | xargs -i cp {} /home/usr/test

# 以上为1小时以内的当前目录内修改的所有为txt格式的文件. 其中-1为1小时以内, +1为1小时之前
find . -name "*.txt" -mtime -1
find . -mmin -10 //查找10分钟内当前目录内修改的所有文件
#2) 按类型查找
find . -type d

find . -iname \*.txt
#默认find是区分大小写的，如果不想区分大小写，请使用-iname替代-name，如上则”abc.TXT”将被查找到