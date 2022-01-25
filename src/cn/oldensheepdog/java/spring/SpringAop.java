package cn.oldensheepdog.java.spring;

/**
 * Spring AOP比使用完整的AspectJ更简单，因为不需要在开发和构建过程中引入AspectJ编译器/编织器。如果您只需要建议在Spring bean上执行操作，
 * 那么Spring AOP是正确的选择。如果需要通知Spring容器不管理的对象(通常是域对象)，则需要使用AspectJ。如果希望建议连接点而不是简单的方法执行(例如，字段get或set连接点等等)，还需要使用AspectJ
 * 通知类型
 *
 * 切点表达
 * @Pointcut(“within(com.chenss.dao.)")//匹配com.chenss.dao包中的任意方法
 * @Pointcut("within(com.chenss.dao…)”)//匹配com.chenss.dao包及其子包中的任意方法
 *
 * execution 表达式 可以精确到类中的每个方法(粒度细),推荐使用
 *
 * @Around 环绕通知 (功能最强大)
 * @Before 前置通知：在目标方法调用之前通知
 * @After 后置通知
 * @AfterReturning 正常返回通知
 * @AfterThrowing 异常返回通知
 * */
public class SpringAop {
}
