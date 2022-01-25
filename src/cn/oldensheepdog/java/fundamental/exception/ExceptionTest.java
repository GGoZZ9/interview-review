package cn.oldensheepdog.java.fundamental.exception;

public class ExceptionTest {
    /**
     * Error 和 Exception 区别是什么？
     * Error 类型的错误通常为虚拟机相关错误，如系统崩溃，内存不足，堆栈溢出等，编译器不会对这类错误进行检测，JAVA 应用程序也不应对这类错误进行捕获,应用程序终止，无法回复
     * Exception 类的错误是可以在应用程序中进行捕获并处理的，通常遇到这种错误，应对其进行处理，使应用程序可以继续正常运行
     *
     * 受检异常是Exception 中除 RuntimeException 及其子类之外的异常。 Java 编译器会检查受检异常。如果没有特殊的要求，建议使用RuntimeException异常
     * JVM 是如何处理异常的？
     * 创建一个异常对象，交给JVM，JVM看有没有异常处理代码，有就处理，没有就抛出异常的调用栈，终止应用程序
     *
     * throw在方法内部，throws在方法声明上
     *
     * final、finally、finalize 有什么区别？finalize是一个方法，属于Object类的一个方法，而Object类是所有类的父类，
     * Java 中允许使用 finalize()方法在垃圾收集器将对象从内存中清除出去之前做必要的清理工作。
     *
     * RuntimeException继承自Exception，其他Exception也继承自Exception（受检异常，普通异常）
     *
     * 果你只用try去处理普通异常却不加以catch处理，编译是通不过的，因为编译器硬性规定，普通异常如果选择捕获，则必须用catch显示声明以便进一步处理
     * 而运行时异常在编译时没有如此规定，所以catch可以省略，你加上catch编译器也觉得无可厚非。
     *
     * try-catch-finally 中，如果 catch 中 return 了，finally 还会执行吗？
     * 会执行，在 return 前执行。finally里有return就又形成一条返回路径，会直接返回，不走catch的return
     *
     * 常见的异常
     * RuntimeException:ClassCastException,IndexOutOfBoundsException,NullPointerException
     * java常见的异常 ClassNotFoundException,ArrayIndexOutOfBoundsException,NoSuchFieldException,NullPointerException
     * */

    public static void main(String[] args) throws RuntimeException, ClassNotFoundException{
        throw new AssertionError("test exception");
    }
}
