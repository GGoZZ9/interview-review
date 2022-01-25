import copy
import os
import time
import calendar

'''
/**
* Python主要有以下特点和优点：
* 可解释
* 具有动态特性
* 面向对象
* 简明简单
* 开源
* 具有强大的社区支持
* */
/**
* 深拷贝和浅拷贝之间的区别是什么？
* 深拷贝就是将一个对象拷贝到另一个对象中，这意味着如果你对一个对象的拷贝做出改变时，不会影响原对象。在Python中，我们使用函数deepcopy()执行深拷贝，导入模块copy
* copy.deepcopy(a)
* 浅拷贝则是将一个对象的引用拷贝到另一个对象上，所以如果我们在拷贝中改动，会影响到原对象
* */
'''
'''
__开始的是私有变量或私有函数

列表和元组之间的区别是？
列表是可变的，而元组是不可变的
'''
'''
解释一下Python中的三元运算子
[on true] if [expression] else [on false]
'''
'''
在Python中如何实现多线程？
GIL（全局解释器锁）确保一次执行单个线程。一个线程保存GIL并在将其传递给下个线程之前执行一些操作

解释一下Python中的继承
单继承：一个类继承自单个基类
多继承：一个类继承自多个基类
多级继承：一个类继承自单个基类，后者则继承自另一个基类
分层继承：多个类继承自单个基类

Flask是Python编写的一款轻量级Web应用框架
Flask会话使用签名cookie让用户查看和修改会话内容。它会记录从一个请求到另一个请求的信息。不过，要想修改会话，用户必须有密钥Flask.secret_key。

Python有一个私有堆空间来保存所有的对象和数据结构。作为开发者，我们无法访问它，是解释器在管理它。但是有了核心API后，我们可以访问一些工具。Python内存管理器控制内存分配。
另外，内置垃圾回收器会回收使用所有的未使用内存，所以使其适用于堆空间。

解释Python中的help()和dir()函数
Help()函数是一个内置函数，用于查看函数或模块用途的详细说明：
Dir()函数也是Python内置函数，dir() 函数不带参数时，返回当前范围内的变量、方法和定义的类型列表；带参数时，返回参数的属性、方法列表。

当退出Python时，是否释放全部内存？
答案是No。循环引用其它对象或引用自全局命名空间的对象的模块，在Python退出时并非完全释放。
另外，也不会释放C库保留的内存部分。

什么是猴子补丁
在运行期间动态修改一个类或模块

Python中的字典是什么？有键值对，roots={25:5,16:4,9:3,4:2,1:1} roots[9] 结果为3 字典是不可变的
请解释使用args和*kwargs的含义
当我们不知道向函数传递多少参数时，比如我们向传递一个列表或元组，我们就使用*args。
在我们不知道该传递多少关键字参数时，使用**kwargs来收集关键字参数。
可变参数允许你传入0个或任意个参数，这些可变参数在函数调用时自动组装为一个tuple,而关键字参数允许你传入0个或任意个含参数名的参数，这些关键字参数在函数内部自动组装为一个dict。

什么是负索引？从列表右边开始检索
列表切片 list[-6:-1]
如何以就地操作方式打乱一个列表的元素？从random模块中导入shuffle()函数。
join()和split()函数
join()能让我们将指定字符添加至字符串中。
split()能让我们用指定字符分割字符串。

Python是区分大小写的

怎么移除一个字符串中的前导空格？ '  Ayushi '.lstrip(), 后导空格 '  Ayushi '.rstrip()
怎样将字符串转换为小写？ 'AyuShi'.lower()  upper()方法可以将其转换为大写
使用isupper()和islower()方法检查字符春是否全为大写或小写。@和$这样的字符既满足大写也满足小写。
Istitle()能告诉我们一个字符串是否为标题格式。

list 包含的函数 cmp 比较两个列表的元素, len 列表元素个数, max(list)返回列表元素最大值，min(list)最小值，list(seq)将元组转化为列表
list 包含的方法 append, count , extend, index, insert, pop, remove, reverse, sort

元组 中的元素不能修改，但可以对元组进行连接组合 , 运算符 len() 元素个数，+ 连接， * 复制，in 是否存在，for x in tup: print x 迭代
元组也是一个序列 ， 无关闭分隔符，  任意无符号对象以逗号隔开， 默认为元组
元组内置函数 cmp(tuple1, tuple2), len(tuple), max(tuple), min(tuple), tuple(seq)列表转换为元组

字典 键必须唯一，重复键后面的覆盖前面的，值可以是任意数据类型，键必须是不可变的，如字符串，数字，元组
内置函数 cmp, len, str(dict)输出字典可打印的字符串形式, type(variable)返回输入的变量类型，
内置方法 dict.clear(), dict.copy(), dict.fromkeys(seq[,val]), dict.get(key, default=None), dict.items()以列表返回可遍历的元组数组
dict.keys() 返回字典所有键，dict.setdefault(key, default=None)和get类似，但如果键不存在与字典中，将会天津键并将值设为default, dict.values()返回所有值
dict.pop(key), dict.popitem()删除字典中的最后一堆键和值

字符串 + 连接字符串， * 重复字符串， []通过索引获取字符串, [:]截取字符串的一部分，in , not in , r/R 原始字符串。\ 转义， 
字符串格式化  %s, % d %u %f 
内建函数 string.capitalize() 第一个字符大写，string.count()字符在字符串里面出现的次数, 
string.format()格式化字符串
string.find() 检测 str 是否包含在 string 中，如果 beg 和 end 指定范围，则检查是否包含在指定范围内，如果是返回开始的索引值，否则返回-1
string.index() 
string.isalnum() 所有字符都是字母或数字则返回 True,否则返回 False 字符中没有空格
string.isalpha() 所有字符都是字母则返回 True,
string.isdecimal()  string 只包含十进制数字则返回 True 否则返回 False.
string.isdigit() 只包含数字则返回 True 否则返回 False.
string.islower() 
string.join(seq)
string.lower()  转换 string 中所有大写字符为小写.
string.lstrip() 截掉 string 左边的空格
max(str) 
min(str)
string.rstrip() 删除 string 字符串末尾的空格.
string.title() 返回"标题化"的 string,就是说所有单词都是以大写开始，其余字母均为小写(见 istitle())
string.upper() 

Python有五个标准的数据类型：
Numbers（数字）
int（有符号整型）
long（长整型，也可以代表八进制和十六进制）
float（浮点型）
complex（复数）

String（字符串）
List（列表）
Tuple（元组）
Dictionary（字典）

==	等于 - 比较对象是否相等
成员运算符 in   not in
身份运算符 is  not is   id(x) == id(y) , 如果引用的是同一个对象则返回 True，否则返回 False

time.asctime([tupletime])
接受时间元组并返回一个可读的形式为"Tue Dec 11 18:07:14 2008"（2008年12月11日 周二18时07分14秒）的24个字符的字符串。
time.time( ) 返回当前时间的时间戳

strings, tuples, 和 numbers 是不可更改的对象，而 list,dict 等则是可以修改的对象。
不可变类型：变量赋值 a=5 后再赋值 a=10，这里实际是新生成一个 int 值对象 10，再让 a 指向它，而 5 被丢弃，不是改变a的值，相当于新生成了a。
可变类型：变量赋值 la=[1,2,3,4] 后再赋值 la[2]=5 则是将 list la 的第三个元素值更改，本身la没有动，只是其内部的一部分值被修改了。

函数的参数传递：
不可变类型：类似 c++ 的值传递，如 整数、字符串、元组。如fun（a），传递的只是a的值，没有影响a对象本身。比如在 fun（a）内部修改 a 的值，只是修改另一个复制的对象，不会影响 a 本身。
可变类型：类似 c++ 的引用传递，如 列表，字典。如 fun（la），则是将 la 真正的传过去，修改后fun外部的la也会受影响
python 中一切都是对象，严格意义我们不能说值传递还是引用传递，我们应该说传不可变对象和传可变对象。

使用 lambda 来创建匿名函数。

lambda只是一个表达式，函数体比def简单很多。
lambda的主体是一个表达式，而不是一个代码块。仅仅能在lambda表达式中封装有限的逻辑进去。
lambda函数拥有自己的命名空间，且不能访问自有参数列表之外或全局命名空间里的参数。
虽然lambda函数看起来只能写一行，却不等同于C或C++的内联函数，后者的目的是调用小函数时不占用栈内存从而增加运行效率。

参数 
必备参数
关键字参数
默认参数
不定长参数  参数前加 *

Python 模块(Module)，是一个 Python 文件，以 .py 结尾

dir() 函数一个排好序的字符串列表，内容是一个模块里定义过的名字。
返回的列表容纳了在一个模块里定义的所有模块，变量和函数

python2和python3的区别
print "",  print ()
Python3.x 源码文件默认使用 utf-8 编码 有了 Unicode (utf-8) 字符串，以及一个字节类：byte 和 bytearrays
/ 结果是一个整数，把小数部分完全忽略; 结果也会是浮点数
捕获异常的语法由 except exc, var 改为 except exc as var


'''

