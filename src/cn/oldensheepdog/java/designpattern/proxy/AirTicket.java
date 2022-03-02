package cn.oldensheepdog.java.designpattern.proxy;

//定义机场售票
public class AirTicket implements IAirTicket{
    @Override
    public void buy() {
        System.out.println("买票");
    }

    @Override
    public void aaa() {

    }
}
