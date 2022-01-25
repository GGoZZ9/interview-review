package cn.oldensheepdog.java.fundamental.java8newfeature.lambada;

public class Test {
    public int operate(int a, int b, Operation operation){
        return operation.operation(a,b);
    }
}
