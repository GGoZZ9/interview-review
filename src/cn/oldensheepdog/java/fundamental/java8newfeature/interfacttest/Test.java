package cn.oldensheepdog.java.fundamental.java8newfeature.interfacttest;

public class Test implements TestInterface {

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.defaultTest());
        System.out.println(TestInterface.staticTest());
    }

    /**
     * 接口和抽象类之间几乎没有区别（除了多重继承）。实际上，您可以使用接口模拟常规类。
     * 在对实现进行编程时，程序员可能会忘记覆盖默认方法。
     * 如果类试图实现两个或多个具有默认方法且具有相同签名的接口，则会出现编译错误。要解决此问题，我们将必须重写类中相同的那个方法签名
     * 通过向接口添加默认方法，每个实现类都会自动继承此行为。这些类中的某些类可能并未在设计时考虑到该新功能，因此可能会引起问题。
     * 例如，如果有人将新的默认方法添加default void foo()到interface Ix，则不会编译Cx实现Ix并具有具有foo相同签名的私有方法的类。
     * */

    /**
     * Java标准库中提供了一个默认方法的激励示例，您现在可以在其中找到它
     * list.sort(ordering);
     * 代替
     * Collections.sort(list, ordering);
     * 如果没有多个相同的实现，我认为他们不可能做到这一点List.sort。
     * */

    /**
     * 说接口和抽象类实际上没有区别是不正确的，因为抽象类可以具有状态（即声明字段），而接口则不能
     * 因此，它不等同于多重继承，甚至不等同于混合类型继承。
     * */

    /**
    * 主要是为了方便扩展已有接口；如果没有默认方法，假如给Java中的某个接口添加一个新的抽象方法，那么所有实现了该接口的类都得修改，影响将非常大。
    * */

    /**
     * 类中的方法优先级最高。类或父类中声明的方法的优先级高于任何声明为默认方法的优先级。
     * 如果无法依据第一条进行判断，那么子接口的优先级更高：函数签名相同时，优先选择拥有最具体实现的默认方法的接口，即如果B继承了A，那么B就比A更加具体。
     * 最后，如果还是无法判断，继承了多个接口的类必须通过显式覆盖和调用期望的方法，显式地选择使用哪一个默认方法的实现。
     * */
}
