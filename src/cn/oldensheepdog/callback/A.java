package cn.oldensheepdog.callback;

public class A implements CallBack {

    private B b;
    public A(B b) {
        this.b =b;
    }

    public void call(final String question) {
        new Thread(() -> b.answer(A.this, question)).start();
        doOtherThing();
    }

    public void doOtherThing() {
        String thread = Thread.currentThread().getName();
        System.out.println(thread + " 我是提问者A， 我问完问题就去干别的事了");
    }

    @Override
    public void callBack(String result) {
        String thread = Thread.currentThread().getName();
        System.out.println(thread +" B调用A定义的回调函数：回答者B告诉A答案是： " + result);
    }
}
