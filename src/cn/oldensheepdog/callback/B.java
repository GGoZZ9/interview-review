package cn.oldensheepdog.callback;

public class B {

    public void answer(CallBack callback, String question) {
        String thread = Thread.currentThread().getName();
        System.out.println(thread+" 我是回答者B，提问者A问的问题是： " + question);

        System.out.println(thread+" 我是回答者B， 我接完电话就去忙我自己的事了");

        for (int i=0;i<10000;i++) {

        }
        String result = "2";
        System.out.println(thread+" 我是回答者B， 我知道答案了： " + result);
        callback.callBack(result);
    }
}
