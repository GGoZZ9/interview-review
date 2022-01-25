package cn.oldensheepdog.java.fundamental.java8newfeature.interfacttest;

public interface TestInterface {

    // Java 8 新增了接口的默认实现，通过 default 关键字表示。同时也可以提供静态默认方法。
    // 接口默认方法
    default String defaultTest(){
        return "default";
    }

    static String staticTest(){
        return "static";
    }
}
