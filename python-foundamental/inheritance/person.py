class Person:
    def __init__(self, name, age):
        self._name = name  # name 是保护类型
        self._age = age

    def print_age(self):  # self就是指类的实例
        print("%s's age is %s" % (self._name, self._age))
