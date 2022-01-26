package cn.oldensheepdog.callback.invoker;

import java.io.Serializable;

public class Invoker implements CallBack, Serializable {

    private Handler handler;
    public Invoker(Handler handler){
        this.handler=handler;
    }
    public void invoke(final int num){
        new Thread(() -> handler.handlerData(Invoker.this,num)).start();
    }
    @Override
    public  void accept(Object object) {
        System.out.println(object);
    }
}
