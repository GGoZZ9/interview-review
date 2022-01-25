package cn.oldensheepdog.java.designpattern.decorator;

public class DecoratorTest {
    public static void main(String[] args) {
        Luccy luccy = new Luccy();
        Jacket jacket = new Jacket(luccy);
        Hat hat = new Hat(jacket);
//        jacket.show();
        hat.show();

    }
}
