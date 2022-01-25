package cn.oldensheepdog.java.designpattern.proxy.jdkProxy;

public class Dog implements Animal{
    @Override
    public void eat() {
        System.out.println("The dog is eating");
    }
}
