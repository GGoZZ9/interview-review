package cn.oldensheepdog.java.designpattern.factory;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        String result = new CoffeeFactory().createProduct("Latte");
        System.out.println(result);
    }
}
