package cn.oldensheepdog.java.designpattern.factory;

public class CoffeeFactory extends AbstractFactory{
    @Override
    public String createProduct(String product) {
        String result;
        switch (product){
            case "Mocca":
                result="摩卡";
                break;
            case "Latte":
                result="拿铁";
                break;
            default:
                result="其他咖啡";
                break;
        }
        return result;
    }
}
