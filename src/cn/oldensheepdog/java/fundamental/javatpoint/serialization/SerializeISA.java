package cn.oldensheepdog.java.fundamental.javatpoint.serialization;

import java.io.*;
import java.nio.charset.Charset;

public class SerializeISA {

    public static void main(String args[])
    {
        try{
            //Creating the object
            String defaultCharsetName= Charset.defaultCharset().displayName();
            System.out.println("defaultCharsetName:"+defaultCharsetName);
            Student s1 =new Student(211,"ravi","Engineering",50000);
            //Creating stream and writing the object
            FileOutputStream fout=new FileOutputStream("./src/cn/oldensheepdog/java/fundamental/javatpoint/serialization/f.txt");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(s1);
            out.flush();
            //closing the stream
            out.close();
            System.out.println("success");
        }catch(Exception e){System.out.println(e);}
        try{
            //Creating stream to read the object
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("./src/cn/oldensheepdog/java/fundamental/javatpoint/serialization/f.txt"));
            Student s=(Student)in.readObject();
            //printing the data of the serialized object
            System.out.println(s.id+" "+s.name+" "+s.course+" "+s.fee);
            //closing the stream
            in.close();
        }catch(Exception e){System.out.println(e);}
    }
}

class Person implements Serializable {
    int id;
    String name;
    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
class Student extends Person{
    String course;
    int fee;
    public Student(int id, String name, String course, int fee) {
        super(id,name);
        this.course=course;
        this.fee=fee;
    }
}
