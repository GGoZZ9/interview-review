package cn.oldensheepdog.java.fundamental.collection;

import java.util.LinkedList;
import java.util.Queue;

public class CollectionContainer {

    /**
     * 解决hash冲突 再散列函数法，链地址法，而HashMap即是采用了链地址法，也就是数组+链表的方式。
     * HashMap由数组+链表组成的，数组是HashMap的主体，链表则是主要为了解决哈希冲突而存在的，
     * 如果定位到的数组位置不含链表（当前entry的next指向null）,那么查找，添加等操作很快，仅需一次寻址即可；
     * 如果定位到的数组包含链表，对于添加操作，其时间复杂度为O(n)，首先遍历链表，存在即覆盖，否则新增；
     * 对于查找操作来讲，仍需遍历链表，然后通过key对象的equals方法逐一比对查找。所以，性能考虑，HashMap中的链表出现越少，性能才会越好。
     * */
    /**
     * HashMap是非线程安全的，在对其进行迭代时，如果期间其他线程的参与导致HashMap的结构发生变化（如 put，remove）需要抛出异常 ConcurrentModificationException
     * */

    /**
     * 在重写equals的方法的时候，必须注意重写hashCode方法，同时还要保证通过equals判断相等的两个对象，调用hashCode方法要返回同样的整数值。
     * 而如果equals判断不相等的两个对象，其hashCode可以相同（只不过会发生哈希冲突，应尽量避免）。
     * 因为我们希望equals判断相等后，调用hashCode方法返回要返回同样的整数值。
     * */

    /**
    * 对象封装数据，对象多了也需要存储。集合用于存储对象。
     * 对象的个数确定可以使用数组 （ArrayList是一个长度可变的数组），对象的个数不确定的可以用集合。因为集合是可变长度的。
     * 数组可以存储基本数据类型 Primitive data types，也可以存储引用数据类型；集合只能存储引用数据类型
     * 数组存储的元素必须是同一个数据类型；集合存储的对象可以是不同数据类型
     *
     * Map接口 (SortedMap, HashMap)(key 无序，唯一， value 无序，不唯一)和Collection (Set, List, Queue)接口是所有集合框架的父接口：
     *
     * Collection接口的子接口包括：Set（无序，不可重复）接口和List(有序,可重复)接口
     *
     * Map接口的实现类主要有：HashMap、TreeMap、Hashtable、ConcurrentHashMap以及Properties等
     * Set接口的实现类主要有：HashSet、TreeSet、LinkedHashSet等
     * List接口的实现类主要有：ArrayList、LinkedList、Stack以及Vector等
    * */

    /**
     * https://blog.csdn.net/u013063153/article/details/78808923
     * Object类中的equals方法定义为判断两个对象的地址是否相等（可以理解成是否是同一个对象），地址相等则认为是对象相等。
     * 这也就意味着，我们新建的所有类如果没有复写equals方法，那么判断两个对象是否相等时就等同于“==”，也就是两个对象的地址是否相等。
     * 但在我们的实际开发中，通常会认为两个对象的内容相等时，则两个对象相等，equals返回true。对象内容不同，则返回false。
     * 2、hashCode的作用及与equals的关系。
     * hashCode的作用是用来获取哈希码，也可以称作散列码。实际返回值为一个int型数据。用于确定对象在哈希表中的位置。
     * Object中有hashcode方法，也就意味着所有的类都有hashCode方法。
     * 但是，hashcode只有在创建某个类的散列表的时候才有用，需要根据hashcode值确认对象在散列表中的位置，但在其他情况下没用。
     * java中本质上是散列表的类常见的有HashMap，HashSet，HashTable
     * 所以，如果一个对象一定不会在散列表中使用，那么是没有必要复写hashCode方法的。但一般情况下我们还是会复写hashCode方法，因为谁能保证这个对象不会出现再hashMap等中呢？
     *
     * 补充几点：
     * 1、新建一个类，尤其是业务相关的对象类的时候，最好复写equals方法。
     * 2、复写equals方法时，同时记着要复写hashCode方法，谁能保证说这个对象一定不会出现在hashMap中呢？如果你用的是eclipse的自动代码生成，你会发现eclipse中复写equals和hashCode是在一起的。
     *
     * 引申出几个经常在面试中问到的问题：
     *      1、两个对象，如果a.equals(b)==true，那么a和b是否相等？
     *           相等，但地址不一定相等。
     *      2、两个对象，如果hashcode一样，那么两个对象是否相等？
     *           不一定相等，判断两个对象是否相等，需要判断equals是否为true。
     * */

