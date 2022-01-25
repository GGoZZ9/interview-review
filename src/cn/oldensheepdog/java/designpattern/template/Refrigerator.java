package cn.oldensheepdog.java.designpattern.template;

public abstract class Refrigerator {
    public void open(){
        System.out.println("open the refrigerator's door");
    }

    public abstract void put();

    public void close() {
        System.out.println("close the refrigerator's door");
    }
}
