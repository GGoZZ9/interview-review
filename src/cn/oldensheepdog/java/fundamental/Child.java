package cn.oldensheepdog.java.fundamental;

public class Child extends Parent {

    int x = 10;
    static int y = 11;
    private String name;
    private int age;

    // 静态代码块
    static {
        System.out.println("Child静态代码块：y=" + y);
        y++;
    }

    // 代码块
    {
        System.out.println("Child代码块： x=" + x);
        System.out.println("Child代码块： y=" + y);
        y++;
        x++;
    }

    // 构造函数
    Child() {
        System.out.println("Child构造函数： x=" + x);
        System.out.println("Child构造函数： y=" + y);
    }

    // 方法
    @Override
    void function() {
        System.out.println("Child function run ……");
    }

    void lost() {
        System.out.println("lost me?");
    }

//    @Override
//    public int hashCode() {
//        int result = 17;
//        result = result *31 + name.hashCode();
//        result = name.charAt(0); // 第一个字符的ASCII值
//        result = result * 31 + age;
//        return result;
//    }
//
//    @Override
//    public boolean equals(Object child) {
//        if (child == this) return true;
//        if (!(child instanceof Child)) return false;
//        Child child1 = (Child)child;
//        return child1.name.equals(name) && child1.age == age;
//    }
}
