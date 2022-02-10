package cn.oldensheepdog.java.fundamental;

import java.util.HashSet;
import java.util.Set;

public class Fundamental {

/**
 * JVM + 核心类库 java.lang等
 = JRE + 开发工具 java.exe 运行java程序，javac.exe编译生成.class文件
 = JDK
 Java源代码 -> 编译器 compiler ->jvm可执行的.class文件->jvmj 解释器 Interpreter ->机器可执行的二进制机器码 Binary machine code ->程序运行
 * */

    /**
     * Java 主类 程序执行入口只有一个main方法，Java小程序主类是继承自系统类的JApplet 或Applet类，在浏览器上运行调用init()线程或run()
     *
     * 1 Byte 字节 = 8 bit 位 (binary digit)
     * 1 KB = 1024 Bytes
     * 1 MB = 1024 KB
     * 1 GB = 1024 MB
     */


    /**
     * https://www.javatpoint.com/command-line-argument
     * OOP: Object-Oriented Programming
     * Inheritance: Inheritance(IS-A), Aggregation(HAS-A)
     * Polymorphism: Overload, Override, covariant Return type, super, Instance Initializer block, final, Runtime Polymorphism, instanceof operator
     * Abstraction: Abstract class, Interface
     * Encapsulation: package, access modifiers
     * Array
     *
     * */

    /**
     * Connecting a method call to the method body is known as binding.
     *
     * */

    /**
     * abstract class
     * An abstract class must be declared with an abstract keyword.
     * It can have abstract and non-abstract methods.
     * It cannot be instantiated.
     * It can have constructors and static methods also.
     * It can have final methods which will force the subclass not to change the body of the method.
     *
     * A factory method is a method that returns the instance of the class. We will learn about the factory method later.
     * */

    /**
     * No.	Method Overloading	                                                                        Method Overriding
     * 1)	Method overloading is used to increase the readability of the program.	                    Method overriding is used to provide the specific implementation of the method that is already provided by its super class.
     * 2)	Method overloading is performed within class.	                                            Method overriding occurs in two classes that have IS-A (inheritance) relationship.
     * 3)	In case of method overloading, parameter must be different.	                                In case of method overriding, parameter must be same.
     * 4)	Method overloading is the example of compile time polymorphism.	                            Method overriding is the example of run time polymorphism.
     * 5)	In java, method overloading can't be performed by changing return type of the method only.  Return type can be same or different in method overloading. But you must have to change the parameter.	Return type must be same or covariant in method overriding.
     * */

    /**
     * Member inner class: A non-static class that is created inside a class but outside a method is called member inner class.
     * OuterClassReference.new MemberInnerClassConstructor();
     * Anonymous inner class: An anonymous inner class can be useful when making an instance of an object with certain "extras"
     * such as overloading methods of a class or interface, without having to actually subclass a class.
     * Local inner class:A class i.e., created inside a method, is called local inner class in java.
     * static nested class: TestOuter1.Inner obj=new TestOuter1.Inner();
     * */

    /**
     * we use multithreading than multiprocessing because threads use a shared memory area.
     * They don't allocate separate memory area so saves memory, and context-switching between the threads takes less time than process.
     *
     * Thread-based Multitasking (Multithreading)
     * Threads share the same address space.
     * A thread is lightweight.
     * Cost of communication between the thread is low.
     *
     * Process-based Multitasking (Multiprocessing)
     * Each process has an address in memory. In other words, each process allocates a separate memory area.
     * A process is heavyweight.
     * Cost of communication between the process is high.
     * Switching from one process to another requires some time for saving and loading registers, memory maps, updating lists, etc.
     *
     * thread scheduler to provide the thread time to run, i.e., moving the thread the running state.
     * A program implementing multithreading acquires a fixed slice of time to each individual thread.
     *
     * Synchronization in Java is the capability to control the access of multiple threads to any shared resource.
     * There are two types of thread synchronization mutual exclusive 互斥通信 and inter-thread communication 线程间通信.
     *
     * If you make any static method as synchronized, the lock will be on the class not on object.
     * */

