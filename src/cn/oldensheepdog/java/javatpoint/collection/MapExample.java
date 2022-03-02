package cn.oldensheepdog.java.javatpoint.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Map is interface, Collection is interface
 * HashMap is non synchronized. 16/0.75 , 无序
 * A Hashtable is an array of a list. is synchronized,  11/0.75 initial default capacity 和HashMap不同
 * TreeMap 有序，升序，ascending
 *
 * ArrayList 里的element 可以重复，Set 不能重复
 * HashSet是用has table 来存储
 * */
public class MapExample {
    public static void main(String[] args){
        Map<Integer,String> map=new HashMap<>();
        map.put(100,"Amit");
        map.put(101,"Vijay");
        map.put(102,"Rahul");
        //Returns a Set view of the mappings contained in this map
        map.entrySet()
                //Returns a sequential Stream with this collection as its source
                .stream()
                //Sorted according to the provided Comparator
                .sorted(Map.Entry.comparingByKey())
                //Performs an action for each element of this stream
                .forEach(System.out::println);
    }
}
