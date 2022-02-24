package cn.oldensheepdog.java.javatpoint.javaio;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataStreamExample {
    public static void main(String[] args) throws IOException {
        InputStream input = new FileInputStream("/Users/freda/Downloads/interview-review/src/cn/oldensheepdog/java/fundamental/javatpoint/javaio/testout.txt");
        DataInputStream inst = new DataInputStream(input);
        int count = input.available();
        byte[] ary = new byte[count];
        inst.read(ary);
        for (byte bt : ary) {
            char k = (char) bt;
            System.out.print(k+"-");
        }
        System.out.println("\n");
    }
}
