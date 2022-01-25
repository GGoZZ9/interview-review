package cn.oldensheepdog.java.designpattern.strategy;

public class Drive implements ITrip{
    @Override
    public void going() {
        System.out.println("开车");
    }
}
