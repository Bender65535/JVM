package jvm;

/**
 * 常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中,
 * 本质上,调用类并没有直接引用到定义常量的类,因此并不会触发定义常量的类的初始化
 *
 * 这里指的是将常量存放到了MyTest2的常量池中,之后Mytest2与Myparent2就没有任何关系了
 * 甚至可以将MyParent2的class文件删除!!
 *
 * -XX:+TraceClassLoading
 */

/*
    助记符:
    ldc:表示int,float或是String类型的常量池从常量池推送至栈顶
    bipush:表示将单字节(-128 ~ 127)的常量值推送至栈顶
    sipush:表示将单字节(-32768 ~ 32767)的常量值推送至栈顶
    iconst_1:表示将int类型推送至栈顶(iconst_0 ~ iconst_5)
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println(Myparent2.str);
    }
}
class Myparent2{
    //加上final后变为常量,被存入常量池(该常量能在编译时确认)
    public final static String str="hello world";

    public static final short s =127;

    public static final int i =128;

    public static final int m =1;

    public static final int n =2;

    static{
        System.out.println("static block");

    }
}
