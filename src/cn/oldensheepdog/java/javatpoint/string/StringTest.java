package cn.oldensheepdog.java.javatpoint.string;

/**
 * String, StringBuffer and StringBuilder classes implement CharSequence
 * The Java String is immutable which means it cannot be changed. Whenever we change any string, a new instance is created.
 * For mutable strings, you can use StringBuffer and StringBuilder classes.
 * 字符串常量池有就返回引用，没有就建新的并返回引用 string constant pool
 * String s=new String("Welcome");//creates two objects and one reference variable  : a new string object and a literal
 *
 * The == operator compares references not values
 * equals()比较的是string的值
 * */

/**
 * StringBuffer 是线程安全的，连接字符串时消耗更少的内存，String 连接字符串时消耗更多内存，因为每次都创建一个新实例
 * String override了equals，StringBuffer没有override equals
 * String class uses String constant pool.  StringBuffer uses Heap memory
 *
 * StringBuffer is synchronized i.e. thread safe. StringBuilder is non-synchronized i.e. not thread safe.
 * StringBuffer 更低效，StringBuilder 更高效
 *
 * create Immutable class: use final class , have final 数据成员
 * */

/**
 * 如果不重写toString()，打印类实例的结果是这个对象的hashcode
 * */

/**
 * 重写equals和hashcode方法，判断两个对象相等
 * 重写这两个方法的场景基本就是该对象要保存到HashMap这样的集合中去。
 * 比如我的业务场景就要要保存到ConcurrentHashMap<Message, Long>集合中。
 * 假设不重写的话，两个属性值都相同的Message的hashcode是不相同的，
 * 因为对象的hashcode是根据内存的地址算出来的。
 * 重写hashcode后，就需要重写equals方法，因为假设不重写的话，
 * 默认的equals方法相等于== 即：判断两个引用是否指向内在中的同一个对象。
 * 所以也要重写。
 * 研究员发现素数31，可以更有效的分配key
 * */




public class StringTest {
    public static void main(String args[]){
        String s1="Sachin";
        String s2="Sachin";
        String s3=new String("Sachin");
        System.out.println(s1==s2);//true (because both refer to same instance) 引用都指向常量池
        System.out.println(s1==s3);//false(because s3 refers to instance created in nonpool)
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));  // 比较的常量池

        String s="hello";
        System.out.println(s.substring(0,2)); //returns he  as a substring  包含左侧不包含右侧
    }
}
