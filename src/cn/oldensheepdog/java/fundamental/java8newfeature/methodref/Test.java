package cn.oldensheepdog.java.fundamental.java8newfeature.methodref;

public class Test {
    public static int result;
    public static int result2;

    public static Test create(Creator<Test> creator){
        return creator.get();
    }

    private int operate(int a, int b, Operation operation){
        return operation.operation(a,b);
    }

    private static int add(int a, int b){
        return a-b;
    }

    private int sub(int a, int b){
        return a-b;
    }

    public int testM(Test test){
        return 0;
    }

    public void test(TestInt testInt){
        Test test=Test.create(Test::new);//构造方法引用 使用方式：Class::new
        Test t1=Test.create(Test::new);
        Test t2=Test.create(Test::new);
        testInt.cp(t1,t2);
        test.operate(1,2,Test::add); // 静态方法引用 使用方式：Class::staticMethod ,operate里只要是int,int,function 三个参数就行
        result2 = test.operate(1,2,test::sub); // 对象的实例方法引用 使用方式：instance::method
        test.test(Test::testM); //类的实例方法引用 使用方式：Class::method
        result = t1.testM(t2);
    }

    public static void main(String[] args) {
        System.out.println(result);
    }

    /**
     * 类的实例方法引用，有两个条件：
     *
     * 1.首先要满足实例方法，而不是静态方法
     * 2.Lambda 表达式的第一个参数会成为调用实例方法的对象
     * 根据这两点我们看上面的例子，test 方法接受一个 TestInt 实例，用 Lambda 表达式表示就是 (Test t1, Test t2) -> res，
     * 而我们调用 test 方法时传入的方法引用是 Test::testM，其参数也是一个 Test 实例，最终 test.test(Test::testM) 的调用效果就是 t1.testM(t2)
     * */
}
