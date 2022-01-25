package cn.oldensheepdog.java.designpattern.strategy;

public class Bike implements ITrip{
    @Override
    public void going() {
        System.out.println("骑自行车");
    }
}
