package cn.oldensheepdog.java.javatpoint.reflectiong;

import java.lang.reflect.Method;

class A{
    private void cube(int n){System.out.println(n*n*n);}
}

public class M {
    public static void main(String args[])throws Exception{
        Class c=A.class;
        Object obj=c.newInstance();

        Method m=c.getDeclaredMethod("cube",new Class[]{int.class});
        m.setAccessible(true);
        m.invoke(obj,4);
    }
}