    /**
     * Inter-thread communication or Co-operation is all about allowing synchronized threads to communicate with each other.
     * wait()
     * notify()
     * notifyAll()
     * The notify() method wakes up a single thread that is waiting on this object's monitor
     * The choice is arbitrary and occurs at the discretion of the implementation.
     *
     * wait()	                                                        sleep()
     * The wait() method releases the lock.	                            The sleep() method doesn't release the lock.
     * It is a method of Object class	                                It is a method of Thread class
     * It is the non-static method	                                    It is the static method
     * It should be notified by notify() or notifyAll() methods	        After the specified amount of time, sleep is completed.
     * */

    /**
     * Java monitors are reentrant means java thread can reuse the same monitor for different synchronized methods if method is called from the method.
     * */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        fun();
    }

    public static void fun() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
//        System.out.println(Math.round(11.5));
//        System.out.println(Math.round(-11.5)); // 先加0.5再取整
        Child demo = new Child();
        demo.function();
        System.out.println("…………………………………………………………………………………………………………………………");
        Child child = new Child();
        child.function();
        System.out.println("…………………………………………………………………………………………………………………………");
//        Outer outer = new Outer();
//        outer.outMethod();
        System.out.println("…………………………………………………………………………………………………………………………");
        String a = new String("ab"); // new产生在堆中，a是堆中变量的引用，
        String b = new String("ab");
        String aa = "ab"; // 放在常量池中 ， 是字面值的引用
        String bb = "ab"; // 从常量池查找
        if (aa ==bb) {
            System.out.println("aa==bb");
        }
        if (a == b) {
            System.out.println("a==b");
        }
        if (a.equals(b)) {
            System.out.println("aEQb");
        }
        if (42 == 42.0) {
            System.out.println("true");
        }

        System.out.println("HashCode()…………………………………………………………………………………………………………………………");
        Coder coder1 = new Coder("bruce", 10);
        Coder coder2 = new Coder("bruce", 10);
        Set<Coder> set = new HashSet<>();
        set.add(coder1);
        System.out.println(set.contains(coder2));

        System.out.println("Reflect()…………………………………………………………………………………………………………………………");
        Reflect reflect = new Reflect();
        reflect.reflect();

        System.out.println("Change String…………………………………………………………………………………………………………………………");
        ChangeString changeString = new ChangeString();
        changeString.changeString();
    }

/**
 * 包装类型 packing type 基本类型 base type
 * byte 1B
 * short 2B
 * int 4Byte
 * long 8Byte
 * float 单精度 4Byte
 * double 双精度 8Byte
 * char 2B
 * float f = float(3.4)或者 float f = 3.4F
 * 更精确的用 BigDecimal
 * long 整型 64位
 * 超过64位用 BigInteger内部用一个int[]数组来模拟一个非常大的整数：
 * */

/**
 * private : 在同一类内可见。使用对象：变量、方法 The private keyword is an access modifier used for attributes, methods and constructors,
 * making them only accessible within the declared class.
 * protected : 对同一包内的类和所有子类可见。使用对象：变量、方法 making them accessible in the same package and subclasses.
 *
 * default (即缺省，什么也不写）: 在同一包内可见。使用对象：类、接口、变量、方法。
 * public : 对所有类可见。使用对象：类、接口、变量、方法
 * */

/**
 * &&左边的表达式的值是 false，右边的表达式会被直接短路掉 Short-circuit operations ，不会进行运算。
 * */

/**
 * 被final修饰的类不可以被继承 inherit, 重写 override，变量不可改变 When a variable is declared with final keyword, its value can’t be modified
 * 被final修饰不可变的是变量的引用 reference，而不是引用指向的内容，引用指向的内容是可以改变的
 *
 * finally一般作用在try-catch代码块 Code blocks 中，一定要执行的，一般关闭资源
 * finalize是一个方法，属于Object类的一个方法，调用System.gc() 方法的时候，由垃圾回收器调用finalize()，回收垃圾，一个对象是否可回收的最后判断。
 * */

