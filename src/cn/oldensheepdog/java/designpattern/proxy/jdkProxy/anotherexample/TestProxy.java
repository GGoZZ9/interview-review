package cn.oldensheepdog.java.designpattern.proxy.jdkProxy.anotherexample;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        ProImp proImp = new ProImp();
        ProxyInte proxyInte = (ProxyInte) Proxy.newProxyInstance(ProImp.class.getClassLoader(), ProImp.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("..."+proxy.getClass().getName()); // 输出proxy对象的字节码文件名

                Method[] declaredMethods = this.getClass().getDeclaredMethods();
                for (Method declaredMethod : declaredMethods){
                    System.out.println(declaredMethod.getName());
                }
                method.invoke(proImp,null);
                return null;
            }
        });

        System.out.println(proxyInte.getClass().getName()); // 输出实现类的字节码文件名
        proxyInte.test();

        //$Proxy0.class的static模块中创建了被代理类的方法，调用相应方法时方法体中调用了父类中的成员变量InvocationHandler的invoke()方法
    }
}
