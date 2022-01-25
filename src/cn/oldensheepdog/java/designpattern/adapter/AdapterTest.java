package cn.oldensheepdog.java.designpattern.adapter;

public class AdapterTest {
    public static void main(String[] args) {
        TypeC typeC = new TypeC();
        MicroUSB microUSB = new AdapterMicroUSB(typeC);
        microUSB.charger();
    }
}
