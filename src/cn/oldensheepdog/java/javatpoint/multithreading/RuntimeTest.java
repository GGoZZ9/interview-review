package cn.oldensheepdog.java.javatpoint.multithreading;

public class RuntimeTest {
    public static void main(String[] args)throws Exception{
        Runtime.getRuntime().exec("cd /Users/freda/Downloads; ls");
    }
}
