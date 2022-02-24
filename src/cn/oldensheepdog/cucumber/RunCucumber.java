package cn.oldensheepdog.cucumber;

/**
 * 用的cucumber-java的版本是6.10.0, cucumber-junit-platform-engine , junit 5.7, junit-platform-engine 1.7  @Cucumber作为入口
 * 但新版已经弃用，取而代之的是@Suite
 * 新版的 7.0.0 The CucumberJUnit Platform Engine has been updated to 1.8. With JUnit 5.8 comes the junit-platform-suite engine
 * 7.0.0新增 @BeforeAll // Runs before all scenarios  @AfterAll // Runs after all scenarios
 *
 *  JUnit 4 test
 *  @RunWith(Cucumber.class)
 * @CucumberOptions(glue = "com.example.application", features = "classpath:com/example/application")
 *
 * JUnit 5.8 test suite , cucumber 7.0
 * @Suite
 * @IncludeEngines("cucumber")
 * @SelectClasspathResource("com/example/application")
 * @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.example.application")
 *
 * 如果要在整个测试阶段设置
 * @PostConstruct
 * @PreDestroy
 * 比如可以计算整个测试执行的时间
 *
 * @CucumberContextConfiguration
 * @ContextConfiguration(classes = {IndependentConfig.class})
 *
 * @Configuration
 * @ComponentScan("cn.homecredit.aldi.independent")
 * @Import({AldiCommonConfig.class, TestConfig.class, DatabaseConfig.class})
 *
 * Datatables can be transformed into lists, maps, lists of maps and other objects using the DataTable.asX methods.
 * However not all asX methods would use the @DataTableType transformers that had been defined for them.
 *
 * */

 /**
  * org.assertj.core.api.Assertions.assertThat
  * io.restassured.path.json.JsonPath;
  * Groovy GPath in REST Assured
  * */

import io.cucumber.junit.platform.engine.Cucumber;

@Cucumber
public class RunCucumber {
}
