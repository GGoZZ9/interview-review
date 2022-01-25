package cn.oldensheepdog.java.fundamental.java8newfeature.annoation;

import java.lang.annotation.Repeatable;

@Repeatable(AfterJava8Authors.class)
public @interface AfterJava8Author {
    String name();
}
