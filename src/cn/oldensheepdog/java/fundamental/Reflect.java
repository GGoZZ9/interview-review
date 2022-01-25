package cn.oldensheepdog.java.fundamental;

public class Reflect {

    public void reflect() throws ClassNotFoundException {
        // 通过new对象实现反射
        Child child = new Child();
        Class classObj1 = child.getClass();
        System.out.println(classObj1.getName());
        // 通过相对路径实现反射
        Class classObj2 = Class.forName("cn.oldensheepdog.java.fundamental.Child");
        System.out.println(classObj2.getName());
        // 通过哦类名实现反射
        Class classObj3 = Child.class;
        System.out.println(classObj3.getName());

    }
}
