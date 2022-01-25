package cn.oldensheepdog.testannotation.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class PrintLogAspect {
    @Around(value = "@annotation(cn.oldensheepdog.testannotation.annotation.PrintLog)")
    public Object handlerPrintLog(ProceedingJoinPoint joinPoint){
        //获取方法名称
        String methodName= joinPoint.getSignature().getName();
        //获取方法入参
        Object[] param = joinPoint.getArgs();

        StringBuilder stringBuilder = new StringBuilder();
        for (Object o : param){
            stringBuilder.append(o).append(";");
        }
        log.info("进入<{}>方法，参数为: {}", methodName, stringBuilder.toString());

        Object object =null;
        //继续执行方法
        try{
            object = joinPoint.proceed();
        } catch (Throwable throwable){
            log.error("打印日志处理error...", throwable);
        }
        log.info("{} 方法执行结束..", methodName);
        return object;
    }
}
