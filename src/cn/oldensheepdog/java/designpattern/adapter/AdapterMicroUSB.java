package cn.oldensheepdog.java.designpattern.adapter;

public class AdapterMicroUSB implements MicroUSB{
    private TypeC typeC;

    public AdapterMicroUSB(TypeC typeC){
        this.typeC=typeC;
    }
    @Override
    public void charger() {
        typeC.charger();
    }
}
