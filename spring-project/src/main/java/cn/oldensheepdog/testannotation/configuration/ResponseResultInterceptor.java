package cn.oldensheepdog.testannotation.configuration;

import cn.oldensheepdog.testannotation.annotation.ResponseResult;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class ResponseResultInterceptor implements HandlerInterceptor {
    /**
     * 标记位，标记请求的controller类或方法上使用了到了自定义注解，返回数据需要被包装
     */
    public static final String RESPONSE_ANNOTATION = "RESPONSE_ANNOTATION";

    /**
     * 请求预处理，判断是否使用了自定义注解
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws  Exception{
        if (handler instanceof HandlerMethod){
            final HandlerMethod handlerMethod = (HandlerMethod)handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();
            // 判断是否在类对象上加了注解
            if (clazz.isAnnotationPresent(ResponseResult.class)){
                // 在请求中设置需要进行响应包装的属性标志，在下面的ResponseBodyAdvice增强中进行处理
                request.setAttribute(RESPONSE_ANNOTATION, clazz.getAnnotation(ResponseResult.class));
            } else if (method.isAnnotationPresent(ResponseResult.class)){
                // 在请求中设置需要进行响应包装的属性标志，在下面的ResponseBodyAdvice增强中进行处理
                request.setAttribute(RESPONSE_ANNOTATION, method.getAnnotation(ResponseResult.class));
            }

        }

        return true;
    }
}
