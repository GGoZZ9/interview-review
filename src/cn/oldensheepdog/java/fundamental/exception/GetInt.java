package cn.oldensheepdog.java.fundamental.exception;

public class GetInt {
    public static void main(String[] args) {
        int a = getInt();
        System.out.println(a);
    }

    public static int getInt() {
        int a =10;
        try{
            System.out.println(a/0);
            a = 20;
        } catch (ArithmeticException e) {
            a = 30;
            return a; // return 30 返回路径形成，再次回到以前的路径，执行finally，a=40，然后再次回来走return 30 ，形成返回路径之后a就不是变量了而是常量30
        } finally {
            a =40;
        }
        return a;
    }
}
