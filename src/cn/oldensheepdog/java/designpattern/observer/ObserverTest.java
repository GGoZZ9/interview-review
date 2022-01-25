package cn.oldensheepdog.java.designpattern.observer;

public class ObserverTest {
    public static void main(String[] args) {
        // 定义发布者 被观察者
        ConcreteSubject concreteSubject = new ConcreteSubject();
        // 定义订阅者
        ConcreteObserver concreteObserver1 = new ConcreteObserver("Java");
        ConcreteObserver concreteObserver2 = new ConcreteObserver("Python");
        // 添加订阅
        concreteSubject.attach(concreteObserver1);
        concreteSubject.attach(concreteObserver2);
        //发布消息
        concreteSubject.notify("更新了");
    }
}
