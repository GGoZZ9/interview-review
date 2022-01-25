from person import Person


class Man(Person):  # 子类不重写 __init__，实例化子类时，会自动调用父类定义的 __init__
    work = "Teacher"

    def print_age(self):
        super().print_age()  # 调用基类的方法
        # print("Mr. %s's age is %s" % (self._name, self._age))

    def print_work(self):
        print("Mr. %s's work is %s" % (self._name, self.work))


if __name__ == "__main__":
    bob = Man("Bob", 33)
    bob.print_age()
    bob.print_work()
