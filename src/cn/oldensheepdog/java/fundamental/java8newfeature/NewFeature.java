package cn.oldensheepdog.java.fundamental.java8newfeature;

import java.util.Arrays;
import java.util.List;

/**
 * 1. Lambda 和 函数式接口
 * 2. 方法引用 通过方法引用，可以使用方法的名字来指向一个方法。使用一对冒号来引 "::" 用方法。
 * 3. 接口默认方法和静态方法 Java 8 新增了接口的默认实现，通过 default 关键字表示。同时也可以提供静态默认方法。
 * 可以在不破坏代码的前提下扩展原有库的功能。但从另一个方面来说，这使得接口作为协议，类作为具体实现的界限开始变得有点模糊。
 * 优点是，它通过一个很优雅的方式使得接口变得更智能，同时还避免了代码冗余，并且扩展类库。
 * 层级很复杂的情况下很容易引起模糊不清甚至变异错误。
 * 多重继承的冲突说明：
 * 由于同一个方法可以从不同接口引入，自然而然的会有冲突的现象，规则如下：
 * 1）一个声明在类里面的方法优先于任何默认方法
 * 2）优先选取最具体的实现
 * java 8中抽象类与接口的异同
 * 相同点：
 * 1）都是抽象类型；
 * 2）都可以有实现方法（以前接口不行）；
 * 3）都可以不需要实现类或者继承者去实现所有方法，（以前不行，现在接口中默认方法不需要实现者实现）
 * 不同点：
 * 1）抽象类不可以多重继承，接口可以（无论是多重类型继承还是多重行为继承）；
 * 2）抽象类和接口所反映出的设计理念不同。其实抽象类表示的是"is-a"关系，接口表示的是"like-a"关系；
 * 3）接口中定义的变量默认是public static final 型，且必须给其初值，所以实现类中不能重新定义，也不能改变其值；抽象类中的变量默认是 friendly 型，其值可以在子类中重新定义，也可以重新赋值。
 * Note：friendly 型：如果一个类、类属变量及方法不以public,protected,private这三种修饰符来修饰，它就是friendly类型的，那么包内的任何类都可以访问它，而包外的任何类都不能访问它(包括包外继承了此类的子类)，因此，这种类、类属变量及方法对包内的其他类是友好的，开放的，而对包外的其他类是关闭的。

 * 为什么不能用默认方法来重载equals，hashCode和toString？
 * 每一个java类都是Object的子类，也都继承了它类中的equals/hashCode/toString方法，那么在类的接口上包含这些默认方法是没有意义的，它们也从来不会被编译
 *
 * 4. 重复注解
 * 5. 类型注解 Java 8 之前注解只能用在声明中，在 Java 8 中，注解可以使用在 任何地方。
 * 6. 更好的类型推断
 * 7. Optional Java 8 中新增了 Optional 类用来解决空指针异常。Optional 是一个可以保存 null 的容器对象。通过 isPresent() 方法检测值是否存在，通过 get() 方法返回对象。
 * 8. Stream Java 8 中新增的 Stream 类提供了一种新的数据处理方式。这种方式将元素集合看做一种流，在管道中传输，经过一系列处理节点，最终输出结果。
 * 9. 日期时间 API Java 8 中新增了日期时间 API 用来加强对日期时间的处理，其中包括了 LocalDate，LocalTime，LocalDateTime，ZonedDateTime
 * 10. Base64 支持 Java 8 标准库中提供了对 Base 64 编码的支持。
 * 11. 并行数组 ParallelSort Java 8 中提供了对数组的并行操作，包括 parallelSort 等等
 *
* */
public class NewFeature {

    public static void main(String[] args) {
        streamTest();
    }

    public static void streamTest() {
        List<String> list = Arrays.asList("maa", "a", "ab", "c");
        list.stream()
                .filter(s->s.contains("a"))
                .map(s->s+"aa")
                .sorted()
                .forEach(System.out::println);
        System.out.println("++++++++");
        list.parallelStream().forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        int res = numbers.stream().map(i->i+1).mapToInt(i->i).summaryStatistics().getMax();
        System.out.println(res);
    }
}