    /**
     * Collection
     * List
     * Arraylist： Object数组
     * Vector： Object数组
     * LinkedList： 双向循环链表
     * Set
     * HashSet（无序，唯一）：基于 HashMap 实现的，底层采用 HashMap 来保存元素
     * LinkedHashSet： LinkedHashSet 继承于 HashSet，并且其内部是通过 LinkedHashMap 来实现的。有点类似于我们之前说的LinkedHashMap
     * 其内部是基于 Hashmap 实现一样，不过还是有一点点区别的。
     * TreeSet（有序，唯一）： 红黑树(自平衡的排序二叉树。)
     * Map
     * HashMap： JDK1.8之前HashMap由数组+链表组成的，数组是HashMap的主体，链表则是主要为了解决哈希冲突而存在的（“拉链法”解决冲突）.
     * JDK1.8以后在解决哈希冲突时有了较大的变化，当链表长度大于阈值（默认为8）时，将链表转化为红黑树，以减少搜索时间
     * LinkedHashMap：LinkedHashMap 继承自 HashMap，所以它的底层仍然是基于拉链式散列结构即由数组和链表或红黑树组成。另外，LinkedHashMap
     * 在上面结构的基础上，增加了一条双向链表，使得上面的结构可以保持键值对的插入顺序。同时通过对链表进行相应的操作，实现了访问顺序相关逻辑。
     * HashTable： 数组+链表组成的，数组是 HashMap 的主体，链表则是主要为了解决哈希冲突而存在的
     * TreeMap： 红黑树（自平衡的排序二叉树）
     *
     * 对线程不安全的集合加锁以后也能达到安全的效果(但是效率会低，因为会有锁的获取以及等待)。其实在jdk源码中相同效果的集合线程安全的比线程不安全的
     * 就多了一个同步机制，但是效率上却低了不止一点点，因为效率低，所以已经不太建议使用了
     * hashtable：就比hashmap多了个线程安全。
     * ConcurrentHashMap:是一种高效但是线程安全的集合。是hashtable的代替
     * Vector：就比Arraylist多了个同步化机制（线程安全）。
     * Stack：栈，也是线程安全的，继承于Vector。
     * */

    /**
     * Java集合的快速失败机制 “fail-fast”？
     * 迭代器在遍历时直接访问集合中的内容，并且在遍历过程中使用一个 modCount 变量。集合在被遍历期间如果内容发生变化，就会改变modCount的值。
     * 每当迭代器使用hashNext()/next()遍历下一个元素之前，都会检测modCount变量是否为expectedmodCount值，是的话就返回遍历否则抛出异常，终止遍历。
     * 解决办法：
     * 在遍历过程中，所有涉及到改变modCount值得地方全部加上synchronized。
     * 使用CopyOnWriteArrayList来替换ArrayList
     * */

