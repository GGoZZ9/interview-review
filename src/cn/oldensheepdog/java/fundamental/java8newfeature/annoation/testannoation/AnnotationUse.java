package cn.oldensheepdog.java.fundamental.java8newfeature.annoation.testannoation;

import lombok.extern.slf4j.Slf4j;

@TestAnnotation(test="AnnotationUse")
@Slf4j
public class AnnotationUse {

    @TestAnnotation(test="annotationUse", number = 566)
    public static void annotationUser(){
        log.info("oneself define annotation use..");
    }

    public static void main(String[] args) {
        annotationUser();
    }
}
