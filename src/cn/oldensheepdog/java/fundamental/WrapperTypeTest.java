package cn.oldensheepdog.java.fundamental;

/**
 * 字符常量，单引号，相当于整型ASCII值，占一个字节
 * 字符串常量，双引号，代表在内存中的地址，若干字节
 * 字符串常量池位于堆内存中，专门用来存储字符串常量，可以提高内存的使用率，避免开辟多块空间存储相同的字符串。创建字符串时先检查常量池，如果存在就返回引用，不存在就实例化一个字符串，返回引用
 * byte、short、int、long、float、double、char、boolean，
 * String 底层就是一个 char 类型的数组，引用类型。是immutable对象，对它任何操作都是创建一个新对象，再把引用指向该对象，String类利用了final修饰的char类型数组存储字符
 * 字符串连接后是开辟了新的内存地址给新的字符串
 * immutable模式主要作用在于当一个对象需要被多线程共享并频繁访问时，可以保证数据的一致性
 * String是final类，不可以被继承
 * String str="i"分配到常量池。 String str=new String("abc")分配到堆内存，创建了两个对象，一个是静态区的abc，一个是堆内的对象
 * */

/**
 * 如何将字符串反转？
 * 使用 StringBuilder 或者 stringBuffer 的 reverse() 方法
 * */

/**
 * equals(),split(),trim(),indexOf(),charAt(),toLowerCase(),toUpperCase(),subString()
 * */

/**
 * 在使用 HashMap 的时候，用 String 做 key 有什么好处？
 * HashMap 内部实现是通过 key 的 hashcode 来确定 value 的存储位置，因为字符串是不可变的，所以当创建字符串时，它的 hashcode 被缓存下来，不需要再次计算，所以相比于其他对象更快。
 * */

/**
 * String和StringBuffer、StringBuilder的区别是什么？String为什么是不可变的
 * private　final　char　value[]
 * StringBuilder与StringBuffer都继承自AbstractStringBuilder类，在AbstractStringBuilder中也是使用字符数组保存字符串，char[] value，这两种对象都是可变的。
 * String中的对象是不可变的，也就可以理解为常量，线程安全。AbstractStringBuilder是StringBuilder与StringBuffer的公共父类，定义了一些字符串的基本操作，如expandCapacity、append、insert、indexOf等公共方法。StringBuffer对方法加了同步锁或者对调用的方法加了同步锁，所以是线程安全的。StringBuilder并没有对方法进行加同步锁，所以是非线程安全的。
 * 在使用 StringBuffer 类时，每次都会对 StringBuffer 对象本身进行操作，而不是生成新的对象，所以如果需要对字符串进行修改推荐使用 StringBuffer。
 * StringBuilder 类在 Java 5 中被提出，它和 StringBuffer 之间的最大不同在于 StringBuilder 的方法不是线程安全的（不能同步访问）。
 * 由于 StringBuilder 相较于 StringBuffer 有速度优势，所以多数情况下建议使用 StringBuilder 类。
 * 如果要操作少量的数据用 = String
 * 单线程操作字符串缓冲区 下操作大量数据 = StringBuilder
 * 多线程操作字符串缓冲区 下操作大量数据 = StringBuffer
 * */

public class WrapperTypeTest {

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("abcdefg");
        System.out.println(stringBuffer.reverse());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("abcdefg");
        System.out.println(stringBuilder.reverse());

        Integer a = new Integer(3);
        Integer b = 3; // 将3自动装箱成Integer类型
        int c = 3;
        System.out.println(a==b);
        System.out.println(a==c); // a自动拆箱成int类型再比较
        System.out.println(b==c);

        Integer a1 = 128;
        Integer b1 = 128;
        System.out.println(a1==b1); // 整型字面量的值在-128到127之间,超过范围,那么自动装箱时不会new新的Integer对象，而是直接引用常量池中的Integer对象

        Integer a2 = 127;
        Integer b2 = 127;
        System.out.println(a2==b2);
    }
}