/**
 * this是自身的一个对象，代表对象本身，可以理解为：指向对象本身的一个指针。
 * 1.普通的直接引用，this相当于是指向当前对象本身。
 * 2.形参与成员名字重名，用this来区分
 * 3.引用本类的构造函数
 * this can be used to refer current class instance variable.
 * this can be used to invoke current class method (implicitly)
 * this() can be used to invoke current class constructor.
 * this can be passed as an argument in the method call.
 * this can be passed as argument in the constructor call.
 * this can be used to return the current class instance from the method.
 *
 * super可以理解为是指向自己超（父）类对象的一个指针，而这个超类指的是离自己最近的一个父类。
 * The super keyword in Java is a reference variable which is used to refer immediate parent class object.
 * 1.普通的直接引用：与this类似，super相当于是指向 point to 当前对象的父类 Parent class 的引用，这样就可以用super.xxx来引用父类的成员。
 * 2.子类中的成员变量 Member variables 或方法与父类中的成员变量或方法同名时，用super进行区分
 * 3.引用父类构造函数 super()
 * super can be used to refer immediate parent class instance variable.
 * super can be used to invoke immediate parent class method.
 * super() can be used to invoke immediate parent class constructor.
 *
 * this()和super()都指的是对象，所以，均不可以在static环境中使用。包括：static变量,static方法，static语句块。
 * 从本质上讲，this是一个指向本对象的指针, 然而super是一个Java关键字。
 * */

