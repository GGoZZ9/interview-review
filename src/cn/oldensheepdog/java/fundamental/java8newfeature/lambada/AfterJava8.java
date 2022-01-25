package cn.oldensheepdog.java.fundamental.java8newfeature.lambada;

/**
 * Lambda 和 函数式接口
 *
 *
 * */
public class AfterJava8 {

    public static void main(String[] args) {
        Test test = new Test();
        test.operate(1, 2, (a,b)->{
            System.out.println(a+b);
            return a+b;});
        test.operate(1, 7 , (a,b)->a+b);
    }
}
