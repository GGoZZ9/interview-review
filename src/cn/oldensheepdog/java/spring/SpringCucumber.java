package cn.oldensheepdog.java.spring;

/**
 * Spring
 * */
/**
 * 在step里加上用spring load properties，那么文件命名 application-dev.yml, application-prod.yml
 * 这样配置可直接读出来 yml文件里设置的 ${placeholder}
 * @ContextConfiguration(classes = TraderConfig.class, loader = SpringBootContextLoader.class)
 * */

/**
 * 如果要重写 PropertyResourceConfigurer 这个Bean，就要彻底重写
 * */

/**
 * 如果把不同环境写在一个yml文件里
 *  spring:
 *    profiles: prod
 * 如果分开文件 application-dev.yml
 * 就加不加 active 都行
 * */




public class SpringCucumber {
}
