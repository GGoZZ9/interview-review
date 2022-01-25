package cn.oldensheepdog.java.fundamental.java8newfeature.lambada;

public class BeforeJava8 {

    public static void main(String[] args) {
        Test test = new Test();
        // Java8之前要实现Operation接口并传给Test.operate()方法使用，要定义一个匿名类，实现Operation方法
        test.operate(1, 2, new Operation() {
            @Override
            public int operation(int a, int b) {
                System.out.println(a+b);
                return a+b;
            }
        });
    }
}
