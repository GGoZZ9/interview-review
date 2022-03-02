package cn.oldensheepdog.java.designpattern.proxy.jdkproxy;

public class Dog implements Animal{
    @Override
    public void eat() {
        System.out.println("The dog is eating");
    }
}
