package cn.oldensheepdog.callback;

/**
 * Filter(过滤器)和Interceptor(拦截器)的区别，拦截器基于是Java的反射机制，和容器无关。但与回调机制有异曲同工之妙。
 *
 * 总之，这设计让底层代码调用高层定义（实现层）的子程序，增强了程序的灵活性。
 * */
public class CallbackDemo {

    public static void main(String[] args) {
        B b=new B();
        A a=new A(b);
        a.call("1 + 1 = ?");
    }
}