/**
 * static的主要意义是在于创建独立于具体对象的域变量或者方法。以致于即使没有创建对象，也能使用属性和调用方法！
 * static关键字还有一个比较关键的作用就是 用来形成静态代码块以优化程序性能。static块可以置于类中的任何地方，类中可以有多个static块。
 * 在类初次被加载的时候，会按照static块的顺序来执行每个static块，并且只会执行一次,是因为它的特性:只会在类加载的时候执行一次。
 * （虚拟机把描述类的数据从class文件加载到内存，并对数据进行校验，转换解析和初始化，最终形成可以被虚拟机直接使用的Java类型，这就是虚拟机的类加载机制。
 * 类的加载指的是将类的.class文件中的二进制数据读入到内存中，将其放在运行时数据区的方法区内，然后在堆区创建一个java.lang.Class对象，用来封装类在方法区内的数据结构。）
 * 因此，很多时候会将一些只需要进行一次的初始化操作都放在static代码块中进行。
 * 1、被static修饰的变量或者方法是独立于该类的任何对象，也就是说，这些变量和方法不属于任何一个实例对象，而是被类的实例对象所共享
 * 2、在该类被第一次加载的时候，就会去加载被static修饰的部分，而且只在类第一次使用时加载并进行初始化，注意这是第一次用就要初始化，后面根据需要是可以再次赋值的。
 * 3、static变量值在类加载的时候分配空间，以后创建类对象的时候不会重新分配。赋值的话，是可以任意赋值的！
 * 4、被static修饰的变量或者方法是优先于对象存在的，也就是说当一个类加载完毕之后，即便没有创建对象，也可以去访问。
 * 类的加载过程
 * 在创建(new)一个对象的时候，先要去JVM的方法区里获取该对象所对应的类的信息，如果方法区里没有该类的信息，则需要去将它加载进来，加载进来之后，有了该类的信息，我们才能创建一个对象。
 * Java类被编译后，会生成一个class文件，在运行的时候会将class文件加载到Java虚拟机JVM中，class文件由类装载器装载，在JVM中（准确的来说应该是在JVM的方法区里）
 * 将形成一份描述Class结构的元信息对象，通过该元信息对象可以获知Class的结构信息：如构造函数，属性和方法等。
 * 静态代码块是在类加载时自动执行的代码，非静态代码块是在创建对象时自动执行的代码，不创建对象不执行该类的非静态代码块。
 * 对象的创建过程
 * 1、new一个对象时，在堆内存中开辟一块空间。
 * 2、给开辟的空间分配一个地址。
 * 3、把对象的所有非静态成员加载到所开辟的空间下。
 * 4、所有的非静态成员加载完成之后，对所有非静态成员变量进行默认初始化。
 * 5、所有非静态成员变量默认初始化完成之后，调用构造函数。
 * 6、在构造函数入栈执行时，分为两部分：先执行构造函数中的隐式三步，再执行构造函数中书写的代码。
 * 隐式三步：
 *    ①执行super()语句
 *
 *    ②显示初始化(对开辟空间下的所有非静态成员变量进行)
 *
 *    ③执行构造代码块
 * 7、在整个构造函数执行完并弹栈后，把空间分配的地址赋给引用对象。
 * super语句，可能出现以下三种情况:
 * 1）构造方法体的第一行是this()语句，则不会执行隐式三步，而是调用this()语句所对应的的构造方法，最终肯定会有第一行不是this语句的构造方法。
 * 2）构造方法体的第一行是super()语句，则调用相应的父类的构造方法，
 * 3）构造方法体的第一行既不是this()语句也不是super()语句，则隐式调用super()，即其父类的默认构造方法，这也是为什么一个父类通常要提供默认构造方法的原因；
 *
 * 因为static是被类的实例对象所共享，因此如果某个成员变量是被所有对象所共享的，那么这个成员变量就应该定义为静态变量。（1、修饰成员变量 2、修饰成员方法 3、静态代码块 4、修饰类【只能修饰内部类也就是静态内部类】 5、静态导包）
 *
 * 栈（stack）：存放基本类型的变量数据和对象的引用
 * 堆（heap）：一种通用性的内存池（也存在于RAM中），用于存放所有的JAVA对象
 * 静态存储（static storage）：这里的“静态”是指“在固定的位置”。静态存储里存放程序运行时一直存在的数据 static
 * 常量存储（constant storage）：存放字符串常量和基本类型常量（public static final）。
 * **寄存器 < 堆栈 < 堆 < 其他 **
 *
 * 静态代码块是在类加载的时候执行的，类的加载只会执行一次所以静态代码块也只会执行一次
 * 非静态代码块和构造函数中的代码是在对象创建的时候执行的，因此对象创建(new)一次，它们就会执行一次
 *
 * 堆的优势是可以动态地分配内存大小，所有使用new xxx()构造出来的对象都在堆中存储，生存期也不必事先告诉编译器，Java的垃圾收集器会自动收走这些不再使用的数据。但缺点是，由于要在运行时动态分配内存，存取速度较慢。
 * 栈的优势是，存取速度比堆要快，仅次于直接位于CPU中的寄存器。但缺点是，存在栈中的数据大小与生存期必须是确定的，缺乏灵活性。另外，栈数据可以共享
 * 常量池：存放字符串常量和基本类型常量（public static final）。常量池的好处是为了避免频繁的创建和销毁对象而影响系统性能，其实现了对象的共享。
 * 包装类数据，如Integer, String, Double等将相应的基本数据类型包装起来的类
 *
 * String s = new String(“abc”);产生几个对象？答：一个或两个，如果常量池中原来没有”abc”,就是两个。
 * 基本数据类型包装类的值不可修改。不仅仅是String类的值不可修改，所有的基本数据数据类型包装类都不能更改其内部的值。
 * 我们在使用诸如String str = "abc"；的格式定义类时，总是想当然地认为，我们创建了String类的对象str。担心陷阱！对象可能并没有被创建！
 * 唯一可以肯定的是，指向 String类的引用被创建了。
 * 至于这个引用到底是否指向了一个新的对象，必须根据上下文来考虑，除非你通过new()方法来显要地创建一个新的对象。
 * 当比较包装类里面的数值是否相等时，用equals()方法；当测试两个包装类的引用是否指向同一个对象时，用==。
 * 由于String类的immutable性质，当String变量需要经常变换其值时，应该考虑使用StringBuffer类，以提高程序效率。
 * 栈使用的是一级缓存， 他们通常都是被调用时处于存储空间中，调用完毕立即释放。
 * 堆则是存放在二级缓存中，生命周期由虚拟机的垃圾回收算法来决定（并不是一旦成为孤儿对象就能被回收）。所以调用这些对象的速度要相对来得低一些
 *
 *
 * break 跳出总上一层循环，不再执行循环(结束当前的循环体)
 * continue 跳出本次循环，继续执行下次循环(结束正在执行的循环 进入下一个循环条件)
 * return 程序返回，不再执行下面的代码(结束当前的方法 直接返回)
 * 在Java中，要想跳出多重循环，可以在外面的循环语句前定义一个标号，然后在里层循环体的代码中使用带有标号的break 语句，即可跳出外层循环
 * */

/**
 * 非静态代码块则在类每次调用构造方法之前调用一次，所以也称之为匿名构造方法，可以用于类中属性的初始化操作，由于位于构造方法之前调用，
 * 所以一些初始化的成员变量可能会在构造方法中被重新赋值，从而覆盖掉之前的初始化的值
 * */