    /**
     * 怎么确保一个集合不能被修改？
     * Collections. unmodifiableCollection(Collection c) 方法来创建一个只读集合
     *
     * iterator.next(), iterator.remove()
     *
     * Iterator 和 ListIterator 有什么区别？
     * Iterator 可以遍历 Set 和 List 集合，而 ListIterator 只能遍历 List。
     * Iterator 只能单向遍历，而 ListIterator 可以双向遍历（向前/后遍历）。
     * ListIterator 实现 Iterator 接口，然后添加了一些额外的功能，比如添加一个元素、替换一个元素、获取前面或后面元素的索引位置。
     *
     * 遍历方式有以下几种：
     * for 循环遍历，基于计数器
     * 迭代器遍历，Iterator
     * foreach 循环遍历，也是采用了 Iterator 的方式实现，不需要显式声明 Iterator 或计数器
     * ArrayList 支持 Random Access，LinkedList 不支持 Random Access
     * 支持 Random Access 的列表可用 for 循环遍历，否则建议用 Iterator 或 foreach 遍历。
     *
     * ArrayList的优点如下
     * ArrayList 随机访问，顺序添加
     *
     * ArrayList 的缺点如下：
     * 插入元素和删除元素的时候，需要做一次元素复制操作。如果要复制的元素很多，那么就会比较耗费性能。
     *
     * ArrayList：可以看作是能够自动增长容量的数组（Array），利用ArrayList的toArray返回一个数组；Arrays.asList返回一个列表
     *
     * ArrayList 和 LinkedList 的区别是什么？
     *
     * 数据结构实现：ArrayList 是动态数组的数据结构实现，而 LinkedList 是双向链表的数据结构实现。
     * 随机访问效率：ArrayList 比 LinkedList 在随机访问的时候效率要高，因为 LinkedList 是线性的数据存储方式，所以需要移动指针从前往后依次查找。
     * 增加和删除效率：在非首尾的增加和删除操作，LinkedList 要比 ArrayList 效率要高，因为 ArrayList 增删操作要影响数组内的其他数据的下标。
     * 内存空间占用：LinkedList 比 ArrayList 更占内存，因为 LinkedList 的节点除了存储数据，还存储了两个引用，一个指向前一个元素，一个指向后一个元素。
     * 线程安全：ArrayList 和 LinkedList 都是不同步的，也就是不保证线程安全；
     *
     * ArrayList 不是线程安全的，如果遇到多线程场景，可以通过 Collections 的 synchronizedList 方法将其转换成线程安全的容器后再使用
     *
     * 为什么 ArrayList 的 elementData 加上 transient 修饰？
     * transient 的作用是说不希望 elementData 数组被序列化，重写了 writeObject 实现
     * 每次序列化时，先调用 defaultWriteObject() 方法序列化 ArrayList 中的非 transient 元素，然后遍历 elementData，只序列化已存入的元素，这样既加快了序列化的速度，又减小了序列化之后的文件大小。
     *
     * List 支持for循环，也就是通过下标来遍历，也可以用迭代器，但是set只能用迭代，因为他无序，无法用下标来取得想要的值。
     * Set：检索元素效率低下，删除和插入效率高，插入和删除不会引起元素位置改变。
     * List：和数组类似，List可以动态增长，查找元素效率高，插入删除元素效率低，因为会引起其他元素位置改变
     *
     * HashSet 是基于 HashMap 实现的，HashSet的值存放于HashMap的key上，HashMap的value统一为PRESENT，因此 HashSet 的实现比较简单，
     * 相关 HashSet 的操作，基本上都是直接调用底层 HashMap 的相关方法来完成，HashSet 不允许重复的值
     * HashSet 中add ()元素时，判断元素是否存在的依据，不仅要比较hash值，同时还要结合equles 方法比较。会使用HashMap 的put()方法
     * 并且在HashMap中如果K/V相同时，会用新的V覆盖掉旧的V，然后返回旧的V。所以不会重复（ HashMap 比较key是否相等是先比较hashcode 再比较equals
     *
     * hashCode（）与equals（）的相关规定：
     * 如果两个对象相等，则hashcode一定也是相同的
     * 两个对象相等,对两个equals方法返回true
     * 两个对象有相同的hashcode值，它们也不一定是相等的
     * 综上，equals方法被覆盖过，则hashCode方法也必须被覆盖
     * hashCode()的默认行为是对堆上的对象产生独特值。如果没有重写hashCode()，则该class的两个对象无论如何都不会相等（即使这两个对象指向相同的数据）
     *
     * HashSet与HashMap的区别
     * 实现了Map接口	实现Set接口
     * 存储键值对	仅存储对象
     * 调用put（）向map中添加元素	调用add（）方法向Set中添加元素
     * HashMap使用键（Key）计算Hashcode	HashSet使用成员对象来计算hashcode值
     * HashMap相对于HashSet较快
     *
     * BlockingQueue接口是Java集合框架的一部分，主要用于实现生产者-消费者模式,BlockingQueue的实现，比如ArrayBlockingQueue、LinkedBlockingQueue、PriorityBlockingQueue,、SynchronousQueue等
     * 在 Queue 中 poll()和 remove()有什么区别？
     * 相同点：都是返回第一个元素，并在队列中删除返回的对象。
     * 不同点：如果没有元素 poll()会返回 null，而 remove()会直接抛出 NoSuchElementException 异常。
     * */

