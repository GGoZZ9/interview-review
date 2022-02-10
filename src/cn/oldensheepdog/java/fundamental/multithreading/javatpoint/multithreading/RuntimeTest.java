package cn.oldensheepdog.java.fundamental.multithreading.javatpoint.multithreading;

public class RuntimeTest {
    public static void main(String[] args)throws Exception{
        Runtime.getRuntime().exec("cd /Users/freda/Downloads; ls");
    }
}