/**
 * 面向对象（OO）
 * 易维护、易复用、易扩展，由于面向对象有封装、继承、多态性的特性，可以设计出低耦合的系统
 * 抽象：抽象是将一类对象的共同特征总结出来构造类的过程
 * 封装把一个对象的属性私有化，同时提供一些可以被外界访问的属性的方法
 * 继承是使用已存在的类的定义作为基础建立新类的技术
 * 多态一个引用变量到底会指向哪个类的实例对象必须在由程序运行期间才能决定。在Java中有两种形式可以实现多态：继承（多个子类对同一方法的重写）和接口（实现接口并覆盖接口中同一方法）
 * 方法重载（overload）实现的是编译时的多态性（也称为前绑定），而方法重写（override）实现的是运行时的多态性（也称为后绑定）
 * 方法重写（子类继承父类并重写父类中已有的或抽象的方法）；
 * 对象造型（用父类型引用子类型对象，这样同样的引用调用同样的方法就会根据子类对象的不同而表现出不同的行为）。
 * 实现多态有三个必要条件：继承、重写（override）、向上转型
 *
 * 面向对象五大基本原则是什么（可选）
 *
 * 单一职责原则SRP(Single Responsibility Principle) 类的功能要单一，不能包罗万象，跟杂货铺似的。
 * 开放封闭原则OCP(Open－Close Principle) 一个模块对于拓展是开放的，对于修改是封闭的，想要增加功能热烈欢迎，想要修改，哼，一万个不乐意。
 * 里式替换原则LSP(the Liskov Substitution Principle LSP) 子类可以替换父类出现在父类能够出现的任何地方。比如你能代表你爸去你姥姥家干活。哈哈~~
 * 依赖倒置原则DIP(the Dependency Inversion Principle DIP) 高层次的模块不应该依赖于低层次的模块，他们都应该依赖于抽象。
 * 抽象不应该依赖于具体实现，具体实现应该依赖于抽象。就是你出国要说你是中国人，而不能说你是哪个村子的。比如说中国人是抽象的，下面有具体的xx省，xx市，xx县。你要依赖的抽象是中国人，而不是你是xx村的。
 * 接口分离原则ISP(the Interface Segregation Principle ISP) 设计时采用多个与特定客户类有关的接口比采用一个通用的接口要好。
 * 就比如一个手机拥有打电话，看视频，玩游戏等功能，把这几个功能拆分成不同的接口，比在一个接口里要好的多。
 *
 * */

/**
 * java8以后抽象和接口有什么不同
 * Java8 在接口中推出了默认方法、静态方法，打破了接口只能写抽象方法的传统
 * 抽象类是一个“类”，而接口只是一个“接口”，两者的概念和应用场景不一样，这也是抽象类和接口的主要区别。
 * 在 Java8 中接口也能写实现方法了，但却不能写构造方法，而在抽象类是可以写构造方法的，意味着抽象类是参与类的实例化过程的，而接口则不是。
 * 抽象类可以有自己的各种成员变量，并且可以通过自己的非抽象方法进行改变，而接口中的变量默认全是 public static final 修饰的，意味着都是常量，并且不能被自己和外部修改。
 * 接口可以实现多继承，而抽象类只能单继承。
 * 抽象类中的方法可以是任意访问修饰符，接口方法默认修饰符是public；抽象类的字段声明可以是任意的，接口的字段默认都是 static 和 final 的
 * */

/**
 * 如何选择用接口还是抽象类
 * 行为模型应该总是通过接口而不是抽象类定义，所以通常是优先选用接口，尽量少用抽象类。
 * 选择抽象类的时候通常是如下情况：需要定义子类的行为，又要为子类提供通用的功能。
 * */

/**
 * 普通类和抽象类有哪些区别
 * 普通类不能包含抽象方法，抽象类可以包含抽象方法。final 不能修饰抽象类
 * 抽象类不能直接实例化，普通类可以直接实例化。
 * */

/**
 * 为什么不能多继承
 * 超类和子类中都存在具有相同签名的方法时，就会出现问题，编译器无法确定调用哪个类方法。可以通过接口和内部类来
 * Java是不允许“实现多继承”，简称不允许“多继承”。但是Java支持“声明多继承”——Java的接口的多继承——一个类可以实现多个接口（“继承”了多个接口上的方法声明），
 * 而一个接口可以继承多个接口（同样是“继承”了多个接口上的方法声明）。接口只允许有方法声明而不允许有实现
 * 从Java8开始，接口允许为方法提供“默认实现”了——默认方法（default method）。因而实质上Java 8的接口多继承其实也会涉及到实现多继承，
 * 在发现会继承多个默认方法实现并且没有override时报错，逼使用户显式override可能冲突的方法。
 * */

