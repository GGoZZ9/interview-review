package cn.oldensheepdog.java.designpattern.strategy;

public class StrategyTest {
    public static void main(String[] args) {
        Trip trip = new Trip(new Bike());
        trip.doTrip();
    }
}
