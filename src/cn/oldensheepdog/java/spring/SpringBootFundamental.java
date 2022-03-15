package cn.oldensheepdog.java.spring;

/**
 * springboot启动流程：
 * SpringApplication 开始启动 - new SpringApplication() 构造一个Spring应用 - initialize 初始化模块 - 配置Source
 * Spring boot 最大的优势是 约定优于配置，可以减少开发人员需做的决定，获得简单的好处，又不失灵活
 *  Spring Boot Start Spring Boot JPA 都是约定优于配置的一种体现，Spring Boot Starter在启动过程中会根据约定的信息对资源进行初始化；
 *  Spring Boot JPA通过约定的方式来自动生成SQL，避免大量无效代码编写
 *  Spring Boot 工作原理：Spring Boot在启动时按照约定去读取Spring Boot Starter的配置信息，再根据配置信息对资源进行初始化，并注入到Spring容器中
 *  这样Spring Boot 启动完毕后就已经准备好一切资源，使用过程中直接注入对应的Bean资源即可
 *
 *  Spring Boot Parent: 维护确定的java版本和其他依赖属性；控制依赖版本避免冲突；资源过滤；控制默认插件；Source encoding 源编码
 *  The spring-boot-starter-parent inherits dependency management from spring-boot-dependencies
 *  Spring Boot Starter Parent defines spring-boot-dependencies as a parent pom.
 *  只需要确定spring-boot版本号，其他starter的版本号可以省略
 *  data-mongodb, data-redis, data-jdbc, starter-test, starter-web
 *
 *  如果不用Spring boot parent,可以用spring-boot-dependencies，<scope>import</scope>  可以对确定的依赖用不同的版本
 * */

/**
 * Spring启动时去读取应用程序提供的Bean配置信息,并在Spring容器中生成相应的Bean定义注册表,然后根据注册表去实例化Bean,装配好Bean之间的依赖关系,为上层提供准备就绪的运行环境.
 * */

/**
 * 嵌入式的server作为可部署的应用的一部分
 * */
/**
 * Spring Data JPA 处理大部分基于JDBC数据库的获取和ORM(Object Relational Mapping)，是实现持久层容易而快速
 * 是杂JPA上又加了新特性
 * 不在需要实现读写操作。基于方法名生成数据库查询，以findBy开头命名。只要定义实体 Entity和主键数据类型。
 * */
/**
 * actuator: 用来监控和管理Spring Boot Application，比如 /actuator/health 返回 {"status","UP"}
 * */
/**
 * 自动配置 比如我们在依赖中引入了H2，但是没有配置bean，Spring Boot就会自动配置，@EnableAutoConfiguration 就是这个作用
 * spring-boot-starter-web Spring Boot auto-configuration 在classpath下寻找Spring MVC，它自动配置
 * dispatcherServlet, a default error page, and web jars.
 * spring-boot-starter-data-jpa 自动配置  datasource and an Entity Manager
 * */
/**
 * Spring 加自动配置，适合开发restful api
 * 提供Spring框架的快速开发特性 RAD Rapid，是构建在Spring框架之上的项目，目的是提供更简单快速的方式set up，config， run 简单的和基于web的应用
 * Spring 框架+ Embedded HTTP Servers（Tomcat，Jetty）- XML configuration = Spring Boot
 * 使用约定的配置，减少开发的effort，缺点是引入一些不必要的依赖
 * @SpringBootApplication
 * SpringApplication.run(ClassName.class, args);
 *
 * @SpringBootApplication: It is a combination of three annotations @EnableAutoConfiguration, @ComponentScan, and @Configuration.
 * */

/**
 * Spring AOP
 * 应用有很多层 比如 web层,业务层，数据层，这些层有不同的职责，但有通用的切面Logging, Security, validation, caching等，这些通用的切面叫做 cross-cutting concerns. 横切关注，跨领域关注
 * 如果我们在每层实现这些关注会很难维护，
 * 将横切关注作为一个aspect加以实施，定义切入点 pointcuts 以指示必须应用 aspect 的位置
 * 这就保证所有横切关注都定义在一个代码组件中
 * 不改变代码本身而增加代码的行为
 * 横切关注点模块化到特殊的类中，叫 aspect
 * 这些横切关注点需要被实施，叫做 advice
 * 可以实施一个切面的功能在一个或多个 join points.
 * 运行时织入 run time weaving
 * Aspect 封装了 advice and pointcuts ，用 @Aspect 实施一个切面
 * Pointcut 切入点 ：advice被执行的一个或多个 join points，可以用 expressions or patterns 定义，使用不同的和 连接点匹配的 表达式，在spring中AspectJ 切点表达式语言被使用
 * Join point：在应用中应用AOP切面的点。或者它是Advice的特定执行实例，在AOP中 连接点可以是 method execution, exception handling, changing object variable value
 * Advice：是执行method之前或之后的行动，这个action是代码的一部分，在程序执行时调用，在spring中有五种advice：before, after, after-returning, after-throwing, and around advice
 * Target object: advice 应用的object；Target object通常是一个被代理，在运行时一个subclass被创建，在其中目标对象被重写override，同时advice根据配置被包含在其中
 * Weaving 织入： 是连接切面和其他应用类型的过程，可以在 run time, load time, and compile time 执行织入
 * Proxy: 在target object 上应用advice后创建的对象就是代理，spring AOP实施JDK动态代理，用target class和advice调用创建代理类
 * AOP advice 包括：
 * Before Advice
 * After Advice
 * Around Advice
 * After Throwing
 * After Returning
 *
 *
 * */


/**
 * AOP	OOP
 * Aspect: A code unit that encapsulates pointcuts, advices, and attributes.	Class: A code unit that encapsulates methods and attributes.
 * Pointcut: It defines the set of entry points in which advice is executed.	Method signature: It defines the entry points for the execution of method bodies.
 * Advice: It is an implementation of cross-cutting concerns.	                Method bodies: It is an implementation of the business logic concerns.
 * Waver: It constructs code (source or object) with advice.	                Compiler: It converts source code to object code.
 *
 * */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootFundamental {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootFundamental.class, args);
    }
}
