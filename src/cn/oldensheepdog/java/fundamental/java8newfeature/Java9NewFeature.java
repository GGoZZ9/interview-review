package cn.oldensheepdog.java.fundamental.java8newfeature;

/**
 * 1. Jigsaw 模块系统
 * 在 Java 9 以前，打包和依赖都是基于 JAR 包进行的。JRE 中包含了 rt.jar，将近 63M，也就是说要运行一个简单的 Hello World，也需要依赖这么大的 jar 包。在 Java 9 中提出的模块化系统，对这点进行了改善。
 * 2. JShell REPL  Java 9 提供了交互式解释器。有了 JShell 以后，Java 终于可以像 Python，Node.js 一样在 Shell 中运行一些代码并直接得出结果了。
 * 3. 接口中使用私有方法 Java 9 中可以在接口中定义私有方法
 * 4. 集合不可变实例工厂方法
 * 5. 改进 try-with-resources
 * 6. 多版本兼容 jar 包
 * 7. 增强了 Stream，Optional，Process API
 * 8. 新增 HTTP2 Client
 * 9. 增强 Javadoc，增加了 HTML 5 文档的输出，并且增加了搜索功能
 * 10. 增强 @Deprecated
 * 对 Deprecated 新增了 since 和 forRemoval 属性
 * 11. 增强了钻石操作符 "<>"，可以在 匿名内部类中使用了。
 * 12. 多分辨率图像 API：定义多分辨率图像API，开发者可以很容易的操作和展示不同分辨率的图像了。
 * 13. 改进的 CompletableFuture API
 * */
/**
 * Java 10
 * 1. 新增局部类型推断 var var 关键字目前只能用于局部变量以及 for 循环变量声明中。
 * 2. 删除工具 javah 从JDK中移除了 javah 工具，使用 javac -h 代替。
 * 3. 统一的垃圾回收接口，改进了 GC 和其他内务管理
 * 1.ThreadLocal 握手交互
 * JDK 10 引入一种在线程上执行回调的新方法，很方便的停止单个线程而不是停止全部线程或者一个都不停。
 *
 * 2.基于Java的实验性JIT编译器
 * Java 10 开启了 Java JIT编译器 Graal，用作Linux / x64平台上的实验性JIT编译器。
 * 3.提供默认的 CA 根证书
 * 4.将 JDK 生态整合到单个仓库
 * 此JEP的主要目标是执行一些内存管理，并将JDK生态的众多存储库组合到一个存储库中。
 * */
/**
 * Java 11
 * 1. Lambda 表达式中使用 var
 * 2. 字符串 API 增强 Java 11 新增了 一系列字符串处理方法
 * 3. 标准化 HttpClient API
 * 4. java 命令直接编译并运行 java 文件，省去先 javac 编译生成 class 再运行的步骤
 * 5. 增加对 TLS 1.3 的支持
 * Java 12 Java 12 以后，switch 不仅可以作为语句，也可以作为表达式。
 * */
public class Java9NewFeature {
}
