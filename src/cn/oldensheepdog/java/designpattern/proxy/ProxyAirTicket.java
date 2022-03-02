package cn.oldensheepdog.java.designpattern.proxy;

public class ProxyAirTicket implements IAirTicket{
    private AirTicket airTicket;

    public ProxyAirTicket() {
        airTicket = new AirTicket();
    }
    @Override
    public void buy() {
        airTicket.buy();
    }

    @Override
    public void aaa() {

    }
}
