package cn.oldensheepdog.java.designpattern.template;

import java.util.Arrays;
import java.util.Iterator;

public class Person implements Comparable{
    private Integer age;

    public Person(Integer age){
        this.age=age;
    }
    @Override
    public int compareTo(Object o) {
        Person person = (Person)o;
        return this.age.compareTo(person.age);
    }

    public static void main(String[] args) {
        Person p1 = new Person(10);
        Person p2 = new Person(5);
        Person p3 = new Person(15);
        Person[] people = {p1,p2,p3};
        Arrays.sort(people);
        Iterator iterator = Arrays.stream(people).iterator();
        while (iterator.hasNext()){
            Person p = (Person) iterator.next();
            System.out.println(p.age);
        }
    }

}
