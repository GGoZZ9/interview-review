package cn.oldensheepdog.testannotation.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomMVCConfiguration implements WebMvcConfigurer {

    private final ResponseResultInterceptor interceptor;

    public CustomMVCConfiguration(ResponseResultInterceptor interceptor) {
        this.interceptor = interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(interceptor).addPathPatterns("/user/findAllUserByAnnotation");
    }
}
