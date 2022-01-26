package cn.oldensheepdog.callback.invoker;

public class Handler {
    /**
     * @param callBack 回调接口
     * @param number 接收数据值
     * @return 返回值信息
     */
    public  void handlerData(CallBack callBack, final int number) {
        final int count = 1000;
        for (int i = 0; i < count; i++) {

        }
        double v = Math.pow(number, 2);
        callBack.accept(v);

    }
}
