package cn.oldensheepdog.java.designpattern.template;

public class TemplateTest {
    public static void main(String[] args) {
        Refrigerator banana = new Banana();
        banana.open();
        banana.put();
        banana.close();

        Refrigerator apple = new Apple();
        apple.open();
        apple.put();
        apple.close();
    }
}
