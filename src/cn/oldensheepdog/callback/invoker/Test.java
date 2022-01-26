package cn.oldensheepdog.callback.invoker;

public class Test {
    public static void main(String[] args) {
        Handler handler=new Handler();
        Invoker invoker=new Invoker(handler);
        invoker.invoke(10);
    }
}
