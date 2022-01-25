package cn.oldensheepdog.shiftlefttesting;

/**
 * Junit4 PowerMock
 * mockito
 *                              JUNIT4          JUNIT5
 * 在当前类中的所有测试方法之前执行	@BeforeClass	@BeforeAll
 * 在当前类中的所有测试方法之后执行	@AfterClass	@AfterAll
 * 在每个测试方法之前执行	@Before	@BeforeEach
 * 每种测试方法后执行	@After	@AfterEach
 * 禁用测试方法/类	@Ignore	@Disabled
 * 测试工厂进行动态测试	NA	@TestFactory
 * 嵌套测试	NA	@Nested
 * 标记和过滤	@Category	@Tag
 * 注册自定义扩展	NA	@ExtendWith
 *
 * JUnit 4将所有内容捆绑到单个jar文件中。
 *
 * Junit 5由3个子项目组成，即JUnit Platform，JUnit Jupiter和JUnit Vintage。
 * JUnit平台
 *
 * 它定义了TestEngine用于开发在平台上运行的新测试框架的API。
 *
 * JUnit Jupiter
 *
 * 它具有所有新的junit注释和TestEngine实现，以运行使用这些注释编写的测试。
 *
 * JUnit Vintage
 *
 * 支持在JUnit 5平台上运行JUnit 3和JUnit 4编写的测试。
 *
 * Junit 5需要Java 8或更高版本。
 * 在Junit 4中，org.junit.Assert具有所有断言方法来验证预期结果和结果。
 * 在JUnit 5中，org.junit.jupiter.Assertions包含大多数断言方法，包括附加assertThrows()
 * JUnit 5断言方法也有重载方法，以支持在测试失败时传递错误消息
 * 在JUnit 4，@RunWith和@Suite注释。例如
 * 在JUnit 5 @RunWith，@SelectPackages和@SelectClasses如
 * */

/**
 * spring integration test
 * @ExtendWith(SpringExtension.class)
 * @ContextConfiguration(classes = { ApplicationConfig.class })
 * @WebAppConfiguration
 *
 * @ContextConfiguration annotation to load the context configuration and bootstrap the context that our test will use.
 *
 * MockMvc provides support for Spring MVC testing. It encapsulates all web application beans and makes them available for testing.
 * WebApplicationContext provides a web application configuration. It loads all the application beans and controllers into the context.
 * mockMvc.perform(get("/homePage")).andDo(print())
 *       .andExpect(view().name("index"));
 * */

/**
 * JUnit 4 JUnit5
 *
 * @RunWith(SpringRunner.class) and @ExtendWith(SpringExtension.class)
 * In the JUnit4 version, when adding @SpringBootTest annotations to the test class, the same must be added @RunWith(SpringRunner.class) to take effect, namely:
 * However, in the JUnit5, the official website to inform @RunWith functions are @ExtendWith substituting the original @RunWith(SpringRunner.class) the same function @ExtendWith(SpringExtension.class) instead. But @SpringBootTest annotation in JUnit5 already includes @ExtendWith(SpringExtension.class) by default.
 *
 * */

 /**
  * Test-driven development (TDD) requires us to write unit tests first, and then write implementation code.
  * In the process of writing unit tests, we often encounter many dependencies on the classes to be tested,
  * and these dependent classes/objects/resources have other dependencies, thus forming a large dependency tree.
  * The purpose and function of the Mock technology is to simulate some objects that are not easy to construct or
  * more complex in the application, thereby isolating the test from the objects outside the test boundary.
  * */
public class Junit5 {
}
