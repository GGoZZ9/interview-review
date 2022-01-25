package cn.oldensheepdog.java.fundamental;

public class Outer {

    private void test(final int i) {
        new Service() {
            public void method() {
                for (int j = 0; j < i; j++) {
                    System.out.println("匿名内部类");
                }
            }
        }.method();
    }

    public void outMethod() {
        final int a = 10;
        class Inner {
            void innerMethod() {
                System.out.println(a);
            }
        }
        Inner inner = new Inner();
        inner.innerMethod();
    }

}