    /**
     * HashMap实现原理
     * HashMap实际上是一个“链表散列”的数据结构，即数组和链表的结合体
     * HashMap 基于 Hash 算法实现的
     * 当我们往Hashmap中put元素时，利用key的hashCode重新hash计算出当前对象的元素在数组中的下标
     * 存储时，如果出现hash值相同的key，此时有两种情况。(1)如果key相同，则覆盖原始值；(2)如果key不同（出现冲突），则将当前的key-value放入链表中
     * 获取时，直接找到hash值对应的下标，在进一步判断key是否相同，从而找到对应值。
     * 理解了以上过程就不难明白HashMap是如何解决hash冲突的问题，核心就是使用了数组的存储方式，然后将冲突的key的对象放入链表中，一旦发现冲突就在链表中做进一步的对比。
     *
     * JDK1.7 VS JDK1.8 比较
     * resize 扩容优化
     * 引入了红黑树，目的是避免单条链表过长而影响查询效率，红黑树算法请参考
     * 解决了多线程死循环问题，但仍是非线程安全的，多线程时可能会造成数据丢失问题。
     *
     * HashMap的put方法的具体流程？
     * 首先计算 key的hash值,这里调用了 hash方法,使用高16bit和低16bit异或来简单处理减少碰撞
     *
     * HashMap的扩容操作是怎么实现的？
     * ①.在jdk1.8中，resize方法是在hashmap中的键值对大于阀值时或者初始化时，就调用resize方法进行扩容；
     * ②.每次扩展的时候，都是扩展2倍；
     * ③.扩展后Node对象的位置要么在原位置，要么移动到原偏移量两倍的位置。
     *
     * 哈希冲突
     * 当两个不同的输入值，根据同一散列函数计算出相同的散列值的现象
     * 这样我们就可以将拥有相同哈希值的对象组织成一个链表放在hash值所对应的bucket下
     * 简单总结一下HashMap是使用了哪些方法来有效解决哈希冲突的
     * 1. 使用链地址法（使用散列表）来链接拥有相同hash值的数据；
     * 2. 使用2次扰动函数（hash函数）来降低哈希冲突的概率，使得数据分布更平均；
     * 3. 引入红黑树进一步降低遍历的时间复杂度，使得遍历更快；
     *
     * 任何类可以作为Map的key，但如果重写了equals()也应该重写hashCode(),如果一个类没有使用equals(),不应该在hashCode()中使用它，
     * 自定义key类最佳实践是使之为不可变的
     * String,Integer是final类型，内部也重写类equals() hashCode适合做key，重写equals()方法，需要遵守自反性、对称性、传递性、一致性
     * 以及对于任何非null的引用值x，x.equals(null)必须返回false
     *
     * HashMap 与 HashTable 有什么区别?
     * 线程安全： HashMap 是非线程安全的，HashTable 是线程安全的；HashTable 内部的方法基本都经过 synchronized 修饰。
     * （如果你要保证线程安全的话就使用 ConcurrentHashMap 吧！）；
     * 在 Hashtable 的类注释可以看到，Hashtable 是保留类不建议使用，推荐在单线程环境下使用 HashMap 替代，如果需要多线程使用则用 ConcurrentHashMap 替代。
     * HashMap的键值对允许有null，但是ConCurrentHashMap都不允许。ConcurrentHashMap对整个桶数组进行了分割分段(Segment)，然后在每一个分段上都用lock锁进行保护，相对于HashTable的synchronized锁的粒度更精细了一些，并发性能更好
     * jdk1.8 Node + CAS + Synchronized 实现并发
     *
     * 如何决定使用 HashMap 还是 TreeMap？
     * 对于在Map中插入、删除和定位元素这类操作，HashMap是最好的选择。然而，假如你需要对一个有序的key集合进行遍历，TreeMap是更好的选择
     *
     * */

    /**
     * Array 和 ArrayList 有何区别？
     * Array 可以存储基本数据类型和对象，ArrayList 只能存储对象。
     * Array 是指定固定大小的，而 ArrayList 大小是自动扩展的。
     * Array 内置方法没有 ArrayList 多，比如 addAll、removeAll、iteration 等方法只有 ArrayList 有。Arrays. asList(array),List.toArray()
     * */

    /**
     * comparable 和 comparator的区别？
     * comparable接口实际上是出自java.lang包，它有一个 compareTo(Object obj)方法用来排序
     * comparator接口实际上是出自 java.util 包，它有一个compare(Object obj1, Object obj2)方法用来排序
     * */

    /**
     * Collection 和 Collections 有什么区别？
     * java.util.Collection 是一个集合接口（集合类的一个顶级接口）直接继承接口有List与Set。
     * Collections则是集合类的一个工具类/帮助类，其中提供了一系列静态方法，用于对集合中元素进行排序、搜索以及线程安全等各种操作。
     *
     * TreeMap 和 TreeSet 在排序时如何比较元素？
     * TreeSet 要求存放的对象所属的类必须实现 Comparable 接口,TreeMap 要求存放的键值对映射的键必须实现 Comparable 接口从而根据键对元素进 行排 序
     * Collections 工具类中的 sort()方法如何比较元素？
     * Collections 工具类的 sort 方法有两种重载的形式，
     * 第一种要求传入的对象实现 Comparable 接口以实现元素的比较；第二种不强制性的要求容器中的元素必须可比较，但是要求传入第二个参数，
     * 参数是Comparator 接口的子类型
     * */

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("string");
        System.out.println(queue.poll());
//        System.out.println(queue.remove());
        System.out.println(queue.size());
    }
}