/**
 * new关键字，new创建对象实例（对象实例在堆内存中），对象引用指向对象实例（对象引用存放在栈内存中），一个实例可有多个引用，一个引用可有一个或0个实例
 * 成员变量和局部变量区别
 * 成员变量在类中方法外，存储在堆中，随对象创建，对象消失而消失，有默认初始值；局部变量在方法内，在栈内存中，方法被调用或执行时存在，执行完销毁，没有默认值，使用前必须赋值
 * */

/**
 * 在Java中定义一个不做事且没有参数的构造方法的作用
 * Java程序在执行子类的构造方法之前，如果没有用super()来调用父类特定的构造方法，则会调用父类中“没有参数的构造方法”。
 * 因此，如果父类中只定义了有参数的构造方法，而在子类的构造方法中又没有用super()来调用父类中特定的构造方法，则编译时将发生错误，
 * 因为Java程序在父类中找不到没有参数的构造方法可供执行。解决办法是在父类里加上一个不做事且没有参数的构造方法。
 *
 * 构造方法
 * 完成类对象的初始化工作，没有声明构造方法也会有默认不带参构造方法
 * 构造方法有哪些特性？名字与类名相同；没有返回值，但不能用void声明构造函数；生成类的对象时自动执行，无需调用。
 *
 * 先执行构造代码块（给类变量初始化），再执行构造方法，
* */

/**
 * 调用静态方法可以无需创建对象。类名.方法名;静态方法在访问本类的成员时，只允许访问静态成员（即静态成员变量和静态方法）
 * */

/**
 * 匿名内部类必须继承一个抽象类或者实现一个接口。
 * 匿名内部类不能定义任何静态成员和静态方法。
 * 当所在的方法的形参需要被匿名内部类使用时，必须声明为 final。
 * 内部类的优点
 * 一个内部类对象可以访问创建它的外部类对象的内容，包括私有数据！
 * 内部类不为同一包的其他类所见，具有很好的封装性；
 * 内部类有效实现了“多重继承”，优化 java 单继承的缺陷。
 * 匿名内部类可以很方便的定义回调。
 * 使用场合 当某个类除了它的外部类，不再被其他的类使用时
 * */

/**
 * 重载（Overload）和重写（Override）的区别。重载的方法能否根据返回类型进行区分？
 * 重载：发生在同一个类中，方法名相同参数列表不同（参数类型不同、个数不同、顺序不同），与方法返回值和访问修饰符无关，即重载的方法不能根据返回类型进行区分
 * 重写：发生在父子类中，方法名、参数列表必须相同，返回值小于等于父类，抛出的异常小于等于父类，访问修饰符大于等于父类（里氏代换原则）；如果父类方法访问修饰符为private则子类中就不是重写。
 * */

