package cn.oldensheepdog.java.designpattern.factory;

public class BeerFactory extends AbstractFactory{
    @Override
    public String createProduct(String product) {
        String result;
        switch (product){
            case "Hans":
                result="汉斯";
                break;
            case "Yanjing":
                result="燕京";
                break;
            default:
                result="其他啤酒";
                break;
        }
        return result;
    }
}
