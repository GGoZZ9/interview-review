package cn.oldensheepdog.java.fundamental;

public class Coder {
    private String name;
    private int age;

    public Coder(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object other) {
        System.out.println("equals method invoked!");
        if (other == this) return true;
        if (!(other instanceof Coder)) return false;
        Coder o = (Coder) other;
        return o.name.equals(name) && o.age == age;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + name.hashCode();
        result = result * 31 + age;
        return result;
    }
}
