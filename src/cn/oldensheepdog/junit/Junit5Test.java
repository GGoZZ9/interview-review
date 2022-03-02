package cn.oldensheepdog.junit;

/**
 * UT
 * @ExtendWith(MockitoExtension.class)
 * @Mock 用在template，repository 的mock
 * @Test 用来写UT
 * */

/** Spring 2.6.2
 * IT
 * @SpringBootTest
 * @ActiveProfiles({"integration-test"})
 * @AutoConfigureMockMvc
 * @DirtiesContext
 * @AutoConfigureJsonTesters
 *
 * */

/**
 * Mock mock一个Bean，比如Service，要stub这个class里的method，根据一定的条件return想要的结果
 * stub是state-based，关注的是输入和输出。mock是interaction-based，关注的是交互过程。
 * mock通常通过一些成熟的框架对类或方法进行模拟。通常的流程是：
 *
 * 创建指定类的mock，指定输入返回对应的响应内容。
 * 当被测函数调用到该mock时针对输入进行预期返回。
 * 最后验证该mock是否被调用。
 * 而使用stub时针对每个状态，返回指定的响应。比如在Junit4 in action第6章为了测试getContent，分别模拟了几种状态：
 *
 * https://blog.csdn.net/yingxysuc/article/details/39677625
 *    Stub是一个虚拟的物件，一个Stub可以使用最少的依赖方法来模拟该单元测试。简单的说，stub是代码的一部分。在运行时用stub替换真正代码，
 *    忽略调用代码的实现。目的是用一个简单一点的行为替换一个复杂的行为，从而独立地测试代码的某一部分。比如，要测试dao层的代码，势必要连接数据库，
 *    这时候就可以使用HashMap来模拟数据库操作，这个Stub对象就可以根据你想要的状态去模拟，通过方法去测试Stub的内部状态。可以使用map的方式以及dbUtil来实现stub测试。
 *
 *    mocks不实现任何逻辑，它们只是抽象地提供了一种使测试能控制需要测试的类的所有业务逻辑方法的一个壳子。比如同事A在开发service层，同事B在开发dao层。
 *    现在的情况：A的service层的代码已经写完毕了，就等待B开发的dao层完毕并测试好，但是B还没有完成dao层的开发。A这时就可以使用mock对象来模拟dao层的实现，
 *    因为A并不需要关注dao层的是否有错(B开发的dao层，也会经过严格的测试，才会提交代码的)。
 * */
public class Junit5Test {
}
