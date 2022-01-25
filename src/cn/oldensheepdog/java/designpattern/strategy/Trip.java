package cn.oldensheepdog.java.designpattern.strategy;

public class Trip {
    private ITrip trip;

    public Trip(ITrip trip){
        this.trip = trip;
    }

    public void doTrip(){
        this.trip.going();
    }
}
