package cn.oldensheepdog.java.designpattern.decorator;

// 定义具体对象
public class Luccy implements IPerson{

    @Override
    public void show() {
        System.out.println("什么都没穿");
    }
}