Money = 500000


def deepcopy():
    a = [1, 2, 3, 4, ['a', 'b']]  # 原始对象 a里每一个元素一个内存地址
    print(id(a))
    b = a  # 赋值，传对象的引用， 传a的引用，a变，跟着变,a 和b的内存地址一样
    c = copy.copy(a)  # 对象拷贝，浅拷贝，c和a内存地址不一样，c拷贝的是a里面每一个元素的内存地址
    d = copy.deepcopy(a)  # 对象拷贝，深拷贝，生成一个新对象与原对象无关，互不影响
    a.append(5)  # 修改对象a ， append追加的是该对象的引用
    a[4].append('c')  # 修改对象a中的['a', 'b']数组对象, c[4]和a[4]内存地址一样
    print(id(a[0]))
    print(id(a[4]))
    print('a = ', a)
    print('b = ', b)
    print('c = ', c)
    print('d = ', d)


def list_and_tuple():
    my_list = [1, 2, 3]
    my_list[1] = 'a'
    my_tuple = (6, 7, 8)
    print(my_list)
    print(my_tuple)


def ternary():
    a, b = 2, 3
    min_num = a if a < b else b
    print(min_num)


def count_supper_word():
    os.chdir('/Users/freda/Downloads')
    with open('mysql') as text:
        count = 0
        for i in text.read():
            if i.isupper():
                count += 1
        print(count)


