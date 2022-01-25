package cn.oldensheepdog.java.designpattern.proxy;

/**
 * https://www.jianshu.com/p/d93922d20ced 代理模式的例子
 * 动态代理在java中最常见的应用之一就是切面编程
 * */
public class ProxyTest {
    public static void main(String[] args) {
        IAirTicket airTicket = new ProxyAirTicket();
        airTicket.buy();
    }
}