/**
 * 你重写过 hashcode 和 equals 么，为什么重写equals时必须重写hashCode方法？(HashSet如何检查重复)
 * 对象加入 HashSet 时，HashSet 会先计算对象的 hashcode 值来判断对象加入的位置
 * 但是如果发现有相同 hashcode 值的对象，这时会调用 equals()方法来检查 hashcode 相等的对象是否真的相同
 * 如果两者相同，HashSet 就不会让其加入操作成功。如果不同的话，就会重新散列到其他位置。减少了 equals 的次数，相应就大大提高了执行速度
 * hashCode() 的作用是确定该对象在哈希表中的索引位置（Object中的hashCode() 返回对象的32位jvm内存地址。也就是说如果对象不重写该方法，则返回相应对象的32位JVM内存地址。）
 * 如果两个对象相等，则hashcode一定也是相同的,两个对象有相同的hashcode值，它们也不一定是相等的,因此，equals 方法被覆盖过，则 hashCode 方法也必须被覆盖
 * hashCode() 的默认行为是对堆上的对象产生独特值。如果没有重写 hashCode()，则该 class 的两个对象无论如何都不会相等（即使这两个对象指向相同的数据）
 * 绑定：当equals方法被重写时，通常有必要重写 hashCode 方法，以维护 hashCode 方法的常规协定，该协定声明相等对象必须具有相等的哈希码
 * 绑定原因：Hashtable（HashMap, HashSet这样前面以Hash开头的集合类时，hashCode()就会被隐式调用以来创建哈希映射关系）实现一个哈希表，为了成功地在哈希表中存储和检索对象，用作键的对象必须实现 hashCode 方法和 equals 方法。同(1)，必须保证equals相等的对象，hashCode 也相等。因为哈希表通过hashCode检索对象
 * 默认：==默认比较对象在JVM中的地址；hashCode 默认返回对象在JVM中的存储地址；equal比较对象，默认也是比较对象在JVM中的地址，同==

 * 对象的相等与指向他们的引用相等，两者有什么不同？
 * 对象的相等 比的是内存中存放的内容是否相等而 引用相等 比较的是他们指向的内存地址是否相等。

 * 基本数据类型 == 比较的是值，引用数据类型 == 比较的是内存地址
 * 类没有覆盖 equals() 方法。则通过 equals() 比较该类的两个对象时，等价于通过“==”比较这两个对象。
 * 类覆盖了 equals() 方法。一般，我们都覆盖 equals() 方法来两个对象的内容相等；若它们的内容相等，则返回 true (即，认为这两个对象相等)
 * String中的equals方法是被重写过的, 比较的是对象的值
 * 当创建String类型的对象时，虚拟机会在常量池中查找有没有已经存在的值和要创建的值相同的对象，如果有就把它赋给当前引用。如果没有就在常量池中重新创建一个String对象。
 *
 * 重写equals：1. 判断是否等于自身 2. 使用instanceof运算符判断 other 是否为被判断的对象类型的对象 3. 比较Coder类中你自定义的数据域，name和age，一个都不能少
 *
 * */

/**
 * java.lang：这个是系统的基础类；
 * java.io：这里面是所有输入输出有关的类，比如文件操作等；
 * java.nio：为了完善 io 包中的功能，提高 io 包中性能而写的一个新包；
 * java.net：这里面是与网络有关的类；
 * java.util：这个是系统辅助类，特别是集合类；
 * java.sql：这个是数据库操作的类。
 * */

/**
 * java 中 IO 流分为几种?
 * 按照流的流向分，可以分为输入流和输出流；
 * 按照操作单元划分，可以划分为字节流和字符流；
 * 按照流的角色划分为节点流和处理流。
 * InputStream/Reader: 所有的输入流的基类，前者是字节输入流，后者是字符输入流。 InputStream 字节读入，Reader 字符读入
 * OutputStream/Writer: 所有输出流的基类，前者是字节输出流，后者是字符输出流。 OutputStream 字节写出，Writer 字符写出
 * Java IO 有 缓冲操作，基本数据类型操作，对象序列化操作，转化操作，打印控制，文件操作，管道操作，数组操作
 *
 * BIO Block IO同步阻塞式IO，处理能力低，NIO 同步非阻塞IO，通过Channel通讯，实现多路复用，AIO 异步非阻塞IO，基于事件和回调
 * NIO Channel , Selector，Buffer
 * */

/**
 * JAVA反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法,能够调用它的任意一个方法和属性
 * 优点： 运行期类型的判断，动态加载类，提高代码灵活度。
 * 缺点： 性能瓶颈：反射相当于一系列解释操作，通知 JVM 要做的事情，性能比直接的java代码要慢很多。Spring 通过 XML 配置模式装载 Bean 的过程
 * 1.通过new对象实现反射机制 2.通过路径实现反射机制 3.通过类名实现反射机制
 * */

/**
 * 常用工具+类库
 * Jackson, slf4j, Logback, Junit5, Mockito, Cucumber, 通用类库Apache Commons/Google Guava, Dom4j, Xerces
 * 集合类库Apache Commons Collections, Google Collections
 *
 * */

/**
 * List是接口，ArrayList是用一个数组实现的List类
 * ArrayList是自动扩容的Arrays。有add().remove()这样的方法。
 * Java中提供了Arrays类协助这几个操作：sort(),binarySearch(),equals(),fill(),asList().
 * Java中提供了ArrayList类协助这几个操作：如Index、IndexOf、Contains、Sort、Add、AddRange、Insert、InsertRange。
 * */

}