def test_join():
    print(','.join('123456'))  # 1,2,3,4,5,6
    print('1,2,3,4,5'.split(','))  # ['1', '2', '3', '4', '5']


def test_list():
    my_list = [1, 2, 3, 4, 5, 7, 7, 8, 9]
    my_list_2 = [11, 23, 88]
    my_list.append(10)
    count = my_list.count(7)
    print(count)
    my_list.extend(my_list_2)
    print(my_list.index(8))
    my_list.insert(1, 888)
    print(my_list)
    my_list.pop(10)
    print(my_list)
    my_list.remove(4)
    print(my_list)
    my_list.reverse()
    my_list.sort()
    print(my_list)


def test_tuple():
    tup1 = ('physics', 'chemistry', 1997, 2000)
    tup2 = (1, 2, 3, 4, 4, 5, 6, 6, 7, 8, 8, 9)

    print('tup1[0]:', tup1[0])
    print('tup2[1:5]', tup2[1:5])

    print('tup3: ', tup1 + tup2)
    # del tup1
    print('delete tup: ', tup1)

    print('len ', len(tup2))
    print(tup2 * 2)
    print(3 in tup2)

    # for x in tup2: print(x)
    print(tup2[-1])
    print(tup2[1:])  # 截取元素
    print('abc', -3.15, 18 + 6.6j, 'xyz')
    x, y = 1, 2
    a = 1, 2
    print("value of a: ", a)
    print("value of x, y: ", x, y)


def test_dict():
    my_dict = {'a': 1, 'b': 2, 'b': 3}  # 键一般是唯一的，如果重复最后的一个键值对会替换前面的，值不需要唯一。
    print(my_dict['b'])
    my_dict['b'] = 'school'
    my_dict['c'] = 'c'
    print(my_dict)
    del my_dict['c']
    print(my_dict)
    # my_dict.clear()
    # print(my_dict)  # 清空字典所有条目
    my_dict[1] = 111
    print(str(my_dict))
    print(type(my_dict))
    my_list = ['a', 'b', 'c']
    my_dict2 = dict.fromkeys(my_list, 10)
    print("my_dict2: ", my_dict2)
    print(my_dict.get('a'))
    print(my_dict.items())
    for key, values in my_dict.items():
        print(key, values)
    my_dict.setdefault('fff', 1)
    print("my_dict: ", my_dict)
    print("my_dict2: ", my_dict2)
    my_dict.update(my_dict2)
    print(my_dict)
    my_dict.pop('a')
    print("my_dict: ", my_dict)


def test_string():
    var1 = 'Hello world'
    var2 = "Python Runoob"
    print("var1[0]", var1[0])
    print("var2[1:5]", var2[1:5])
    print("var2[:6]", var2[:6])  # 取前6个字符
    print("My name is %s age is %0d." % ("hahaha", 27.265))
    print('%10.1f' % 27.265)  # 共10位，小数点后保留1位
    print('%010.1f' % 27.265)  # 共10位，小数点后保留1位，前面补0
    # 所见即所得）格式 需要一块HTML或者SQL时，这时当用三引号标记
    hi = '''hi  
    there
    '''
    print(hi)
    unicode_str = u'hello'
    print(unicode_str)
    print("{1} {0} {1}".format("hello", "world"))
    print("{:.2f}".format(3.14159265))  # 保留小数点后两位


def test_time():
    localtime = time.localtime(time.time())  # 用一个元组装起来的9组数字处理时间
    print("本地时间为： ", localtime)
    print("时间戳为： ", time.time())
    localtime = time.asctime(localtime)
    print(localtime)
    print(time.strftime("%Y-%m-%d %H:%M:%S", time.localtime()))
    time_zone = time.timezone  # 属性 time.timezone 是当地时区（未启动夏令时）距离格林威治的偏移秒数
    # time_zone = time.tzname  # 属性time.tzname包含一对根据情况的不同而不同的字符串，分别是带夏令时的本地时区名称，和不带的。
    print(time_zone)
    cal = calendar.calendar(1, 2, 1, 6)
    cal = calendar.firstweekday()
    print(cal)
    return cal


def f(arg1, arg2):
    return arg1 + arg2  # s = lambda arg1, arg2: arg1 + arg2


s = lambda arg1, arg2: arg1 + arg2

print(f(10, 20))
print(s(1, 2))


def var_test():
    global Money
    print(Money)
    Money = Money + 100000
    print(Money)


if __name__ == '__main__':
    print("Main")
    var_test()
