package cn.oldensheepdog.java.designpattern.decorator;

// 定义装饰器超类
public class DecoratorBase implements IPerson{
    IPerson iPerson;

    public DecoratorBase(IPerson iPerson){
        this.iPerson = iPerson;
    }
    @Override
    public void show() {
        iPerson.show();
    }
}
