package cn.oldensheepdog.callback;

// https://cloud.tencent.com/developer/article/1611150
/**
 * 说下java的异步回调模式，是指当调用者实现了CallBack接口，调用者包含了被调用者的引用，在调用者类中调用被调用者的方法，然后在被调用者类的方法中调用调用者类的callBack方法。
 *
 * 举个例子，异步体现在A类通过新起的一个线程执行B类的方法，至于该方法有没有执行完，暂时不用去等待。
 *
 * */
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
