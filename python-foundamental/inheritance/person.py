class Person:
    def __init__(self, name, age):
        self._name = name  # name 是保护类型 以单个下划线 underline 开头的变量或方法仅供内部使用 ； Python 中不存在私有变量一说，若是遇到需要保护的变量，使用小写和一个前导下划线。但这只是程序员之间的一个约定，用于警告说明这是一个私有变量，外部类不要去访问它。但实际上，外部类还是可以访问到这个变量。
        self._age = age

    def print_age(self):  # self就是指类的实例
        print("%s's age is %s" % (self._name, self._age))


#         https://blog.csdn.net/hudiedd/article/details/12581485
