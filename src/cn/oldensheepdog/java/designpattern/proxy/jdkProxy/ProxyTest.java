package cn.oldensheepdog.java.designpattern.proxy.jdkProxy;

public class ProxyTest {
    public static void main(String[] args) {
        // jdk动态代理调用
        AnimalProxy proxy =new AnimalProxy();
        Animal dogProxy = (Animal) proxy.getInstance(new Dog());
        dogProxy.eat();
    }

}
