package cn.oldensheepdog.java.fundamental;

import java.lang.reflect.Field;

public class ChangeString {
    public void changeString() throws NoSuchFieldException, IllegalAccessException {
        String s = "Hello World";
        System.out.println("s="+s);
        // 获取String类中的value字段
        Field valueFieldOfString = String.class.getDeclaredField("value");
        // 改变value属性的访问权限
        valueFieldOfString.setAccessible(true);
        // 获取s对象上的value属性的值
        char[] value = (char[]) valueFieldOfString.get(s);
        // 改变value所引用的数组中的第5个字符
        value[5] = '_';
        System.out.println("s="+s);
    }
}
