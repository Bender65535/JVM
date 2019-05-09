package memory;

/**
 * 虚拟机栈:Stack Frame 栈帧,对于方法字节码执行时的入栈出栈,局部变量表
 * 程序计数器:(Program Counter)描述字节码执行时的顺序
 * 本地方法栈:主要用于处理本地方法(native)
 * 堆(Heap):JVM管理的最大一块内存空间
 * 方法区:存储元信息(常量,静态变量,class对象固有的信息)  永久代:不会被垃圾回收,可能会出现内存溢出
 * jdk1.8后废弃永久带,使用元空间
 *
 * 运行时常量池:方法区的一部分内容(生成class文件时生成的自变量和符号引用)
 * 直接内存:
 */

public class Test1 {
}
