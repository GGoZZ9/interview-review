package cn.oldensheepdog.java.fundamental.javatpoint.javaio;

/**
 * 非文本文件，图片，音频，视频，用 FileOutputStream FileInputStream (need convert string into byte array)
 * 速度更快用 BufferedOutputStream BufferedInputStream
 * 读两个文件用 SequenceInputStream(FileInputStream1, FileInputStream2), 两个以上文件用
 * SequenceInputStream(Enumeration),
 * Vector v=new Vector();
 * v.add(FileInputStream1).add(FileInputStream2)
 * Enumeration e=v.elements();
 *
 * BufferedInputStream内部的数组大小是可以更改的。
 * ByteArrayInputStream是用外来的一个byte []类型的数组来对内部的数组进行初始化,如mark()， reset(), skip()， read()也都是建立在这个数组之上，这个数组的大小将不再能变化。
 * 无论ByteArrayInputStream如何调用read,它都是在返回内部固定的数组中的数值。
 * 如果当前位置超过了数组的count，那么返回-1
 * BufferedInputStream， 当其调用read()时候，如果当前的位置超过了数组的count，BufferedInputStream会去从底层的inputStream去读取新的数据，填充到内部数组中。
 *
 * ByteArrayOutputStream class is used to write common data into multiple files. In this stream,
 * the data is written into a byte array which can be written to multiple streams later.
 * 字节数组输出流在内存中创建一个字节数组缓冲区，所有发送到输出流的数据保存在该字节数组缓冲区中。创建字节数组输出流对象有以下几种方式
 * The ByteArrayInputStream is composed of two words: ByteArray and InputStream.
 * As the name suggests, it can be used to read byte array as input stream.
 * 字节数组输入流在内存中创建一个字节数组缓冲区，从输入流读取的数据保存在该字节数组缓冲区中
 *
 * ByteArrayInputStream与ByteArrayOutputStream类用于以IO流的方式来完成对字节数组的内容的读写，来支持类似内存虚拟文件或者内存映像文件的功能。
 *
 * DataOutputStream DataInputStream 基本数据类型的输入输出
 *
 *
 * BufferedOutputStream会首先创建一个默认的容器量, capacity = 8192 = 8KB, 每次在写的时候都会去比对capacity是否还够用, 如果不够用的时候, 就flushBuffer(), 把buf中的数据写入对应的outputStream中, 然后将buf清空, 一直这样等到把内容写完. 在这过程中主要起到了一个数据缓冲的功能.
 * 普通的OutputStream, 例如ByteArrayOutputStream也会首先创建一个默认的容器量, capacity = 32 = 32b, 每次在写的时候都会去比对capacity是否还够用, 如果不够用的时候, 就重新创建buf的容量, 一直等到内容写完, 这些数据都会一直处于内存中.
 *
 *
 * 写字符文件用 FileWriter
 * Java FileWriter class is used to write character-oriented data to a file. It is character-oriented class which is used for file handling in java.
 * Unlike FileOutputStream class, you don't need to convert string into byte array because it provides method to write string directly.
 * FileReader
 * It returns data in byte format like FileInputStream class.
 *
 * BufferedWriter BufferReader 可以write newLine，read line by line
 *
 * FileWriter : throws IOException, None of the PrintWriter
 * PrintWriter has an optional constructor you may use to enable auto-flushing when specific methods are called. No such option exists in FileWriter.
 * */

/**
 * https://blog.csdn.net/u010644448/article/details/23797687
 * 字节流I/O类和字符流I/O类的命名有其对应关系。字节输入流类的名字以“InputStream”结尾。而字符输入流类的名字以“Reader” 结尾。
 * 字节输出流类的名字后缀为“OutputStream”，而字符输出流类的名字后缀为“Writer”
 * 为了在适当的时候能把这两种流类联系起来，API中设置了两个类，充当二者的桥梁。
 * InputStreamReader根据特定的编码规则从字节流创建相应的字符流，
 * 而OutputStreamWriter则根据编码规则从字符流读取字符，把它们转化为字节，写入字节流中
 * 文件I/O
 * 内存缓冲区I/O
 * 管道I/O类 专门为线程通讯预备的。管道提供了自动同步机制，可以防止线程通讯中的数据混乱。
 * 过滤器I/O 过滤器(Filter)形成的类对象从一个流中读入数据，写入另一个，就像一个流经过过滤产生另一个流一样
 * */
public class JavaIo {
}
