package cn.oldensheepdog.python;

/**
 * 抛弃传统的类似QC的测试用例工具，将测试用例描述和测试用例执行整合在一起，即自然语言描述出来的测试用例可以直接被执行，而不需要人工的将自然语言转化为可运行的测试用例
 *
 * 测试用例 + 测试执行 + 测试报告将高度整合，并且通过可持续集成的方法，易于开发人员了解测试人员测试点，根据测试用例，开发人员可以直接回测，并不需要了解测试框架的设计
 *
 * Appium + WinAppDriver + pytest
 * pip install Appium-Python-Client Selenium
 * https://github.com/microsoft/WinAppDriver/releases
 *
 * WinAppDriver是微软官方提供的一款用于做Window桌面应用程序的界面（UI）自动化测试工具，并且支持Appium，而Appium本身就支持多种编程语言，
 * 这样我们就可以借助于Appium-Python-Client（Appium的python客户端）使用python来编写测试windows桌面程序的自动化测试脚本。
 * https://cxybb.com/article/hotswwkyo/115355703
 *
 * Appium 是一个开源工具，用于自动化 iOS 手机、 Android 手机和 Windows 桌面平台上的原生、移动 Web 和混合应用。
 * 它把这些系统本身提供的框架包装进一套 API —WebDriver API 中。WebDriver，即Selenium WebDriver。
 *
 * 通过cucumber.wire 已经支持了cucumber-wire 协议，也就是说您的step definitions不仅可以通过ruby编写，您还可以使用.net 等语言
 *
 * 嵌入式软件自动化测试工具，越来越多的企业开始关注嵌入式软件自动化测试工具。而且很多企业都已经在使用各种自动化测试工具（如VectorCAST, PRQA，DT10，Squore等
 *
 * 基于Python的RobotFramework能够很好地处理报文相关的逻辑，加上团队在Python上有比较好的技术储备，因此RobotFramework成了最终的选择。
 * */

/**
 * 1. 最下面是被测系统，需要明确它的形态，比如是Web系统、REST系统或者特定协议系统。
 * 2. 中间是测试库。比如Selenium、SSH、Scapy等，有了它们用例才能和被测系统进行交互，所以需要根据被测系统的形态来选择相应地测试库。该层的选择需要考虑几个因素：
 * 3. 最上层则是测试框架，也就是Cucumber和RobotFramework这一层。其作用包括用例管理、测试数据管理、测试运行、测试报告等。该层的选择需要考虑几个因素：
 * 这一层会通过函数调用的方式和测试库打交道，因此测试框架必须支持测试库所使用的编程语言。
 * 是否提供易用的测试用例开发环境，比如是否有如RIDE这样的专用工具，或者Intellij的IDE的插件。
 * 引入某个测试框架之后对现有工作模式的影响程度，比如让不懂编程的测试人员写代码。
 *
 * ProcessBuilder
 * */
public class WindowsAuto {
}
