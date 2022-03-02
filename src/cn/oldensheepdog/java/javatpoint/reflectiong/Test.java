package cn.oldensheepdog.java.javatpoint.reflectiong;

class Simple {
    void message() { System.out.println();}
}
public class Test {
    public static void main(String args[]){
        try{
            Class c=Class.forName("Simple"); // loads the class and returns the reference of Class class.

            Simple s=(Simple)c.newInstance();
            s.message();

        }catch(Exception e){System.out.println(e);}

    }

}
