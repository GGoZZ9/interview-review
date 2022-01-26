import os
import random
import requests
import time
import re
from concurrent.futures import ProcessPoolExecutor

# https://www.cnblogs.com/peng-zhao/p/10221922.html
def get_data(url):
    print("%s 正在请求%s" % (os.getpid(),url))
    time.sleep(random.randint(1,2))
    response = requests.get(url)
    print(os.getpid(),"请求成功 数据长度",len(response.content))
    #parser(response) # 3.直接调用解析方法  哪个进程请求完成就那个进程解析数据  强行使两个操作耦合到一起了
    return response


def parser(obj):
    data = obj.result()
    htm = data.content.decode("utf-8")
    ls = re.findall("href=.*?com",htm)
    print(os.getpid(),"解析成功",len(ls),"个链接")


if __name__ == '__main__':
    pool = ProcessPoolExecutor(3)
    urls = ["https://www.baidu.com",
            "https://www.sina.com",
            "https://www.python.org",
            "https://www.tmall.com",
            "https://www.mysql.com",
            "https://www.apple.com.cn"]
    # objs = []
    for url in urls:
# res = pool.submit(get_data,url).result() # 1.同步的方式获取结果 将导致所有请求任务不能并发
# parser(res)
        obj = pool.submit(get_data,url) #
        obj.add_done_callback(parser) # 4.使用异步回调，保证了数据可以被及时处理，并且请求和解析解开了耦合
# objs.append(obj)

# pool.shutdown() # 2.等待所有任务执行结束在统一的解析
# for obj in objs:
#     res = obj.result()
#     parser(res)
# 1.请求任务可以并发 但是结果不能被及时解析 必须等所有请求完成才能解析
# 2.解析任务变成了串行,
#使用进程池时，回调函数都是主进程中执行执行；

#使用线程池时，回调函数的执行线程是不确定的，哪个线程空闲就交给哪个线程；

#回调函数默认接收一个参数就是这个任务对象自己，再通过对象的result函数来获取任务的处理结果。