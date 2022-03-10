# 1）查找包含“the”的行
grep -n 'the' test.txt
# 2）查找不包含“the”的行
grep -vn 'the' test.txt
# 3）查找以sh开头，以rt结尾，中间是i或o的字符
grep -n 'sh[io]rt' test.txt
# 4）查询oo前面不是w的字符串
grep -n '[^w]oo' test.txt
# 5）查询oo前面不是小写字母的字符串
grep -n '[^a-z]oo' test.txt
# 6）^匹配以某个字符开头的行。查询以the开头的字符串
grep -n '^the' test.txt
# 7）[^]匹配未包含的一个任意字符。查询不以字母开头的字符串
grep -n '^[^a-zA-Z]' test.txt
# 8）$匹配以某个字符结尾的行。查询以.结尾的字符串
grep -n '\.$' a.txt
# 9）“.”匹配除\r\n外的任意一个字符。查询w与d之间包含两个字符的行
grep -n 'w..d' test.txt
# 10）查询包含连续o字母的行
# “*”表示的是重复零个或多个前面的单字符
grep -n 'ooo*' test.txt
# 11）查询以w开头以d结尾中间至少包含一个o的行
grep -n 'woo*d' test.txt
# 12）查询以w开头d结尾，中间的字符可有可无的行
grep -n 'w.*d' test.txt
# 13）{n}匹配确定的n次。查询包含两个o的行 “{}”是特殊字符需要用“\”转义
grep -n 'o\{2\}' test.txt
#

