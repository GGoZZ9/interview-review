package cn.oldensheepdog.java.fundamental.java8newfeature.annoation.testannoation;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestAnnotation {

    /**
     * ①、此注解的作用范围，可以使用在类（接口、枚举）、方法上；
     *
     * ②、此注解的生命周期，被编译器保存在class文件中，而且在运行时会被JVM保留，可以通过反射读取；
     *
     * 注解中test 成员属性没有默认值，需要使用此注解时进行赋值
     * */
    String test();

    int number() default 688;
}
