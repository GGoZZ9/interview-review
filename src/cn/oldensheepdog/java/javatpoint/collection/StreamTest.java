package cn.oldensheepdog.java.javatpoint.collection;

/**
 * collect() method of Stream interface.
 * Collectors.toList() is a static method of Collectors class. It belong to java.util.Stream.Collectors class.
 * How to Sort Java ArrayList in Descending Order
 * 1. user Object 增加 一个comparator方法 实现 Comparator<?> 接口的compare 方法
 * 2. 排序用 Collections.sort(ArrayList, Comparator)
 * 3. 降序用 Collections.reverseOrder(Comparator)
 * How to remove duplicates from ArrayList in Java?
 * To remove dupliates from ArrayList, we can convert it into Set. Since Set doesn't contain duplicate elements,
 * it will have only unique elements.
 * Set<String> s = new LinkedHashSet<String>(ArrayList);
 * */

/**
 * A list can contain duplicate elements whereas Set contains unique elements only.
 * Java LinkedHashSet class maintains insertion order.
 * HashSet doesn't maintain the insertion order. Here, elements are inserted on the basis of their hashcode.
 *
 * TreeSet class maintains ascending order. access and retrieval times are quiet fast.
 *
 * 带Tree的不允许null，Queue也不允许null
 * */

/**
 * Entry is the subinterface of Map. So we will be accessed it by Map.Entry name.
 * */
public class StreamTest {
}
